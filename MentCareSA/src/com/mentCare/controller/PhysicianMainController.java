package com.mentCare.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PhysicianMainController {
	//configure the Patient Table
	@FXML private TableView patientTableView;
	@FXML private TableColumn patientTableColumn;
	
	//configure Patient Fields
	@FXML private TextField nameField;
	@FXML private DatePicker dobPicker;
	@FXML private ComboBox genderCombo;
	@FXML private TextField ssnField;
	@FXML private ComboBox bloodTypeCombo;
	@FXML private TextField phoneNumField;
	@FXML private TextField emailField;
	@FXML private TextField emerNameField;
	@FXML private TextField emerPhoneField;
	@FXML private TextField emerEmailField;
	@FXML private TextField emerRelationField;
	@FXML private TextArea conditionArea;
	@FXML private TextArea treatmentArea;
	@FXML private TextArea notesArea;
	
	public void initialize() {
		
	}
}
