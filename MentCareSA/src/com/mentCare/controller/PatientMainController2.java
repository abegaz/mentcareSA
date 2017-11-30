package com.mentCare.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


import com.mentCare.adapter.PatientAdapter;
import com.mentCare.model.Address;
import com.mentCare.model.EmergencyContact;
import com.mentCare.model.Patient;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PatientMainController2 {

		//configure Patient Fields
		@FXML private Label nameLabel;
		@FXML private Label dobLabel;
		@FXML private Label genderLabel;
		@FXML private Label ssnLabel;
		@FXML private Label bloodTypeLabel;
		@FXML private Label heightLabel;
		@FXML private Label weightLabel;
		@FXML private Label organDonorLabel;
		@FXML private Label phoneNumLabel;
		@FXML private Label emailLabel;
		@FXML private Label emerNameLabel;
		@FXML private Label emerPhoneLabel;
		@FXML private Label emerEmailLabel;
		@FXML private Label emerRelationLabel;
		@FXML private Label address1Label;
		@FXML private Label address2Label;
		@FXML private Label cityLabel;
		@FXML private Label zipLabel;
		@FXML private Label conditionArea;
		@FXML private Label treatmentArea;
		
		private Connection connection;	
		private ResultSet resultSet;
		private static Connection conn = MentcareDBconfig.getConnection();
				
		

		
		/*String sql_query = "SELECT Pat_id FROM PAT_INFO WHERE Username = '"; 
		Statement st = connection.createStatement();
	    // execute the query, and get a java resultset
	    ResultSet rs = st.executeQuery(sql_query);
	    // Get the password with username
	    // If the username is not existed in the database, it will be handled by catch statement
	    String password = rs.getString("Password");
	    String name = nameLabel.getText();
	    String dob = dobLabel.getText();
	    String gender = genderLabel.getText();
	    String ssn = ssnLabel.getText();
	    String bloodType = bloodTypeLabel.getText();
	    String height = heightLabel.getText();
	    String weight = weightLabel.getText();
	    String organDonor = organDonorLabel.getText();
	    String phoneNum = phoneNumLabel.getText();
	    String email = emailLabel.getText();
	    String emerName = emerNameLabel.getText();
	    String emerPhone = emerPhoneLabel.getText();
	    String emerEmail=  emerEmailLabel.getText();
	    String emerRelation = emerRelationLabel.getText();
	    String address1 = address1Label.getText();
	    String address2 = address2Label.getText();
	    String city = cityLabel.getText();
	    String zip = zipLabel.getText();*/
	    

		

		
		
}
