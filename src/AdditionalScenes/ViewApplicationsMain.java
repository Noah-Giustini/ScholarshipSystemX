//package information
package AdditionalScenes;
//import statements
import seng300.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Views the details of a specific application.
 * 
 * @author Kaitlin
 */
public class ViewApplicationsMain extends Application {
    /**
     * start the scene
     * @param stage the stage
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("application.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * main
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
