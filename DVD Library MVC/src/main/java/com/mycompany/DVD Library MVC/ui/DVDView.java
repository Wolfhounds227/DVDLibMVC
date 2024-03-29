/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.summative2.ui;

import com.mycompany.summative2.dao.DVDDao;
import com.mycompany.summative2.dao.DVDDaoFileImpl;
import com.mycompany.summative2.dtos.DVD;
import java.util.List;

/**
 *
 * @author enjoi
 */
public class DVDView {
 private UserIO io;
    public DVDView(UserIO io) {
    this.io = io;
}
    DVDDao dao = new DVDDaoFileImpl("");

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List DVD IDs");
        io.print("2. Create New DVD");
        io.print("3. View a DVD");
        io.print("4. Remove a DVD");
        io.print("5. edit a DVD");
        io.print("6.Search by title");
        io.print("7. Exit");

        return io.readInt("Please select from the above choices.", 1, 7);
    }

    public DVD getNewDVDInfo() {
//        String DVDId = io.readString("Please enter DVD ID");
        String DVDTitle = io.readString("Please enter a DVD Title");
        String DVDReleaseDate = io.readString("Please enter the DVD release Date");
        String DVDMPAARating = io.readString("Please enter the DVD MPAA Rating");
        String DVDDirectorsName = io.readString("Please enter the DVD Directors Name");
        String DVDStudio = io.readString("Please enter the DVD Studios name");
        String DVDUserRating = io.readString("Please enter the DVD User Rating");
        DVD currentDVD = new DVD();
//        currentDVD.setId(Integer.parseInt(DVDId));
        currentDVD.setTitle(DVDTitle);
        currentDVD.setReleaseDate(DVDReleaseDate);
        currentDVD.setMPAARating(Integer.parseInt(DVDMPAARating));
        currentDVD.setDirectorName(DVDDirectorsName);
        currentDVD.setStudio(DVDStudio);
        currentDVD.setUserRating(Integer.parseInt(DVDUserRating));
        return currentDVD;
    }

    public void displayCreateDVDBanner() {
        io.print("=== Create DVD ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString(
                "DVD successfully created.  Please hit enter to continue");
    }

    public void displayDVDList(List<DVD> DVDList) {
        for (DVD currentDVD : DVDList) {
            io.print(currentDVD.getId() + ": "
                    + currentDVD.getTitle() + " "
                    + currentDVD.getReleaseDate() + " "
                    + currentDVD.getMPAARating() + " "
                    + currentDVD.getDirectorName() + " "
                    + currentDVD.getStudio() + " "
                    + currentDVD.getUserRating());
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All DVDs ===");
    }

    public void displayDisplayDVDBanner() {
        io.print("=== Display DVD ===");
    }

    public String getDVDIdChoice() {
        return io.readString("Please enter the DVD ID.");
    }
    public String getDVDbyTitle(){
        return io.readString("Please enter the title of the DVD");
    }
    public int editDVDbyId(){
        return io.readInt("Please enter the Id of the DVD to Edit");
    }
    public void displayDVD(DVD dvd) {
        if (dvd != null) {
            io.print(dvd.getId());
            io.print(dvd.getTitle() + " " + dvd.getReleaseDate() + " ");
            io.print(dvd.getMPAARating() + " " + dvd.getDirectorName()+ " ");
            io.print(dvd.getStudio() + " " + dvd.getUserRating());
            io.print("");
        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveDVDBanner() {
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveSuccessBanner() {
        io.readString("DVD successfully removed. Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    public void displayErrorMessage(String errorMsg) {
    io.print("=== ERROR ===");
    io.print(errorMsg);
}
    public String displaySQLDVD(){
        return io.readString("Select * From DVD where DVDId= ");
        
    }
}
