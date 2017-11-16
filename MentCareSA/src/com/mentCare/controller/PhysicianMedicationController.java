package com.mentCare.controller;

import com.mentCare.model.Medication;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PhysicianMedicationController {
	//configure the Medication Table
	@FXML TableView<Medication> medicationTableView;
	@FXML TableColumn<Medication, String> rxTableColumn;
	@FXML TableColumn<Medication, String> nameTableColumn;
	@FXML TableColumn<Medication, String> dosageTableColumn;
	@FXML TableColumn<Medication, String> drTableColumn;
	@FXML TableColumn<Medication, String> dateTableColumn;
	
	//configure the Fields
	@FXML ComboBox medNameComboBox;
	@FXML TextField dosageTextField;
	@FXML DatePicker datePicker;
	@FXML Label patientNameLabel;
	
	//misc. Variables
	ObservableList<Medication> medicationChoiceList;
	
	public void initialize(){
		medicationChoiceList = FXCollections.observableArrayList();
		addStaticMedication();
	}
	
	private void addStaticMedication(){
		Medication m1 = new Medication();
		m1.setRxNum("1111");
		m1.setMedicationName("Testing");
		m1.setDrPrescribed("Dr. Strange");
		m1.setDosage("11 pills 7x/hour");
		m1.setMedDate("11/11/11");
		medicationChoiceList.add(m1);
	}
	
	public void todayButtonPressed(){
		
	}
	
	public void addMedication(){
		
	}
}
