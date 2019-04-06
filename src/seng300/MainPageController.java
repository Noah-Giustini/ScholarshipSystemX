/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seng300;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import backend.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FXML Controller class
 * Controls the main admin page making sure scholarships are displayed correctly. 
 * Allows admin to create or edit scholarships and to view scholarship applications.
 *
 * @author Kaitlin/Roxanne
 */
public class MainPageController implements Initializable {

    @FXML
    private ScrollPane currentScholarshipScrollPane;
    @FXML
    private ScrollPane historyScrollPane;
    @FXML
    private Button adminMainPageLogoutButton;
    @FXML
    private Button createNewScholarshipButton;
    @FXML
    private Button viewApplicationsButton;
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
    private Button refreshMainAdminPage;
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
    private Label lblDraft1;
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
    private Button buttonEditDraft;
    @FXML
    private Label schstatuslbl;
    @FXML
    private Button buttonEdit;
    @FXML
    private Button ButtonScholarshipDelete;
    @FXML
    private Button ButtonDelScholarshipDrafts;
    @FXML
    private Button viewArchivedScholarshipButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        startUp();
    
    }
    
    /**
     * When create new scholarship button is pressed the GUI is switched to the scholarship creation window. 
     * 
     * @param event
     * @throws IOException 
     */
    @FXML
    private void handleCreateNewScholarshipButtonAction(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/AdditionalScenes/CreateScholarshipFXML.fxml"));
        Scene sc = new Scene(root);
        Stage s = Seng300.mainStage;
        s.setTitle("Create Scholarship");
        s.setScene(sc);
        s.show();
    }
    
    /**
     * When the view archived scholarships button is pressed, this switches to the correct window
     * @param event 
     */
    @FXML
    private void openArchivedScholarshipsWindow(javafx.event.ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/AdditionalScenes/archivedScholarships.fxml"));
            Scene sc = new Scene(root); 
            Stage s = Seng300.mainStage;
            s.setTitle("Archived Scholarships");
            s.setScene(sc);
            s.show();          
        } catch (IOException e) {
            e.printStackTrace();
        }
            

    }
    
    /**
     * When the show applications button is pressed it shows the applications for the selected scholarship. 
     * 
     * @param event
     * @throws IOException 
     */
    @FXML
    private void openApplicationsWindow(javafx.event.ActionEvent event) throws IOException {
        ArrayList<Scholarship> schols = Seng300.theManager.getScholarships();
        int index = 0;
        if (radioSchol1.isSelected()) {
            index = 0;
        } else if (radioSchol2.isSelected()) {
            index = 1;
        } else if (radioSchol3.isSelected()) {
            index = 2;
        } else if (radioSchol4.isSelected()) {
            index = 3;
        } else if (radioSchol5.isSelected()) {
            index = 4;
        } else if (radioSchol6.isSelected()) {
            index = 5;
        } else if (radioSchol7.isSelected()) {
            index = 6;
        }
        try {
            Seng300.theManager.setCurrentScholarship(schols.get(index));
            Parent root = FXMLLoader.load(getClass().getResource("/AdditionalScenes/applications.fxml"));
            Scene sc = new Scene(root);
            Stage s = Seng300.mainStage;
            s.setTitle("Create Scholarship");
            s.setScene(sc);
            s.show();
        } catch (IndexOutOfBoundsException e) {

        }

    }
    
    /**
     * When button is pressed user is taken to the scholarship creation page with there submitted scholarship
     * is loaded into the fields and ready to be edited. 
     * 
     * @param event
     * @throws IOException 
     */
    @FXML
    private void editSubmitted(javafx.event.ActionEvent event) throws IOException {
        try {
            Seng300.theManager.findScholarships();
        } catch (Exception ex) {
            Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Scholarship> schols = Seng300.theManager.getScholarships();
        int index = 0;
        if (radioSchol1.isSelected()) {
            index = 0;
        } else if (radioSchol2.isSelected()) {
            index = 1;
        } else if (radioSchol3.isSelected()) {
            index = 2;
        } else if (radioSchol4.isSelected()) {
            index = 3;
        } else if (radioSchol5.isSelected()) {
            index = 4;
        } else if (radioSchol6.isSelected()) {
            index = 5;
        } else if (radioSchol7.isSelected()) {
            index = 6;
        }
        try {
            if (schols.get(index).getChosen() != 0){
                schstatuslbl.setText("Scholarship Already Has Applications: Cannot be Edited");
            }
            else{
                Seng300.theManager.setCurrentScholarship(schols.get(index));
                Seng300.theManager.setEditMode(true);
                Parent root = FXMLLoader.load(getClass().getResource("/AdditionalScenes/CreateScholarshipFXML.fxml"));
                Scene sc = new Scene(root);
                Stage s = Seng300.mainStage;
                s.setTitle("Create Scholarship");
                s.setScene(sc);
                s.show();
            }
        } catch (IndexOutOfBoundsException e) {

        }

    }
    
    /**
     * When button is pressed user is taken to the scholarship creation page with there scholarship
     * draft loaded into the fields and ready to be edited. 
     * 
     * @param event
     * @throws IOException 
     */
    @FXML
    private void editDraft(javafx.event.ActionEvent event) throws IOException {
        try {
            Seng300.theManager.findScholarshipDrafts();
        } catch (Exception ex) {
            Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Scholarship> schs = Seng300.theManager.getScholarshipDrafts();
        int index = 0;
        if (rdoDraft1.isSelected()) {
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
            Seng300.theManager.setCurrentScholarship(schs.get(index));
            Seng300.theManager.setEditMode(true);
            Parent root = FXMLLoader.load(getClass().getResource("/AdditionalScenes/CreateScholarshipFXML.fxml"));
            Scene sc = new Scene(root);
            Stage s = Seng300.mainStage;
            s.setTitle("Create Scholarship");
            s.setScene(sc);
            s.show();
        } catch (IndexOutOfBoundsException e) {

        }

    }
    
     /**
     * When delete scholarship button is pressed user that scholarship and it's corresponding drafts are 
     * archived. 
     * 
     * @param event
     * @throws IOException 
     */
    @FXML
    private void deleteScholarshipSubmitted(javafx.event.ActionEvent event) throws IOException {
        try {
            Seng300.theManager.findScholarships();
        } catch (Exception ex) {
            Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Scholarship> schols = Seng300.theManager.getScholarships();
        int index = 0;
        if (radioSchol1.isSelected()) {
            //radioSchol1.setVisible(false);
            //lblScholarship1.setVisible(false);
            //lbldate1.setVisible(false);
            index = 0;
        } else if (radioSchol2.isSelected()) {
            //radioSchol1.setSelected(true);
            index = 1;
        } else if (radioSchol3.isSelected()) {
            index = 2;
        } else if (radioSchol4.isSelected()) {
            index = 3;
        } else if (radioSchol5.isSelected()) {
            index = 4;
        } else if (radioSchol6.isSelected()) {
            index = 5;
        } else if (radioSchol7.isSelected()) {
            index = 6;
        }
            schols.get(index).archive();
            Seng300.theManager.clearScholarships();        
            lblScholarship1.setText("");
            lblScholarship2.setText("");
            lblScholarship3.setText("");
            lblScholarship4.setText("");
            lblScholarship5.setText("");
            lblScholarship6.setText("");
            lblScholarship7.setText("");
            lbldate1.setText("");
            lbldate2.setText("");
            lbldate3.setText("");
            lbldate4.setText("");
            lbldate5.setText("");
            lbldate6.setText("");
            lbldate7.setText("");
            radioSchol1.setVisible(false);
            radioSchol2.setVisible(false);
            radioSchol3.setVisible(false);
            radioSchol4.setVisible(false);
            radioSchol5.setVisible(false);
            radioSchol6.setVisible(false);
            radioSchol7.setVisible(false);  
            startUp();
    }

    /**
     * When delete scholarship draft button is pressed that scholarship draft is deleted.
     * 
     * @param event
     * @throws IOException 
     */
    @FXML
    private void deleteScholarshipDraft(javafx.event.ActionEvent event) throws IOException {
        try {
            Seng300.theManager.findScholarshipDrafts();
        } catch (Exception ex) {
            Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Scholarship> schs = Seng300.theManager.getScholarshipDrafts();
        int index = 0;
        if (rdoDraft1.isSelected()) {
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
            schs.get(index).delete();
            Seng300.theManager.clearScholarshipDrafts();
            lblDraft1.setText("");
            lblDraft2.setText("");
            lblDraft3.setText("");
            lblDraft4.setText("");
            lblDraft5.setText("");
            lblDraft6.setText("");
            lblDraft7.setText("");
            rdoDraft1.setVisible(false);
            rdoDraft2.setVisible(false);
            rdoDraft3.setVisible(false);
            rdoDraft4.setVisible(false);
            rdoDraft5.setVisible(false);
            rdoDraft6.setVisible(false);
            rdoDraft7.setVisible(false);
            startUp();
        } catch (IndexOutOfBoundsException e) {
        }
    }
    
    /**
     * Makes submitted scholarships from file system visible on GUI.
     * 
     * @param s
     * @param l
     * @param d
     * @param r 
     */
    private void showScholarshipInView(String s, Label l, Label d, RadioButton r) {
        l.setText(s.substring(0, s.length() - 11));
        d.setText(s.substring(s.length() - 11));
        l.setVisible(true);
        d.setVisible(true);
        r.setVisible(true);

    }
    
    /**
     * Makes drafts scholarships from file system visible on GUI.
     * 
     * @param s
     * @param l
     * @param r 
     */
    private void showDraftScholarshipInView(String s, Label l, RadioButton r) {
        l.setText(s.substring(0, s.length() - 11));
        l.setVisible(true);
        r.setVisible(true);
    }

    @FXML
    private void handleRefresh(javafx.event.ActionEvent event) {
       startUp();
    }
    
    /**
     * Take user to login page when button is pressed.
     * 
     * @param event 
     */
    @FXML 
    private void handleLogout(javafx.event.ActionEvent event){
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
     * Makes sure correct labels are presented and radio buttons are pressed when scholarships are loaded
     * into the GUI display. 
     */
    private void startUp(){
        ArrayList<String> allTheCurrentScholarships = Seng300.theManager.showSubmittedScholarships();
        int size = allTheCurrentScholarships.size();
        if (size > 0) {
            String toAdd = allTheCurrentScholarships.get(0);

            showScholarshipInView(toAdd, lblScholarship1, lbldate1, radioSchol1);

            if (size > 1) {
                toAdd = allTheCurrentScholarships.get(1);
                showScholarshipInView(toAdd, lblScholarship2, lbldate2, radioSchol2);
                if (size > 2) {
                    toAdd = allTheCurrentScholarships.get(2);
                    showScholarshipInView(toAdd, lblScholarship3, lbldate3, radioSchol3);

                    if (size > 3) {
                        toAdd = allTheCurrentScholarships.get(3);
                        showScholarshipInView(toAdd, lblScholarship4, lbldate4, radioSchol4);
                        if (size > 4) {
                            toAdd = allTheCurrentScholarships.get(4);
                            showScholarshipInView(toAdd, lblScholarship5, lbldate5, radioSchol5);
                            if (size > 5) {
                                toAdd = allTheCurrentScholarships.get(5);
                                showScholarshipInView(toAdd, lblScholarship6, lbldate6, radioSchol6);
                                if (size > 6) {
                                    toAdd = allTheCurrentScholarships.get(6);
                                    showScholarshipInView(toAdd, lblScholarship7, lbldate7, radioSchol7);

                                }

                            }
                        }
                    }
                }
            }
        }
        
        ArrayList<String> allTheDraftScholarships = Seng300.theManager.showSavedScholarships();
        int sizeDraft = allTheDraftScholarships.size();
        if (sizeDraft > 0) {
            String toAdd = allTheDraftScholarships.get(0);
            showDraftScholarshipInView(toAdd, lblDraft1, rdoDraft1);
            if (sizeDraft > 1) {
                toAdd = allTheDraftScholarships.get(1);
                showDraftScholarshipInView(toAdd, lblDraft2, rdoDraft2);
                if (sizeDraft > 2) {
                    toAdd = allTheDraftScholarships.get(2);
                    showDraftScholarshipInView(toAdd, lblDraft3, rdoDraft3);
                    if (sizeDraft > 3) {
                        toAdd = allTheDraftScholarships.get(3);
                        showDraftScholarshipInView(toAdd, lblDraft4, rdoDraft4);
                        if (sizeDraft > 4) {
                            toAdd = allTheDraftScholarships.get(4);
                            showDraftScholarshipInView(toAdd, lblDraft5, rdoDraft5);
                            if (sizeDraft > 5) {
                                toAdd = allTheDraftScholarships.get(5);
                                showDraftScholarshipInView(toAdd, lblDraft6, rdoDraft6);
                                if (sizeDraft > 6) {
                                    toAdd = allTheDraftScholarships.get(7);
                                    showDraftScholarshipInView(toAdd, lblDraft7, rdoDraft7);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
