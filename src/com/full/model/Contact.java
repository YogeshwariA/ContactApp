package com.full.model;

import java.util.Date;

public class Contact {

	private Name name;
	private String email;
	private ContactDetails contactDetails;
	private Date birthDay;
	private Address address;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		String contactsDetails = "";
		if (name != null) {
			contactsDetails += name;
		}
		if (email != null) {
			contactsDetails += " Email Id: " + email;
		}
		if (contactDetails != null) {
			contactsDetails += contactDetails;
		}
		if (birthDay != null) {
			contactsDetails += " Date of birth: " + birthDay;
		}
		if (address != null) {
			contactsDetails += address;
		}
		return contactsDetails;
	}
}
