package org.brapi.test.BrAPITestServer.controller;

import java.util.ArrayList;

import org.brapi.test.BrAPITestServer.model.rest.metadata.GenericRequest;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaDataPagination;

public class BrAPIController {
	protected MetaData generateMetaDataTemplate(GenericRequest request) {
		return generateMetaDataTemplate(request.getPage(), request.getPageSize());
	}
	
	protected MetaData generateMetaDataTemplate(int page, int pageSize) {
		MetaData metaData = generateEmptyMetadata();
		metaData.getPagination().setCurrentPage(page);
		metaData.getPagination().setPageSize(pageSize);
		return metaData;
	}
	
	protected MetaData generateEmptyMetadata() {
		MetaData metaData = new MetaData();
		metaData.setDatafiles(new ArrayList<>());
		metaData.setStatus(new ArrayList<>());
		metaData.setPagination(new MetaDataPagination());
		metaData.getPagination().setCurrentPage(0);
		metaData.getPagination().setPageSize(0);
		metaData.getPagination().setTotalCount(0);
		metaData.getPagination().setTotalPages(0);
		return metaData;
	}
}
