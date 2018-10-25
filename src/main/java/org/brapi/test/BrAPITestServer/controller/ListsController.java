package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import javax.validation.Valid;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.api.ListsApi;
import io.swagger.model.ListResponse;
import io.swagger.model.ListSummaryResponse;
import io.swagger.model.ListTypes;
import io.swagger.model.NewListRequest;

@RestController
public class ListsController extends BrAPIController implements ListsApi {

	@Autowired
	public ListsController() {
	}

	@Override
	public ResponseEntity<ListSummaryResponse> listsGet(@Valid ListTypes listType, @Valid String listName,
			@Valid String listDbId, @Valid String listSource, @Valid Integer page, @Valid Integer pageSize,
			String authorization) throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ListResponse> listsListDbIdGet(String listDbId, String authorization)
			throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ListResponse> listsListDbIdItemsPost(String listDbId, @Valid List<String> body,
			String authorization) throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ListResponse> listsListDbIdPut(String listDbId, @Valid NewListRequest body,
			String authorization) throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ListResponse> listsPost(@Valid NewListRequest body, String authorization)
			throws BrAPIServerException {
		// TODO Auto-generated method stub
		return null;
	}


}
