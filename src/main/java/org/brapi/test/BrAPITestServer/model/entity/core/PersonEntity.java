package org.brapi.test.BrAPITestServer.model.entity.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;

@Entity
@Table(name = "person")
public class PersonEntity extends BrAPIPrimaryEntity {
	@Column
	private String description;
	@Column
	private String emailAddress;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String mailingAddress;
	@Column
	private String middleName;
	@Column
	private String phoneNumber;
	@Column
	private String userID;
	@Column
	private String instituteName;

	public String getName() {
		String name = getFirstName();
		if(!getLastName().isEmpty()) 
			name = (name + " " + getLastName()).trim();
		
		return name;
	}
	public String getFullName() {
		String name = getFirstName();
		if(!getMiddleName().isEmpty()) 
			name = (name + " " + getMiddleName()).trim();
		if(!getLastName().isEmpty()) 
			name = (name + " " + getLastName()).trim();
		
		return name;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMailingAddress() {
		return mailingAddress;
	}

	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getInstituteName() {
		return instituteName;
	}
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

}