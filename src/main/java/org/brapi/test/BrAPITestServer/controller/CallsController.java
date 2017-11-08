package org.brapi.test.BrAPITestServer.controller;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.rest.Call;
import org.brapi.test.BrAPITestServer.model.rest.metadata.GenericResults;
import org.brapi.test.BrAPITestServer.model.rest.metadata.GenericResultsDataList;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
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
	public GenericResults<GenericResultsDataList<Call>> calls(
			@RequestParam(value="datatype", defaultValue="json") String datatype,
			@RequestParam(value="pageSize", defaultValue="1000") int pageSize,
			@RequestParam(value="page", defaultValue="0") int page){
		
		MetaData metadata = generateMetaDataTemplate(page, pageSize);
		List<Call> calls = callService.getAvailableCalls(datatype, metadata);
		
		return GenericResults
				.withList(calls)
				.withMetaData(metadata);
	}
}
