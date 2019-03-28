/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdditionalScenes;

import backend.Application;
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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import seng300.Seng300;

/**
 * FXML Controller class
 *
 * @author Kaitlin
 */
public class CreateApplicationFXMLController implements Initializable {

    @FXML
    private Button buttonBack;
    @FXML
    private Font x1;
    @FXML
    private Button buttonSaveProgress;
    @FXML
    private Button buttonSubmitApplication;
    @FXML
    private TextArea txtSchDescription;
    @FXML
    private Label lblcus1;
    @FXML
    private TextArea txtCustom1;
    @FXML
    private Label lblcus2;
    @FXML
    private TextArea txtCustom2;
    @FXML
    private Label lblcus3;
    @FXML
    private TextArea txtCustom3;
    @FXML
    private Label lblcus4;
    @FXML
    private TextArea txtCustom4;
    @FXML
    private Label lblcus5;
    @FXML
    private TextArea txtCustom5;
    @FXML
    private TextArea txtCustom6;
    @FXML
    private Label lblcus6;
    @FXML
    private Label lblcus7;
    @FXML
    private TextArea txtCustom7;
    @FXML
    private Label lblcus8;
    @FXML
    private TextArea txtCustom8;
    @FXML
    private Label lblcus9;
    @FXML
    private TextArea txtCustom9;
    @FXML
    private Label lblScholarshipName;
    @FXML
    private TextField txtGPA;
    @FXML
    private RadioButton rdioBachelors;
    @FXML
    private ToggleGroup EDUlevel;
    @FXML
    private RadioButton rdioMasters;
    @FXML
    private RadioButton rdioDoctorate;
    @FXML
    private Color x4;
    @FXML
    private Font x3;
    @FXML
    private Label statustxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backFromScholarshipCreator(MouseEvent event) {
    }

    @FXML
    private void backFromApplicationCreator (ActionEvent event) throws IOException {
        Seng300.theManager.setEditMode(false);
        Parent root = FXMLLoader.load(getClass().getResource("/seng300/studentMainPage.fxml"));
        Scene sc = new Scene(root);
        Stage s = Seng300.mainStage; 
        s.setTitle("Home");
        s.setScene(sc);
        s.show();
    }

    @FXML
    private void handleSaveScholarship(MouseEvent event) {
    }

    @FXML
    private void saveApplication(ActionEvent event) {
        String name = Seng300.theManager.getUser();
        String sch = lblScholarshipName.getText();
        if(checkGPA()){
            if(rdioBachelors.isSelected()){
                try{
                Application newApp = new Application(sch, name, false);
                Seng300.theManager.addDraftApplication(newApp);
                }
                catch (Exception e){
                    System.out.println("Please stop throwing exception");
                    System.out.println("But the error was in SaveApplication in create application controller");
                }
            }
            else if(rdioMasters.isSelected()){
                try{
                Application newApp = new Application(sch, name, false);
                Seng300.theManager.addDraftApplication(newApp);
                }
                catch (Exception e){
                    System.out.println("Please stop throwing exception");
                    System.out.println("But the error was in SaveApplication in create application controller");
                }
            }
            else if(rdioDoctorate.isSelected()) {
                try{
                Application newApp = new Application(sch, name, false);
                Seng300.theManager.addDraftApplication(newApp);
                }
                catch (Exception e){
                    System.out.println("Please stop throwing exception");
                    System.out.println("But the error was in SaveApplication in create application controller");
                }
            }
        }
        else{ //GPA not valid or missing
            try{
                Application newApp = new Application(sch, name, false);
                Seng300.theManager.addDraftApplication(newApp);
                }
                catch (Exception e){
                    System.out.println("Please stop throwing exception");
                    System.out.println("But the error was in SaveApplication in create application controller");
                }
        }
        
        
        
    }

    @FXML
    private void handleSubmitScholarship(MouseEvent event) {
    }

    @FXML
    private void submitApplication(ActionEvent event) {
        if(isValid()){
            String sch = lblScholarshipName.getText();
            try{
                Application newApp = new Application(sch, Seng300.theManager.getUser(), true);
                Seng300.theManager.addApplication(newApp);
                JOptionPane.showMessageDialog(null, "Application has been submitted ");
                }
                catch (Exception e){
                    System.out.println("Please stop throwing exception");
                    System.out.println("But the error was in handle submit Application in create application controller");
                }
        }
        else{
            JOptionPane.showMessageDialog(null, "Please enter all required fields properly ");
        }
    }
    
    
    private boolean checkGPA(){
        String gpa = txtGPA.getText();
        double toCheck;
        try{
            toCheck = Double.parseDouble(gpa);
        }
        catch( NumberFormatException e){
            return false;
        }
        
        if(toCheck >= 0.0 && toCheck <= 4.0){
            return true;
        }
        else{
            return false;
        }  
    }

    private boolean isValid() {
        if (checkGPA()){
            //probably should do more but oh well
            return true;
        }
        else {
            return false;
        }
          
    }
    
    
    
}