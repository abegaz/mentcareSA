package com.mentCare.model;

public class Address {
	private String address, city, state, zip;
	
	public Address() {
		address = "";
		city = "";
		state = "";
		zip = "";
	}
	
	public Address(String address, String city, String state, String zip){
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	/**
	 * @return the address1
	 */
	public String getAddress() {
		return address;
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
	public void setAddress(String address) {
		this.address = address;
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
		
		if(address.equals(newAddress.getAddress()) &&
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
		
		if(address.equalsIgnoreCase(newAddress.getAddress()) &&
		   city.equalsIgnoreCase(newAddress.getCity()) &&
		   state.equalsIgnoreCase(newAddress.getState()) &&
		   zip.equalsIgnoreCase(newAddress.getZip())) {
			theSame = true;
		}
		
		return theSame;
	}
	
	public String toString() {
		String returnMe = address + " " + city + ", " + state + " " + zip;
		
		return returnMe;
	}
}
