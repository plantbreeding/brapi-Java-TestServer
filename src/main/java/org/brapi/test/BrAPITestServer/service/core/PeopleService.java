package org.brapi.test.BrAPITestServer.service.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerDbIdNotFoundException;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.core.PersonEntity;
import org.brapi.test.BrAPITestServer.repository.core.PeopleRepository;
import org.brapi.test.BrAPITestServer.service.PagingUtility;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.swagger.model.Metadata;
import io.swagger.model.core.Contact;
import io.swagger.model.core.Person;
import io.swagger.model.core.PersonNewRequest;
import io.swagger.model.core.PersonSearchRequest;

@Service
public class PeopleService {

	private PeopleRepository peopleRepository;

	public PeopleService(PeopleRepository peopleRepository) {
		this.peopleRepository = peopleRepository;
	}

	public List<Person> findPeople(String firstName, String lastName, String personDbId, String userID,
			String commonCropName, String programDbId, String externalReferenceId, String externalReferenceID,
			String externalReferenceSource, Metadata metadata) {

		PersonSearchRequest request = new PersonSearchRequest();
		if (firstName != null)
			request.addFirstNamesItem(firstName);
		if (lastName != null)
			request.addLastNamesItem(lastName);
		if (personDbId != null)
			request.addPersonDbIdsItem(personDbId);
		if (userID != null)
			request.addUserIDsItem(userID);
		if (commonCropName != null)
			request.addCommonCropNamesItem(commonCropName);
		if (programDbId != null)
			request.addProgramDbIdsItem(programDbId);

		request.addExternalReferenceItem(externalReferenceId, externalReferenceID, externalReferenceSource);
		return findPeople(request, metadata);
	}

	public List<Person> findPeople(PersonSearchRequest request, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		SearchQueryBuilder<PersonEntity> searchQuery = new SearchQueryBuilder<PersonEntity>(PersonEntity.class)
				.withExRefs(request.getExternalReferenceIDs(), request.getExternalReferenceSources())
				.appendList(request.getEmailAddresses(), "emailAddress")
				.appendList(request.getFirstNames(), "firstName").appendList(request.getLastNames(), "lastName")
				.appendList(request.getMailingAddresses(), "mailingAddress")
				.appendList(request.getMiddleNames(), "middleName").appendList(request.getPersonDbIds(), "id")
				.appendList(request.getPhoneNumbers(), "phoneNumber").appendList(request.getUserIDs(), "userID");

		Page<PersonEntity> entityPage = peopleRepository.findAllBySearch(searchQuery, pageReq);

		List<Person> data = entityPage.map(this::convertToPerson).getContent();
		PagingUtility.calculateMetaData(metadata, entityPage);

		return data;
	}

	public Person getPerson(String personDbId) throws BrAPIServerException {
		return convertToPerson(getPersonEntity(personDbId, HttpStatus.NOT_FOUND));
	}

	public PersonEntity getPersonEntity(String personDbId) throws BrAPIServerException {
		return getPersonEntity(personDbId, HttpStatus.BAD_REQUEST);
	}

	public PersonEntity getPersonEntity(String personDbId, HttpStatus errorStatus) throws BrAPIServerException {
		PersonEntity entity = null;

		if (personDbId != null) {
			Optional<PersonEntity> entityOpt = peopleRepository.findById(personDbId);
			if (entityOpt.isPresent()) {
				entity = entityOpt.get();
			} else {
				throw new BrAPIServerDbIdNotFoundException("person", personDbId, errorStatus);
			}
		}

		return entity;
	}

	public Person updatePerson(String personDbId, PersonNewRequest person) throws BrAPIServerException {
		PersonEntity entity = getPersonEntity(personDbId, HttpStatus.NOT_FOUND);
		updateEntity(entity, person);
		PersonEntity savedEntity = peopleRepository.save(entity);

		return convertToPerson(savedEntity);
	}

	public List<Person> savePeople(List<PersonNewRequest> body) {
		List<Person> savedPeople = new ArrayList<>();

		for (PersonNewRequest person : body) {
			PersonEntity entity = new PersonEntity();
			updateEntity(entity, person);

			PersonEntity savedEntity = peopleRepository.save(entity);

			savedPeople.add(convertToPerson(savedEntity));
		}

		return savedPeople;
	}

	public PersonEntity saveContact(Contact contact) {
		PersonEntity entity = new PersonEntity();

		entity.setEmailAddress(contact.getEmail());
		entity.setInstituteName(contact.getInstituteName());
		parseName(contact.getName(), entity);
		entity.setUserID(contact.getOrcid());
		entity.setDescription(contact.getType());

		PersonEntity savedEntity = peopleRepository.save(entity);
		return savedEntity;
	}

	private void parseName(String name, PersonEntity entity) {
		if (name != null && !name.isEmpty()) {
			entity.setFirstName("");
			entity.setMiddleName("");
			entity.setLastName("");

			String[] splitName = name.split(" ");

			if (splitName.length >= 1) {
				entity.setFirstName(splitName[0]);

				if (splitName.length >= 2) {
					entity.setLastName(splitName[splitName.length - 1]);

					if (splitName.length >= 3) {
						String middle = name.substring(name.indexOf(" ") + 1, name.lastIndexOf(" "));
						entity.setMiddleName(middle);
					}
				}
			}
		}
	}

	private Person convertToPerson(PersonEntity entity) {
		Person person = new Person();

		person.setAdditionalInfo(entity.getAdditionalInfo());
		person.setDescription(entity.getDescription());
		person.setEmailAddress(entity.getEmailAddress());
		person.setExternalReferences(entity.getExternalReferencesMap());
		person.setFirstName(entity.getFirstName());
		person.setLastName(entity.getLastName());
		person.setMailingAddress(entity.getMailingAddress());
		person.setMiddleName(entity.getMiddleName());
		person.setPersonDbId(entity.getId());
		person.setPhoneNumber(entity.getPhoneNumber());
		person.setUserID(entity.getUserID());

		return person;
	}

	public Contact convertToContact(PersonEntity entity) {
		Contact contact = new Contact();

		contact.setContactDbId(entity.getId());
		contact.setEmail(entity.getEmailAddress());
		contact.setInstituteName(entity.getInstituteName());
		contact.setName(entity.getFullName());
		contact.setOrcid(entity.getUserID());
		contact.setType(entity.getDescription());

		return contact;
	}

	private void updateEntity(PersonEntity entity, PersonNewRequest request) {
		if (request.getAdditionalInfo() != null)
			entity.setAdditionalInfo(request.getAdditionalInfo());
		if (request.getDescription() != null)
			entity.setDescription(request.getDescription());
		if (request.getEmailAddress() != null)
			entity.setEmailAddress(request.getEmailAddress());
		if (request.getExternalReferences() != null)
			entity.setExternalReferences(request.getExternalReferences());
		if (request.getFirstName() != null)
			entity.setFirstName(request.getFirstName());
		if (request.getLastName() != null)
			entity.setLastName(request.getLastName());
		if (request.getMailingAddress() != null)
			entity.setMailingAddress(request.getMailingAddress());
		if (request.getMiddleName() != null)
			entity.setMiddleName(request.getMiddleName());
		if (request.getPhoneNumber() != null)
			entity.setPhoneNumber(request.getPhoneNumber());
		if (request.getUserID() != null)
			entity.setUserID(request.getUserID());
	}

}
