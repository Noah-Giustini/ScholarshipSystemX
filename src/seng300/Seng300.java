/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seng300;

import backend.Manager;
import java.awt.event.ActionEvent;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Kaitlin
 */


public class Seng300 extends Application {
public static Stage mainStage;
public static Manager theManager;
    
    @Override
    public void start(Stage stage) throws Exception {
        //put something in here to create A.L of Scholarships and Applications
        //this will be stored here as instance variables
        
        Seng300.mainStage = stage;
        Seng300.theManager = new Manager();
        Parent root = FXMLLoader.load(getClass().getResource("adminMainPage.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
