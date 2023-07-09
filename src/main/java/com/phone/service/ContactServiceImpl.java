package com.phone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phone.entity.Contact;
import com.phone.repo.IContactRepo;

@Service
public class ContactServiceImpl implements ContactService
{
	@Autowired
	private IContactRepo contactRepo;

	@Override
	public String upsert(Contact contact) 
	{
		contact.setActiveSw("Y");//here we set the value for activeSw as "Y" so no need to provide this value form swagger-api.
		Contact save = contactRepo.save(contact);
		return "Contact Saved Sucessfully.";
	}

	@Override
	public List<Contact> getAllContact() 
	{
		return contactRepo.findAll();
	}

	@Override
	public Contact getContact(int id) 
	{
		Optional<Contact> optional = contactRepo.findById(id);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}

	@Override
	public String deleteContact(int id) 
	{
		//contactRepo.deleteById(id);//this will use for hard delete our contactd
		//below all code we will user for soft delete
		Optional<Contact> optional = contactRepo.findById(id);
		if(optional.isPresent())
		{
			Contact contact =  optional.get();
			contact.setActiveSw("N");
			contactRepo.save(contact);
		}
		return "Contact Deleted Successfully.";
	}
	
	
	
}
