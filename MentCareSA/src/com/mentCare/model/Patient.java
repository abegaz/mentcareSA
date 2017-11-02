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
	
	/*equals
	 * used to compare 2 contacts to each other. Returns true if they are the exact same, false otherwise.
	 */
	public boolean equals(EmergencyContact newContact) {
		boolean theSame = false;
		
		if(firstName.equals(newContact.getFirstName()) &&
		   lastName.equals(newContact.getLastName()) &&
		   phoneNum.equals(newContact.getPhoneNum()) &&
		   email.equals(newContact.getEmail())) {
			theSame = true;
		}
		
		return theSame;
	}
	
	/*equalsIgnoreCase
	 * used to compare 2 contacts to each other. Returns true if they are the same (ignoring case), false otherwise
	 * "A".equalsIgnoreCase("a"); will return true
	 */
	
	public boolean equalsIgnoreCase(EmergencyContact newContact) {
		boolean theSame = false;
		
		if(firstName.equalsIgnoreCase(newContact.getFirstName()) &&
		   lastName.equalsIgnoreCase(newContact.getLastName()) &&
		   phoneNum.equalsIgnoreCase(newContact.getPhoneNum()) &&
		   email.equalsIgnoreCase(newContact.getEmail())) {
			theSame = true;
		}
		
		return theSame;
	}
	
}
