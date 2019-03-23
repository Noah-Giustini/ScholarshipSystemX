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
    @FXML
    private Label lblcus1;
    @FXML
    private Label lblcus2;
    @FXML
    private Label lblcus3;
    @FXML
    private Label lblcus4;
    @FXML
    private TextArea txtCustom4;
    @FXML
    private Label lblcus5;
    @FXML
    private TextArea txtCustom5;
    @FXML
    private TextArea txtCustom6;
    @FXML
    private Label lblcus6;
    @FXML
    private Label lblcus7;
    @FXML
    private TextArea txtCustom7;
    @FXML
    private Label lblcus8;
    @FXML
    private TextArea txtCustom8;
    @FXML
    private Label lblcus9;
    @FXML
    private TextArea txtCustom9;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (Seng300.theManager.getEditMode()){
            
        }
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
    private void addCustomQuestion(MouseEvent event) {
        
        if (!(lblcus1.isVisible())){
            lblcus1.setVisible(true);
            txtCustom1.setVisible(true);
        }
        else if (!(lblcus2.isVisible())){
            lblcus2.setVisible(true);
            txtCustom2.setVisible(true);
        }
        else if (!(lblcus3.isVisible())){
            lblcus3.setVisible(true);
            txtCustom3.setVisible(true);
        }
        else if (!(lblcus4.isVisible())){
            lblcus4.setVisible(true);
            txtCustom4.setVisible(true);
        }
        else if (!(lblcus5.isVisible())){
            lblcus5.setVisible(true);
            txtCustom5.setVisible(true);
        }
        else if (!(lblcus6.isVisible())){
            lblcus6.setVisible(true);
            txtCustom6.setVisible(true);
        }
        else if (!(lblcus7.isVisible())){
            lblcus7.setVisible(true);
            txtCustom7.setVisible(true);
        }
        else if (!(lblcus8.isVisible())){
            lblcus8.setVisible(true);
            txtCustom8.setVisible(true);
        }
        else if (!(lblcus9.isVisible())){
            lblcus9.setVisible(true);
            txtCustom9.setVisible(true);
        }
        else {
            statustxt.setText("Maximum Number of Questions Reached");
        }
    }

    @FXML
    private void handleSubmitScholarship(MouseEvent event) throws IOException{
        
        if (txtEnterSchName.getText().trim().equals("")){
            statustxt.setText("Unable to Submit: Scholarship Requires Name"); 
		return;
	}
        
        getFields(true);
        
        Seng300.theManager.setEditMode(false);
        Parent root = FXMLLoader.load(getClass().getResource("/seng300/adminMainPage.fxml"));
        Scene sc = new Scene(root);
        Stage s = Seng300.mainStage; 
        s.setTitle("Home");
        s.setScene(sc);
        s.show();
    }

    @FXML
    private void backFromScholarshipCreator(MouseEvent event) throws IOException {
        Seng300.theManager.setEditMode(false);
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
                String cus4;
                String cus5;
                String cus6;
                String cus7;
                String cus8;
                String cus9;
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
                
                cus1 = txtCustom1.getText().replace("\n", "");
                cus2 = txtCustom2.getText().replace("\n", "");
                cus3 = txtCustom3.getText().replace("\n", "");
                cus4 = txtCustom4.getText().replace("\n", "");
                cus5 = txtCustom5.getText().replace("\n", "");
                cus6 = txtCustom6.getText().replace("\n", "");
                cus7 = txtCustom7.getText().replace("\n", "");
                cus8 = txtCustom8.getText().replace("\n", "");
                cus9 = txtCustom9.getText().replace("\n", "");
                desc = txtSchDescription.getText().replace("\n", "");
              
                
                if (submit){
                    Seng300.theManager.addSubmittedScholarship(name, submit, desc, gpa, duedate, amount, recips, bach, mast, doc, cus1, cus2, cus3, cus4, cus5, cus6, cus7, cus8, cus9);
                }
                else {
                    Seng300.theManager.addSavedScholarship(name, submit, desc, gpa, duedate, amount, recips, bach, mast, doc, cus1, cus2, cus3, cus4, cus5, cus6, cus7, cus8, cus9);
                }
    }

}
    

