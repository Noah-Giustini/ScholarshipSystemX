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
    private TextArea scholarship1;
    @FXML
    private TextArea scholarshipArea2;
    @FXML
    private TextArea scholarshipArea3;
    @FXML
    private TextArea scholarshipArea4;
    @FXML
    private TextArea scholarshipArea5;
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
            scholarship1.setText(allTheCurrentScholarships.get(0));
            if (size > 1) {
                scholarshipArea2.setText(allTheCurrentScholarships.get(1));
                if (size > 2) {
                    scholarshipArea3.setText(allTheCurrentScholarships.get(2));
                    if (size > 3) {
                        scholarshipArea4.setText(allTheCurrentScholarships.get(3));
                        if (size > 4) {
                            scholarshipArea5.setText(allTheCurrentScholarships.get(4));
                            if (size > 5) {
                                scholarshipArea6.setText(allTheCurrentScholarships.get(5));
                                if (size > 6) {
                                    scholarshipArea7.setText(allTheCurrentScholarships.get(6));

                                }

                            }
                        }
                    }
                }
            }
        }
    }

}
