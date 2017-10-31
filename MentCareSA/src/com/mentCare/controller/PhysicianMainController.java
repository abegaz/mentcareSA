package com.mentCare.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PhysicianMainController {
	//Initialize ComboBox Options
	ObservableList<String> genderOptions = FXCollections.observableArrayList(
	        "Male",
	        "Female"
	    );
	ObservableList<String> bloodTypeOptions = FXCollections.observableArrayList(
			"A+",
			"A-",
			"B+",
			"B-",
			"AB+",
			"AB-",
			"O+",
			"O-");
	//configure the Patient Table
	@FXML private TableView patientTableView;
	@FXML private TableColumn patientTableColumn;
	
	//configure Patient Fields
	@FXML private TextField nameField;
	@FXML private DatePicker dobPicker;
	@FXML private ComboBox<String> genderCombo;
	@FXML private TextField ssnField;
	@FXML private ComboBox<String> bloodTypeCombo;
	@FXML private TextField phoneNumField;
	@FXML private TextField emailField;
	@FXML private TextField emerNameField;
	@FXML private TextField emerPhoneField;
	@FXML private TextField emerEmailField;
	@FXML private TextField emerRelationField;
	@FXML private TextArea conditionArea;
	@FXML private TextArea treatmentArea;
	@FXML private TextArea notesArea;
	@FXML private GridPane gridPane;
	@FXML private Button newButton;
	@FXML private Button deleteButton;
	
	public void initialize() {
		genderCombo.setItems(genderOptions);
		genderCombo.getSelectionModel().selectFirst();
		
		bloodTypeCombo.setItems(bloodTypeOptions);
		bloodTypeCombo.getSelectionModel().selectFirst();
	}
	
	//******************Button Actions**********************
	
	/*newPatientButtonPushed
	 * Executes when the button labeled "New Patient" is pressed
	 * if unsaved data exists, a prompt pops up on screen asking to save the data
	 * the data in the main pane clears in order to get ready to accept new data.
	 */
	public void newPatientButtonPushed() {
		
	}
	
	public void closeButtonPushed() {
		
	}
}
