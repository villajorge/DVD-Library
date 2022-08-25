/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.jv.controller;

import com.jv.dao.DVDLibraryDao;
import com.jv.dao.DVDLibraryDaoException;
import com.jv.dto.DVD;
import com.jv.ui.DVDLibraryView;
import java.util.List;

/**
 * @author: Jorge Villa 
 * email: villajorge41@gmail.com
 * Date: 08/24/22
 * Purpose: The controller of the program, tells each class when and what to do
 * 
 */
public class DVDLibraryController {
    private DVDLibraryView view;
    private DVDLibraryDao dao;
    
    public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view ){
        this.dao = dao;
        this.view = view;
    }
    
    //
    public void run(){
        boolean keepGoing = true;
        int selection = 0;
        int editSelection = 0;
        int addSelection = 0;
        int removeSelection = 0;
        try{
            while (keepGoing){
                selection = getSelection();
                switch(selection){
                    case 1:
                        do{
                        addDVD();
                        addSelection = view.printAddMenuAndSelect();
                        }while (addSelection == 1);
                        break;
                    case 2:
                        do{
                        removeDVD();
                        removeSelection = view.printRemoveMenuAndSelect();
                        }while (removeSelection == 1);
                        break;
                    case 3: 
                        do{
                            editDVD();
                            editSelection = view.printEditMenuAndSelect();
                        }while(editSelection == 1);
                        break;
                    case 4:
                        listDVDs();
                        break;
                    case 5:
                        displayDVD();
                        break;
                    case 6:
                        findDVD();
                        break;
                    case 7:
                        keepGoing = false;
                        break;
                    default:
                        printUnknown();
                        break;
                        
                }
            }
             view.printExit();
        }catch(DVDLibraryDaoException e){
            view.displayError(e.getMessage());
        }
    }
    
    private void printUnknown(){
        view.printUnknown();
    }
    
    private int getSelection(){
        return view.printMenuAndSelect();
    }
    
    private void addDVD() throws DVDLibraryDaoException{
        view.printAddBanner();
        DVD newDVD = view.getDVDInfo();
        dao.addDVD(newDVD.getTitle(),newDVD);
        view.printAddOutcome(newDVD);
    }
    
    private void removeDVD()throws DVDLibraryDaoException{
        view.printRemoveBanner();
        String title = view.getDVDChoice();
        DVD removedDVD = dao.removeDVD(title);
        view.printRemoveOutcome(removedDVD);
    }
    
    private void listDVDs() throws DVDLibraryDaoException{
        view.printListBanner();
        List<DVD> dvds = dao.listDVDs();
        for(DVD dvd : dvds){
            view.displayDVD(dvd);
        }
        
    }
    
    private void displayDVD() throws DVDLibraryDaoException{
        view.printDisplayBanner();
        String dvdName = view.getDVDChoice();
        DVD displayDVD = dao.listDVD(dvdName);
        view.displayDVD(displayDVD);
    }
    
    private void findDVD() throws DVDLibraryDaoException{
        view.printFindBanner();
        String dvdName = view.displayTitlesGetChoice(dao.listDVDs());
        DVD foundDVD = dao.findDVD(dvdName);
        view.displayDVD(foundDVD);
    }
    
    private void editDVD() throws DVDLibraryDaoException{
        view.printEditBanner();
        String dvdName = view.getDVDChoice();
        DVD editDVD = dao.editDVD(dvdName);
        DVD changedDVD = dao.changeDVD(view.getEdits(editDVD),editDVD);
        DVD newDVD = dao.addDVD(changedDVD.getTitle(), changedDVD);
        view.printAddOutcome(newDVD);
    }
}
