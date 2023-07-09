package com.phone.service;

import java.util.List;

import com.phone.entity.Contact;

public interface ContactService 
{

	String upsert(Contact contact);
	
	List<Contact> getAllContact();
	
	Contact getContact(int id);
	
	String deleteContact(int id);
}
