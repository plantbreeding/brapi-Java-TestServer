package org.brapi.test.BrAPITestServer.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import io.swagger.model.Metadata;

public class PagingUtility {
	public static void calculateMetaData(Metadata metaData) {
		int totalCount = metaData.getPagination().getTotalCount();
		int pageSize = metaData.getPagination().getPageSize();
		metaData.getPagination().setTotalPages(totalCount / pageSize);
	}

	public static Pageable getPageRequest(Metadata metaData) {
		return getPageRequest(metaData, null);
	}

	public static Pageable getPageRequest(Metadata metaData, Sort sort) {
		int page = metaData.getPagination().getCurrentPage();
		if (page < 0) {
			page = 0;
		}
		int pageSize = metaData.getPagination().getPageSize();
		if (pageSize < 1) {
			pageSize = 1000;
		}
		if (sort == null) {
			return PageRequest.of(page, pageSize);
		}
		return PageRequest.of(page, pageSize, sort);
	}

	public static void calculateMetaData(Metadata metaData, Page<?> page) {
		metaData.getPagination().setPageSize(page.getNumberOfElements());
		metaData.getPagination().setCurrentPage(page.getNumber());
		metaData.getPagination().setTotalCount((int) page.getTotalElements());
		metaData.getPagination().setTotalPages((int) page.getTotalPages());
	}
}
