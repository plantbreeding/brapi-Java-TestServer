package org.brapi.test.BrAPITestServer.service;

import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class PagingUtility {
	public static void calculateMetaData(MetaData metadata) {
		int totalCount = metadata.getPagination().getTotalCount();
		int pageSize = metadata.getPagination().getPageSize();
		metadata.getPagination().setTotalPages(totalCount/pageSize);		
	}
	
	public static Pageable getPageRequest(MetaData metadata) {
		return PageRequest.of(metadata.getPagination().getCurrentPage(), metadata.getPagination().getPageSize());
	}
}
