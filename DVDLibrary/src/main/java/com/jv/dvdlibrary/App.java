/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.jv.dvdlibrary;

import com.jv.controller.DVDLibraryController;
import com.jv.dao.DVDLibraryDao;
import com.jv.dao.DVDLibraryDaoFileImpl;
import com.jv.ui.DVDLibraryView;
import com.jv.ui.UserIO;
import com.jv.ui.UserIOConsoleImpl;

/**
 * @author: Jorge Villa 
 * email: villajorge41@gmail.com
 * Date: 08/25/22
 * Purpose: Putting together all classes to run program
 * 
 */
public class App {
    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        DVDLibraryView view = new DVDLibraryView(io);
        DVDLibraryDao dao = new DVDLibraryDaoFileImpl();
        DVDLibraryController controller = new DVDLibraryController(dao, view);
        controller.run();
                
                
    }
}
