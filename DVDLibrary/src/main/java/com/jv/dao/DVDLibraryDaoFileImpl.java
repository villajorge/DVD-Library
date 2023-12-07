/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.jv.dao;

import com.jv.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: Jorge Villa 
 * email: villajorge41@gmail.com
 * Date: 08/24/22
 * Purpose: Implementing DVDLibraryDao for file writing/reading
 * 
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao{
    
    private static final String DVD_FILE = "DVDs.txt";
    private static final String DELIMITER = "::";
    private Map<String, DVD> dvds = new HashMap<>();
    
    
    @Override
    public DVD addDVD(String dvdName, DVD dvd) throws DVDLibraryDaoException {
        loadLibrary();
        DVD curDVD = dvds.put(dvdName, dvd);
        writeLibrary();
        return curDVD;
    }

    @Override
    public DVD removeDVD(String dvdName) throws DVDLibraryDaoException{
        loadLibrary();
        DVD removedDVD = dvds.remove(dvdName);
        writeLibrary();
        return removedDVD;
         
    }

    @Override//return to this!
    public DVD editDVD(String dvdName) throws DVDLibraryDaoException{
    loadLibrary();
    DVD edit = dvds.remove(dvdName);
    return edit;
    
    }

    @Override
    public List<DVD> listDVDs() throws DVDLibraryDaoException{
     loadLibrary();
     return new ArrayList<>(dvds.values());
    }

    @Override
    public DVD listDVD(String dvdName) throws DVDLibraryDaoException {
        loadLibrary();
        return dvds.get(dvdName);
    }

    @Override
    public DVD findDVD(String dvdName) throws DVDLibraryDaoException{
        loadLibrary();
        return dvds.get(dvdName);
    }
    
    private void loadLibrary() throws DVDLibraryDaoException{
        Scanner scan;
        try {
            scan = new Scanner(new BufferedReader(new FileReader (DVD_FILE)));
        }catch (FileNotFoundException e){
            throw new DVDLibraryDaoException("Could not load DVD file");
        }
        
        String line;
        DVD curDVD;
        
        while (scan.hasNextLine()){
            line = scan.nextLine();
            curDVD = unmarshalDVD(line);
            dvds.put(curDVD.getTitle(),curDVD);
        }
        scan.close();
    }
    
    //Title::releaseDate::mpaaRating::director::studio::note
    private DVD unmarshalDVD(String line){
        String[] tokens = line.split(DELIMITER);
        DVD newDVD = new DVD(tokens[0]);
        newDVD.setReleaseDate(tokens[1]);
        newDVD.setMpaaRating(tokens[2]);
        newDVD.setDirectorName(tokens[3]);
        newDVD.setStudio(tokens[4]);
        //if no note is given default to N/A
        //System.out.println("Tokens lenth: "+tokens.length);
        if(tokens.length == 5){
            newDVD.setNote("N/A");
        }else{
            newDVD.setNote(tokens[5]);
        }
        
        return newDVD;
    }

    
    private void writeLibrary() throws DVDLibraryDaoException{
        PrintWriter out;
        try{
            out = new PrintWriter(new FileWriter (DVD_FILE));
        }catch(IOException e){
            throw new DVDLibraryDaoException("Could not save DVD to library",e);
        }
        String dvdStr;
        List<DVD> dvdList = this.listDVDs();
        for(DVD curDVD : dvdList){
            dvdStr = marshalDVD(curDVD);
            out.println(dvdStr);
            out.flush();
        }
        out.close();
        
    }
    
    //Title::releaseDate::mpaaRating::director::studio::note
    private String marshalDVD(DVD dvd){
        String dvdStr = dvd.getTitle()+DELIMITER;
        dvdStr+= dvd.getReleaseDate()+DELIMITER;
        dvdStr+= dvd.getMpaaRating()+DELIMITER;
        dvdStr+= dvd.getDirectorName()+DELIMITER;
        dvdStr+= dvd.getStudio()+DELIMITER;
        dvdStr+= dvd.getNote();
        
        return dvdStr;
    }
    
    @Override
    public DVD changeDVD(String[] changes, DVD dvdEdit){
        for(int i = 0; i<changes.length;i++){
            if("".equals(changes[i])){
                //nothing
            }else{
                switch(i){
                    case 0:
                        dvdEdit.setTitle(changes[i]);
                        break;
                    case 1:
                        dvdEdit.setReleaseDate(changes[i]);
                        break;
                    case 2: 
                        dvdEdit.setMpaaRating(changes[i]);
                        break;
                    case 3:
                        dvdEdit.setDirectorName(changes[i]);
                        break;
                    case 4:
                        dvdEdit.setStudio(changes[i]);
                        break;
                    case 5:
                        dvdEdit.setNote(changes[i]);
                }
            }
        }
        return dvdEdit;
    }
}
