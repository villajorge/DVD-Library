/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.jv.ui;

import com.jv.dto.DVD;
import java.util.List;

/**
 * @author: Jorge Villa 
 * email: villajorge41@gmail.com
 * Date: 08/24/22
 * Purpose: IO for application
 * 
 */
public class DVDLibraryView {
    private UserIO io;
    public DVDLibraryView(UserIO io){
        this.io = io;
    }
    
    //display and get menu selction
    public int printMenuAndSelect(){
        io.print("=== Main Menu ===");
        io.print("1. Add DVD");
        io.print("2. Remove DVD");
        io.print("3. Edit DVD");
        io.print("4. List all DVDs");
        io.print("5. Display DVD info");
        io.print("6. Search DVD by Title");
        io.print("7. Quit");
        
        return io.readInt("Select option from above",1,7);
    }
    
    public void printAddBanner(){
        io.print("=== Add DVD ===");
    }
    
     public void printUnknown(){
        io.print("Unknown Command");
    }
    
    public void printRemoveBanner(){
        io.print("=== Remove DVD ===");
    }
    
    public void printEditBanner(){
        io.print("=== Edit DVD ===");
    }
    
    public void printListBanner(){
        io.print("=== List all DVDs ===");
    }
    
    public void printDisplayBanner(){
        io.print("=== Display Certain DVD ===");
    }
    
    public void printFindBanner(){
        io.print("=== Find Title ===");
    }
    
    public void displayError(String error){
        io.print("=== Error ===");
        io.print(error);
    }
    
    //Print the outcome of add
    public void printAddOutcome(DVD dvd){
        if(dvd != null){
            io.print("Successfully added: "+dvd.getTitle());
        }else{
            io.print("No such DVD");
        }
        //io.readString("Please hit enter to continue");
    }
    
    //Print the outcome of remove
    public void printRemoveOutcome(DVD dvd){
        if (dvd!=null){
            io.print("Successfully removed "+dvd.getTitle()+" from library");
        }else{
            io.print("DVD not found in library");
        }
        //io.readString("Please hit enter to continue");
    }
    
    //Title::releaseDate::mpaaRating::director::studio::note
    //Get info to add new DVD into map
    public DVD getDVDInfo(){
        DVD dvd = new DVD(io.readString("Enter title of DVD: "));
        dvd.setReleaseDate(io.readString("Enter the release date: "));
        dvd.setMpaaRating(io.readString("Enter the MPAA rating: "));
        dvd.setDirectorName(io.readString("Enter the director name: "));
        dvd.setStudio(io.readString("Enter the studio name: "));
        dvd.setNote(io.readString("Enter any additional notes: "));
        
        return dvd;
    }
    
    public String getDVDChoice(){
        return io.readString("Enter the title of the DVD: ");
    }
    
    //display contents of dvd
    public void displayDVD(DVD dvd){
        if(dvd != null){
            io.print("Title: "+dvd.getTitle());
            io.print("Release Date: "+dvd.getReleaseDate());
            io.print("MPAA Rating: "+dvd.getMpaaRating());
            io.print("Director's Name: "+dvd.getDirectorName());
            io.print("Studio: "+dvd.getStudio());
            io.print("Addtional Notes: "+dvd.getNote());
            io.print("");
        }else{
            io.print("DVD not in library");
        }
    }
 
    //display all titles and ask which user is looking for
    public String displayTitlesGetChoice(List<DVD> dvds){
        io.print("Here are the titles: ");
        for (DVD curDVD : dvds){
            io.print(curDVD.getTitle());
        }
        return io.readString("Enter the title are you looking for: ");
    }
    
    //Does user want to edit another DVD in session
    public int printEditMenuAndSelect(){
        io.print("Would you like to edit another DVD?");
        io.print("1. yes");
        io.print("2. no");
        return io.readInt("Enter choice from above",1,2);          
    }
    
    //Does user want to add another DVD in session
    public int printAddMenuAndSelect(){
        io.print("Would you like to add another DVD?");
        io.print("1. yes");
        io.print("2. no");
        return io.readInt("Enter choice from above",1,2);          
    }
    
    //Does user want to remove another DVD in session
    public int printRemoveMenuAndSelect(){
        io.print("Would you like to remove another DVD?");
        io.print("1. yes");
        io.print("2. no");
        return io.readInt("Enter choice from above",1,2);          
    }
    
    //Getting what user wants to edit
    public String[] getEdits(DVD dvd){
        String[] changes = new String[6];
        io.print("Currently editing: "+dvd.getTitle());
        changes[0] = io.readString("Enter new title (Hit enter if no change): ");
        changes[1] = io.readString("Enter new release date (Hit enter if no change): ");
        changes[2] = io.readString("Enter new MPAA rating (Hit enter if no change): ");
        changes[3] = io.readString("Enter new director (Hit enter if no change): ");
        changes[4] = io.readString("Enter new studio (Hit enter if no change): ");
        changes[5] = io.readString("Enter new note (Hit enter if no change): ");
        return changes;
    }
    
    public void printExit(){
        io.print("Good bye!");
    }
    
   
}
