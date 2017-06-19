package com.full.service;


import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Set;
import java.util.TreeMap;

//import com.full.application.ContactManagement;
import com.full.model.Address;

import com.full.model.Contact;
import com.full.model.ContactDetails;
import com.full.model.Name;
import com.full.model.PhoneDetail;

public class ContactManageService {
	private final Map<String, List<Contact>> contactsByFirstName = new TreeMap<>();


	public void addContact(Contact contact) {

		if (contactsByFirstName.containsKey(contact.getName().getFirstName())) {
			contactsByFirstName.get(contact.getName().getFirstName()).add(contact);
		} else {
			List<Contact> contacts = new LinkedList<>();
			contacts.add(contact);
			contactsByFirstName.put(contact.getName().getFirstName(), contacts);
		}
	}

	public boolean deleteContact(String firstName) {

		Contact contactToBeDeleted = searchSingleContact(firstName);
		boolean isDeleted = false;
		for (Entry<String, List<Contact>> contactEntry : contactsByFirstName.entrySet()) {
			if (contactEntry.getKey().startsWith(firstName)) {
				for (Contact contact : contactEntry.getValue()) {
					if (contact.equals(contactToBeDeleted)) {
						isDeleted = contactEntry.getValue().remove(contact);
					}

				}
			}
		}
		return isDeleted;

	}

	public Map<String, List<Contact>> readContacts() {

		return contactsByFirstName;

	}

	public boolean updateContact(String firstName) {

		return false;
	}

	public Contact searchContact(String firstName, long mobileNumber) {

		if (contactsByFirstName.containsKey(firstName)) {
			List<Contact> contacts = contactsByFirstName.get(firstName);

			for (Contact contact : contacts) {

				List<PhoneDetail> phoneNumbers = contact.getContactDetails().getPhoneNumbers();

				for (PhoneDetail phoneDetail : phoneNumbers) {
					if (phoneDetail.getMobileNumber() == mobileNumber) {
						return contact;
					}
				}

			}
		}
		return null;

	}

	public List<Contact> searchContact(String firstName) {

		List<Contact> contacts = new ArrayList<>();
		Set<Entry<String, List<Contact>>> contactsEntrySet = contactsByFirstName.entrySet();
		for (Entry<String, List<Contact>> contactEntry : contactsEntrySet) {
			if (contactEntry.getKey().startsWith(firstName)) {
				contacts.addAll(contactEntry.getValue());
			}
		}
		return contacts;

	}

	private Contact searchSingleContact(String firstName) {
		List<Contact> contacts = searchContact(firstName);

		for (int i = 0; i < contacts.size(); i++) {
			System.out.println((i + 1) + ") " + contacts.get(i).getContactDetails().getPhoneNumbers());
		}
		return null;

	}

	public Contact getContactFromUser() {
		Contact contact = new Contact();
		Name name = new Name();
		Address address = new Address();

		ContactDetails contactDetails = new ContactDetails();
		List<PhoneDetail> phoneDetails = getPhoneDetailsFromUser();
		contactDetails.setPhoneNumbers(phoneDetails);

		contact.setName(name);
		contact.setAddress(address);
		contact.setContactDetails(contactDetails);

		return contact;
	}

	private void deleteMobileNumber(long mobileNumber, Contact contact) {
		List<PhoneDetail> phoneDetails = contact.getContactDetails().getPhoneNumbers();

		for (PhoneDetail phoneDetail : phoneDetails) {
			if (phoneDetail.getMobileNumber() == mobileNumber) {
				phoneDetails.remove(phoneDetail);
			}
		}
	}

	private void updateMobileNumber(long oldMobileNumber, long newMobileNumber, Contact contact) {
		List<PhoneDetail> phoneDetails = contact.getContactDetails().getPhoneNumbers();

		for (PhoneDetail phoneDetail : phoneDetails) {
			if (phoneDetail.getMobileNumber() == oldMobileNumber) {
				phoneDetail.setMobileNumber(newMobileNumber);
			}
		}
	}

	private List<PhoneDetail> getPhoneDetailsFromUser() {
		List<PhoneDetail> phoneDetails = new LinkedList<>();
		boolean hasMoreNumber;

		return phoneDetails;
	}

}
