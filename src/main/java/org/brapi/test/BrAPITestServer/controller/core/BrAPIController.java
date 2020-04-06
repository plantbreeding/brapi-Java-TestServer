package org.brapi.test.BrAPITestServer.controller.core;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.exceptions.InvalidPagingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.swagger.model.BrAPIResponse;
import io.swagger.model.BrAPIResponseResult;
import io.swagger.model.IndexPagination;
import io.swagger.model.Metadata;
import io.swagger.model.SearchRequestParametersPaging;

public class BrAPIController {
	protected Metadata generateMetaDataTemplateForSearch(Integer originalRequestedPage, Integer newRequestedPage,
			Integer originalRequestedPageSize, Integer newRequestedPageSize) throws BrAPIServerException {
		Integer page = newRequestedPage;
		Integer pageSize = newRequestedPageSize;

		if (page == null) {
			page = originalRequestedPage;
		}
		if (pageSize == null) {
			pageSize = originalRequestedPageSize;
		}

		return generateMetaDataTemplate(page, pageSize);
	}

	protected Metadata generateMetaDataTemplate(SearchRequestParametersPaging request) throws BrAPIServerException {
		return generateMetaDataTemplate(request.getPage(), request.getPageSize());
	}

	protected Metadata generateMetaDataTemplate(Integer page, Integer pageSize) throws BrAPIServerException {
		validatePaging(page, pageSize);

		// defaults
		if (page == null) {
			page = 0;
		}
		if (pageSize == null) {
			pageSize = 1000;
		}

		Metadata metaData = generateEmptyMetadata();
		metaData.getPagination().setCurrentPage(page);
		metaData.getPagination().setPageSize(pageSize);
		return metaData;
	}

	private void validatePaging(Integer page, Integer pageSize) throws BrAPIServerException {
		boolean pageValid = (page == null) || (page >= 0);
		if (!pageValid)
			throw new InvalidPagingException("page");
		boolean pageSizeValid = (pageSize == null) || (pageSize >= 1);
		if (!pageSizeValid)
			throw new InvalidPagingException("pageSize");

	}

	protected Metadata generateEmptyMetadata() {
		Metadata metaData = new Metadata();
		metaData.setDatafiles(new ArrayList<>());
		metaData.setStatus(new ArrayList<>());
		metaData.setPagination(new IndexPagination());
		metaData.getPagination().setCurrentPage(0);
		metaData.getPagination().setPageSize(0);
		metaData.getPagination().setTotalCount(0);
		metaData.getPagination().setTotalPages(0);
		return metaData;
	}

	protected void validateAcceptHeader(HttpServletRequest request) throws BrAPIServerException {
		String accept = request.getHeader("Accept");
		if (accept != null) {
			String acceptRegex = accept.replaceAll("\\*", ".*").replaceAll(", ?", "|").replaceAll(";?q=[01]\\.[0-9]", "");
			if (!"application/json".matches(acceptRegex)) {
				throw new BrAPIServerException(HttpStatus.NOT_ACCEPTABLE,
						"Client is requesting a response other than \"application/json\"");
			}
		}
	}

	public <R, T extends BrAPIResponse<R>> ResponseEntity<T> responseOK(T response, R result) {
		return responseOK(response, result, generateEmptyMetadata());
	}

	public <R, T extends BrAPIResponse<R>> ResponseEntity<T> responseOK(T response, R result, Metadata metadata) {
		response.setMetadata(metadata);
		response.setResult(result);
		return new ResponseEntity<T>(response, HttpStatus.OK);
	}

	public <T extends BrAPIResponse<R>, R extends BrAPIResponseResult<S>, S> ResponseEntity<T> responseOK(T response,
			R result, List<S> data) {
		return responseOK(response, result, data, generateEmptyMetadata());
	}

	public <T extends BrAPIResponse<R>, R extends BrAPIResponseResult<S>, S> ResponseEntity<T> responseOK(T response,
			R result, List<S> data, Metadata metadata) {
		result.setData(data);
		response.setMetadata(metadata);
		response.setResult(result);
		return new ResponseEntity<T>(response, HttpStatus.OK);
	}

}
