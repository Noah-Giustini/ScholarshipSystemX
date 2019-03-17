/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdditionalScenes;

import backend.Manager;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import seng300.Seng300;

/**
 * FXML Controller class
 *
 * @author Kaitlin
 */
public class CreateScholarshipFXMLController implements Initializable {

    @FXML
    private Button buttonBack;
    @FXML
    private Font x1;
    @FXML
    private Button buttonSaveProgress;
    @FXML
    private Button buttonSubmitScholarship;
    @FXML
    private TextField txtEnterSchName;
    @FXML
    private TextArea txtSchDescription;
    @FXML
    private CheckBox chkGPA;
    @FXML
    private DatePicker dateGetter;
    @FXML
    private TextField txtAmount;
    @FXML
    private TextField txtNumRecipients;
    @FXML
    private CheckBox chkbach;
    @FXML
    private CheckBox chkmaster;
    @FXML
    private CheckBox chkDoctorate;
    @FXML
    private TextArea txtCustom1;
    @FXML
    private TextArea txtCustom2;
    @FXML
    private Color x4;
    @FXML
    private Font x3;
    @FXML
    private TextArea txtCustom3;
    @FXML
    private Label statustxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleSaveScholarship(MouseEvent event) {
        
        if (txtEnterSchName.getText().trim().equals("")){
            statustxt.setText("Unable to Save: Scholarship Requires Name"); 
		return;
	}
        
        getFields(false);
        
        statustxt.setText("Save Succesful");
    }

    @FXML
    private void handleSubmitScholarship(MouseEvent event) throws IOException{
        
        if (txtEnterSchName.getText().trim().equals("")){
            statustxt.setText("Unable to Submit: Scholarship Requires Name"); 
		return;
	}
        
        getFields(true);
        
        Parent root = FXMLLoader.load(getClass().getResource("/seng300/adminMainPage.fxml"));
        Scene sc = new Scene(root);
        Stage s = Seng300.mainStage; 
        s.setTitle("Home");
        s.setScene(sc);
        s.show();
    }

    @FXML
    private void backFromScholarshipCreator(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/seng300/adminMainPage.fxml"));
        Scene sc = new Scene(root);
        Stage s = Seng300.mainStage; 
        s.setTitle("Home");
        s.setScene(sc);
        s.show();
    }
    
    private void getFields(boolean sub){
        
                boolean submit = sub;
                String name = txtEnterSchName.getText().trim();
                String duedate;
                boolean gpa = false;
                double amount;
                int recips;
                int recipsch;
                boolean bach;
                boolean mast;
                boolean doc;
                String cus1;
                String cus2;
                String cus3;
                String desc;
                int day;
                int month;
                int year;
		
 
		LocalDate date = dateGetter.getValue();
                
                try{
                    day = date.getDayOfMonth();
                    month = date.getMonthValue();
                    year = date.getYear();
                }
                catch (Exception e){
                    day = 0;
                    month = 0;
                    year = 0;
                }
		String strDay;
		String strMonth;
		String strYear = Integer.toString(year);
		
		try{
                    if (day < 10){
                    	strDay = "0" + Integer.toString(day);
                    }
                    else {
                    	strDay = Integer.toString(day);
                    }
		
                    if (month < 10){
                    	strMonth = "0" + Integer.toString(month);
                    }
                    else {
                    	strMonth = Integer.toString(month);
                    }
                    
                    duedate = strDay + "/" + strMonth + "/" + strYear;
                }
                catch (Exception e){
                    duedate = "dd/mm/yyyy";    
                     }
		
		gpa = chkGPA.isSelected();
                
                try{
                    amount = Double.parseDouble(txtAmount.getText());
                    
                }
                catch (Exception e){
                    amount = 0.0;
                }
                
                try{
                    recips = Integer.parseInt(txtNumRecipients.getText());
                }
                catch (Exception e){
                    recips = 0;
                }
                
                bach = chkbach.isSelected();
                mast = chkmaster.isSelected();
                doc = chkDoctorate.isSelected();
                
                cus1 = txtCustom1.getText();
                cus2 = txtCustom2.getText();
                cus3 = txtCustom3.getText();
                desc = txtSchDescription.getText();
              
                
                if (submit){
                    Seng300.theManager.addSubmittedScholarship(name, submit, desc, gpa, duedate, amount, recips, bach, mast, doc, cus1, cus2, cus3);
                }
                else {
                    Seng300.theManager.addSavedScholarship(name, submit, desc, gpa, duedate, amount, recips, bach, mast, doc, cus1, cus2, cus3);
                }
    }

}
    

