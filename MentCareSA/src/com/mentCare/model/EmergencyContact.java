package com.mentCare.model;

public class EmergencyContact {
	private String lastName, firstName, phoneNum, email;

	public EmergencyContact() {
		lastName = "";
		firstName = "";
		phoneNum = "";
		email = "";
	}
	
	public EmergencyContact(String lastName, String firstName, String phoneNum, String email) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.phoneNum = phoneNum;
		this.email = email;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the phoneNum
	 */
	public String getPhoneNum() {
		return phoneNum;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param phoneNum the phoneNum to set
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
