package com.mentCare.model;

public class Patient {
	//Declare variables
	private String lastName, middleName, firstName;
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
	
	//******************Constructors******************************
	public Patient() {
		super();
		lastName = "";
		middleName = "";
		firstName = "";
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
	}
	
	public Patient(String lastName, String middleName, String firstName, String email, String password, String ssn,
			String bloodType, String phoneNum, Address address, String height, String weight, boolean organDonor,
			EmergencyContact emerContact, String condition, String treatment, String notes) {
		this.lastName = lastName;
		this.middleName = middleName;
		this.firstName = firstName;
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

	public String toString() {
		return "Patient [lastName=" + lastName + ", MiddleName=" + middleName + ", firstName=" + firstName + ", email="
				+ email + ", password=" + password + ", ssn=" + ssn + ", bloodType=" + bloodType + ", phoneNum="
				+ phoneNum + ", address=" + address + ", height=" + height + ", weight=" + weight + ", organDonor="
				+ organDonor + ", emerContact=" + emerContact + ", condition=" + condition + ", treatment=" + treatment
				+ ", notes=" + notes + "]";
	}
	
	
}
