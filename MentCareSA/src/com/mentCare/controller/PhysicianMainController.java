package com.mentCare.controller;

import com.mentCare.model.Patient;

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
import javafx.scene.control.ToggleButton;
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
	ObservableList<String> feetOptions = FXCollections.observableArrayList();
	ObservableList<String> inchesOptions = FXCollections.observableArrayList();
	ObservableList<String> stateOptions = FXCollections.observableArrayList();
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
	@FXML private TextField address1Field;
	@FXML private TextField address2Field;
	@FXML private TextField zipField;
	@FXML private TextArea conditionArea;
	@FXML private TextArea treatmentArea;
	@FXML private TextArea notesArea;
	@FXML private GridPane gridPane;
	@FXML private ComboBox<String> feetPicker;
	@FXML private ComboBox<String> inchesPicker;
	@FXML private ComboBox<String> statePicker;
	@FXML private Button newButton;
	@FXML private Button deleteButton;
	@FXML private ToggleButton editToggleButton;
	
	public void initialize() {
		//populate genderCombo
		genderCombo.setItems(genderOptions);
		genderCombo.getSelectionModel().selectFirst();
		//populate bloodTypeCombo
		bloodTypeCombo.setItems(bloodTypeOptions);
		bloodTypeCombo.getSelectionModel().selectFirst();
		//populate feetPicker
		feetPicker.setItems(feetOptions);
		feetPicker.getSelectionModel().selectFirst();
		//populate inchesPicker
		inchesPicker.setItems(inchesOptions);
		inchesPicker.getSelectionModel().selectFirst();
		//populate statePicker
		statePicker.setItems(stateOptions);
		statePicker.getSelectionModel().selectFirst();
		
		populatePatientTable();
	}
	
	//******************Button Actions**********************
	/*populatePatientTable
	 * this is used to take the data from the database and put the patient's name into the table view
	 */
	public void populatePatientTable() {
		
	}
	
	//******************Button Actions**********************
	
	/*newPatientButtonPushed
	 * Executes when the button labeled "New Patient" is pressed
	 * if unsaved data exists, a prompt pops up on screen asking to save the data
	 * the data in the main pane clears in order to get ready to accept new data.
	 */
	public void newButtonPushed() {
		
	}
	
	public void deleteButtonPushed() {
		
	}
	
	public void editButtonToggled() {
		Patient temp = new Patient();
		
		if(editToggleButton.isSelected()){//If the button is toggled on
			editToggleButton.setText("Done");
			//enable the view elements
			
		} else {//If the button is toggled off
			//ask user if they would like to save changes if any are present
			
			editToggleButton.setText("Edit");
			//disable the view elements
		}
	}
}
