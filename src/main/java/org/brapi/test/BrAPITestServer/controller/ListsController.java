package org.brapi.test.BrAPITestServer.controller;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.api.ListsApi;
import io.swagger.model.ListDetails;
import io.swagger.model.ListResponse;
import io.swagger.model.ListSummary;
import io.swagger.model.ListSummaryResponse;
import io.swagger.model.ListSummaryResponseResult;
import io.swagger.model.ListTypes;
import io.swagger.model.Metadata;
import io.swagger.model.NewListRequest;

@RestController
public class ListsController extends BrAPIController implements ListsApi {

	private ListService listService;
	
	@Autowired
	public ListsController(ListService listService) {
		this.listService = listService;
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ListSummaryResponse> listsGet(@Valid ListTypes listType, @Valid String listName,
			@Valid String listDbId, @Valid String listSource, @Valid Integer page, @Valid Integer pageSize,
			String authorization) throws BrAPIServerException {
		Metadata metadata = generateMetaDataTemplate(page, pageSize);

		List<ListSummary> data = listService.findLists(listType, listName, listDbId,  listSource, metadata);

		ListSummaryResponseResult result = new ListSummaryResponseResult();
		result.setData(data);
		ListSummaryResponse response = new ListSummaryResponse();
		response.setMetadata(metadata);
		response.setResult(result);
		return new ResponseEntity<ListSummaryResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@Override
	public ResponseEntity<ListResponse> listsListDbIdGet(@PathVariable("listDbId") String listDbId, String authorization)
			throws BrAPIServerException {

		ListDetails data = listService.getList(listDbId);

		ListResponse response = new ListResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(data);
		return new ResponseEntity<ListResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@PreAuthorize("hasAuthority('ROLE_USER')")
	@Override
	public ResponseEntity<ListResponse> listsListDbIdItemsPost(@PathVariable("listDbId") String listDbId, @Valid @RequestBody ArrayList<String> body,
			String authorization) throws BrAPIServerException {
		
		ListDetails data = listService.updateListItems(listDbId, body);

		ListResponse response = new ListResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(data);
		return new ResponseEntity<ListResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@PreAuthorize("hasAuthority('ROLE_USER')")
	@Override
	public ResponseEntity<ListResponse> listsListDbIdPut(@PathVariable("listDbId") String listDbId, @Valid @RequestBody NewListRequest body,
			String authorization) throws BrAPIServerException {
		
		ListDetails data = listService.updateList(listDbId, body);

		ListResponse response = new ListResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(data);
		return new ResponseEntity<ListResponse>(response, HttpStatus.OK);
	}

	@CrossOrigin
	@PreAuthorize("hasAuthority('ROLE_USER')")
	@Override
	public ResponseEntity<ListResponse> listsPost(@Valid @RequestBody NewListRequest body, String authorization)
			throws BrAPIServerException {
		
		ListDetails data = listService.saveNewList(body);

		ListResponse response = new ListResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(data);
		return new ResponseEntity<ListResponse>(response, HttpStatus.OK);
	}


}
