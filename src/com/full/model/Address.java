package com.full.model;

public class Address {
	private String street;
	private String postBox;
	private String neighborhood;
	private String city;
	private String state;
	private int zipCode;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostBox() {
		return postBox;
	}

	public void setPostBox(String postBox) {
		this.postBox = postBox;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		String address = "";
		if (street != null) {
			address += " Street: " + street;
		}
		if (city != null) {
			address += " City: " + city;
		}
		if (state != null) {
			address += " State: " + state;
		}
		if (zipCode != 0) {
			address += " ZipCode: " + zipCode;
		}
		return address;
	}

}
