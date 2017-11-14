/*Class Name: PatientAdapter
 * 
 * Version: 00.01
 * Recent Changes:
 * 
 * Description:
 * This class provides a way for the user to communicate with the SQL database.
 */

package com.mentCare.adapter;

import java.time.LocalDate;

import com.mentCare.model.Patient;

public class PatientAdapter {
	private Patient adaptee;
	private String query;
	
	public PatientAdapter(){
		adaptee = null;
		query = "";
	}
	
	public PatientAdapter(Patient adaptee) {
		this.adaptee = adaptee;
	}
	
	public Patient getPatient() {
		return adaptee;
	}
	
	public void setPatient(Patient adaptee) {
		this.adaptee = adaptee;
	}
	
	public String getFullNameQuery() {
		String fullName = adaptee.getFullName();
		query = "";
		return query;
	}
	
	public String getLastNameQuery() {
		String lastName = adaptee.getLastName();
		query = "";
		return query;
	}
	
	public String getFirstNameQuery() {
		String firstName = adaptee.getFirstName();
		query = "";
		return query;
	}
	
	public String getMiddleNameQuery() {
		String middleName = adaptee.getMiddleName();
		query = "";
		return query;
	}
	
	public String getDobQuery() {
		LocalDate dob = adaptee.getDob();
		query = "";
		return query;
	}
	
	public String getEmailQuery() {
		String email = adaptee.getEmail();
		query = "";
		return query;
	}
	
	public String getPhoneNumQuery() {
		String phoneNum = adaptee.getPhoneNum();
		query = "";
		return query;
	}
	
	public String getPasswordQuery() {
		String pass = adaptee.getPassword();
		query = "";
		return query;
	}
	
	public String getSSNQuery() {
		String ssn = adaptee.getSsn();
		query = "";
		return query;
	}
	
	public String getBloodType() {
		String bloodType = adaptee.getBloodType();
		query = "";
		return query;
	}
	
	public String getAddressLine1() {
		String address1 = adaptee.getAddress().getAddress1();
		query = "";
		return query;
	}
}
