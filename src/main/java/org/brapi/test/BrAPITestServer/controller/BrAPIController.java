package org.brapi.test.BrAPITestServer.controller;

import java.util.ArrayList;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.exceptions.InvalidPagingException;

import io.swagger.model.Metadata;
import io.swagger.model.MetadataPagination;

public class BrAPIController {
	protected Metadata generateMetaDataTemplate(Integer page, Integer pageSize) throws BrAPIServerException {
		validatePaging(page, pageSize);
		
		//defaults
		if(page == null) {
			page = 0;
		}
		if(pageSize == null) {
			pageSize = 1000;
		}
		
		Metadata metaData = generateEmptyMetadata();
		metaData.getPagination().setCurrentPage(page);
		metaData.getPagination().setPageSize(pageSize);
		return metaData;
	}

	private void validatePaging(Integer page, Integer pageSize) throws BrAPIServerException {
		boolean pageValid = (page == null) || (page >= 0);
		if(!pageValid)
			throw new InvalidPagingException("page");
		boolean pageSizeValid = (pageSize == null) || (pageSize >= 1);
		if(!pageSizeValid)
			throw new InvalidPagingException("pageSize");
		
	}

	protected Metadata generateEmptyMetadata() {
		Metadata metaData = new Metadata();
		metaData.setDatafiles(new ArrayList<>());
		metaData.setStatus(new ArrayList<>());
		metaData.setPagination(new MetadataPagination());
		metaData.getPagination().setCurrentPage(0);
		metaData.getPagination().setPageSize(0);
		metaData.getPagination().setTotalCount(0);
		metaData.getPagination().setTotalPages(0);
		return metaData;
	}
}
