/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdditionalScenes;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import seng300.Seng300;

/**
 * This is the controller for the archivedApplicationView fxml page
 * @author Stephen
 */
public class ArchivedApplicationViewFXMLController implements Initializable{
    private static String desiredApplication = "";
    
    @FXML
    private TextArea applicationInfo;
    @FXML
    private Button backButton;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        applicationInfo.setText(desiredApplication);
    }
    
    /**
     * Goes back to the archivedApplications page when the back button is pushed
     * @param event The event fired when the back button is pushed
     */
    @FXML
    private void goBack(javafx.event.ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("archivedApplications.fxml"));
            Scene sc = new Scene(root); 
            Stage s = Seng300.mainStage;
            s.setTitle("Archived Applications for " + ArchivedApplicationsFXMLController.getScholarshipName());
            s.setScene(sc);
            s.show();          
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    /**
     * Sets the desired application to be shown in full detail
     * @param application The desired application to be shown in full detail
     */
    public static void setDesiredApplication(String application) {
        desiredApplication = application;
    }
}
