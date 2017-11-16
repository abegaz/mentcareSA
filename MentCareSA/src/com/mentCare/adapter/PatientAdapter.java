/*Class Name: PatientAdapter
 *
 * Version: 00.01
 * Recent Changes:
 *
 * Description:
 * This class provides a way for the user to communicate with the SQL database.
 * The get methods return the SQL code required to SELECT data from the database
 * The set methods return the SQL code required to INSERT data into the database
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

	public String setFullNameQuery() {
		String fullName = adaptee.getFullName();
		query = "";
		return query;
	}

	public String setLastNameQuery() {
		String lastName = adaptee.getLastName();
		query = "";
		return query;
	}

	public String setFirstNameQuery() {
		String firstName = adaptee.getFirstName();
		query = "";
		return query;
	}

	public String setMiddleNameQuery() {
		String middleName = adaptee.getMiddleName();
		query = "";
		return query;
	}

	public String setDobQuery() {
		LocalDate dob = adaptee.getDob();
		query = "";
		return query;
	}

	public String setEmailQuery() {
		String email = adaptee.getEmail();
		query = "";
		return query;
	}

	public String setPhoneNumQuery() {
		String phoneNum = adaptee.getPhoneNum();
		query = "";
		return query;
	}

	public String setPasswordQuery() {
		String pass = adaptee.getPassword();
		query = "";
		return query;
	}

	public String setSSNQuery() {
		String ssn = adaptee.getSsn();
		query = "";
		return query;
	}

	public String setBloodType() {
		String bloodType = adaptee.getBloodType();
		query = "";
		return query;
	}

	public String setAddressLine1() {
		String address1 = adaptee.getAddress().getAddress1();
		query = "";
		return query;
	}

	public String setAddressLine2() {
		String address2 = adaptee.getAddress().getAddress2();
		query = "";
		return query;
	}

	public String setAddressCity() {
		String city = adaptee.getAddress().getCity();
		query = "";
		return query;
	}

	public String setAddressState() {
		String state = adaptee.getAddress().getState();
		query = "";
		return query;
	}

	public String setAddressZip() {
		String zip = adaptee.getAddress().getZip();
		query = "";
		return query;
	}

	public String setHeightQuery() {
		String height = adaptee.getHeight();
		query = "";
		return query;
	}

	public String setWeightQuery() {
		String weight = adaptee.getWeight();
		query = "";
		return query;
	}

	public String setOrganDonorQuery() {
		String organDonor;

		if(adaptee.isOrganDonor()) {
			organDonor = "Yes";
		} else {
			organDonor = "No";
		}

		query = "";
		return query;
	}

	public String setEmerContactName() {
		String name = adaptee.getEmerContact().getName();
		query = "";
		return query;
	}

	public String setEmerContactPhone() {
		String phone = adaptee.getEmerContact().getPhoneNum();
		query = "";
		return query;
	}

	public String setEmerContactEmail() {
		String email = adaptee.getEmerContact().getEmail();
		query = "";
		return query;
	}

	public String setEmerContactRelation() {
		String relation = adaptee.getEmerContact().getRelation();
		query = "";
		return query;
	}

	public String setTreatmentQuery() {
		String treatment = adaptee.getTreatment();
		query = "";
		return query;
	}

	public String setConditionQuery() {
		String condition = adaptee.getCondition();
		query = "";
		return query;
	}

	public String setNotesQuery() {
		String notes = adaptee.getNotes();
		query = "";
		return query;
	}

	public String setGenderQuery() {
		String gender;

		if(adaptee.isMale()) {
			gender = "Male";
		} else {
			gender = "Female";
		}

		query = "";
		return query;
	}
}