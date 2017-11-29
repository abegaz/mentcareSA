package com.mentCare.model;

public class EmergencyContact {
	private String name, phoneNum, email, relation;

	public EmergencyContact() {
		name = "";
		phoneNum = "";
		email = "";
		relation = "";
	}
	
	public EmergencyContact(String name, String phoneNum, String email, String relation) {
		super();
		this.name = name;
		this.phoneNum = phoneNum;
		this.email = email;
		this.relation = relation;
	}

	/**
	 * @return the Name
	 */
	public String getName() {
		return name;
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
	
	public String getRelation(){
		return relation;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setName(String name) {
		this.name = name;
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
	
	public void setRelation(String relation){
		this.relation = relation;
	}
	
	/*equals
	 * used to compare 2 contacts to each other. Returns true if they are the exact same, false otherwise.
	 */
	public boolean equals(EmergencyContact newContact) {
		boolean theSame = false;
		
		if(name.equals(newContact.getName()) &&
		   phoneNum.equals(newContact.getPhoneNum()) &&
		   email.equals(newContact.getEmail()) && 
		   relation.equals(newContact.getRelation())) {
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
		
		if(name.equalsIgnoreCase(newContact.getName()) &&
		   phoneNum.equalsIgnoreCase(newContact.getPhoneNum()) &&
		   email.equalsIgnoreCase(newContact.getEmail()) &&
		   relation.equalsIgnoreCase(newContact.getRelation())) {
			theSame = true;
		}
		
		return theSame;
	}
	
}

