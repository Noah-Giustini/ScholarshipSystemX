/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdditionalScenes;

import java.io.IOException;
import java.util.ArrayList;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import seng300.Seng300;
import backend.*;

/**
 * FXML Controller class
 *
 * @author Kaitlin
 */
public class ApplicationsController implements Initializable {

    @FXML
    private Button backFromApplicationWindow;
    @FXML
    private TextArea ApplicationText1;
    @FXML
    private TextArea ApplicationText2;
    
    @FXML
    private TextArea ApplicationText3;
    @FXML
    private TextArea ApplicationText4;
    @FXML
    private TextArea ApplicationText5;
    @FXML
    private Button view1;
    @FXML
    private Button EditApplicationList;
    @FXML
    private RadioButton radio1;
    @FXML
    private RadioButton radio2;
    @FXML
    private RadioButton radio3;
    @FXML
    private RadioButton radio4;
    @FXML
    private RadioButton radio5;
    @FXML
    private ToggleGroup ListView;
    @FXML
    private Button refresh;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        startUp();
    }    
    
    @FXML
    private void backToMain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/seng300/adminMainPage.fxml"));
        Scene sc = new Scene(root);
        Stage s = Seng300.mainStage; 
        s.setTitle("Home");
        s.setScene(sc);
        s.show();
    }

    @FXML
    private void openViewApplication(ActionEvent event) throws IOException {
        Scholarship schol = Seng300.theManager.getCurrentScholarship();
        ArrayList<Application> apps = schol.getApplications();
        int index = 0;
        if (radio1.isSelected()){
            index = 0;
        }
        else if (radio2.isSelected()){
            index = 1;
        }
        else if (radio3.isSelected()){
            index = 2;
        }
        else if (radio4.isSelected()){
            index = 3;
        }
        else if (radio5.isSelected()){
            index = 4;
        }
        try{
            Seng300.theManager.setCurrentApplication(apps.get(index));
            Parent root = FXMLLoader.load(getClass().getResource("/AdditionalScenes/ApplicationView.fxml"));
            Scene sc = new Scene(root);
            Stage s = Seng300.mainStage; 
            s.setTitle("Home");
            s.setScene(sc);
            s.show();
        }
        catch(IndexOutOfBoundsException e){
            
        }
        
    }

    @FXML
    private void openEditApplication(ActionEvent event) {
        if (radio1.isSelected()){
        
        } else if (radio2.isSelected()){
        
        } else if (radio3.isSelected()){
        
        } else if (radio4.isSelected()){
        
        } else if (radio5.isSelected()){
        
        } else {
        
        
        }    
    }
    
    @FXML
    private void refreshPage(ActionEvent event){
        
    }
    
    
    private void startUp(){
         Scholarship s = Seng300.theManager.getCurrentScholarship();
        ArrayList<String> apps = Seng300.theManager.showApplications(s);
        if (apps.size()>0){
            ApplicationText1.setText(apps.get(0));
        }
        if (apps.size()>1){
            ApplicationText2.setText(apps.get(1));
        }
        if (apps.size()>2){
            ApplicationText3.setText(apps.get(2));
        }
        if (apps.size()>3){
            ApplicationText4.setText(apps.get(3));
        }
        if (apps.size()>4){
            ApplicationText5.setText(apps.get(4));
        }
        
        //load all applications from a scholarship provided by the manager
        //1st step Manager.getCurrentScholarship()
        //2nd step showSubmittedScholarships() gives an arraylist of strings 
        // 3rd loop through the list, if it goes past 5 don't do anything otherwise just fill however many you can 
        //probably don't actually need to loop but it will be good if we end up having more windows - no use limiting ourselves
        
    }
}
    
    
    
    
    
    

