package org.brapi.test.BrAPITestServer.controller.old;

import java.util.List;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.api.PeopleApi;
import io.swagger.model.Metadata;
import io.swagger.model.NewPersonRequest;
import io.swagger.model.Person;
import io.swagger.model.PersonResponse;
import io.swagger.model.PersonsResponse;
import io.swagger.model.PersonsResponseResult;

@RestController
public class PeopleController extends BrAPIController implements PeopleApi {

	PeopleService peopleService;
	
	@Autowired
	public PeopleController(PeopleService peopleService) {
		this.peopleService = peopleService;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<PersonsResponse> peopleGet(@Valid String firstName, @Valid String lastName,
			@Valid String personDbId, @Valid String userID, @Valid Integer page, @Valid Integer pageSize,
			String authorization) throws BrAPIServerException {
		Metadata metadata = generateMetaDataTemplate(page, pageSize);

		List<Person> data = peopleService.findPeople(firstName, lastName, personDbId, userID, metadata);

		PersonsResponseResult result = new PersonsResponseResult();
		result.setData(data);
		PersonsResponse response = new PersonsResponse();
		response.setMetadata(metadata);
		response.setResult(result);
		return new ResponseEntity<PersonsResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<PersonResponse> peoplePersonDbIdGet(@PathVariable("personDbId") String personDbId, String authorization)
			throws BrAPIServerException {

		Person data = peopleService.getPerson(personDbId);

		PersonResponse response = new PersonResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(data);
		return new ResponseEntity<PersonResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@PreAuthorize("hasAuthority('ADMIN')")
	@Override
	public ResponseEntity<PersonResponse> peoplePersonDbIdPut(@PathVariable("personDbId") String personDbId, @Valid @RequestBody NewPersonRequest body,
			String authorization) throws BrAPIServerException {
		
		Person data = peopleService.updatePerson(personDbId, body);

		PersonResponse response = new PersonResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(data);
		return new ResponseEntity<PersonResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@PreAuthorize("hasAuthority('ADMIN')")
	@Override
	public ResponseEntity<PersonResponse> peoplePost(@Valid @RequestBody NewPersonRequest body, String authorization)
			throws BrAPIServerException {
		
		Person data = peopleService.saveNewPerson(body);

		PersonResponse response = new PersonResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(data);
		return new ResponseEntity<PersonResponse>(response, HttpStatus.OK);
	}

}
