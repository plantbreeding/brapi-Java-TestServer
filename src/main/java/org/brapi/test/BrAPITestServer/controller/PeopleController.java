package org.brapi.test.BrAPITestServer.controller;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.api.PeopleApi;
import io.swagger.model.NewPersonRequest;
import io.swagger.model.PersonResponse;
import io.swagger.model.PersonsResponse;

@RestController
public class PeopleController extends BrAPIController implements PeopleApi {

	@Autowired
	public PeopleController() {
	}

	@Override
	public ResponseEntity<PersonsResponse> peopleGet(@Valid String firstName, @Valid String lastName,
			@Valid String personDbId, @Valid String userID, @Valid Integer page, @Valid Integer pageSize,
			String authorization) throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<PersonResponse> peoplePersonDbIdGet(String personDbId, String authorization)
			throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<PersonResponse> peoplePersonDbIdPut(String personDbId, @Valid NewPersonRequest body,
			String authorization) throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<PersonResponse> peoplePost(@Valid NewPersonRequest body, String authorization)
			throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}

}
