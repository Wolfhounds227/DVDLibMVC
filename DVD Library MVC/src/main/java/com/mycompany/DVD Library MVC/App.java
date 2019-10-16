/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.summative2;

import com.mycompany.summative2.DVDController.DVDController;
import com.mycompany.summative2.dao.DVDDao;
import com.mycompany.summative2.dao.DVDDaoFileImpl;
import com.mycompany.summative2.ui.DVDView;
import com.mycompany.summative2.ui.UserIO;
import com.mycompany.summative2.ui.UserIOConsoleImpl;

/**
 *
 * @author enjoi
 */
public class App {
  public static void main(String[] args) {
    UserIO myIo = new UserIOConsoleImpl();
    DVDView myView = new DVDView(myIo);
    DVDDao myDao = new DVDDaoFileImpl("test.txt");
    DVDController controller = 
            new DVDController(myDao, myView);
    controller.run();
}  
}
