package com.phone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Contact_Info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact 
{
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="Name")
	private String name; 
	
	@Column(name="Email")
	private String email;
	
	@Column(name="Contact_Number")
	private long phoneno;
	
	@Column(name="Status")
	private String activeSw;

}
