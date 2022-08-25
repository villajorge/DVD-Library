/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.jv.dao;

/**
 * @author: Jorge Villa 
 * email: villajorge41@gmail.com
 * Date: 08/25/22
 * Purpose: DVDLibrary exception, inherits from exception
 * 
 */
public class DVDLibraryDaoException extends Exception{
    
    public DVDLibraryDaoException (String message){
        super(message);
    }
    
    public DVDLibraryDaoException (String message, Throwable cause){
        super(message, cause);
    }
}
