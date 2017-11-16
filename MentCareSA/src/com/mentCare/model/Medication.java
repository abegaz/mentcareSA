package com.mentCare.model;

public class Medication {
	private String rxNum, medicationName, drPrescribed, dosage, medDate;

	public Medication() {
		rxNum = "";
		medicationName = "";
		drPrescribed = "";
		dosage = "";
		medDate = "";
	}

	/**
	 * @return the rxNum
	 */
	public String getRxNum() {
		return rxNum;
	}

	/**
	 * @return the medicationName
	 */
	public String getMedicationName() {
		return medicationName;
	}

	/**
	 * @return the drPrescribed
	 */
	public String getDrPrescribed() {
		return drPrescribed;
	}

	/**
	 * @return the dosage
	 */
	public String getDosage() {
		return dosage;
	}

	/**
	 * @return the medDate
	 */
	public String getMedDate() {
		return medDate;
	}

	/**
	 * @param rxNum the rxNum to set
	 */
	public void setRxNum(String rxNum) {
		this.rxNum = rxNum;
	}

	/**
	 * @param medicationName the medicationName to set
	 */
	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}

	/**
	 * @param drPrescribed the drPrescribed to set
	 */
	public void setDrPrescribed(String drPrescribed) {
		this.drPrescribed = drPrescribed;
	}

	/**
	 * @param dosage the dosage to set
	 */
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	/**
	 * @param medDate the medDate to set
	 */
	public void setMedDate(String medDate) {
		this.medDate = medDate;
	}
	
	public boolean equals(Medication input) {
		if(this.getRxNum().equals(input.getRxNum()) &&
				this.getMedicationName().equals(input.getMedicationName()) &&
				this.getDrPrescribed().equals(input.getDrPrescribed()) &&
				this.getMedDate().equals(input.getMedDate())) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean equalsIgnoreCase(Medication input) {
		if(this.getRxNum().equalsIgnoreCase(input.getRxNum()) &&
				this.getMedicationName().equalsIgnoreCase(input.getMedicationName()) &&
				this.getDrPrescribed().equalsIgnoreCase(input.getDrPrescribed()) &&
				this.getMedDate().equalsIgnoreCase(input.getMedDate())) {
			return true;
		} else {
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Medication [rxNum=" + rxNum + ", medicationName=" + medicationName + ", drPrescribed=" + drPrescribed
				+ ", dosage=" + dosage + ", medDate=" + medDate + "]";
	}
	
	
}
