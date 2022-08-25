/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jv.dao;

import com.jv.dto.DVD;
import java.util.List;

/**
 *
 * @author offbe
 */
public interface DVDLibraryDao {
    DVD addDVD(String dvdName, DVD dvd) throws DVDLibraryDaoException;
    
    DVD removeDVD(String dvdName)throws DVDLibraryDaoException;
    
    DVD editDVD(String dvdName)throws DVDLibraryDaoException;
    
    List<DVD> listDVDs()throws DVDLibraryDaoException;
    
    DVD listDVD(String dvdName)throws DVDLibraryDaoException;
    
    DVD findDVD(String dvdName)throws DVDLibraryDaoException;

    DVD changeDVD(String[] edits, DVD editDVD)throws DVDLibraryDaoException;
}
