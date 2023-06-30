package org.brapi.test.BrAPITestServer.service;

import java.util.List;
import java.util.Optional;
import jakarta.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.PersonEntity;
import org.brapi.test.BrAPITestServer.repository.PeopleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import io.swagger.model.Person;
import io.swagger.model.Metadata;
import io.swagger.model.NewPersonRequest;

@Service
public class PeopleService {

	private PeopleRepository peopleRepository;

	public PeopleService(PeopleRepository peopleRepository) {
		this.peopleRepository = peopleRepository;
	}

	public List<Person> findPeople(@Valid String firstName, @Valid String lastName, @Valid String personDbId,
			@Valid String userID, Metadata metadata) {
		Pageable pageReq = PagingUtility.getPageRequest(metadata);
		Page<PersonEntity> entityPage;
		firstName = prepParam(firstName, true);
		lastName = prepParam(lastName, true);
		personDbId = prepParam(personDbId, false);
		userID = prepParam(userID, false);
		entityPage = peopleRepository.findBySearch(firstName, lastName, personDbId, userID, pageReq);

		List<Person> summaries = entityPage.map(this::convertFromEntity).getContent();
		PagingUtility.calculateMetaData(metadata, entityPage);

		return summaries;
	}

	private String prepParam(String param, boolean fuzzySearch) {
		if (param == null) {
			return "";
		} else {
			if (fuzzySearch) {
				return "%" + param + "%";
			} else {
				return param;
			}
		}
	}

	public Person getPerson(String personDbId) throws BrAPIServerException {
		PersonEntity entity;

		Optional<PersonEntity> entityOpt = peopleRepository.findById(personDbId);
		if (entityOpt.isPresent()) {
			entity = entityOpt.get();
		} else {
			throw new BrAPIServerException(HttpStatus.NOT_FOUND, "PersonDbId not found!");
		}

		return convertFromEntity(entity);
	}

	public Person updatePerson(String PeopleDbId, @Valid NewPersonRequest person) throws BrAPIServerException {
		PersonEntity savedEntity;
		Optional<PersonEntity> entityOpt = peopleRepository.findById(PeopleDbId);
		if (entityOpt.isPresent()) {
			PersonEntity entity = entityOpt.get();
			updateEntity(entity, person);

			savedEntity = peopleRepository.save(entity);
		} else {
			throw new BrAPIServerException(HttpStatus.NOT_FOUND, "PersonDbId not found!");
		}

		return convertFromEntity(savedEntity);
	}

	public Person saveNewPerson(@Valid NewPersonRequest person) {
		PersonEntity entity = new PersonEntity();
		updateEntity(entity, person);

		PersonEntity savedEntity = peopleRepository.save(entity);

		return convertFromEntity(savedEntity);
	}

	private Person convertFromEntity(PersonEntity entity) {
		Person person = new Person();

		person.setDescription(entity.getDescription());
		person.setEmailAddress(entity.getEmailAddress());
		person.setFirstName(entity.getFirstName());
		person.setLastName(entity.getLastName());
		person.setMailingAddress(entity.getMailingAddress());
		person.setMiddleName(entity.getMiddleName());
		person.setPersonDbId(entity.getId());
		person.setPhoneNumber(entity.getPhoneNumber());
		person.setUserID(entity.getUserID());

		return person;
	}

	private void updateEntity(PersonEntity entity, NewPersonRequest person) {
		if (person.getDescription() != null)
			entity.setDescription(person.getDescription());
		if (person.getEmailAddress() != null)
			entity.setEmailAddress(person.getEmailAddress());
		if (person.getFirstName() != null)
			entity.setFirstName(person.getFirstName());
		if (person.getLastName() != null)
			entity.setLastName(person.getLastName());
		if (person.getMailingAddress() != null)
			entity.setMailingAddress(person.getMailingAddress());
		if (person.getMiddleName() != null)
			entity.setMiddleName(person.getMiddleName());
		if (person.getPhoneNumber() != null)
			entity.setPhoneNumber(person.getPhoneNumber());
		if (person.getUserID() != null)
			entity.setUserID(person.getUserID());
	}

}
