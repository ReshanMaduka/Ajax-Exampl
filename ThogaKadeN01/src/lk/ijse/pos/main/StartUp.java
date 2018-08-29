/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.main;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import lk.ijse.pos.view.Main;

/**
 *
 * @author ranjith-suranga
 */
public class StartUp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        Logger lokuAiya = Logger.getLogger("");
        
        FileHandler fileHandler = new FileHandler("error.log",true);
        fileHandler.setFormatter(new SimpleFormatter());
        lokuAiya.addHandler(fileHandler);
        
        Main frmMain = new Main();
        frmMain.setVisible(true);
    }
    
}
