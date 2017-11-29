package com.mentCare.model;

import java.time.LocalDate;

import com.mentCare.adapter.PatientAdapter;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Patient {
	//Declare variables
	private int id;
	private SimpleStringProperty displayName;
	private String name;
	private LocalDate dob;
	private String email;
	private String password;
	private String assignedPhysician;
	private int ssn;
	private String bloodType;
	private String phoneNum;
	private Address address;
	private String height, weight;
	private boolean organDonor;
	private EmergencyContact emerContact;
	private String condition, treatment, notes;
	private boolean isMale;

//******************Constructors******************************
	public Patient() {
		super();
		name = "";
		displayName = new SimpleStringProperty("Untitled Patient");
		email = "";
		password = "";
		ssn = 0;
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
	}

	public Patient(String name, LocalDate dob, boolean isMale, String email, String password, String ssn,
			String bloodType, String phoneNum, Address address, String height, String weight, boolean organDonor,
			EmergencyContact emerContact, String condition, String treatment, String notes) {
		this.name = name;
		this.displayName = new SimpleStringProperty(name);
		this.dob = dob;
		this.isMale = isMale;
		this.email = email;
		this.password = password;
		this.ssn = 0;
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

	public Patient(String name) {
		this.name = name;
		this.displayName = new SimpleStringProperty(name);
		email = "";
		password = "";
		ssn = 0;
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
	}

//*********************Getters*********************

	/**
	 * @return the lastName
	 */
	public String getName() {
		return name;
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
	public int getSsn() {
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

	/**
	 * @return the displayName itself
	 */
	public SimpleStringProperty displayNameProperty(){
		return displayName;
	}
	
	public String getTreatment() {
		return treatment;
	}

	public int getId() {
		return id;
	}

	public String getAssignedPhysician() {
		return assignedPhysician;
	}

	//*********************Setters*********************

	/**
	 * @param dob the dob to set
	 */
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setName(String name) {
		this.name = name;
		displayName = new SimpleStringProperty(name);
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
	public void setSsn(int ssn) {
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

	public void setTreatment(String treatment) {
		
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAssignedPhysician(String assignedPhysician) {
		this.assignedPhysician = assignedPhysician;
	}

	/*equals
	 * used to compare 2 patients to each other. Returns true if they are the exact same, false otherwise.
	 */

	public boolean equals(Patient newPatient) {
		boolean theSame = false;

		if(name.equals(newPatient.getName()) &&
		   address.equals(newPatient.getAddress()) &&
		   bloodType.equals(newPatient.getBloodType()) &&
		   condition.equals(newPatient.getCondition()) &&
		   email.equals(newPatient.getEmail()) &&
		   emerContact.equals(newPatient.getEmerContact()) &&
		   height.equals(newPatient.getHeight()) &&
		   notes.equals(newPatient.getNotes()) &&
		   isOrganDonor() == newPatient.isOrganDonor() &&
		   phoneNum.equals(newPatient.getPhoneNum()) &&
		   ssn == newPatient.getSsn() &&
		   weight.equals(newPatient.getWeight()) &&
		   dob.equals(newPatient.getDob()) &&
		   isMale() == newPatient.isMale()) {
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

		if(name.equalsIgnoreCase(newPatient.getName()) &&
				   address.equalsIgnoreCase(newPatient.getAddress()) &&
				   bloodType.equalsIgnoreCase(newPatient.getBloodType()) &&
				   condition.equalsIgnoreCase(newPatient.getCondition()) &&
				   email.equalsIgnoreCase(newPatient.getEmail()) &&
				   emerContact.equalsIgnoreCase(newPatient.getEmerContact()) &&
				   height.equalsIgnoreCase(newPatient.getHeight()) &&
				   notes.equalsIgnoreCase(newPatient.getNotes()) &&
				   isOrganDonor() == newPatient.isOrganDonor() &&
				   phoneNum.equalsIgnoreCase(newPatient.getPhoneNum()) &&
				   ssn == newPatient.getSsn() &&
				   weight.equalsIgnoreCase(newPatient.getWeight()) &&
				   dob.equals(newPatient.getDob()) &&
				   isMale() == newPatient.isMale()) {
			theSame = true;
		}

		return theSame;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Patient [name= " + name + ", dob="
				+ dob + ", email=" + email + ", ssn=" + ssn + ", bloodType=" + bloodType + ", phoneNum=" + phoneNum
				+ ", address=" + address + ", height=" + height + ", weight=" + weight + ", organDonor=" + organDonor
				+ ", emerContact=" + emerContact + ", condition=" + condition + ", treatment=" + treatment + ", notes=" + notes + ", isMale="
				+ isMale + "]";
	}


}
