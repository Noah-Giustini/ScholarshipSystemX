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
    private Button refreshMainAdminPage;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        applicationStartUp();
        draftApplicationStartUp();
    }    


    @FXML
    private void openStudentApplicationsWindow(ActionEvent event) throws IOException {
        ArrayList<Application> apps = Seng300.theManager.getStudentApplications();
        int index = 0;
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
            Seng300.theManager.setCurrentApplication(apps.get(index));
            Parent root = FXMLLoader.load(getClass().getResource("/AdditionalScenes/StudentApplicationView.fxml"));
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
    private void openEditDraftPage(ActionEvent event) {
        
        
    }

    @FXML
    private void openApplyToScholarshipWindow(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/AdditionalScenes/CreateApplication.fxml"));
        Scene sc = new Scene(root);
        Stage s = Seng300.mainStage; 
        s.setTitle("Home");
        s.setScene(sc);
        s.show(); 
        
    }
    
    
    private void showApplicationInView(String s, Label l, Label d, RadioButton r) {
        l.setText(s.substring(0, s.length() - 11));
        d.setText(s.substring(s.length() - 11));
        l.setVisible(true);
        d.setVisible(true);
        r.setVisible(true);

    }
        
    private void showDraftApplicationInView(String s, Label l, RadioButton r) {
        l.setText(s.substring(0, s.length() - 11));
        l.setVisible(true);
        r.setVisible(true);
    }
    
    
        private void applicationStartUp(){
        ArrayList<Application> currentApplications = Seng300.theManager.getStudentApplications();
        int size = currentApplications.size();
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
                                    toAdd = currentApplications.get(7).getScholarship();
                                    showApplicationInView(toAdd, lblScholarship7, lbldate7, radioSchol7);

                                }

                            }
                        }
                    }
                }
            }
        }
    }
        private void draftApplicationStartUp(){
        ArrayList<Application> allTheDraftApplications = Seng300.theManager.getDraftApplications();
        
        int sizeDraft = allTheDraftApplications.size();
        if (sizeDraft > 0) {
            String toAdd = allTheDraftApplications.get(0).getScholarship();
            showDraftApplicationInView(toAdd, lblDraft1, rdoDraft1);
            if (sizeDraft > 1) {
                toAdd = allTheDraftApplications.get(1).getScholarship();
                showDraftApplicationInView(toAdd, lblDraft2, rdoDraft2);
                if (sizeDraft > 2) {
                    toAdd = allTheDraftApplications.get(2).getScholarship();
                    showDraftApplicationInView(toAdd, lblDraft3, rdoDraft3);
                    if (sizeDraft > 3) {
                        toAdd = allTheDraftApplications.get(3).getScholarship();
                        showDraftApplicationInView(toAdd, lblDraft4, rdoDraft4);
                        if (sizeDraft > 4) {
                            toAdd = allTheDraftApplications.get(4).getScholarship();
                            showDraftApplicationInView(toAdd, lblDraft5, rdoDraft5);
                            if (sizeDraft > 5) {
                                toAdd = allTheDraftApplications.get(5).getScholarship();
                                showDraftApplicationInView(toAdd, lblDraft6, rdoDraft6);
                                if (sizeDraft > 6) {
                                    toAdd = allTheDraftApplications.get(7).getScholarship();
                                    showDraftApplicationInView(toAdd, lblDraft7, rdoDraft7);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    
}
