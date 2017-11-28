package org.brapi.test.BrAPITestServer.service;

import org.brapi.test.BrAPITestServer.model.entity.BaseEntity;
import org.brapi.test.BrAPITestServer.model.entity.ContactEntity;
import org.brapi.test.BrAPITestServer.model.rest.Contact;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

	public Contact convertFromEntity(ContactEntity e) {
		Contact contact = new Contact();
		contact.setContactDbId(e.getId());
		contact.setEmail(e.getEmail());
		contact.setInstituteName(e.getInstituteName());
		contact.setName(e.getName());
		contact.setOrcid(e.getOrcid());
		contact.setType(e.getType());
		return contact;
	}
}
