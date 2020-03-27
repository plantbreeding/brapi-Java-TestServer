package org.brapi.test.BrAPITestServer.controller.core;

import io.swagger.model.common.Metadata;
import io.swagger.model.core.Person;
import io.swagger.model.core.PersonListResponse;
import io.swagger.model.core.PersonListResponseResult;
import io.swagger.model.core.PersonSingleResponse;
import io.swagger.model.core.PersonNewRequest;
import io.swagger.model.core.PersonSearchRequest;
import io.swagger.api.core.PeopleApi;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.PeopleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
@Controller
public class PeopleApiController extends BrAPIController implements PeopleApi {

	private static final Logger log = LoggerFactory.getLogger(PeopleApiController.class);

	private final PeopleService peopleService;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public PeopleApiController(PeopleService peopleService, HttpServletRequest request) {
		this.peopleService = peopleService;
		this.request = request;
	}

	public ResponseEntity<PersonListResponse> peopleGet(
			@Valid @RequestParam(value = "firstName", required = false) String firstName,
			@Valid @RequestParam(value = "lastName", required = false) String lastName,
			@Valid @RequestParam(value = "personDbId", required = false) String personDbId,
			@Valid @RequestParam(value = "userID", required = false) String userID,
			@Valid @RequestParam(value = "externalReferenceID", required = false) String externalReferenceID,
			@Valid @RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<Person> data = peopleService.findPeople(firstName, lastName, personDbId, userID, externalReferenceID, externalReferenceSource, metadata);
		return responseOK(new PersonListResponse(), new PersonListResponseResult(), data, metadata);
	}

	public ResponseEntity<PersonSingleResponse> peoplePersonDbIdGet(
			@PathVariable("personDbId") String personDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Person data = peopleService.getPerson(personDbId);
		return responseOK(new PersonSingleResponse(), data);
	}

	public ResponseEntity<PersonSingleResponse> peoplePersonDbIdPut(
			@PathVariable("personDbId") String personDbId,
			@Valid @RequestBody PersonNewRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Person data = peopleService.updatePerson(personDbId, body);
		return responseOK(new PersonSingleResponse(), data);
	}

	public ResponseEntity<PersonListResponse> peoplePost(@Valid @RequestBody List<PersonNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		List<Person> data = peopleService.savePeople(body);
		return responseOK(new PersonListResponse(), new PersonListResponseResult(), data);
	}

	public ResponseEntity<PersonListResponse> searchPeoplePost(@Valid @RequestBody PersonSearchRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(body);
		List<Person> data = peopleService.findPeople(body, metadata);
		return responseOK(new PersonListResponse(), new PersonListResponseResult(), data, metadata);
	}

	public ResponseEntity<PersonListResponse> searchPeopleSearchResultsDbIdGet(
			@PathVariable("searchResultsDbId") String searchResultsDbId,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		return new ResponseEntity<PersonListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}
}
