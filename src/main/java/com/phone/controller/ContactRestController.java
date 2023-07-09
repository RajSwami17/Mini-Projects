package com.phone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.phone.entity.Contact;
import com.phone.service.ContactService;

@RestController
public class ContactRestController 
{

	@Autowired
	private ContactService contactService;
	
	
	@PostMapping("/contact")
	ResponseEntity<String> contact(@RequestBody Contact contact)
	{
		String status = contactService.upsert(contact);//to update and save - upsert
		return new ResponseEntity<>(status,HttpStatus.CREATED);//201
	}
	
	@GetMapping("/contacts")
	ResponseEntity<List<Contact>> getAllContacts() 
	{ 
		List<Contact> allContacts = contactService.getAllContact();
		return new ResponseEntity<>(allContacts,HttpStatus.OK);
	}
	
	@GetMapping("/contact/{id}")
	ResponseEntity<Contact> getContact(@PathVariable int id)
	{
		Contact contact = contactService.getContact(id);
		return new ResponseEntity<>(contact,HttpStatus.OK);
	}
	@DeleteMapping("/contact/{id}")
	ResponseEntity<String> deleteContact(@PathVariable int id)
	{
		String delete = contactService.deleteContact(id);
		return new ResponseEntity<>(delete,HttpStatus.OK);
	}
	
}
 