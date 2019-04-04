/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdditionalScenes;

import java.util.ArrayList;
import backend.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * This class is the controller for the archivedApplications fxml file
 * @author Stephen
 */
public class ArchivedApplicationsFXMLController implements Initializable{
    private ArrayList<Application> archivedApplications = new ArrayList<>();
    private String desiredScholarship = "";
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    
    public void setDesiredScholarship(String desiredScholarship) {
        this.desiredScholarship = desiredScholarship;
    }
}
