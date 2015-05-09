package com.jmsapp.JmsApplication.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="idUser", unique=true, nullable=false)
	private int idUser;
	
	@Column(name = "firstname", unique = true, nullable = false, length = 50)
	private String firstname;
	
	@Column(name = "lastname", unique = true, nullable = false, length = 50)
	private String lastname;
	
	@Column(name = "email", unique = true, nullable = false, length = 50)
	private String email;

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
