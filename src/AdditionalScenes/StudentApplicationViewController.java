//package information
package AdditionalScenes;
//imports
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import backend.*;
import seng300.Seng300;

/**
 * FXML Controller class
 *
 * Controls page that allows a student to view an application's status
 * and accept awards.
 * 
 * @author Noah
 */
public class StudentApplicationViewController implements Initializable {
    //instance variables
    @FXML
    private Button backButton;
    @FXML
    private Button acceptButton;
    @FXML
    private Button withdrawButton;
    @FXML
    private ScrollPane scrollWindow;
    @FXML
    private TextArea applicationInfo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.applicationInfo.setText(Seng300.theManager.getCurrentApplication().toString());
        String status = Seng300.theManager.getCurrentApplication().getStatus();
        if (status.equals("Pending") ||status.equals("Accepted")){
            this.acceptButton.setVisible(false);
        }
        else {
            this.acceptButton.setVisible(true);
        }
        if (status.equals(status.equals("Accepted"))){
            this.withdrawButton.setVisible(false);
        }
        else {
            this.withdrawButton.setVisible(true);
        }
        
    }    
    /**
     * This method takes us back to the student main page from the view application page
     * @param event mouse event generated by clicking the back button
     * @throws IOException 
     */
    @FXML
    private void backToViewApplications(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/seng300/studentMainPage.fxml"));
        Scene sc = new Scene(root);
        Stage s = Seng300.mainStage; 
        s.setTitle("Home");
        s.setScene(sc);
        s.show();
    }
    /**
     * this method accepts the scholarship if it has been granted to a student
     * @param event mouse event generated by clicking the accept button
     */
    @FXML
    private void accept(ActionEvent event) {
        if (Seng300.theManager.getCurrentApplication().getStatus().equals("Granted")){
            try {
                Seng300.theManager.getCurrentApplication().setStatus("Accepted");
                JOptionPane.showMessageDialog(null, "Success, scholarship has been accepted. \n You will be contacted shortly to recieve your award");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Something went wrong. \n Ensure all files are in the file system");
                System.out.println("Something went wrong. please ensure all files are in the file system. \n");
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "You are not permitted to accept a scholarship at this time");
        }
    }
    /**
     * this method withdraws the student's application for the scholarship
     * @param event mouse event generated by clicking the withdraw button
     */
    @FXML
    private void withdraw(ActionEvent event) {
        String scholName = Seng300.theManager.getCurrentApplication().getScholarship();
        try{
            Scholarship schol = new Scholarship(scholName, true);
            int chosen = schol.getChosen();
            if (Seng300.theManager.getCurrentApplication().getStatus().equals("Granted")){
                schol.setChosen(chosen - 1);
                Seng300.theManager.getCurrentApplication().delete();
                Seng300.theManager.setCurrentApplication(null);
                this.acceptButton.setVisible(false);
                this.withdrawButton.setVisible(false);
                JOptionPane.showMessageDialog(null, "You have successfully withdrawn your application");
            }
            else if (Seng300.theManager.getCurrentApplication().getStatus().equals("Accepted")){
                JOptionPane.showMessageDialog(null, "You have already accepted this scholarship and cannot withdraw at this time");
                Seng300.theManager.setCurrentApplication(null);
            }
            else{
                Seng300.theManager.getCurrentApplication().delete();
                Seng300.theManager.getStudentApplications().remove(Seng300.theManager.getCurrentApplication());
                Seng300.theManager.setCurrentApplication(null);
                this.withdrawButton.setVisible(false);
                this.applicationInfo.setText("Application has been deleted");
                JOptionPane.showMessageDialog(null, "You have successfully withdrawn your application");
                
                
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "There was an error");
            System.out.println("You threw an exception");
        }
    }
}   

