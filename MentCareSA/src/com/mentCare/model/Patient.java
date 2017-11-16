package com.mentCare.model;

import java.time.LocalDate;

import com.mentCare.adapter.PatientAdapter;

import javafx.beans.property.SimpleStringProperty;

public class Patient {
	//Declare variables
	private SimpleStringProperty displayName;
	private String lastName, middleName, firstName;
	private LocalDate dob;
	private String email;
	private String password;
	private String ssn;
	private String bloodType;
	private String phoneNum;
	private Address address;
	private String height, weight;
	private boolean organDonor;
	private EmergencyContact emerContact;
	private String condition, treatment, notes;
	private boolean isMale;
	private PatientAdapter adapter;

//******************Constructors******************************
	public Patient() {
		super();
		lastName = "";
		middleName = "";
		firstName = "";
		displayName = new SimpleStringProperty("Untitled Patient");
		email = "";
		password = "";
		ssn = "";
		bloodType = "";
		phoneNum = "";
		address = new Address();
		height = "";
		weight = "";
		organDonor = false;
		emerContact = new EmergencyContact();
		condition = "";
		treatment = "";
		notes = "";
		isMale = true;
		adapter = new PatientAdapter(this);
	}

	public Patient(String lastName, String middleName, String firstName, LocalDate dob, boolean isMale, String email, String password, String ssn,
			String bloodType, String phoneNum, Address address, String height, String weight, boolean organDonor,
			EmergencyContact emerContact, String condition, String treatment, String notes) {
		this.lastName = lastName;
		this.middleName = middleName;
		this.firstName = firstName;
		this.displayName = new SimpleStringProperty(lastName + ", " + firstName);
		this.dob = dob;
		this.isMale = isMale;
		this.email = email;
		this.password = password;
		this.ssn = ssn;
		this.bloodType = bloodType;
		this.phoneNum = phoneNum;
		this.address = address;
		this.height = height;
		this.weight = weight;
		this.organDonor = organDonor;
		this.emerContact = emerContact;
		this.condition = condition;
		this.treatment = treatment;
		this.notes = notes;
	}

	public Patient(String lastName, String firstName, String middleName) {
		this.lastName = lastName;
		this.middleName = middleName;
		this.firstName = firstName;
		this.displayName = new SimpleStringProperty(lastName + ", " + firstName);
	}

//*********************Getters*********************

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the displayName
	 */
	public String getDisplayName(){
		return displayName.get();
	}

	public LocalDate getDob() {
		return dob;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the ssn
	 */
	public String getSsn() {
		return ssn;
	}

	/**
	 * @return the bloodType
	 */
	public String getBloodType() {
		return bloodType;
	}

	/**
	 * @return the phoneNum
	 */
	public String getPhoneNum() {
		return phoneNum;
	}

	/**
	 * @return the height
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * @return the weight
	 */
	public String getWeight() {
		return weight;
	}

	/**
	 * @return the organDonor
	 */
	public boolean isOrganDonor() {
		return organDonor;
	}

	/**
	 * @return the condition
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * @return the treatment
	 */
	public String getTreatment() {
		return treatment;
	}

	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @return the emerContact
	 */
	public EmergencyContact getEmerContact() {
		return emerContact;
	}

	public boolean isMale() {
		return isMale;
	}

	public String getFullName(){
		return getFirstName() + " " + getMiddleName() + " " + getLastName();
	}

	/**
	 * @return the displayName itself
	 */
	public SimpleStringProperty displayNameProperty(){
		return displayName;
	}

	public PatientAdapter getAdapter(){
		return adapter;
	}

	//*********************Setters*********************

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param ssn the ssn to set
	 */
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	/**
	 * @param bloodType the bloodType to set
	 */
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	/**
	 * @param phoneNum the phoneNum to set
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}

	/**
	 * @param organDonor the organDonor to set
	 */
	public void setOrganDonor(boolean organDonor) {
		this.organDonor = organDonor;
	}

	/**
	 * @param condition the condition to set
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}

	/**
	 * @param treatment the treatment to set
	 */
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @param emerContact the emerContact to set
	 */
	public void setEmerContact(EmergencyContact emerContact) {
		this.emerContact = emerContact;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	/*equals
	 * used to compare 2 patients to each other. Returns true if they are the exact same, false otherwise.
	 */

	public boolean equals(Patient newPatient) {
		boolean theSame = false;

		if(lastName.equals(newPatient.getLastName()) &&
		   middleName.equals(newPatient.getMiddleName()) &&
		   lastName.equals(newPatient.getLastName()) &&
		   address.equals(newPatient.getAddress()) &&
		   bloodType.equals(newPatient.getBloodType()) &&
		   condition.equals(newPatient.getCondition()) &&
		   email.equals(newPatient.getEmail()) &&
		   emerContact.equals(newPatient.getEmerContact()) &&
		   height.equals(newPatient.getHeight()) &&
		   notes.equals(newPatient.getNotes()) &&
		   isOrganDonor() == newPatient.isOrganDonor() &&
		   phoneNum.equals(newPatient.getPhoneNum()) &&
		   ssn.equals(newPatient.getSsn()) &&
		   treatment.equals(newPatient.getTreatment()) &&
		   weight.equals(newPatient.getWeight())) {
			theSame = true;
		}

		return theSame;
	}

	/*equalsIgnoreCase
	 * used to compare 2 contacts to each other. Returns true if they are the same (ignoring case), false otherwise
	 * "A".equalsIgnoreCase("a"); will return true
	 */

	public boolean equalsIgnoreCase(Patient newPatient) {
		boolean theSame = false;

		if(lastName.equalsIgnoreCase(newPatient.getLastName()) &&
		   middleName.equalsIgnoreCase(newPatient.getMiddleName()) &&
		   lastName.equalsIgnoreCase(newPatient.getLastName()) &&
		   address.equalsIgnoreCase(newPatient.getAddress()) &&
		   bloodType.equalsIgnoreCase(newPatient.getBloodType()) &&
		   condition.equalsIgnoreCase(newPatient.getCondition()) &&
		   email.equalsIgnoreCase(newPatient.getEmail()) &&
		   emerContact.equalsIgnoreCase(newPatient.getEmerContact()) &&
		   height.equalsIgnoreCase(newPatient.getHeight()) &&
		   notes.equalsIgnoreCase(newPatient.getNotes()) &&
		   isOrganDonor() == newPatient.isOrganDonor() &&
		   phoneNum.equalsIgnoreCase(newPatient.getPhoneNum()) &&
		   ssn.equalsIgnoreCase(newPatient.getSsn()) &&
		   treatment.equalsIgnoreCase(newPatient.getTreatment()) &&
		   weight.equalsIgnoreCase(newPatient.getWeight())) {
			theSame = true;
		}

		return theSame;
	}

	public String toString() {
		return "Patient [lastName=" + lastName + ", MiddleName=" + middleName + ", firstName=" + firstName + ", email="
				+ email + ", password=" + password + ", ssn=" + ssn + ", bloodType=" + bloodType + ", phoneNum="
				+ phoneNum + ", address=" + address + ", height=" + height + ", weight=" + weight + ", organDonor="
				+ organDonor + ", emerContact=" + emerContact + ", condition=" + condition + ", treatment=" + treatment
				+ ", notes=" + notes + "]";
	}


}
