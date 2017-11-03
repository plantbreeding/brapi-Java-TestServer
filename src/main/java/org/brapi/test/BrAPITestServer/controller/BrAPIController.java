package org.brapi.test.BrAPITestServer.controller;

import org.brapi.test.BrAPITestServer.model.metadata.MetaData;
import org.brapi.test.BrAPITestServer.model.metadata.MetaDataPagination;

public class BrAPIController {
	protected MetaData mockMetaData(int page, int pageSize) {
		MetaData metaData = new MetaData();
		metaData.setPagination(new MetaDataPagination());
		metaData.getPagination().setCurrentPage(page);
		metaData.getPagination().setPageSize(pageSize);
		metaData.getPagination().setTotalCount(7);
		metaData.getPagination().setTotalPages(1);
		return metaData;
	}
	
	protected MetaData mockEmptyMetadata() {
		MetaData metaData = new MetaData();
		metaData.setPagination(new MetaDataPagination());
		metaData.getPagination().setCurrentPage(0);
		metaData.getPagination().setPageSize(0);
		metaData.getPagination().setTotalCount(0);
		metaData.getPagination().setTotalPages(0);
		return metaData;
	}
}
