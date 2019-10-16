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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DVDDaoFileImpl implements DVDDao {

    String path;

    public DVDDaoFileImpl(String path) {

        this.path = path;
    }

    //NOPE
    //List<Student> allTheData = new List blah blah blah
    @Override
    public List<DVD> getAll() throws DVDDaoException {

        List<DVD> toReturn = new ArrayList<>();

        FileReader reader = null;
        try {
            reader = new FileReader(path);
            Scanner scn = new Scanner(reader);

            while (scn.hasNextLine()) {
                String line = scn.nextLine();
                if (line.length() > 0) {
                    String[] cells = line.split("::");

                    DVD toAdd = new DVD();
                    toAdd.setId(Integer.parseInt(cells[0]));
                    toAdd.setTitle(cells[1]);
                    toAdd.setReleaseDate(cells[2]);
                    toAdd.setMPAARating(Integer.parseInt(cells[3]));
                    toAdd.setDirectorName(cells[4]);
                    toAdd.setStudio(cells[5]);
                    toAdd.setUserRating(Integer.parseInt(cells[6]));

                    toReturn.add(toAdd);
                }
            }
        } catch (FileNotFoundException ex) {
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ex) {
                throw new DVDDaoException("Could not close reader for " + path, ex);
            }
        }

        return toReturn;
    }

    @Override
    public DVD getById(int id) throws DVDDaoException {
        DVD toReturn = null;

        List<DVD> allDVDs = getAll();

        for (DVD toCheck : allDVDs) {
            if (toCheck.getId() == id) {
                toReturn = toCheck;
                break;
            }
        }

        return toReturn;
    }
    
    @Override
    public DVD getByTitle(String title) throws DVDDaoException{
        DVD toReturn = null;
        List<DVD> allDVDs = getAll();
        
        for(DVD toCheck : allDVDs){
            if(toCheck.getTitle().equalsIgnoreCase(title)){
                toReturn = toCheck;
                break;
        }
        }
        return toReturn;
    }
    @Override
    public void removeById(int id) throws DVDDaoException {

        List<DVD> allDVDs = getAll();

        int matchIndex = -1;

        for (int i = 0; i < allDVDs.size(); i++) {
            DVD toCheck = allDVDs.get(i);

            if (toCheck.getId() == id) {
                matchIndex = i;
                break;
            }
        }

        if (matchIndex == -1) { //didn't find a match
            throw new DVDDaoException("ERROR: could not remove DVD with id " + id);
        }

        allDVDs.remove(matchIndex);

        writeFile(allDVDs);
    }

    public DVD addDVD(DVD toAdd) throws DVDDaoException {
        List<DVD> allDVDs = getAll();

        int newId = 0;

        for (DVD toCheck : allDVDs) {
            if (toCheck.getId() > newId) {
                newId = toCheck.getId();
            }
        }

        newId++;
        toAdd.setId(newId);

        allDVDs.add(toAdd);

        writeFile(allDVDs);

        return toAdd;
    }

    @Override
    public void editDVD( int oldId, DVD edited  ) throws DVDDaoException {

        List<DVD> allDVDs = getAll();

        int matchIndex = -1;

        for (int i = 0; i < allDVDs.size(); i++) {
            DVD toCheck = allDVDs.get(i);

            if (toCheck.getId() == oldId) {
                matchIndex = i;
                break;
            }
        }

        if (matchIndex == -1) { //we didn't find a match

            throw new DVDDaoException("ERROR: could not edit DVD with id " + oldId);
        }

        allDVDs.remove(matchIndex);
        allDVDs.add(edited);

        writeFile(allDVDs);
    }

    private void writeFile(List<DVD> allDVDs) throws DVDDaoException {

        FileWriter writer = null;
        try {
            writer = new FileWriter(path);
            PrintWriter pw = new PrintWriter(writer);

            for (DVD toWrite : allDVDs) {
                String line = convertToLine(toWrite);
                pw.println(line);
            }
        } catch (IOException ex) {
            throw new DVDDaoException("ERROR: could not write to " + path, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                throw new DVDDaoException("ERROR: could not close writer for " + path, ex);
            }
        }
    }

    private String convertToLine(DVD toWrite) {

        String line
                = toWrite.getId() + "::"
                + toWrite.getTitle() + "::"
                + toWrite.getReleaseDate() + "::"
                + toWrite.getMPAARating() + "::"
                + toWrite.getDirectorName() + "::"
                + toWrite.getStudio() + "::"
                + toWrite.getUserRating();

        return line;
    }

}
