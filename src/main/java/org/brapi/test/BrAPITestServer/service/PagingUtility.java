package org.brapi.test.BrAPITestServer.service;

import org.brapi.test.BrAPITestServer.model.rest.metadata.MetaData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PagingUtility {
	public static void calculateMetaData(MetaData metaData) {
		int totalCount = metaData.getPagination().getTotalCount();
		int pageSize = metaData.getPagination().getPageSize();
		metaData.getPagination().setTotalPages(totalCount/pageSize);		
	}

	public static Pageable getPageRequest(MetaData metaData) {
		return PageRequest.of(metaData.getPagination().getCurrentPage(), metaData.getPagination().getPageSize());
	}
	
	public static Pageable getPageRequest(MetaData metaData, Sort sort) {
		return PageRequest.of(metaData.getPagination().getCurrentPage(), metaData.getPagination().getPageSize(), sort);
	}

	public static void calculateMetaData(MetaData metaData, Page<?> page) {
		metaData.getPagination().setPageSize(page.getNumberOfElements());
		metaData.getPagination().setCurrentPage(page.getNumber());
		metaData.getPagination().setTotalCount((int) page.getTotalElements());
		metaData.getPagination().setTotalPages((int) page.getTotalPages());
	}
}
