package com.mentCare.model;

public class Address {
	private String address1, address2, city, state, zip;
	
	public Address() {
		address1 = "";
		address2 = "";
		city = "";
		state = "";
		zip = "";
	}
	
	public Address(String address, String city, String state, String zip){
		this.address1 = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	public Address(String address, String address2, String city, String state, String zip) {
		this.address1 = address;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	/*equals
	 * used to compare 2 addresses to each other. Returns true if they are the exact same, false otherwise.
	 */
	
	public boolean equals(Address newAddress) {
		boolean theSame = false;
		
		if(address1.equals(newAddress.getAddress1()) &&
		   address2.equals(newAddress.getAddress2()) &&
		   city.equals(newAddress.getCity()) &&
		   state.equals(newAddress.getState()) &&
		   zip.equals(newAddress.getZip())) {
			theSame = true;
		}
		
		return theSame;
	}
	
	/*equalsIgnoreCase
	 * used to compare 2 addresses to each other. Returns true if they are the same (ignoring case), false otherwise
	 * "A".equalsIgnoreCase("a"); will return true
	 */
	
	public boolean equalsIgnoreCase(Address newAddress) {
		boolean theSame = false;
		
		if(address1.equalsIgnoreCase(newAddress.getAddress1()) &&
		   address2.equalsIgnoreCase(newAddress.getAddress2()) &&
		   city.equalsIgnoreCase(newAddress.getCity()) &&
		   state.equalsIgnoreCase(newAddress.getState()) &&
		   zip.equalsIgnoreCase(newAddress.getZip())) {
			theSame = true;
		}
		
		return theSame;
	}
	
	public String toString() {
		String returnMe = address1;
		
		if(address2 != null) {
			returnMe += " " + address2;
		}
		
		returnMe += " " + city + ", " + state + " " + zip;
		
		return returnMe;
	}
}
