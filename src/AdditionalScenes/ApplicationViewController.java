//Package details
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
import seng300.Seng300;

/**
 * FXML Controller class
 * 
 * Controls the application view page where scholarships can be awarded to student
 * applications. 
 */
public class ApplicationViewController implements Initializable {
    //instance variables
    @FXML
    private Button backButton;
    @FXML
    private Button awardButton;
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
    }    

    /**
     * This method will take us back to the page too view all applications for some given scholarship
     * @param event Mouse event sent by clicking the button
     * @throws IOException 
     */
    @FXML
    private void backToViewApplications(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/AdditionalScenes/applications.fxml"));
        Scene sc = new Scene(root);
        Stage s = Seng300.mainStage; 
        s.setTitle("Home");
        s.setScene(sc);
        s.show();
    }
    /**
     * This method will award the student who created the application with the ability to accept the scholarship
     * @param event mouse event sent by clicking the award button
     */
    @FXML
    private void award(ActionEvent event) {
        int chosen = Seng300.theManager.getCurrentScholarship().getChosen();
        if (chosen < Seng300.theManager.getCurrentScholarship().getRecipients()){
            try{
                Seng300.theManager.getCurrentApplication().setStatus("Granted");
                Seng300.theManager.getCurrentScholarship().setChosen(chosen + 1);
                JOptionPane.showMessageDialog(null, "Success, scholarship has been granted");
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null, "Something went wrong. \n Ensure all files are in the file system");
                System.out.println("Something went horribly wrong. please ensure all files are in the file system. \n");
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "The maximum amount of applicants has already been selected");
        }
        
    }

    
    
}
