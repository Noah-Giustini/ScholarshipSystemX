/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdditionalScenes;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import seng300.Seng300;

/**
 * FXML Controller class
 *
 * @author Noah
 */
public class StudentApplicationViewController implements Initializable {

    @FXML
    private Button backButton;
    @FXML
    private Button acceptButton;
    @FXML
    private Button withdrawButton;
    @FXML
    private ScrollPane scrollWindow;
    @FXML
    private TextArea applicationInfo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.applicationInfo.setText(Seng300.theManager.getCurrentApplication().toString());
    }    

    @FXML
    private void backToViewApplications(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/seng300/studentMainPage.fxml"));
        Scene sc = new Scene(root);
        Stage s = Seng300.mainStage; 
        s.setTitle("Home");
        s.setScene(sc);
        s.show();
    }

    @FXML
    private void accept(ActionEvent event) {
        
    }
    
    @FXML
    private void withdraw(ActionEvent event) {
        
    }

    
    
}
