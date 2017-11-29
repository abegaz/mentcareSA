/*Class Name: PhysicianMainController
 *
 *Version: 01.01
 *Changes from last version:
 	*Added support for Medication table
 *
 *The purpose of this class is to be the behind-the-scenes work behind the PhysicianMainView class.
 *
 */
/*To-Do:
 * For Treatments, instead of textArea, add ability to add medication, dosage, and doctor prescribed
 	* implies that a tableView of physicians is required
 */

package com.mentCare.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

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
	ObservableList<String> feetOptions = FXCollections.observableArrayList(
			"1",
			"2",
			"3",
			"4",
			"5",
			"6",
			"7",
			"8");
	ObservableList<String> inchesOptions = FXCollections.observableArrayList(
			"0",
			"1",
			"2",
			"3",
			"4",
			"5",
			"6",
			"7",
			"8",
			"9",
			"10",
			"11");
	ObservableList<String> stateOptions = FXCollections.observableArrayList(
			"AL",
			"AK",
			"AZ",
			"AR",
			"CA",
			"CO",
			"CT",
			"DE",
			"FL",
			"GA",
			"HI",
			"ID",
			"IL",
			"IN",
			"IA",
			"KS",
			"KY",
			"LA",
			"ME",
			"MD",
			"MA",
			"MI",
			"MN",
			"MS",
			"MO",
			"MT",
			"NE",
			"NV",
			"NH",
			"NJ",
			"NM",
			"NY",
			"NC",
			"ND",
			"OH",
			"OK",
			"OR",
			"PA",
			"RI",
			"SC",
			"TN",
			"TX",
			"UT",
			"VT",
			"VA",
			"WA",
			"WV",
			"WI",
			"WY",
			"GU",
			"PR",
			"VI");

	//configure the Patient Table
	@FXML private TableView<Patient> patientTableView;
	@FXML private TableColumn<Patient, String> patientTableColumn;

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
	@FXML private TextArea notesArea;
	@FXML private GridPane gridPane;
	@FXML private ComboBox<String> feetPicker;
	@FXML private ComboBox<String> inchesPicker;
	@FXML private ComboBox<String> statePicker;
	@FXML private Button newButton;
	@FXML private Button deleteButton;
	@FXML private ToggleButton editToggleButton;
	@FXML private ToggleButton organDonorToggleButton;
	@FXML private Button saveButton;
	@FXML private MenuButton optionsMenuButton;
	@FXML private Label patientNameLabel;
	@FXML private TextField searchField;
	@FXML private TextField cityField;
	@FXML private TextArea treatmentTextArea;

	//configure misc variables
	private boolean unsavedChanges;//used to track if an unsaved change has been made to a patient
	private boolean newPatient;//used to track if the physician is currently working on creating a new patient
	private ObservableList<Patient> patientList;//used to track all patients locally
	private Patient selectedPatient;//used to track which patient is currently selected.
									//This is changed when a patient in the table is double clicked
	private static ResultSet physicianResult = loginController.getPhysicianResult();
	private String physicianId;

	public void initialize() {
		try {
			physicianId = physicianResult.getString("Phys_Id");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		patientList = FXCollections.observableArrayList();
		unsavedChanges = false;

		//Create tooltip text for buttons
		Tooltip newButtonTip = new Tooltip();
		newButtonTip.setText("Create a new Patient");
		newButton.setTooltip(newButtonTip);

		Tooltip setButtonTip = new Tooltip();
		setButtonTip.setText("Save the Patient information");
		saveButton.setTooltip(setButtonTip);

		Tooltip deleteButtonTip = new Tooltip();
		deleteButtonTip.setText("Delete the selected Patient");
		deleteButton.setTooltip(deleteButtonTip);

		Tooltip editButtonTip = new Tooltip();
		editButtonTip.setText("Edit the Patient information");
		editToggleButton.setTooltip(editButtonTip);

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

		//set up the tableView to detect double clicks
		patientTableView.setRowFactory(tv -> {
			TableRow<Patient> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if(event.getClickCount() == 2 && (! row.isEmpty())){//do the following when the click count is 2 (double click) and we arent clicking an empty row
					Patient oldPatient = selectedPatient;
					selectedPatient = row.getItem();//get the item in the clicked row and assign it to selectedPatient.
					tableCellDoubleClicked(oldPatient, selectedPatient);
				}
			});
			return row;
		});

		//***********Patient Table***************//
		//set up the columns in the table
		patientTableColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("displayName"));
		//static data, will replace with the database record later
		//addStaticData();
		importPatientData();
		patientTableView.setItems(patientList);//use the data in patientList to populate the patientTableView

		patientTableView.setEditable(false);
		patientTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	}

	/**********************Supporting Actions***************************/

	/*addStaticData
	 * used to create a static list of patients
	 * mainly used for testing purposes
	 */
	public void addStaticData(){
		Patient josh = new Patient("Joshua Knight");
		josh.setAddress(new Address("82 College cir.", "Dahlonega", "GA", "30597"));
		josh.setBloodType("O+");
		josh.setCondition("Mentally Handicapped");
		josh.setEmail("jmknig0314@ung.edu");
		josh.setEmerContact(new EmergencyContact("Snuffy", "Joseph", "770-555-1234", "joe.snuffy@ung.edu"));
		josh.setHeight("69");
		josh.setTreatment("There is no hope for him.");
		josh.setNotes("None");
		josh.setOrganDonor(true);
		josh.setPassword("p@ssW0rd!");
		josh.setPhoneNum("706-201-9393");
		josh.setSsn(111223333);
		josh.setWeight("190");
		josh.setMale(true);

		Patient joe = new Patient("Joseph Mathis");
		joe.setAddress(new Address("82 College cir.", "Dahlonega", "GA", "30597"));
		joe.setBloodType("A-");
		joe.setCondition("Alzheimer's");
		joe.setEmail("joe.snuffy@ung.edu");
		joe.setEmerContact(new EmergencyContact("Knight", "Joshua", "706-201-9393", "jmknig0314@ung.edu"));
		joe.setHeight("72");
		joe.setTreatment("Anti Alzheimer's pills");
		joe.setNotes("uhhh. I can't remember.");
		joe.setOrganDonor(false);
		joe.setPassword("toor");
		joe.setPhoneNum("770-555-1234");
		joe.setSsn(123456789);
		joe.setWeight("175");
		joe.setMale(true);

		patientList.add(josh);
		patientList.add(joe);
	}


	public void importPatientData(){
		ResultSet patients = PatientAdapter.getResultSet("Pat_Info");

		try{

			while(patients.next()){
				int id = patients.getInt("PID");
				String assignedPhysician = patients.getString("AssignedPhysician");
				
				if(assignedPhysician.equals(physicianId)){
					String name = patients.getString("Pname");
					Date dob = patients.getDate("DOB");//patients.getString("DOB");//must be in YYYY-MM-DD format
					boolean isMale = patients.getBoolean("Is_Male");
					String password = patients.getString("Ppass");
					int ssn = patients.getInt("SSN");
					String bloodType = patients.getString("Blood_Type");
					String phone = patients.getString("Pphone");
					String email = patients.getString("PEmail");
					boolean organDonor = patients.getBoolean("Organ_Donor");
					String address;
					String city;
					String state;
					String zip;
					String weight = patients.getString("Weight");
					String height = patients.getString("Height");
					String notes = patients.getString("Notes");
					String emerName;
					String emerPhone;
					String emerEmail;
					String emerRelation;

					Patient p = new Patient();
					p.setName(name);

					/*Uncomment when figured out how to get the address info
					Address addressActual = new Address();
					addressActual.setAddress(address);
					addressActual.setCity(city);
					addressActual.setState(state);
					addressActual.setZip(zip);
					*/
					
					/*Uncomment when figured out how to get the Emergency Contact info
					EmergencyContact emer = new EmergencyContact();
					emer.setName(emerName);
					emer.setEmail(emerEmail);
					emer.setPhoneNum(emerPhone);
					emer.setRelation(emerRelation);
					*/

					p.setMale(isMale);
					p.setPassword(password);
					p.setSsn(ssn);
					p.setDob(dob.toLocalDate());
					p.setBloodType(bloodType);
					p.setPhoneNum(phone);
					p.setEmail(email);
					p.setOrganDonor(organDonor);
					p.setWeight(weight);
					p.setHeight(height);
					p.setNotes(notes);
					//p.setAddress(addressActual);
					
					patientList.add(p);
				}
			}

		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}

	/*enableAllElements
	 * used to set the disabled property for all elements in the window to false
	 * textField's setEditable property is set to true to allow for better readability
	 */
	public void enableAllElements(){
		nameField.setEditable(true);
		dobPicker.setDisable(false);
		genderCombo.setDisable(false);
		ssnField.setEditable(true);
		bloodTypeCombo.setDisable(false);
		feetPicker.setDisable(false);
		inchesPicker.setDisable(false);
		weightField.setEditable(true);
		organDonorToggleButton.setDisable(false);
		phoneNumField.setEditable(true);
		emailField.setEditable(true);
		address1Field.setEditable(true);
		address2Field.setEditable(true);
		statePicker.setDisable(false);
		zipField.setEditable(true);
		emerNameField.setEditable(true);
		emerPhoneField.setEditable(true);
		emerEmailField.setEditable(true);
		emerRelationField.setEditable(true);
		conditionArea.setEditable(true);
		treatmentTextArea.setEditable(true);
		notesArea.setEditable(true);
		cityField.setEditable(true);
	}

	/*disableAllElements
	 * used to set the disabled property for all elements in the window to true
	 * textField's setEditable property is set to false to allow for better readability
	 */
	public void disableAllElements(){
		nameField.setEditable(false);
		dobPicker.setDisable(true);
		genderCombo.setDisable(true);
		ssnField.setEditable(false);
		bloodTypeCombo.setDisable(true);
		feetPicker.setDisable(true);
		inchesPicker.setDisable(true);
		weightField.setEditable(false);
		organDonorToggleButton.setDisable(true);
		phoneNumField.setEditable(false);
		emailField.setEditable(false);
		address1Field.setEditable(false);
		address2Field.setEditable(false);
		statePicker.setDisable(true);
		zipField.setEditable(false);
		emerNameField.setEditable(false);
		emerPhoneField.setEditable(false);
		emerEmailField.setEditable(false);
		emerRelationField.setEditable(false);
		conditionArea.setEditable(false);
		treatmentTextArea.setEditable(false);
		notesArea.setEditable(false);
		cityField.setEditable(false);
	}

	/*clearAllElements
	 * wipes the data in all of the input fields
	 */
	private void clearAllElements(){
		selectedPatient = null;
		nameField.setText("");
		dobPicker.setValue(null);
		genderCombo.setValue("Male");
		ssnField.setText("");
		bloodTypeCombo.setValue("A+");
		feetPicker.setValue("1");
		inchesPicker.setValue("0");
		organDonorToggleButton.setText("Yes");
		organDonorToggleButton.setSelected(true);
		phoneNumField.setText("");
		emailField.setText("");
		address1Field.setText("");
		address2Field.setText("");
		statePicker.setValue("AL");
		zipField.setText("");
		emerNameField.setText("");
		emerPhoneField.setText("");
		emerEmailField.setText("");
		emerRelationField.setText("");
		conditionArea.setText("");
		notesArea.setText("");
		weightField.setText("");
		cityField.setText("");
	}

	/*promptSaveChanges
	 * used to create an alert on screen asking if the user would like to save changes
	 * usually used before changes are about to be discarded, in order to preserve data.
	 * returns an Alert to allow the calling method to handle the options
	 *
	 * generic options are used in this method: save the data if yes, discard the data if no.
	 */
	public Alert promptSaveChanges() {
		Alert alert = new Alert(AlertType.CONFIRMATION, "Would you like to save your changes?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
		alert.showAndWait();

		if(alert.getResult() == ButtonType.YES){
			saveButtonPressed();
		} else if(alert.getResult() == ButtonType.NO){
			if(newPatient){//if the data being edited is a new patient, discard the entire patient
				patientList.remove(selectedPatient);
			}

			newPatient = false;

		}

		newButton.setDisable(newPatient);

		return alert;
	}

	/*dataChanged()
	 * called when an input field is altered. Lets the system know that an unsaved change has been made
	 */
	public void dataChanged() {
		if(!unsavedChanges && editToggleButton.isSelected()) {//if editing a field and there are not already unsaved changes
			unsavedChanges = true;
			//puts a star beside the patient's name at the top of the page to indicate that there are
			//unsaved changes
			patientNameLabel.setText("*" + patientNameLabel.getText());
		}
	}

	/*searchPatients
	 * called when the button labeled "Search" is pressed
	 * function takes the data in the searchField and traverses the PatientTable to find a match
	 */
	public void searchPatients(){
		ObservableList<Patient> searchList = FXCollections.observableArrayList();
		String searchText = searchField.getText();

		if(searchField.getText() == ""){
			patientTableView.setItems(patientList);
		} else{
			for(int a = 0; a < patientList.size(); a++){//linear search implemented
				Patient currentIndex = patientList.get(a);//start at the first index in the patientList
				String fullLowercase = currentIndex.getName().toLowerCase();//get the name and change it to lowercase
				CharSequence c = searchText.toLowerCase();//change the search text to lowercase to match the patientList name's case
				if(fullLowercase.contains(c)){
					searchList.add(currentIndex);
				}
			}
			patientTableView.setItems(searchList);
		}
	}

	/*nameFieldIsBlank
	 * called when attempting to save patient data
	 * returns true if nameField is blank, false otherwise
	 * this is used because a patient is not allowed to be saved unless they have a name
	 */
	public boolean nameFieldIsBlank(){
		if(nameField.getText().equals("") || nameField == null){
			return true;
		} else{
			return false;
		}
	}

	/*showEmptyNameError
	 * called when attempting to save data, but the nameField is blank, indicating that the patient has no name
	 * Shows an error message on screen, prompting the user that they must enter a name
	 */
	public void showEmptyNameError(){
		Alert error = new Alert(AlertType.ERROR);
		error.setContentText("Patient must have a name!");
		error.show();
	}

	/*saveData
	 * called when the save button is pressed, or otherwise attempting to save information
	 * updates data in the patient list and pushes that data to the database
	 */
	public void saveData(){
		patientList.remove(selectedPatient);//discard the old changes
		//initialize local variables used to assign input fields to
		String lastName, firstName, middleName;
		LocalDate dob;
		String gender, ssn, bloodType, feet, inches;
		boolean organDonor;
		String phoneNum, email, addressLine, city, state, zip;
		String emerName, emerEmail, emerPhone, emerRelation, condition;
		String treatment, notes, weight;
		Address address;
		EmergencyContact emer;
		Patient p;
		int in, ft, height;

		String name = nameField.getText();//get name from the input field
		//get the values from the input fields and assign them to the local variables
		dob = dobPicker.getValue();
		gender = genderCombo.getValue();
		ssn = ssnField.getText();
		bloodType = bloodTypeCombo.getValue();
		feet = feetPicker.getValue();
		inches = inchesPicker.getValue();
		organDonor = organDonorToggleButton.isSelected();
		phoneNum = phoneNumField.getText();
		email = emailField.getText();
		addressLine = address1Field.getText();
		city = cityField.getText();
		state = statePicker.getValue();
		zip = zipField.getText();
		emerName = emerNameField.getText();
		emerEmail = emerEmailField.getText();
		emerPhone = emerPhoneField.getText();
		emerRelation = emerRelationField.getText();
		condition = conditionArea.getText();
		treatment = treatmentTextArea.getText();
		notes = notesArea.getText();
		weight = weightField.getText();
		address = new Address(addressLine, city, state, zip);
		emer = new EmergencyContact(emerName, emerEmail, emerPhone, emerRelation);
		//calculate the total height in inches
		in = Integer.parseInt(inches);
		ft = Integer.parseInt(feet) * 12;
		height = in + ft;
		//convert the total inches into a String
		String heightString = "" + height;

		boolean isMale;
		//assign the isMale variable
		if(gender.equalsIgnoreCase("Male")){
			isMale = true;
		} else {
			isMale = false;
		}
		//create a new patient based on the input data
		p = new Patient(name, dob, isMale, email, "password", ssn, bloodType, phoneNum, address, heightString, weight, organDonor, emer, condition, treatment, notes);
		//add the new patient to the patientList
		patientList.add(p);
	}

	/*loadData
	 * called when a patient in the table has been double clicked
	 * used to load data from the patientList into the view fields
	 */
	public void loadData(){
		Patient p = selectedPatient;

		String name = p.getName();

		nameField.setText(name);
		dobPicker.setValue(p.getDob());

		String gender;
		if(p.isMale()){
			gender = "Male";
		} else {
			gender = "Female";
		}
		genderCombo.setValue(gender);

		ssnField.setText("" + p.getSsn());
		bloodTypeCombo.setValue(p.getBloodType());
		phoneNumField.setText(p.getPhoneNum());
		emailField.setText(p.getEmail());

		int inches, feet, total;
		total = Integer.parseInt(p.getHeight());
		feet = total / 12;
		inches = total % 12;
		feetPicker.setValue("" + feet);
		inchesPicker.setValue("" + inches);

		EmergencyContact emer = p.getEmerContact();
		emerNameField.setText(emer.getName());
		emerPhoneField.setText(emer.getPhoneNum());
		emerEmailField.setText(emer.getEmail());
		emerRelationField.setText(emer.getRelation());

		Address a = p.getAddress();
		address1Field.setText(a.getAddress());
		cityField.setText(a.getCity());
		statePicker.setValue(a.getState());
		zipField.setText(a.getZip());

		weightField.setText(p.getWeight());
		conditionArea.setText(p.getCondition());
		treatmentTextArea.setText(p.getTreatment());
		notesArea.setText(p.getNotes());

		patientNameLabel.setText(selectedPatient.getDisplayName());
	}

	//******************Button Actions**********************

	/*newPatientButtonPushed
	 * Executes when the button labeled "New Patient" is pressed
	 * if unsaved data exists, a prompt pops up on screen asking to save the data
	 * the data in the main pane clears in order to get ready to accept new data.
	 */
	public void newButtonPressed() {
		newButton.setDisable(true);
		if(unsavedChanges) {
			promptSaveChanges();
		}
		//create new cell in patient table view
		Patient p = new Patient();
		selectedPatient = p;
		patientList.add(selectedPatient);
		//Change name at top of Window
		patientNameLabel.setText("Untitled Patient");
		//clear all input fields
		clearAllElements();
		//act as if you pressed the edit button
		editToggleButton.setSelected(true);
		editButtonToggled();
		newPatient = true;
	}

	/*deleteButtonPressed
	 * Executes when the button labeled "Delete" is pressed
	 * a prompt appears that asks the user if they are sure they want to delete the data
	 * if they confirm, the patient currently selected is deleted from the database and the view
	 */
	public void deleteButtonPressed() {
		if(selectedPatient != null){
			Alert alert = new Alert(AlertType.CONFIRMATION, "Are you sure you want to delete " +
		selectedPatient.getName() + "?", ButtonType.YES, ButtonType.CANCEL);

			alert.showAndWait();

			if(alert.getResult() == ButtonType.YES){
				//The Selected Patient is deleted
				patientList.remove(selectedPatient);
				clearAllElements();//The Input fields are cleared
				editToggleButton.setSelected(false);
				editToggleButton.setText("Edit");
				disableAllElements();
				selectedPatient = null;
			}
		}
	}

	/*saveButtonPressed
	 * Executes when the button labeled "Save" is pressed
	 * the data is compared to that of the database and the database is updated
	 */
	public void saveButtonPressed(){
		//check to see if the name field is blank. disallow saving if it is
		if(nameFieldIsBlank()){
			showEmptyNameError();
		}

		//upload any changes to the database

		if(unsavedChanges) {
			saveData();
			unsavedChanges = false;
		}
		if(newPatient){
			editToggleButton.setSelected(false);
			editToggleButton.setText("Edit");
			disableAllElements();
			newButton.setDisable(false);
			selectedPatient = patientList.get(patientList.size() - 1);
			patientNameLabel.setText(selectedPatient.getDisplayName());
			newPatient = false;
		}
	}

	/*editButtonToggled
	 * Executes when the button labeled "Edit" is pressed
	 * the editable fields are enabled to allow the user to edit the patient information
	 * the edit button is changed to "Done" to allow the user to finish changes
	 * at the end of the changes, a prompt appears to ask if the user would like to save the changes
	 * once changes are saved/discarded, the fields are re-disabled.
	 */
	public void editButtonToggled() {
		if(selectedPatient == null) {
			editToggleButton.setSelected(false);
		}
		else {
			if(editToggleButton.isSelected()){//If the button is toggled on
				editToggleButton.setText("Done");
				//enable the view elements
				enableAllElements();

			} else {//If the button is toggled off
				//check to see if the nameField is blank. disallow saving if it is
				if(nameFieldIsBlank()){
					showEmptyNameError();
					editToggleButton.setSelected(true);
				}
				//ask user if they would like to save changes if any are present
				else if(unsavedChanges) {
					Alert alert = promptSaveChanges();

					if(alert.getResult() == ButtonType.YES){//Data is saved
						editToggleButton.setText("Edit");
						disableAllElements();
					} else if(alert.getResult() == ButtonType.NO){//Data is discarded
						//reload the data from the database

						editToggleButton.setText("Edit");
						disableAllElements();
					} else if(alert.getResult() == ButtonType.CANCEL){//Dialog box is dismissed. Editing is allowed
						editToggleButton.setSelected(true);
					}
				} else {
					editToggleButton.setText("Edit");
					disableAllElements();
				}
			}
		}
	}

	/*printButtonPressed
	 * exports the data to a pdf and uses the system printer window to print the data
	 */
	public void printButtonPressed(){
		System.out.println("Print Button Pressed");
	}

	/*orgonDonorPressed
	 * if the button says yes, change text to no; and vice versa
	 */
	public void organDonorPressed(){
		String buttonText = organDonorToggleButton.getText();
		if(buttonText.equalsIgnoreCase("yes")){
			organDonorToggleButton.setText("No");
		}
		else{
			organDonorToggleButton.setText("Yes");
		}
		dataChanged();
	}

	/*tableCellDoubleClicked
	 * called when a cell in the patientViewTable is double clicked
	 * used to load the data from the patient into the view
	 */
	public void tableCellDoubleClicked(Patient old, Patient newPatient){
		if(nameFieldIsBlank() && old != null){
			showEmptyNameError();
		} else if(unsavedChanges){
			Alert alert = promptSaveChanges();

			if(alert.getResult() == ButtonType.YES){
				selectedPatient = old;
				saveData();
				selectedPatient = newPatient;
				loadData();
			} else if(alert.getResult() == ButtonType.NO){
				loadData();
			}
		} else{
			selectedPatient = newPatient;
			System.out.println(selectedPatient.toString());
			loadData();
		}
	}

	/*logoutButtonPressed
	 * called when the logout button is pressed
	 * used to log the user out of the system and load the login screen
	 */
	public void logoutButtonPressed(ActionEvent event) throws IOException{
		FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(getClass().getResource("../../../com/mentCare/view/login.fxml"));
	    Parent tableViewParent = loader.load();
	    Scene tableViewScene = new Scene(tableViewParent);
	    Stage window = new Stage();
	    window.setScene(tableViewScene);
	    window.show();

	    Stage thisStage = (Stage) newButton.getScene().getWindow();
	    thisStage.close();
	}
}