package com.full.contact;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.full.model.Address;
import com.full.model.Category;
import com.full.model.Contact;
import com.full.model.ContactDetails;
import com.full.model.Name;
import com.full.model.PhoneDetail;

@SuppressWarnings("serial")
public class AddContactServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getMethod();
		if ("get".equalsIgnoreCase(method)) {
			doGet(request, response);
		} else {
			doPost(request, response);
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.sendRedirect("/html/add_contact.html");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Contact contact = convertParamsToMethod(req, resp);
		System.out.println(contact);
		resp.getWriter().print("Contact Added successfully");

	}

	private Contact convertParamsToMethod(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Contact contact = new Contact();
		Name name = new Name();
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		name.setFirstName(firstName);
		name.setLastName(lastName);
		contact.setName(name);
		ContactDetails contactDetails = new ContactDetails();
		PhoneDetail phoneDetail = new PhoneDetail();
		List<PhoneDetail> PhoneDetails = new ArrayList<>();
		try {
			long mobileNumber = Long.parseLong(req.getParameter("phoneNumber"));
			phoneDetail.setMobileNumber(mobileNumber);

		} catch (Exception e) {
			resp.getWriter().print("Please check your input!.Expected mobile number.");

		}
		String category = req.getParameter("category");
		phoneDetail.setCategory(Category.valueOf(category));
		PhoneDetails.add(phoneDetail);
		contactDetails.setPhoneNumbers(PhoneDetails);
		Address address = new Address();
		String street = req.getParameter("street");
		String state = req.getParameter("state");
		String city = req.getParameter("city");
		try{
		int zipCode = Integer.parseInt(req.getParameter("zipCode"));
		address.setZipCode(zipCode);
		}catch(Exception e)
		{
			resp.getWriter().print("Please check your input!.");

		}
		address.setStreet(street);
		address.setState(state);
		address.setCity(city);
		contact.setAddress(address);
		contact.setContactDetails(contactDetails);
		return contact;
	}
}
