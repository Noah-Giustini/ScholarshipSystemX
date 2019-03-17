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

/**
 * FXML Controller class
 *
 * @author Kaitlin
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleCreateNewScholarshipButtonAction(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/AdditionalScenes/CreateScholarshipFXML.fxml"));
        Scene sc = new Scene(root);
        Stage s = Seng300.mainStage;
        s.setTitle("Create Scholarship");
        s.setScene(sc);
        s.show();
    }

    @FXML
    private void openApplicationsWindow(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/AdditionalScenes/applications.fxml"));
        Scene sc = new Scene(root);
        Stage s = Seng300.mainStage;
        s.setTitle("Create Scholarship");
        s.setScene(sc);
        s.show();
    }

    private void showScholarshipInView(String s, Label l, Label d, RadioButton r){
        l.setText(s.substring(0, s.length() - 9));
            d.setText(s.substring(s.length() - 9));
            l.setVisible(true);
            d.setVisible(true);
            r.setVisible(true);
    
    }
    
    @FXML
    private void handleRefresh(javafx.event.ActionEvent event) {
        //load all applications from a scholarship provided by the manager

        //2nd step showSubmittedScholarships() gives an arraylist of strings 
        // 3rd loop through the list, if it goes past 5 don't do anything otherwise just fill however many you can 
        //probably don't actually need to loop but it will be good if we end up having more windows - no use limiting ourselves
        ArrayList<String> allTheCurrentScholarships = Seng300.theManager.showSubmittedScholarships();
        System.out.println(allTheCurrentScholarships);
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
                                    toAdd = allTheCurrentScholarships.get(1);
                                    showScholarshipInView(toAdd, lblScholarship7, lbldate7, radioSchol7);

                                }

                            }
                        }
                    }
                }
            }
        }
    }

}
