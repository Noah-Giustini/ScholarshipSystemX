/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdditionalScenes;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import seng300.Seng300;

/**
 * This class is the controller for the archivedApplications fxml file
 * @author Stephen
 */
public class ArchivedApplicationsFXMLController implements Initializable{
    private ArrayList<String> archivedApplications = new ArrayList<>();
    private static String desiredScholarshipName = "";
    
    @FXML
    private Button backToArchivedScholarshipsButton;
    @FXML
    private Button viewbtn;
    @FXML
    private TextArea ApplicationText1;
    @FXML
    private TextArea ApplicationText2;
    @FXML
    private TextArea ApplicationText3;
    @FXML
    private TextArea ApplicationText4;
    @FXML
    private TextArea ApplicationText5;
    @FXML
    private RadioButton radio1;
    @FXML
    private RadioButton radio2;
    @FXML
    private RadioButton radio3;
    @FXML
    private RadioButton radio4;
    @FXML
    private RadioButton radio5;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadArchivedApplications();
        displayArchivedApplications();
    }
    
    /**
     * The application selected by the radio button is shown in full detail in
     * a new window
     * @param event The view button being pressed
     */
    @FXML
    private void viewApplicationInDetail(javafx.event.ActionEvent event) {
        int desiredApplication = 0;
        
        if(radio1.isSelected()) {
            desiredApplication = 0;
        } else if(radio2.isSelected()) {
            desiredApplication = 1;
        } else if(radio3.isSelected()) {
            desiredApplication = 2;
        } else if(radio4.isSelected()) {
            desiredApplication = 3;
        } else if(radio5.isSelected()) {
            desiredApplication = 4;
        }
        
        //sends the full application to the controller
        ArchivedApplicationViewFXMLController.setDesiredApplication(archivedApplications.get(desiredApplication));
        
        //change windows
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ArchivedApplicationView.fxml"));
            Scene sc = new Scene(root); 
            Stage s = Seng300.mainStage;
            s.setTitle("Archived Application Detailed View");
            s.setScene(sc);
            s.show();          
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Returns the name of the desired scholarship
     * @return The name of the desired scholarship
     */
    public static String getScholarshipName() {
        return desiredScholarshipName;
    }
    
    /**
     * Opens the archivedScholarship window when the back button is pressed
     * @param event The event fired when the back button is pressed
     */
    @FXML
    private void backToArchivedScholarshipsWindow (javafx.event.ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("archivedScholarships.fxml"));
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
     * This method goes through the ArchivedApplications file and finds any
     * that are for the scholarship given in desiredScholarshipName and adds
     * them to the archivedApplications arrayList.
     */
    private void loadArchivedApplications() {
        //look in Seng300\ArchivedScholarships and load the first 7
        this.archivedApplications.clear();
        
        File dir = new File("ArchivedApplications\\");
	File[] directoryListing = dir.listFiles();
		
	if (directoryListing != null) {     //goes through archived scholarships file and loads into array list
            for (File child : directoryListing) { 	
                if(child.getName().contains(desiredScholarshipName)) {   //if file contains desired scholarship name
                    archivedApplications.add(readFile(child.getPath()));                       
                }
            }
        }
    }
    
    /**
     * Reads the file given by pathname and returns its contents as a string
     * @param pathname The pathname of the file you want to read
     * @return The contents of the file as a string
     */
    private String readFile(String pathname) {
        File file = new File(pathname);
        StringBuilder fileContents = new StringBuilder((int)file.length());        

        try (Scanner scanner = new Scanner(file)) {
            while(scanner.hasNextLine()) {
                fileContents.append(scanner.nextLine() + System.lineSeparator());
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return fileContents.toString();
    }
    
    
    /**
     * This method displays the student name in the textArea for the archived
     * applications.
     */
    private void displayArchivedApplications() {
        String name = "";
        int textAreaNumber = 1;
        
        for(String s:archivedApplications) {
            name = s;

            /*
            Below string is of the form:
                Student
                studentName
            */
            name = name.substring(name.indexOf("Student", 0), name.indexOf("GPA", 0) - 1);
     
            //sets the application text area to contain just the student name
            switch(textAreaNumber) {
                case 1:
                    ApplicationText1.setText(name);
                    break;
                case 2:
                    ApplicationText2.setText(name);
                    break;
                case 3:
                    ApplicationText3.setText(name);
                    break;
                case 4:
                    ApplicationText4.setText(name);
                    break;
                case 5:
                    ApplicationText5.setText(name);
                    break;
            }
            
            textAreaNumber++;
            
        }
    }
    
    /**
     * Sets the desired scholarship name
     * @param desiredScholarship The desired scholarship name
     */
    public static void setDesiredScholarship(String desiredScholarship) {
        desiredScholarshipName = desiredScholarship;
    }
}
