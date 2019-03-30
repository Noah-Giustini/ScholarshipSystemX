//package details
package AdditionalScenes;
//imports
import backend.Application;
import backend.Scholarship;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
    //instance variables
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
    @FXML
    private Label GPAlbl;

    /**
     * Initializes the controller class.
     * 
     * Controls the application creation page.
     * Displays application form depending on scholarship
     * being applied to and gets entered information. 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Scholarship sch = Seng300.theManager.getCurrentScholarship();
        lblScholarshipName.setText(sch.getName());
        txtSchDescription.setText(sch.getDescription());
        if(!sch.getGPAReq()){
            txtGPA.setVisible(false);
            GPAlbl.setVisible(false);
        }
        
        if(!sch.getCustom1().isEmpty()){
            lblcus1.setVisible(true);
            lblcus1.setText(sch.getCustom1());
            txtCustom1.setVisible(true);
            if(!sch.getCustom2().isEmpty()){
                lblcus2.setVisible(true);
                lblcus2.setText(sch.getCustom2());
                txtCustom2.setVisible(true);
                if(!sch.getCustom3().isEmpty()){
                    lblcus3.setVisible(true);
                    lblcus3.setText(sch.getCustom1());
                    txtCustom3.setVisible(true);
                    if(!sch.getCustom4().isEmpty()){
                        lblcus4.setVisible(true);
                        txtCustom4.setVisible(true);
                        if(!sch.getCustom5().isEmpty()){
                            lblcus5.setVisible(true);
                            txtCustom5.setVisible(true);
                            if(!sch.getCustom6().isEmpty()){
                                lblcus6.setVisible(true);
                                txtCustom6.setVisible(true);
                                if(!sch.getCustom7().isEmpty()){
                                    lblcus7.setVisible(true);
                                    txtCustom7.setVisible(true);
                                    if(!sch.getCustom8().isEmpty()){
                                        lblcus8.setVisible(true);
                                        txtCustom8.setVisible(true);
                                        if(!sch.getCustom9().isEmpty()){
                                            lblcus9.setVisible(true);
                                            txtCustom9.setVisible(true);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    //i dont think we need this
    @FXML
    private void backFromScholarshipCreator(MouseEvent event) {
    }
    /**
     * This method will take a user from the application creator back to the main page
     * @param event mouse event generated by clicking the back button
     * @throws IOException 
     */
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
    //i dont think we need these
    @FXML
    private void handleSaveScholarship(MouseEvent event) {
    }
    /**
     * This method will save a draft application 
     * @param event mouse event generated by clicking the save button
     */
    @FXML
    private void saveApplication(ActionEvent event) {
        String name = Seng300.theManager.getUser();
        String sch = lblScholarshipName.getText();
        if(checkGPA() || !Seng300.theManager.getCurrentScholarship().getGPAReq()){
            if(rdioBachelors.isSelected()){
                try{
                Application newApp = new Application(sch, name, false);
                newApp.setEducationLevel("Bachelors");
                if(Seng300.theManager.getCurrentScholarship().getGPAReq()){
                    newApp.setGPA(Double.parseDouble(txtGPA.getText()));
                }
                maybeAddApp(Seng300.theManager.getDraftApplications(), newApp);
                JOptionPane.showMessageDialog(null, "Application has been saved ");
                }
                catch (Exception e){
                    System.out.println("Please stop throwing exception");
                    System.out.println("But the error was in SaveApplication in create application controller");
                }
            }
            else if(rdioMasters.isSelected()){
                try{
                Application newApp = new Application(sch, name, false);
                newApp.setEducationLevel("Masters");
                if(Seng300.theManager.getCurrentScholarship().getGPAReq()){
                    newApp.setGPA(Double.parseDouble(txtGPA.getText()));
                }
                maybeAddApp(Seng300.theManager.getDraftApplications(), newApp);
                JOptionPane.showMessageDialog(null, "Application has been saved ");
                }
                catch (Exception e){
                    System.out.println("Please stop throwing exception");
                    System.out.println("But the error was in SaveApplication in create application controller");
                }
            }
            else if(rdioDoctorate.isSelected()) {
                try{
                Application newApp = new Application(sch, name, false);
                newApp.setEducationLevel("Bachelors");
                if(Seng300.theManager.getCurrentScholarship().getGPAReq()){
                    newApp.setGPA(Double.parseDouble(txtGPA.getText()));
                }
                maybeAddApp(Seng300.theManager.getDraftApplications(), newApp);
                JOptionPane.showMessageDialog(null, "Application has been saved ");
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
                if(this.rdioBachelors.isSelected()){
                    newApp.setEducationLevel("Bachelors");
                }
                else if(this.rdioMasters.isSelected()){
                    newApp.setEducationLevel("Masters");
                }
                else{ //Doctorate is selected
                    newApp.setEducationLevel("Doctorate");
                }
                maybeAddApp(Seng300.theManager.getDraftApplications(), newApp);
                JOptionPane.showMessageDialog(null, "Application has been saved ");
                }
                catch (Exception e){
                    System.out.println("Please stop throwing exception");
                    System.out.println("But the error was in SaveApplication in create application controller");
                }
        }
        
        
        
    }
    //i dont think we need this
    @FXML
    private void handleSubmitScholarship(MouseEvent event) {
    }
    /**
     * This method will submit the inputs for a new application
     * @param event a mouse event generated by clicking the submit button
     */
    @FXML
    private void submitApplication(ActionEvent event) {
        if(isValid()){
            String sch = lblScholarshipName.getText();
            try{
                Application newApp = new Application(sch, Seng300.theManager.getUser(), true);
                newApp.setGPA(Double.parseDouble(txtGPA.getText()));
                if(this.rdioBachelors.isSelected()){
                    newApp.setEducationLevel("Bachelors");
                }
                else if(this.rdioMasters.isSelected()){
                    newApp.setEducationLevel("Masters");
                }
                else{ //Doctorate is selected
                    newApp.setEducationLevel("Doctorate");
                }
                maybeAddApp(Seng300.theManager.getStudentApplications(), newApp);
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
    
    /**
     * Method to check GPA
     * @return returns a true or false value if value given was good
     */
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
    /**
     * method to confirm that the input fields have been properly filled out
     * @return returns true or false based on the input fields for the page
     */
    private boolean isValid() {
        if (checkGPA()){
            //probably should do more but oh well
            return true;
        }
        else {
            return false;
        }
          
    }
    
    
    /**
     * will add the application to the given arraylist stored in manager.
     * If an application already exists for the same scholarship then it will
     * replace the old one with this one.
     * So basically you can apply and save as many times as you want but only the
     * most recent one will be saved 
     * @param apps  arraylist to add the application to (drafts or completed)
     * @param toAdd application to add to the arraylist
     */
    private void maybeAddApp(ArrayList<Application> apps, Application toAdd){
        boolean added = false;
        for(int i = 0; i< apps.size(); i++){
            if (apps.get(i).getScholarship().equals(toAdd.getScholarship())){
                apps.set(i, toAdd);
                added = true;
                break;
            }
        }
        if(!added){
            apps.add(toAdd);
        }
    }
    
    
    
    
}
