package com.mentCare.controller;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mentCare.adapter.PatientAdapter;

public class loginController {


	@FXML private ColorPicker colorTextField;
    @FXML private Button loginButton;
    private String physicianLogin = "Physician";
    private String physicianPassword = "Physician";
    private String patientLogin = "Patient";
    private String patientPassword = "Patient";
    @FXML private TextField usernameBar;
    @FXML private TextField passwordBar;
    
    private static ResultSet physicianResults;
    private static ResultSet patientResults;


 public void initialize() {
	 System.out.println("Attempting to connect to Database...");
	 PatientAdapter.connect();
 }
 
 
 
//=================================================================================================
//When you click the login button, and the username/password are correct, go to the correct view.
//=================================================================================================
 
 
	 public void loginButtonClicked(ActionEvent event) throws IOException, SQLException
	 {
		/*if(usernameBar.getText().equalsIgnoreCase(physicianLogin)&& passwordBar.getText().equalsIgnoreCase(physicianPassword)){
			
			 FXMLLoader loader = new FXMLLoader();
			    loader.setLocation(getClass().getResource("../../../com/mentCare/view/PhysicianMainView.fxml"));
			    Parent tableViewParent = loader.load();
			    Scene tableViewScene = new Scene(tableViewParent);
			    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		        window.setScene(tableViewScene);
			    window.show();
			
		}
	
		else if(usernameBar.getText().equalsIgnoreCase(patientLogin)&& passwordBar.getText().equalsIgnoreCase(patientPassword)){
			
			
			FXMLLoader loader = new FXMLLoader();
		    loader.setLocation(getClass().getResource("../../../com/mentCare/view/PatientMainView.fxml"));
		    Parent tableViewParent = loader.load();
		    Scene tableViewScene = new Scene(tableViewParent);
		    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		    window.setScene(tableViewScene);
		    window.show();
			
			
			
		}
		
		
		
		else{
			Alert buttonWasClicked = new Alert(AlertType.CONFIRMATION, "Wrong username or password", ButtonType.OK, ButtonType.CANCEL);
			buttonWasClicked.showAndWait();
		 }
		 */
		 
		 physicianResults = PatientAdapter.getResultSet("physician_info");
		 patientResults = PatientAdapter.getResultSet("pat_info");
		 
		 int userType = 0; //set to 1 for physician, 2 for patient
		 
		 while(physicianResults.next()) {
			 if(physicianResults.getString("Phys_email").equals(usernameBar.getText()) && physicianResults.getString("PASSWORD").equals(passwordBar.getText())) {
				 physicianResults.absolute(physicianResults.getRow());
				 userType = 1;
			 }

		 }
		 
		 while(patientResults.next()) {
			 if(patientResults.getString("PEmail").equals(usernameBar.getText()) && patientResults.getString("PASSWORD").equals(passwordBar.getText())) {
				 patientResults.absolute(patientResults.getRow());
				 userType = 2;
			 }
		 }
		 
		 if(userType == 1) {
			 FXMLLoader loader = new FXMLLoader();
			    loader.setLocation(getClass().getResource("../../../com/mentCare/view/PhysicianMainView.fxml"));
			    Parent tableViewParent = loader.load();
			    Scene tableViewScene = new Scene(tableViewParent);
			    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		        window.setScene(tableViewScene);
			    window.show();
		 }
		
			 
		 else if(userType == 2) {
			 FXMLLoader loader = new FXMLLoader();
			    loader.setLocation(getClass().getResource("../../../com/mentCare/view/PatientMainView.fxml"));
			    Parent tableViewParent = loader.load();
			    Scene tableViewScene = new Scene(tableViewParent);
			    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			    window.setScene(tableViewScene);
			    window.show();
		 }
		 else{
				Alert buttonWasClicked = new Alert(AlertType.CONFIRMATION, "Wrong username or password", ButtonType.OK, ButtonType.CANCEL);
				buttonWasClicked.showAndWait();
			 }
	 }
	 
	 public static ResultSet getPhysicianResult() {
		 return physicianResults;
	 }
	 
	 public ResultSet getPatientResult() {
		 return patientResults;
	 }
}
