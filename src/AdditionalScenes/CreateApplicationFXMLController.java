//package details
package AdditionalScenes;
//imports

import backend.Application;
import backend.Scholarship;
import java.io.File;
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
import javafx.scene.control.ChoiceBox;
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
 * Controls the application creation page. Displays application form depending
 * on scholarship being applied to and gets entered information.
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
    @FXML
    private Label PriorityLevelLbl;
    @FXML
    private ChoiceBox priChoice;
    @FXML
    private Label dateLbl;
    @FXML
    private Label dueDateLbl;

    /**
     * Initializes the controller class.
     *
     * Controls the application creation page. Displays application form
     * depending on scholarship being applied to and gets entered information.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        boolean[] pri = Seng300.theManager.getPriority();
        for(int i = 0; i< pri.length; i++){
            if(!pri[i]){
                priChoice.getItems().add(i+1);
            }
        }
        priChoice.setValue(priChoice.getItems().get(0));
       
        
        if(Seng300.theManager.getEditModeApplication()){
            Application app = Seng300.theManager.getCurrentApplication();
            Scholarship sch = Seng300.theManager.getCurrentScholarship();
            dateLbl.setText(sch.getDueDate());
            if(!priChoice.getItems().contains(app.getPriority()) ){
                priChoice.getItems().add(app.getPriority());
                priChoice.setValue(app.getPriority());
            }
            
            lblScholarshipName.setText(sch.getName());
            txtSchDescription.setText(sch.getDescription());
            if (!sch.getGPAReq()) {
                txtGPA.setVisible(false);
                GPAlbl.setVisible(false);
            }
            else{
                txtGPA.setText(String.valueOf(app.getGPA()));
            }



            if (!sch.getCustom1().isEmpty()) {
                lblcus1.setVisible(true);
                lblcus1.setText(sch.getCustom1());
                txtCustom1.setVisible(true);
                
                if (!(app.getAnswer1().equals("--") || app.getAnswer1().trim().equals(""))){
                     txtCustom1.insertText(0, app.getAnswer1());
                }
            }
            
            if (!sch.getCustom2().isEmpty()) {
                lblcus2.setVisible(true);
                lblcus2.setText(sch.getCustom2());
                txtCustom2.setVisible(true);
                
                if (!(app.getAnswer2().equals("--") || app.getAnswer2().trim().equals(""))){
                     txtCustom2.insertText(0, app.getAnswer2());
                }
            }
            if (!sch.getCustom3().isEmpty()) {
                lblcus3.setVisible(true);
                lblcus3.setText(sch.getCustom3());
                txtCustom3.setVisible(true);
                
                if (!(app.getAnswer3().equals("--") || app.getAnswer3().trim().equals(""))){
                     txtCustom3.insertText(0, app.getAnswer3());
                }
            }
            if (!sch.getCustom4().isEmpty()) {
                lblcus4.setVisible(true);
                lblcus4.setText(sch.getCustom4());
                txtCustom4.setVisible(true);
                
                if (!(app.getAnswer4().equals("--") || app.getAnswer4().trim().equals(""))){
                     txtCustom4.insertText(0, app.getAnswer4());
                }
            }
            if (!sch.getCustom5().isEmpty()) {
                lblcus5.setVisible(true);
                lblcus5.setText(sch.getCustom5());
                txtCustom5.setVisible(true);
                
                if (!(app.getAnswer5().equals("--") || app.getAnswer5().trim().equals(""))){
                     txtCustom5.insertText(0, app.getAnswer5());
                }
            }
            if (!sch.getCustom6().isEmpty()) {
                lblcus6.setVisible(true);
                lblcus6.setText(sch.getCustom6());
                txtCustom6.setVisible(true);
                
                if (!(app.getAnswer6().equals("--") || app.getAnswer6().trim().equals(""))){
                     txtCustom6.insertText(0, app.getAnswer6());
                }
            }
            if (!sch.getCustom7().isEmpty()) {
                lblcus7.setVisible(true);
                lblcus7.setText(sch.getCustom7());
                txtCustom7.setVisible(true);
                
                if (!(app.getAnswer7().equals("--") || app.getAnswer7().trim().equals(""))){
                     txtCustom7.insertText(0, app.getAnswer7());
                }
            }
            if (!sch.getCustom8().isEmpty()) {
                lblcus8.setVisible(true);
                lblcus8.setText(sch.getCustom8());
                txtCustom8.setVisible(true);
                
                if (!(app.getAnswer8().equals("--") || app.getAnswer8().trim().equals(""))){
                     txtCustom8.insertText(0, app.getAnswer8());
                }
            }
            if (!sch.getCustom9().isEmpty()) {
                lblcus9.setVisible(true);
                lblcus9.setText(sch.getCustom9());
                txtCustom9.setVisible(true);
                
                if (!(app.getAnswer9().equals("--") || app.getAnswer9().trim().equals(""))){
                     txtCustom9.insertText(0, app.getAnswer9());
                }
            }
            
            if (!(app.getPriority() == 0)){
                     //set priority field
                }
            
            if ((app.getEducationLevel().equals("Bachelors"))){
                     rdioBachelors.setSelected(true);
                }
            if ((app.getEducationLevel().equals("Masters"))){
                     rdioMasters.setSelected(true);
                }
            if ((app.getEducationLevel().equals("Doctorate"))){
                     rdioDoctorate.setSelected(true);
                }
        }
        else{
        Scholarship sch = Seng300.theManager.getCurrentScholarship();
        dateLbl.setText(sch.getDueDate());
        lblScholarshipName.setText(sch.getName());
        txtSchDescription.setText(sch.getDescription());
        if(!sch.getGPAReq()){
            txtGPA.setVisible(false);
            GPAlbl.setVisible(false);
        }
        
        
        
        if(!sch.getCustom1().isEmpty() && !sch.getCustom1().equals("--")){
            lblcus1.setVisible(true);
            lblcus1.setText(sch.getCustom1());
            txtCustom1.setVisible(true);
            if(!sch.getCustom2().isEmpty() && !sch.getCustom2().equals("--")){
                lblcus2.setVisible(true);
                lblcus2.setText(sch.getCustom2());
                txtCustom2.setVisible(true);
                if(!sch.getCustom3().isEmpty() && !sch.getCustom3().equals("--")){
                    lblcus3.setVisible(true);
                    lblcus3.setText(sch.getCustom3());
                    txtCustom3.setVisible(true);
                    if(!sch.getCustom4().isEmpty()&& !sch.getCustom4().equals("--")){
                        lblcus4.setVisible(true);
                        lblcus4.setText(sch.getCustom4());
                        txtCustom4.setVisible(true);
                        if(!sch.getCustom5().isEmpty()&& !sch.getCustom5().equals("--")){
                            lblcus5.setVisible(true);
                            lblcus5.setText(sch.getCustom5());
                            txtCustom5.setVisible(true);
                            if(!sch.getCustom6().isEmpty() && !sch.getCustom6().equals("--")){
                                lblcus6.setVisible(true);
                                lblcus6.setText(sch.getCustom6());
                                txtCustom6.setVisible(true);
                                if(!sch.getCustom7().isEmpty() && !sch.getCustom7().equals("--")){
                                    lblcus7.setVisible(true);
                                    lblcus7.setText(sch.getCustom7());
                                    txtCustom7.setVisible(true);
                                    if(!sch.getCustom8().isEmpty() && !sch.getCustom8().equals("--")){
                                        lblcus8.setVisible(true);
                                        lblcus8.setText(sch.getCustom8());
                                        txtCustom8.setVisible(true);
                                        if(!sch.getCustom9().isEmpty()&& !sch.getCustom9().equals("--")){
                                            lblcus9.setVisible(true);
                                            lblcus9.setText(sch.getCustom9());
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
        try{
            Application newApp = new Application(sch, name, false);
            
            if(checkGPA()){
                newApp.setGPA(Double.parseDouble(txtGPA.getText()));
            }
            if(checkPriority()){
                newApp.setPriority((Integer) priChoice.getValue());
            }
            else{
                newApp.setPriority((Integer)priChoice.getItems().get(0));
            }

            if(rdioBachelors.isSelected()){
                newApp.setEducationLevel("Bachelors");
            }
            else if (rdioMasters.isSelected()){
                newApp.setEducationLevel("Masters");
            }
            else{
                newApp.setEducationLevel("Doctorate");
            }
            
            
            //custom questions
            if(txtCustom1.isVisible()){
                newApp.setAnswer1(txtCustom1.getText());
                if(txtCustom2.isVisible()){
                    newApp.setAnswer2(txtCustom2.getText());
                    if(txtCustom3.isVisible()){
                        newApp.setAnswer3(txtCustom3.getText());
                        if(txtCustom4.isVisible()){
                            newApp.setAnswer4(txtCustom4.getText());
                            if(txtCustom5.isVisible()){
                                newApp.setAnswer5(txtCustom5.getText());
                                if(txtCustom6.isVisible()){
                                    newApp.setAnswer6(txtCustom6.getText());
                                    if(txtCustom7.isVisible()){
                                        newApp.setAnswer7(txtCustom7.getText());
                                        if(txtCustom8.isVisible()){
                                            newApp.setAnswer8(txtCustom8.getText());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            //END OF CUSTOM QUESTIONS
            maybeAddApp(Seng300.theManager.getDraftApplications(), newApp);
            JOptionPane.showMessageDialog(null, "Application has been saved ");
        }   
        
        
        catch(Exception e){
          System.out.println("There was an exception thrown");
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
        Scholarship sch1 = Seng300.theManager.getCurrentScholarship();
        if(isValid()){
            String sch = lblScholarshipName.getText();
            try{
                Application newApp = new Application(sch, Seng300.theManager.getUser(), true);
                if(sch1.getGPAReq() && Seng300.theManager.getCurrentScholarship().getGPAReq()){
                    newApp.setGPA(Double.parseDouble(txtGPA.getText()));
                }
                if (checkPriority()){
                    newApp.setPriority((Integer) priChoice.getValue());
                }
                if(this.rdioBachelors.isSelected()){
                    newApp.setEducationLevel("Bachelors");
                }
                else if(this.rdioMasters.isSelected()){
                    newApp.setEducationLevel("Masters");
                }
                else{ //Doctorate is selected
                    newApp.setEducationLevel("Doctorate");
                }

                if (this.lblcus1.isVisible()){
                    newApp.setAnswer1(this.txtCustom1.getText());
                }
                if (this.lblcus2.isVisible()){
                    newApp.setAnswer2(this.txtCustom2.getText());
                }
                if (this.lblcus3.isVisible()){
                    newApp.setAnswer3(this.txtCustom3.getText());
                }
                if (this.lblcus4.isVisible()){
                    newApp.setAnswer4(this.txtCustom4.getText());
                }
                if (this.lblcus5.isVisible()){
                    newApp.setAnswer5(this.txtCustom5.getText());
                }
                if (this.lblcus6.isVisible()){
                    newApp.setAnswer6(this.txtCustom6.getText());
                }
                if (this.lblcus7.isVisible()){
                    newApp.setAnswer7(this.txtCustom7.getText());
                }
                if (this.lblcus8.isVisible()){
                    newApp.setAnswer8(this.txtCustom8.getText());
                }
                if (this.lblcus9.isVisible()){
                    newApp.setAnswer9(this.txtCustom9.getText());
                }
                maybeAddApp(Seng300.theManager.getStudentApplications(), newApp);
                JOptionPane.showMessageDialog(null, "Application has been submitted ");
                deleteDraft(newApp);

            }
            catch (Exception e){
                System.out.println("An exception has been thrown");
            }
        }
    }
    
        /*
    private boolean checkValidPriority(){
        String priority =  txtPriorityLvL.getText();
        int priorityIs;
        try{
            priorityIs = Integer.parseInt(priority);
        } catch (NumberFormatException e){
            return false;
        }
        
        if (priorityIs > 0 && priorityIs < 7){
            return true;
        }else{
            return false;
        }
    }    
    */    
    
    /**
     * Method to check GPA
     * @return returns a true or false value if value given was good
     */
    private boolean checkGPA(){
        if(!Seng300.theManager.getCurrentScholarship().getGPAReq()){
            return false;
        }
            String gpa = txtGPA.getText();
            double toCheck;
            try{
                toCheck = Double.parseDouble(gpa);
            }
            catch( NumberFormatException e){
                JOptionPane.showMessageDialog(null, "invalid GPA ");
                return false;
            }
        
            if(toCheck >= 0.0 && toCheck <= 4.0){
                return true;
            }
            else{
                JOptionPane.showMessageDialog(null, "invalid GPA ");
                return false;
            }  
 }
    
    /**
     * method to confirm that the input fields have been properly filled out
     * @return returns true or false based on the input fields for the page
     */
    private boolean isValid() {
        Scholarship sch = Seng300.theManager.getCurrentScholarship();
        if ((checkGPA() || !sch.getGPAReq()) && checkPriority() ){
            if(checkCustoms()){
                return true;
            }
            else{
                JOptionPane.showMessageDialog(null, "Please answer all the questions. ");
            }
        }
        else {
            return false;
   
        }
        return false;
          
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

    
    /**
     * checks whether Priority is valid 
     * @return true if it is valid
     */
    private boolean checkPriority() {

        int a = (Integer) priChoice.getValue();
        boolean[] pri =Seng300.theManager.getPriority();
        if( !pri[a-1] ){
            return true;
        }
 
        if(Seng300.theManager.getEditModeApplication()){
            String sch = Seng300.theManager.getCurrentApplication().getScholarship();
            Application app = Seng300.theManager.getStudentApplication(sch);
            if(!(app == null)){
                if(app.getPriority() == (Integer) priChoice.getValue()){
                    return true;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Priority already in use");
        return false;
    }
    
    private void deleteDraft(Application app){
        String schApp = app.getScholarship();
        for (Application a : Seng300.theManager.getDraftApplications()){
            if (schApp.equals(a.getScholarship())){
                Seng300.theManager.getDraftApplications().remove(a);
                a.delete();
                break;
            }
        }
        
    }
    
    
    /**
     * Sorry for this function but whatever it works. It makes sure
     * The hardest decisions require the strongest wills
     * -Thanos 2018
     * It will make sure the answers to the questions arent blank
     * @return true if answered all questions
     */
    private boolean checkCustoms(){
             if(txtCustom1.isVisible()){
                if(txtCustom1.getText().isEmpty()){
                    return false;
                }
                else{
                    if(txtCustom2.isVisible()){
                        if(txtCustom2.getText().isEmpty()){
                            return false;
                        }
                        else{
    
                            if(txtCustom3.isVisible()){
                                if(txtCustom3.getText().isEmpty()){
                                    return false;
                                }
                                else{ 
                                    if(txtCustom4.isVisible()){
                                        if(txtCustom4.getText().isEmpty()){
                                            return false;
                                        }
                                        else{
                                            if(txtCustom5.isVisible()){
                                                if(txtCustom5.getText().isEmpty()){
                                                    return false;
                                                }
                                                else{
                                                    if(txtCustom6.isVisible()){
                                                        if(txtCustom6.getText().isEmpty()){
                                                            return false;
                                                        }
                                                    else{
                                                        if(txtCustom7.isVisible()){
                                                            if(txtCustom7.getText().isEmpty()){
                                                                return false;
                                                            }
                                                            else{
                                                                if(txtCustom8.isVisible()){
                                                                    if(txtCustom8.getText().isEmpty()){
                                                                        return false;
                                                                    }
                                                                    else{
                                                                        if(txtCustom9.isVisible()){
                                                                            if(txtCustom9.getText().isEmpty()){
                                                                                return false;
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
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        
        return true;
    }
    
    
}
