package org.brapi.test.BrAPITestServer.controller.core;

import io.swagger.model.Metadata;
import io.swagger.model.core.ListDetails;
import io.swagger.model.core.ListNewRequest;
import io.swagger.model.core.ListResponse;
import io.swagger.model.core.ListSearchRequest;
import io.swagger.model.core.ListSummary;
import io.swagger.model.core.ListTypes;
import io.swagger.model.core.ListsListResponse;
import io.swagger.model.core.ListsListResponseResult;
import io.swagger.model.core.ListsSingleResponse;
import io.swagger.api.core.ListsApi;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.service.core.ListService;
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

import java.util.ArrayList;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
@Controller
public class ListsApiController extends BrAPIController implements ListsApi {

	private static final Logger log = LoggerFactory.getLogger(ListsApiController.class);

	private final HttpServletRequest request;
	private final ListService listService;

	@org.springframework.beans.factory.annotation.Autowired
	public ListsApiController(ListService listService, HttpServletRequest request) {
		this.listService = listService;
		this.request = request;
	}

	public ResponseEntity<ListsListResponse> listsGet(
			@Valid @RequestParam(value = "listType", required = false) ListTypes listType,
			@Valid @RequestParam(value = "listName", required = false) String listName,
			@Valid @RequestParam(value = "listDbId", required = false) String listDbId,
			@Valid @RequestParam(value = "listSource", required = false) String listSource,
			@Valid @RequestParam(value = "externalReferenceID", required = false) String externalReferenceID,
			@Valid @RequestParam(value = "externalReferenceSource", required = false) String externalReferenceSource,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(page, pageSize);
		List<ListSummary> data = listService.findLists(listType, listName, listDbId, listSource, externalReferenceID, externalReferenceSource, metadata);
		return responseOK(new ListsListResponse(), new ListsListResponseResult(), data, metadata);
	}

	public ResponseEntity<ListsSingleResponse> listsListDbIdGet(
			@PathVariable("listDbId") String listDbId,
			@RequestHeader(value = "Authorization", required = false) String authorization)
			throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		ListDetails data = listService.getList(listDbId);
		return responseOK(new ListsSingleResponse(), data);
	}

	public ResponseEntity<ListResponse> listsListDbIdItemsPost(
			@PathVariable("listDbId") String listDbId,
			@Valid @RequestBody ArrayList<String> body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		ListDetails data = listService.updateListItems(listDbId, body);
		return responseOK(new ListResponse(), data);
	}

	public ResponseEntity<ListsSingleResponse> listsListDbIdPut(
			@PathVariable("listDbId") String listDbId,
			@Valid @RequestBody ListNewRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		ListDetails data = listService.updateList(listDbId, body);
		return responseOK(new ListsSingleResponse(), data);
	}

	public ResponseEntity<ListsListResponse> listsPost(@Valid @RequestBody List<ListNewRequest> body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		List<ListSummary> data = listService.saveNewList(body);
		return responseOK(new ListsListResponse(), new ListsListResponseResult(), data);
	}
	
	public ResponseEntity<ListsListResponse> searchListsPost(
			@Valid @RequestBody ListSearchRequest body,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		Metadata metadata = generateMetaDataTemplate(body);
		List<ListSummary> data = listService.findLists(body, metadata);
		return responseOK(new ListsListResponse(), new ListsListResponseResult(), data, metadata);
	}

	public ResponseEntity<ListsListResponse> searchListsSearchResultsDbIdGet(
			@PathVariable("searchResultsDbId") String searchResultsDbId,
			@Valid @RequestParam(value = "page", required = false) Integer page,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestHeader(value = "Authorization", required = false) String authorization) throws BrAPIServerException {

		log.debug("Request: " + request.getRequestURI());
		validateAcceptHeader(request);
		return new ResponseEntity<ListsListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

}
