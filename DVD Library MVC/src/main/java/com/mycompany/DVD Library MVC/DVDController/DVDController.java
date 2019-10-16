/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.summative2.DVDController;

import com.mycompany.summative2.dao.DVDDao;
import com.mycompany.summative2.dao.DVDDaoException;
import com.mycompany.summative2.dtos.DVD;
import com.mycompany.summative2.ui.DVDView;
import java.util.List;

/**
 *
 * @author enjoi
 */
public class DVDController {
DVDView view;
DVDDao dao;

public DVDController(DVDDao dao, DVDView view) {
    this.dao = dao;
    this.view = view;
}

public void run() {
    boolean keepGoing = true;
    int menuSelection = 0;
    try {
        while (keepGoing) {

            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    listDVDs();
                    break;
                case 2:
                    createDVD();
                    break;
                case 3:
                    viewDVD();
                    break;
                case 4:
                    removeDVD();
                    break;
                
                case 5:
                    editDVD();
                    break;
                case 6:
                    titleSDVD();
                    break;
                case 7:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }

        }
        exitMessage();
    } catch (DVDDaoException e) {
        view.displayErrorMessage(e.getMessage());
    }
}
    

private int getMenuSelection() {
    return view.printMenuAndGetSelection();
}

private void createDVD() throws DVDDaoException {
    view.displayCreateDVDBanner();
    DVD newDVD = view.getNewDVDInfo();
    dao.addDVD(newDVD);
    view.displayCreateSuccessBanner();
}

private void listDVDs() throws DVDDaoException {
    view.displayDisplayAllBanner();
    List<DVD> DVDList = dao.getAll();
    view.displayDVDList(DVDList);
}
private void viewDVD() throws DVDDaoException {
    String DVDId = view.displaySQLDVD();
//    String DVDId = view.getDVDIdChoice();
    DVD DVD = dao.getById(Integer.parseInt(DVDId));
    view.displayDVD(DVD);
}

private void removeDVD() throws DVDDaoException {
    view.displayRemoveDVDBanner();
    int DVDId = Integer.parseInt(view.getDVDIdChoice());
    dao.removeById(DVDId);
    view.displayRemoveSuccessBanner();
}

private void unknownCommand() {
    view.displayUnknownCommandBanner();
}

private void exitMessage() {
    view.displayExitBanner();
}

    private void editDVD() throws DVDDaoException {
        int DVDedit = view.editDVDbyId();
        DVD DVD = dao.getById(DVDedit);
        view.displayDVD(DVD);
        DVD newDVD = view.getNewDVDInfo();
        newDVD.setId(DVDedit);
        dao.editDVD((DVDedit), newDVD);
        view.displayDVD(newDVD);
    }

    private void titleSDVD() throws DVDDaoException {
            String DVDtitle = view.getDVDbyTitle();
            DVD DVD = dao.getByTitle(DVDtitle);
            view.displayDVD(DVD);
                    }
}

