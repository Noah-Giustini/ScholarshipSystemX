/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdditionalScenes;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Kaitlin
 */
public class StudentApplicationViewController implements Initializable {

    @FXML
    private Button backButton;
    @FXML
    private Button awardButton;
    @FXML
    private ScrollPane scrollWindow;
    @FXML
    private TextArea applicationInfo;
    @FXML
    private Button refreshButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backToViewApplications(ActionEvent event) {
    }

    @FXML
    private void award(ActionEvent event) {
    }

    @FXML
    private void refreshAction(ActionEvent event) {
    }
    
}
