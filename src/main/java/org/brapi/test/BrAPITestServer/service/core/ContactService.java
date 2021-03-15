package org.brapi.test.BrAPITestServer.service.core;

import java.util.Optional;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.core.ContactEntity;
import org.brapi.test.BrAPITestServer.repository.core.ContactRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.core.Contact;

@Service
public class ContactService {
	
	private final ContactRepository contactRepository;
	
	public ContactService(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}

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

	public ContactEntity getContactEntity(String contactDbId) throws BrAPIServerException {
		ContactEntity entity = null;

		Optional<ContactEntity> entityOpt = contactRepository.findById(contactDbId);
		if (entityOpt.isPresent()) {
			entity = entityOpt.get();
		} else {
			throw new BrAPIServerException(HttpStatus.BAD_REQUEST, "contactDbId not found: " + contactDbId);
		}

		return entity;
	}
}
