/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seng300;

import backend.Application;
import backend.Scholarship;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * Controls main student page for selecting and applying to scholarships.
 * 
 * @author Kaitlin
 */
public class StudentMainPageController implements Initializable {

    @FXML
    private ScrollPane currentScholarshipScrollPane;
    @FXML
    private RadioButton radioSchol1;
    @FXML
    private ToggleGroup ListOfSchols;
    @FXML
    private RadioButton radioSchol2;
    @FXML
    private RadioButton radioSchol3;
    @FXML
    private RadioButton radioSchol4;
    @FXML
    private RadioButton radioSchol5;
    @FXML
    private Label lblScholarship1;
    @FXML
    private Label lbldate1;
    @FXML
    private Label lblScholarship2;
    @FXML
    private Label lbldate2;
    @FXML
    private Label lblScholarship3;
    @FXML
    private Label lbldate3;
    @FXML
    private Label lblScholarship4;
    @FXML
    private Label lbldate4;
    @FXML
    private Label lblScholarship5;
    @FXML
    private Label lbldate5;
    @FXML
    private Label lbldate6;
    @FXML
    private Label lblScholarship7;
    @FXML
    private Label lbldate7;
    @FXML
    private RadioButton radioSchol6;
    @FXML
    private RadioButton radioSchol7;
    @FXML
    private Label lblScholarship6;
    @FXML
    private ScrollPane historyScrollPane;
    @FXML
    private Label lblDraft1;
    @FXML
    private RadioButton rdoDraft1;
    @FXML
    private ToggleGroup ListOfDrafts;
    @FXML
    private RadioButton rdoDraft2;
    @FXML
    private RadioButton rdoDraft3;
    @FXML
    private RadioButton rdoDraft4;
    @FXML
    private RadioButton rdoDraft5;
    @FXML
    private RadioButton rdoDraft6;
    @FXML
    private RadioButton rdoDraft7;
    @FXML
    private Button adminMainPageLogoutButton;
    @FXML
    private Button viewApplicationsButton;
    @FXML
    private Button buttonEditDraft;
    @FXML
    private Label schstatuslbl;
    @FXML
    private Button buttonEdit;
    @FXML
    private ScrollPane historyScrollPane1;
    @FXML
    private RadioButton rdoDraft11;
    @FXML
    private ToggleGroup ListOfDrafts1;
    @FXML
    private RadioButton rdoDraft21;
    @FXML
    private RadioButton rdoDraft31;
    @FXML
    private RadioButton rdoDraft41;
    @FXML
    private RadioButton rdoDraft51;
    @FXML
    private RadioButton rdoDraft61;
    @FXML
    private RadioButton rdoDraft71;
    @FXML
    private Label lblOpenSchol1;
    @FXML
    private Label lblOpenSchol2;
    @FXML
    private Label lblOpenSchol3;
    @FXML
    private Label lblOpenSchol4;
    @FXML
    private Label lblOpenSchol5;
    @FXML
    private Label lblOpenSchol6;
    @FXML
    private Label lblOpenSchol7;
    @FXML
    private Label lblDraft2;
    @FXML
    private Label lblDraft3;
    @FXML
    private Label lblDraft4;
    @FXML
    private Label lblDraft5;
    @FXML
    private Label lblDraft6;
    @FXML
    private Label lblDraft7;
    @FXML
    private Button ButtonEditSubmit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        applicationStartUp();
        draftApplicationStartUp();
        schStartUp();
        System.out.println(Seng300.theManager.getScholarships());
        
    }    
    
    
    /**
     * Logouts current student and returns to the login page
     * @param event event that triggers handler(button click)
     */
    @FXML
    private void handleLogoutStu(javafx.event.ActionEvent event){
    try{
        Seng300.theManager.clearOnLogout();
        Parent root = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        Scene sc = new Scene(root);
        Stage s = Seng300.mainStage;
                s.setTitle("Admin Main");
                s.setScene(sc);
                s.show();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }


    /**
     * Open the application view window
     * @param event mouse click on button that triggers handler 
     * @throws IOException 
     */
    @FXML
    private void openStudentApplicationsWindow(ActionEvent event) throws IOException {
        ArrayList<Application> apps = Seng300.theManager.getStudentApplications();
        int index = 0;
        
        //checks what application was selected 
        if (radioSchol1.isSelected()){
            index = 0;
        }
        else if (radioSchol2.isSelected()){
            index = 1;
        }
        else if (radioSchol3.isSelected()){
            index = 2;
        }
        else if (radioSchol4.isSelected()){
            index = 3;
        }
        else if (radioSchol5.isSelected()){
            index = 4;
        }
        else if (radioSchol6.isSelected()){
            index = 5;
        }
        else if (radioSchol7.isSelected()){
            index = 6;
        }
        try{
            
            //load application view page 
            Seng300.theManager.setCurrentApplication(apps.get(index));
            Seng300.theManager.setEditModeApplication(false);
            Parent root = FXMLLoader.load(getClass().getResource("/AdditionalScenes/studentApplicationView.fxml"));
            Scene sc = new Scene(root);
            Stage s = Seng300.mainStage; 
            s.setTitle("Home");
            s.setScene(sc);
            s.show(); 
        }
        catch(IndexOutOfBoundsException e){
            
        }
        
        
        
        
    }

    
    /**
     * Opens edit draft page with information filled out
     * 
     * @param event 
     */
    @FXML
    private void openEditDraftPage(ActionEvent event) {
       ArrayList<Application> apps = Seng300.theManager.getDraftApplications();
        int index = 0;
        
        //checks what application was selected 
        if (rdoDraft1.isSelected()){
            index = 0;
        }
        else if (rdoDraft2.isSelected()){
            index = 1;
        }
        else if (rdoDraft3.isSelected()){
            index = 2;
        }
        else if (rdoDraft4.isSelected()){
            index = 3;
        }
        else if (rdoDraft5.isSelected()){
            index = 4;
        }
        else if (rdoDraft6.isSelected()){
            index = 5;
        }
        else if (rdoDraft7.isSelected()){
            index = 6;
        }
        try{
            
            //load application view page 
            Seng300.theManager.setCurrentApplication(apps.get(index));
           try {
               Scholarship sch0 = new Scholarship(apps.get(index).getScholarship(), true);
               Seng300.theManager.setCurrentScholarship(sch0);
           } catch (Exception ex) {
               Logger.getLogger(StudentMainPageController.class.getName()).log(Level.SEVERE, null, ex);
           }
            Seng300.theManager.setEditModeApplication(true);
            Parent root;
           try {
               root = FXMLLoader.load(getClass().getResource("/AdditionalScenes/CreateApplication.fxml"));
               Scene sc = new Scene(root);
               Stage s = Seng300.mainStage; 
               s.setTitle("Home");
               s.setScene(sc);
               s.show(); 
           } catch (IOException ex) {
               Logger.getLogger(StudentMainPageController.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        catch(IndexOutOfBoundsException e){
            
        } 
        
    }
    
    /**
     * Opens edit draft page with information filled out
     * 
     * @param event 
     */
    @FXML
    private void openEditSubmittedPage(ActionEvent event) {
       ArrayList<Application> apps = Seng300.theManager.getStudentApplications();
        int index = 0;
        
        //checks what application was selected 
        if (radioSchol1.isSelected()){
            index = 0;
        }
        else if (radioSchol2.isSelected()){
            index = 1;
        }
        else if (radioSchol3.isSelected()){
            index = 2;
        }
        else if (radioSchol4.isSelected()){
            index = 3;
        }
        else if (radioSchol5.isSelected()){
            index = 4;
        }
        else if (radioSchol6.isSelected()){
            index = 5;
        }
        else if (radioSchol7.isSelected()){
            index = 6;
        }
        try{
            
            //load application view page 
            Seng300.theManager.setCurrentApplication(apps.get(index));
           try {
               Scholarship sch0 = new Scholarship(apps.get(index).getScholarship(), true);
               Seng300.theManager.setCurrentScholarship(sch0);
           } catch (Exception ex) {
               Logger.getLogger(StudentMainPageController.class.getName()).log(Level.SEVERE, null, ex);
           }
            Seng300.theManager.setEditModeApplication(true);
            Parent root;
           try {
               root = FXMLLoader.load(getClass().getResource("/AdditionalScenes/CreateApplication.fxml"));
               Scene sc = new Scene(root);
               Stage s = Seng300.mainStage; 
               s.setTitle("Home");
               s.setScene(sc);
               s.show(); 
           } catch (IOException ex) {
               Logger.getLogger(StudentMainPageController.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        catch(IndexOutOfBoundsException e){
            
        } 
        
    }

    /**
     * Opens the window to apply to a specific scholarship
     * @param event mouse click on button that triggered handler
     * @throws IOException 
     */
    @FXML
    private void openApplyToScholarshipWindow(ActionEvent event) throws IOException{
        ArrayList<Scholarship> schs = Seng300.theManager.getScholarships();
        int index = 0;
        
        //gets which application draft to load up
        if (rdoDraft11.isSelected()) {
            index = 0;
        } else if (rdoDraft2.isSelected()) {
            index = 1;
        } else if (rdoDraft3.isSelected()) {
            index = 2;
        } else if (rdoDraft4.isSelected()) {
            index = 3;
        } else if (rdoDraft5.isSelected()) {
            index = 4;
        } else if (rdoDraft6.isSelected()) {
            index = 5;
        } else if (rdoDraft7.isSelected()) {
            index = 6;
        }
        try {
            
            //load up create application window
            Seng300.theManager.setCurrentScholarship(schs.get(index));
            Seng300.theManager.setEditModeApplication(false);
            Parent root = FXMLLoader.load(getClass().getResource("/AdditionalScenes/CreateApplication.fxml"));
            Scene sc = new Scene(root);
            Stage s = Seng300.mainStage; 
            s.setTitle("Home");
            s.setScene(sc);
            s.show(); 
        }
        catch (IndexOutOfBoundsException e) {

        }
    }
    
    /**
     * Just sets up the labels and radio buttons for an application
     * @param s string to put on label
     * @param l label to add string to
     * @param d label to set
     * @param r radio button to make visible
     */
    private void showApplicationInView(String s, Label l, Label d, RadioButton r) {
        l.setText(s.substring(0, s.length()));
        d.setText(s.substring(s.length()));
        l.setVisible(true);
        d.setVisible(true);
        r.setVisible(true);

    }

        
    /**
     * sets up the draft applications in view
     * @param s string to put on label
     * @param l label to set the string on
     * @param r radio button to set visible 
     */
    private void showDraftApplicationInView(String s, Label l, RadioButton r) {
        l.setText(s.substring(0, s.length()));
        l.setVisible(true);
        r.setVisible(true);
    }
    
    
        /**
         * loads up the applications for the student and sets it visible on the
         * window
         */
        private void applicationStartUp(){
        ArrayList<Application> currentApplications = Seng300.theManager.getStudentApplications();
        int size = currentApplications.size();
        
        //loads up certain amount of applications based on the size of the arraylist
        if (size > 0) {
            String toAdd = currentApplications.get(0).getScholarship();

            showApplicationInView(toAdd, lblScholarship1, lbldate1, radioSchol1);

            if (size > 1) {
                toAdd = currentApplications.get(1).getScholarship();
                showApplicationInView(toAdd, lblScholarship2, lbldate2, radioSchol2);
                if (size > 2) {
                    toAdd = currentApplications.get(2).getScholarship();
                    showApplicationInView(toAdd, lblScholarship3, lbldate3, radioSchol3);

                    if (size > 3) {
                        toAdd = currentApplications.get(3).getScholarship();
                        showApplicationInView(toAdd, lblScholarship4, lbldate4, radioSchol4);
                        if (size > 4) {
                            toAdd = currentApplications.get(4).getScholarship();
                            showApplicationInView(toAdd, lblScholarship5, lbldate5, radioSchol5);
                            if (size > 5) {
                                toAdd = currentApplications.get(5).getScholarship();
                                showApplicationInView(toAdd, lblScholarship6, lbldate6, radioSchol6);
                                if (size > 6) {
                                    toAdd = currentApplications.get(6).getScholarship();
                                    showApplicationInView(toAdd, lblScholarship7, lbldate7, radioSchol7);

                                }

                            }
                        }
                    }
                }
            }
        }
    }
        
    /**
     * Shows draft applications on the window
     */
    private void draftApplicationStartUp(){
        ArrayList<Application> allTheDraftApplications = Seng300.theManager.getDraftApplications();
        
        int sizeDraft = allTheDraftApplications.size();
        
        //loads up view based on how many draft applications student have 
        if (sizeDraft > 0) {
            String toAdd = allTheDraftApplications.get(0).getScholarship();
            showDraftApplicationInView(toAdd, lblDraft1, rdoDraft11);
            if (sizeDraft > 1) {
                toAdd = allTheDraftApplications.get(1).getScholarship();
                showDraftApplicationInView(toAdd, lblDraft2, rdoDraft21);
                if (sizeDraft > 2) {
                    toAdd = allTheDraftApplications.get(2).getScholarship();
                    showDraftApplicationInView(toAdd, lblDraft3, rdoDraft31);
                    if (sizeDraft > 3) {
                        toAdd = allTheDraftApplications.get(3).getScholarship();
                        showDraftApplicationInView(toAdd, lblDraft4, rdoDraft41);
                        if (sizeDraft > 4) {
                            toAdd = allTheDraftApplications.get(4).getScholarship();
                            showDraftApplicationInView(toAdd, lblDraft5, rdoDraft51);
                            if (sizeDraft > 5) {
                                toAdd = allTheDraftApplications.get(5).getScholarship();
                                showDraftApplicationInView(toAdd, lblDraft6, rdoDraft61);
                                if (sizeDraft > 6) {
                                    toAdd = allTheDraftApplications.get(6).getScholarship();
                                    showDraftApplicationInView(toAdd, lblDraft7, rdoDraft71);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    
    /**
     * loads up scholarships on the window
     */
    private void schStartUp() {
        ArrayList<Scholarship> schs = Seng300.theManager.getScholarships();
        int size = schs.size();
        
        //shows scholarships in view based on how many scholarships there are 
        if (size > 0) {
            String toAdd = schs.get(0).getName();
            showDraftApplicationInView(toAdd, lblOpenSchol1, rdoDraft1);
            if (size > 1) {
                toAdd = schs.get(1).getName();
                showDraftApplicationInView(toAdd, lblOpenSchol2, rdoDraft2);
                if (size > 2) {
                    toAdd = schs.get(2).getName();
                    showDraftApplicationInView(toAdd, lblOpenSchol3, rdoDraft3);
                    if (size > 3) {
                        toAdd = schs.get(3).getName();
                        showDraftApplicationInView(toAdd, lblOpenSchol4,rdoDraft4);
                        if (size > 4) {
                            toAdd = schs.get(4).getName();
                            showDraftApplicationInView(toAdd, lblOpenSchol5, rdoDraft5);
                            if (size > 5) {
                                toAdd = schs.get(5).getName();
                                showDraftApplicationInView(toAdd, lblOpenSchol6, rdoDraft6);
                                if (size > 6) {
                                    toAdd = schs.get(6).getName();
                                    showDraftApplicationInView(toAdd, lblOpenSchol7, rdoDraft7);

                                }

                            }
                        }
                    }
                }
            }
        }

    }
    
    
}
