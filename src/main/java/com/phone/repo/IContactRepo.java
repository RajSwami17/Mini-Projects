package com.phone.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.phone.entity.Contact;

public interface IContactRepo extends JpaRepository<Contact, Integer>
{
	

}
