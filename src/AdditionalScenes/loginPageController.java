/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdditionalScenes;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import seng300.Seng300;
import backend.Manager;

/**
 *
 * @author Stephen
 */
public class loginPageController implements Initializable{
    
     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    /*TODO Features
        -When login button is pressed, the entered username and password are temporarily "stored"
        -The backend.userLoginFiles folder is searched for USERNAME.txt, error if can't be found
        -if the login file is found, it is opened and the password is checked against the given password
        -if given password doesn't match show error
        -otherwise the type is checked from the login file and the appropriate portal is opened (student, admin)
    */
}
