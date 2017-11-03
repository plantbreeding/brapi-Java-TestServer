package org.brapi.test.BrAPITestServer.controller;

import org.brapi.test.BrAPITestServer.model.Call;
import org.brapi.test.BrAPITestServer.model.metadata.SearchResults;
import org.brapi.test.BrAPITestServer.model.metadata.SearchResultsList;
import org.brapi.test.BrAPITestServer.service.CallsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CallsController extends BrAPIController{
	
	CallsService callService;
	
	@Autowired
	public CallsController(CallsService callService) {
		super();
		this.callService = callService;
	}

	@RequestMapping(method=RequestMethod.GET)
	public SearchResults<SearchResultsList<Call>> calls(
			@RequestParam(value="datatype", defaultValue="json") String datatype,
			@RequestParam(value="pageSize", defaultValue="1000") int pageSize,
			@RequestParam(value="page", defaultValue="0") int page){
		
		return SearchResults
				.withList(callService.getAvailableCalls())
				.withMetaData(mockMetaData(page, pageSize));
	}
}
