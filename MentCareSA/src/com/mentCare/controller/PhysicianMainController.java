<<<<<<< HEAD
/*Class Name: PhysicianMainController
 *
 *The purpose of this class is to be the behind-the-scenes work behind the PhysicianMainView class.
 *
 */
/*To-Do:
 * For Treatments, instead of textArea, add ability to add medication, dosage, and doctor prescribed
 	* implies that a tableView of physicians is required
 * Fix TableView so that when you double click a row, the patient's data loads.
 */

package com.mentCare.controller;

import java.time.LocalDate;

import com.mentCare.model.Address;
import com.mentCare.model.EmergencyContact;
import com.mentCare.model.Patient;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
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
	@FXML private Button saveButton;
	@FXML private MenuButton optionsMenuButton;
	@FXML private Label patientNameLabel;
	@FXML private TextField searchField;
	@FXML private TextField cityField;

	private boolean unsavedChanges;
	private boolean newPatient;
	private ObservableList<Patient> patientList;
	private Patient selectedPatient;

	public void initialize() {
		patientList = FXCollections.observableArrayList();
		unsavedChanges = false;
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
		
		patientTableView.setRowFactory(tv -> {
			TableRow<Patient> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if(event.getClickCount() == 2 && (! row.isEmpty())){
					Patient rowData = row.getItem();
					//selectedPatient = rowData;
					tableCellDoubleClicked();
				}
			});
			return row;
		});
		
		//set up the columns in the table
		patientTableColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("displayName"));
		//static data, will replace with the database record later
		addStaticData();
		patientTableView.setItems(patientList);

		patientTableView.setEditable(false);
		patientTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());


	}
	/* this is used to take the data from the database and put the patient's name into the t

	/*addStaticData
	 * used to create a static list of patients
	 * mainly used for testing purposes
	 */
	public void addStaticData(){
		Patient josh = new Patient("Knight", "Joshua", "Matthew");
		josh.setAddress(new Address("82 College cir.", "Dahlonega", "GA", "30597"));
		josh.setBloodType("O+");
		josh.setCondition("Mentally Handicapped");
		josh.setEmail("jmknig0314@ung.edu");
		josh.setEmerContact(new EmergencyContact("Snuffy", "Joseph", "770-555-1234", "joe.snuffy@ung.edu"));
		josh.setHeight("69");
		josh.setNotes("None");
		josh.setOrganDonor(true);
		josh.setPassword("p@ssW0rd!");
		josh.setPhoneNum("706-201-9393");
		josh.setSsn("111-22-3333");
		josh.setTreatment("There is no hope for him");
		josh.setWeight("190");

		Patient joe = new Patient("Snuffy", "Joseph", "Mathis");
		joe.setAddress(new Address("82 College cir.", "Dahlonega", "GA", "30597"));
		joe.setBloodType("A-");
		joe.setCondition("Alzheimer's");
		joe.setEmail("joe.snuffy@ung.edu");
		joe.setEmerContact(new EmergencyContact("Knight", "Joshua", "706-201-9393", "jmknig0314@ung.edu"));
		joe.setHeight("72");
		joe.setNotes("uhhh. I can't remember.");
		joe.setOrganDonor(false);
		joe.setPassword("root");
		joe.setPhoneNum("770-555-1234");
		joe.setSsn("123-45-6789");
		joe.setTreatment("Alzheimer's pills 2/dy");
		joe.setWeight("175");

		patientList.add(josh);
		patientList.add(joe);
	}
	
	/* separateNames
	 * takes in a string as input. Separates the string up into 3 strings using a space
	 * as the separator.
	 */
	public String[] separateNames(String name) {
		return name.split(", ");
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
		cityField.setDisable(false);
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
		cityField.setDisable(true);
	}

	/*clearAllElements
	 * wipes the data in all of the input fields
	 */
	private void clearAllElements(){
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
		treatmentArea.setText("");
		notesArea.setText("");
		weightField.setText("");
		cityField.setText("");
	}

	/*promptSaveChanges
	 * used to create an alert on screen asking if the user would like to save changes
	 * usually used before changes are about to be discarded, in order to preserve data.
	 * returns an Alert to allow the calling method to handle the options
	 */
	public Alert promptSaveChanges() {
		Alert alert = new Alert(AlertType.CONFIRMATION, "Would you like to save your changes?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
		alert.showAndWait();

		if(alert.getResult() == ButtonType.YES){
			patientList.remove(selectedPatient);//remove the placeholder patient
			//initialize local variables used to assign input fields to
			String lastName, firstName, middleName;
			LocalDate dob;
			String gender, ssn, bloodType, feet, inches;
			boolean organDonor;
			String phoneNum, email, address1, address2, city, state, zip;
			String emerName, emerEmail, emerPhone, emerRelation, condition;
			String treatments, notes, weight;
			Address address;
			EmergencyContact emer;
			Patient p;
			int in, ft, height;
			
			String name = nameField.getText();//get name from the input field
			String[] sepNames = separateNames(name);
			//in case the name is not inserted as predicted, the program will not crash
			try {
				lastName = sepNames[0];
			} catch(ArrayIndexOutOfBoundsException e) {
				lastName = "";
			}
			try {	
				firstName = sepNames[1];
			} catch(ArrayIndexOutOfBoundsException e) {
				firstName = "";
			}
			try {
				middleName = sepNames[2];
			} catch(ArrayIndexOutOfBoundsException e){
				middleName = "";
			}
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
			address1 = address1Field.getText();
			address2 = address2Field.getText();
			city = cityField.getText();
			state = statePicker.getValue();
			zip = zipField.getText();
			emerName = emerNameField.getText();
			emerEmail = emerEmailField.getText();
			emerPhone = emerPhoneField.getText();
			emerRelation = emerRelationField.getText();
			condition = conditionArea.getText();
			treatments = treatmentArea.getText();
			notes = notesArea.getText();
			weight = weightField.getText();
			address = new Address(address1, address2, city, state, zip);
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
			p = new Patient(lastName, middleName, firstName, dob, isMale, email, "password", ssn, bloodType, phoneNum, address, heightString, weight, organDonor, emer, condition, treatments, notes);
			//add the new patient to the patientList
			patientList.add(p);
			
			newPatient = false;
		} else if(alert.getResult() == ButtonType.NO){
			
			newPatient = false;
		} else if(alert.getResult() == ButtonType.CANCEL){

		}

		newButton.setDisable(newPatient);
		
		return alert;
	}

	/*dataChanged()
	 * called when an input field is altered. Lets the system know that an unsaved change has been made
	 */
	public void dataChanged() {
		if(!unsavedChanges) {
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

	}

	//******************Button Actions**********************

	/*patientTableClicked
	 * ran when the user clicks on the Table.
	 * used to get the selected row in the table and change the selected patient.
	 */
	public void patientTableClicked(){
		selectedPatient = patientTableView.getSelectionModel().getSelectedItem();
	}
	
	
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
		Alert alert = new Alert(AlertType.CONFIRMATION, "Are you sure you want to delete this patient?", ButtonType.YES, ButtonType.CANCEL);
		alert.showAndWait();

		if(alert.getResult() == ButtonType.YES){
			//The Table Cell is deleted
			//The Input fields are cleared
		}
	}

	/*saveButtonPressed
	 * Executes when the button labeled "Save" is pressed
	 * the data is compared to that of the database and the database is updated
	 */
	public void saveButtonPressed(){
		//upload any changes to the database
		if(unsavedChanges) {
			unsavedChanges = false;
			String patientName = patientNameLabel.getText();
			patientName = patientName.substring(1);
			patientNameLabel.setText(patientName);
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
		if(editToggleButton.isSelected()){//If the button is toggled on
			editToggleButton.setText("Done");
			//enable the view elements
			enableAllElements();

		} else {//If the button is toggled off
			//ask user if they would like to save changes if any are present
			if(unsavedChanges) {
				Alert alert = promptSaveChanges();

				if(alert.getResult() == ButtonType.YES){
					//save the data
					saveButtonPressed();
				} else if(alert.getResult() == ButtonType.NO){
					//reload the data from the database

				} else if(alert.getResult() == ButtonType.CANCEL){
					editToggleButton.setSelected(true);
				}
			}
			editToggleButton.setText("Edit");
			disableAllElements();
		}
	}

	/*printButtonPressed
	 * exports the data to a pdf and uses the system printer window to print the data
	 */
	public void printButtonPressed(){

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
	public void tableCellDoubleClicked(){
		Patient p = selectedPatient;
		
		String name = p.getLastName() + ", " + p.getFirstName();
		
		if(p.getMiddleName() != ""){
			name += ", " + p.getMiddleName();
		}
		nameField.setText(name);
		dobPicker.setValue(p.getDob());
		
		String gender;
		if(p.isMale()){
			gender = "Male";
		} else {
			gender = "Female";
		}
		genderCombo.setValue(gender);
		
		ssnField.setText(p.getSsn());
		bloodTypeCombo.setValue(p.getBloodType());
		phoneNumField.setText(p.getPhoneNum());
		emailField.setText(p.getEmail());
		
		EmergencyContact emer = p.getEmerContact();
		emerNameField.setText(emer.getName());
		emerPhoneField.setText(emer.getPhoneNum());
		emerEmailField.setText(emer.getEmail());
		emerRelationField.setText(emer.getRelation());
		
		Address a = p.getAddress();
		address1Field.setText(a.getAddress1());
		address2Field.setText(a.getAddress2());
		cityField.setText(a.getCity());
		statePicker.setValue(a.getState());
		zipField.setText(a.getZip());
		
		weightField.setText(p.getWeight());
		conditionArea.setText(p.getCondition());
		treatmentArea.setText(p.getTreatment());
		notesArea.setText(p.getNotes());
		
	}
}
=======
/*Class Name: PhysicianMainController
 *
 *The purpose of this class is to be the behind-the-scenes work behind the PhysicianMainView class.
 *
 */
/*To-Do:
 * For Treatments, instead of textArea, add ability to add medication, dosage, and doctor prescribed
 	* implies that a tableView of physicians is required
 * Fix TableView so that when you double click a row, the patient's data loads.
 */

package com.mentCare.controller;

import java.time.LocalDate;

import com.mentCare.model.Address;
import com.mentCare.model.EmergencyContact;
import com.mentCare.model.Patient;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
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
	@FXML private Button saveButton;
	@FXML private MenuButton optionsMenuButton;
	@FXML private Label patientNameLabel;
	@FXML private TextField searchField;
	@FXML private TextField cityField;

	private boolean unsavedChanges;
	private boolean newPatient;
	private ObservableList<Patient> patientList;
	private Patient selectedPatient;

	public void initialize() {
		patientList = FXCollections.observableArrayList();
		unsavedChanges = false;
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
		
		patientTableView.setRowFactory(tv -> {
			TableRow<Patient> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if(event.getClickCount() == 2 && (! row.isEmpty())){
					Patient rowData = row.getItem();
					//selectedPatient = rowData;
					tableCellDoubleClicked();
				}
			});
			return row;
		});
		
		//set up the columns in the table
		patientTableColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("displayName"));
		//static data, will replace with the database record later
		addStaticData();
		patientTableView.setItems(patientList);

		patientTableView.setEditable(false);
		patientTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());


	}
	/* this is used to take the data from the database and put the patient's name into the t

	/*addStaticData
	 * used to create a static list of patients
	 * mainly used for testing purposes
	 */
	public void addStaticData(){
		Patient josh = new Patient("Knight", "Joshua", "Matthew");
		josh.setAddress(new Address("82 College cir.", "Dahlonega", "GA", "30597"));
		josh.setBloodType("O+");
		josh.setCondition("Mentally Handicapped");
		josh.setEmail("jmknig0314@ung.edu");
		josh.setEmerContact(new EmergencyContact("Snuffy", "Joseph", "770-555-1234", "joe.snuffy@ung.edu"));
		josh.setHeight("69");
		josh.setNotes("None");
		josh.setOrganDonor(true);
		josh.setPassword("p@ssW0rd!");
		josh.setPhoneNum("706-201-9393");
		josh.setSsn("111-22-3333");
		josh.setTreatment("There is no hope for him");
		josh.setWeight("190");

		Patient joe = new Patient("Snuffy", "Joseph", "Mathis");
		joe.setAddress(new Address("82 College cir.", "Dahlonega", "GA", "30597"));
		joe.setBloodType("A-");
		joe.setCondition("Alzheimer's");
		joe.setEmail("joe.snuffy@ung.edu");
		joe.setEmerContact(new EmergencyContact("Knight", "Joshua", "706-201-9393", "jmknig0314@ung.edu"));
		joe.setHeight("72");
		joe.setNotes("uhhh. I can't remember.");
		joe.setOrganDonor(false);
		joe.setPassword("root");
		joe.setPhoneNum("770-555-1234");
		joe.setSsn("123-45-6789");
		joe.setTreatment("Alzheimer's pills 2/dy");
		joe.setWeight("175");

		patientList.add(josh);
		patientList.add(joe);
	}
	
	/* separateNames
	 * takes in a string as input. Separates the string up into 3 strings using a space
	 * as the separator.
	 */
	public String[] separateNames(String name) {
		return name.split(", ");
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
		cityField.setDisable(false);
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
		cityField.setDisable(true);
	}

	/*clearAllElements
	 * wipes the data in all of the input fields
	 */
	private void clearAllElements(){
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
		treatmentArea.setText("");
		notesArea.setText("");
		weightField.setText("");
		cityField.setText("");
	}

	/*promptSaveChanges
	 * used to create an alert on screen asking if the user would like to save changes
	 * usually used before changes are about to be discarded, in order to preserve data.
	 * returns an Alert to allow the calling method to handle the options
	 */
	public Alert promptSaveChanges() {
		Alert alert = new Alert(AlertType.CONFIRMATION, "Would you like to save your changes?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
		alert.showAndWait();

		if(alert.getResult() == ButtonType.YES){
			patientList.remove(selectedPatient);//remove the placeholder patient
			//initialize local variables used to assign input fields to
			String lastName, firstName, middleName;
			LocalDate dob;
			String gender, ssn, bloodType, feet, inches;
			boolean organDonor;
			String phoneNum, email, address1, address2, city, state, zip;
			String emerName, emerEmail, emerPhone, emerRelation, condition;
			String treatments, notes, weight;
			Address address;
			EmergencyContact emer;
			Patient p;
			int in, ft, height;
			
			String name = nameField.getText();//get name from the input field
			String[] sepNames = separateNames(name);
			//in case the name is not inserted as predicted, the program will not crash
			try {
				lastName = sepNames[0];
			} catch(ArrayIndexOutOfBoundsException e) {
				lastName = "";
			}
			try {	
				firstName = sepNames[1];
			} catch(ArrayIndexOutOfBoundsException e) {
				firstName = "";
			}
			try {
				middleName = sepNames[2];
			} catch(ArrayIndexOutOfBoundsException e){
				middleName = "";
			}
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
			address1 = address1Field.getText();
			address2 = address2Field.getText();
			city = cityField.getText();
			state = statePicker.getValue();
			zip = zipField.getText();
			emerName = emerNameField.getText();
			emerEmail = emerEmailField.getText();
			emerPhone = emerPhoneField.getText();
			emerRelation = emerRelationField.getText();
			condition = conditionArea.getText();
			treatments = treatmentArea.getText();
			notes = notesArea.getText();
			weight = weightField.getText();
			address = new Address(address1, address2, city, state, zip);
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
			p = new Patient(lastName, middleName, firstName, dob, isMale, email, "password", ssn, bloodType, phoneNum, address, heightString, weight, organDonor, emer, condition, treatments, notes);
			//add the new patient to the patientList
			patientList.add(p);
			
			newPatient = false;
		} else if(alert.getResult() == ButtonType.NO){
			
			newPatient = false;
		} else if(alert.getResult() == ButtonType.CANCEL){

		}

		newButton.setDisable(newPatient);
		
		return alert;
	}

	/*dataChanged()
	 * called when an input field is altered. Lets the system know that an unsaved change has been made
	 */
	public void dataChanged() {
		if(!unsavedChanges) {
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

	}

	//******************Button Actions**********************

	/*patientTableClicked
	 * ran when the user clicks on the Table.
	 * used to get the selected row in the table and change the selected patient.
	 */
	public void patientTableClicked(){
		selectedPatient = patientTableView.getSelectionModel().getSelectedItem();
	}
	
	
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
		Alert alert = new Alert(AlertType.CONFIRMATION, "Are you sure you want to delete this patient?", ButtonType.YES, ButtonType.CANCEL);
		alert.showAndWait();

		if(alert.getResult() == ButtonType.YES){
			//The Table Cell is deleted
			//The Input fields are cleared
		}
	}

	/*saveButtonPressed
	 * Executes when the button labeled "Save" is pressed
	 * the data is compared to that of the database and the database is updated
	 */
	public void saveButtonPressed(){
		//upload any changes to the database
		if(unsavedChanges) {
			unsavedChanges = false;
			String patientName = patientNameLabel.getText();
			patientName = patientName.substring(1);
			patientNameLabel.setText(patientName);
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
		if(editToggleButton.isSelected()){//If the button is toggled on
			editToggleButton.setText("Done");
			//enable the view elements
			enableAllElements();

		} else {//If the button is toggled off
			//ask user if they would like to save changes if any are present
			if(unsavedChanges) {
				Alert alert = promptSaveChanges();

				if(alert.getResult() == ButtonType.YES){
					//save the data
					saveButtonPressed();
				} else if(alert.getResult() == ButtonType.NO){
					//reload the data from the database

				} else if(alert.getResult() == ButtonType.CANCEL){
					editToggleButton.setSelected(true);
				}
			}
			editToggleButton.setText("Edit");
			disableAllElements();
		}
	}

	/*printButtonPressed
	 * exports the data to a pdf and uses the system printer window to print the data
	 */
	public void printButtonPressed(){

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
	public void tableCellDoubleClicked(){
		Patient p = selectedPatient;
		
		String name = p.getLastName() + ", " + p.getFirstName();
		
		if(p.getMiddleName() != ""){
			name += ", " + p.getMiddleName();
		}
		nameField.setText(name);
		dobPicker.setValue(p.getDob());
		
		String gender;
		if(p.isMale()){
			gender = "Male";
		} else {
			gender = "Female";
		}
		genderCombo.setValue(gender);
		
		ssnField.setText(p.getSsn());
		bloodTypeCombo.setValue(p.getBloodType());
		phoneNumField.setText(p.getPhoneNum());
		emailField.setText(p.getEmail());
		
		EmergencyContact emer = p.getEmerContact();
		emerNameField.setText(emer.getName());
		emerPhoneField.setText(emer.getPhoneNum());
		emerEmailField.setText(emer.getEmail());
		emerRelationField.setText(emer.getRelation());
		
		Address a = p.getAddress();
		address1Field.setText(a.getAddress1());
		address2Field.setText(a.getAddress2());
		cityField.setText(a.getCity());
		statePicker.setValue(a.getState());
		zipField.setText(a.getZip());
		
		weightField.setText(p.getWeight());
		conditionArea.setText(p.getCondition());
		treatmentArea.setText(p.getTreatment());
		notesArea.setText(p.getNotes());
		
	}
}
>>>>>>> c5e925cbd91d74fed3712e17fbf0062a9c100683
