/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdditionalScenes;

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
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import seng300.Seng300;
import backend.*;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is the fxml controller for the archivedScholarships fxml page.
 * @author Stephen
 */
public class ArchivedScholarshipsFXMLController implements Initializable {
    
    @FXML
    private Button archivedScholarshipsBackToMainButton;
    @FXML
    private Button viewArchivedApplicationsButton;
    @FXML
    private ScrollPane currentScholarshipScrollPane;
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
    private RadioButton radioSchol1;
    @FXML
    private RadioButton radioSchol2;
    @FXML
    private RadioButton radioSchol3;
    @FXML
    private RadioButton radioSchol4;
    @FXML
    private RadioButton radioSchol5;
    @FXML
    private RadioButton radioSchol6;
    @FXML
    private RadioButton radioSchol7;
    
    
    private ArrayList<Scholarship> archivedScholarshipList = new ArrayList<>(); //list of archived scholarships
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //loadArchivedScholarships();
    }
    
    /*
    TODO
        -Read in at most 7 archived scholarships from folder
        -Display those 7 scholarships
    */
    
    @FXML
    private void backToMainPage(javafx.event.ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/seng300/adminMainPage.fxml"));
            Scene sc = new Scene(root); 
            Stage s = Seng300.mainStage;
            s.setTitle("Admin Main");
            s.setScene(sc);
            s.show();          
        } catch (IOException e) {
            System.out.println("ERROR: IOException thrown when archived scholarships button is pressed!");
        }
    }
    
    

    /**
     * This method loads the archived scholarships from the folder and displays
     * it in the fxml window
     */
    private void loadArchivedScholarships() {
        //look in Seng300\ArchivedScholarships and load the first 7
        this.archivedScholarshipList.clear();
        
        File dir = new File("ArchivedScholarships\\");
	File[] directoryListing = dir.listFiles();
		
	if (directoryListing != null) {     //goes through archived scholarships file and loads into array list
		for (File child : directoryListing) { 	
                    try {
                        String schname = child.getName().substring(0, child.getName().length() - 4);
                        Scholarship s = new Scholarship(schname, true);
                        this.archivedScholarshipList.add(s);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
		}
	}
        
        //for each loop for testing!
        for(Scholarship s:archivedScholarshipList) {
            System.out.println(s.toString());
        }
        
    }
}
