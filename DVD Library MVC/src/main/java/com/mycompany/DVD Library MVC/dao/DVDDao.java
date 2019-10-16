/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.summative2.dao;

/**
 *
 * @author enjoi
 */
import com.mycompany.summative2.dtos.DVD;
import java.util.List;

public interface DVDDao {

    List<DVD> getAll() throws DVDDaoException;

    DVD getById(int id) throws DVDDaoException;
    
    DVD getByTitle(String title) throws DVDDaoException;
    
    void removeById(int id) throws DVDDaoException;

    //compute the next valid id
    //update the student with that id
    //add the new student to the persistence
    //return the updated student
    DVD addDVD(DVD toAdd) throws DVDDaoException;

    //look up the data using the old id
    //replace it in the persistence with the new student data
    void editDVD(int oldId, DVD toEdit) throws DVDDaoException;

}
