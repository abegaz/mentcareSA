package com.mentCare.controller;

import com.mentCare.model.Patient;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
	@FXML private TextField weightField;
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
	@FXML private ToggleButton organDonorToggleButton;
	
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
	
	//******************Created Functions**********************
	/*populatePatientTable
	 * this is used to take the data from the database and put the patient's name into the table view
	 */
	public void populatePatientTable() {
		
	}
	/*enableAllElements
	 * used to set the disabled property for all elements in the window to false 
	 */
	public void enableAllElements(){
		nameField.setDisable(false);
		dobPicker.setDisable(false);
		genderCombo.setDisable(false);
		ssnField.setDisable(false);
		bloodTypeCombo.setDisable(false);
		feetPicker.setDisable(false);
		inchesPicker.setDisable(false);
		weightField.setDisable(false);
		organDonorToggleButton.setDisable(false);
		phoneNumField.setDisable(false);
		emailField.setDisable(false);
		address1Field.setDisable(false);
		address2Field.setDisable(false);
		statePicker.setDisable(false);
		zipField.setDisable(false);
		emerNameField.setDisable(false);
		emerPhoneField.setDisable(false);
		emerEmailField.setDisable(false);
		emerRelationField.setDisable(false);
		conditionArea.setDisable(false);
		treatmentArea.setDisable(false);
		notesArea.setDisable(false);
	}
	
	/*disableAllElements
	 * used to set the disabled property for all elements in the window to true 
	 */
	public void disableAllElements(){
		nameField.setDisable(true);
		dobPicker.setDisable(true);
		genderCombo.setDisable(true);
		ssnField.setDisable(true);
		bloodTypeCombo.setDisable(true);
		feetPicker.setDisable(true);
		inchesPicker.setDisable(true);
		weightField.setDisable(true);
		organDonorToggleButton.setDisable(true);
		phoneNumField.setDisable(true);
		emailField.setDisable(true);
		address1Field.setDisable(true);
		address2Field.setDisable(true);
		statePicker.setDisable(true);
		zipField.setDisable(true);
		emerNameField.setDisable(true);
		emerPhoneField.setDisable(true);
		emerEmailField.setDisable(true);
		emerRelationField.setDisable(true);
		conditionArea.setDisable(true);
		treatmentArea.setDisable(true);
		notesArea.setDisable(true);
	}
	
	//******************Button Actions**********************
	
	/*newPatientButtonPushed
	 * Executes when the button labeled "New Patient" is pressed
	 * if unsaved data exists, a prompt pops up on screen asking to save the data
	 * the data in the main pane clears in order to get ready to accept new data.
	 */
	public void newButtonPressed() {
		
	}
	
	public void deleteButtonPressed() {
		
	}
	
	public void editButtonToggled() {
		Patient temp = new Patient();
		
		if(editToggleButton.isSelected()){//If the button is toggled on
			editToggleButton.setText("Done");
			//enable the view elements
			enableAllElements();
			
		} else {//If the button is toggled off
			//ask user if they would like to save changes if any are present
			Alert alert = new Alert(AlertType.CONFIRMATION, "Would you like to save your changes?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
			alert.showAndWait();
			
			if(alert.getResult() == ButtonType.YES){
				editToggleButton.setText("Edit");
				//disable the view elements
				disableAllElements();
			} else if(alert.getResult() == ButtonType.NO){
				editToggleButton.setText("Edit");
				//disable the view elements
				disableAllElements();
			} else if(alert.getResult() == ButtonType.CANCEL){
				editToggleButton.setSelected(true);
			}
		}
	}
}
