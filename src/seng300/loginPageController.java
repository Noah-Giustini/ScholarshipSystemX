/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seng300;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import seng300.Seng300;
import backend.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * This class controls the loginPage fxml file and deals with logging in the
 * user
 *
 * @author Stephen
 */
public class loginPageController implements Initializable {

    @FXML
    private TextField loginUsernameField;
    @FXML
    private PasswordField loginPasswordField;
    @FXML
    private Button loginButton;
    @FXML
    private Label incorrectLoginLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Sets error message opacity to 0 (invisible)
        hideErrorMessage();
    }

    /**
     * Clears the error message when a user clicks on either textfield
     *
     * @param event The mouse event sent by clicking on the textfield
     */
    @FXML
    private void clearErrorDueToClick(MouseEvent event) {
        hideErrorMessage();
    }

    /**
     * Handles the login event when the user clicks the login button. Verifies
     * password is correct and that the account type is one of student or admin.
     * Reads through the login file to verify this information and makes
     * appropriate User class.
     *
     * @param event The event of clicking the login button
     */
    @FXML
    private void login(ActionEvent event) throws IOException{
        String enteredUsername = loginUsernameField.getText();
        String enteredPassword = loginPasswordField.getText();
        String type = "invalid";

        String passwordFromFile = "";
        String typeFromFile = "";

        //get filepath of user login file and attempt to read it for the password  
        File file = new File(getLoginFilePath(enteredUsername));
        try {
            Scanner scan = new Scanner(file);

            //parses login file and read in information
            while (scan.hasNextLine()) {
                String line = scan.nextLine();  //reads in password

                passwordFromFile = line.substring(line.indexOf(":") + 1);

                line = scan.nextLine();   //reads in type

                typeFromFile = line.substring(line.indexOf(":") + 1);
            }

            scan.close();
        } catch (FileNotFoundException e) {
            displayErrorMessage();
        }

        //verify password is correct
        if (passwordFromFile.equals(enteredPassword)) {
            if (typeFromFile.equals("student") || typeFromFile.equals("admin")) {    //verify type is one of the allowed types
                type = typeFromFile;
            } else {    //type incorrect
                System.out.println("ERROR: Invalid account type!");
            }
        } else {    //password incorrect
            displayErrorMessage();
        }

        if (!type.equals("invalid")) {   //valid login!
            User user = new User(enteredUsername, enteredPassword, type);

            System.out.println("Successfully logged in as: " + type);   //temporary confirmation message!
            //change view to either admin or student portal
        }

        if (type.equals("admin")) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("adminMainPage.fxml"));
                Scene sc = new Scene(root);
                Stage s = Seng300.mainStage;
                s.setTitle("Admin Main");
                s.setScene(sc);
                s.show();
            } catch (IOException e) {
                System.out.println("Something done fucked up");
            }
            

        }
        if (type.equals("student")) {
                    Seng300.theManager.loadApplications("Napolean");
                    Parent root = FXMLLoader.load(getClass().getResource("studentMainPage.fxml"));
                    Scene sc = new Scene(root);
                    Stage s = Seng300.mainStage;
                    s.setTitle("Student Main");
                    s.setScene(sc);
                    s.show();
                
            }
    }

    /**
     * Searches through the userLoginFiles folder and attempts to find the file
     * for the provided username and returns the path of the file if it finds it
     *
     * @param enteredUsername
     * @return filepath The path of the user login file
     */
    private String getLoginFilePath(String enteredUsername) {
        String filepath = "No such username";

        File dir = new File("src\\backend\\userLoginFiles\\");
        File[] directoryListing = dir.listFiles();

        if (directoryListing != null) {
            for (File child : directoryListing) {
                //takes off the .txt part of the file name
                String fileName = child.getName().substring(0, child.getName().length() - 4);

                if (fileName.equals(enteredUsername)) {  //file username matches
                    //open file and grab password
                    filepath = child.getPath();
                }
            }
        }

        return filepath;

    }

    /**
     * Displays the red error message saying "Invalid username or password"
     */
    private void displayErrorMessage() {
        incorrectLoginLabel.setOpacity(1);
    }

    /**
     * Hides the red error message saying "Invalid username or password"
     */
    private void hideErrorMessage() {
        incorrectLoginLabel.setOpacity(0);
    }

}
