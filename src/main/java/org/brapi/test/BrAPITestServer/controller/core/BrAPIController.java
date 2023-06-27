package org.brapi.test.BrAPITestServer.controller.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.brapi.test.BrAPITestServer.auth.AuthDetails;
import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.exceptions.InvalidPagingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import com.google.common.collect.Sets;

import io.swagger.model.BrAPIResponse;
import io.swagger.model.BrAPIResponseResult;
import io.swagger.model.IndexPagination;
import io.swagger.model.Metadata;
import io.swagger.model.Model202AcceptedSearchResponse;
import io.swagger.model.Model202AcceptedSearchResponseResult;
import io.swagger.model.SearchRequest;
import io.swagger.model.Status;
import io.swagger.model.Status.MessageTypeEnum;
import io.swagger.model.TokenPagination;

public class BrAPIController {
	private static final Logger log = LoggerFactory.getLogger(ServerInfoApiController.class);
	
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

	protected Metadata generateMetaDataTemplate(SearchRequest request) throws BrAPIServerException {
		return generateMetaDataTemplate(request.getPage(), request.getPageSize());
	}

	protected Metadata generateMetaDataTemplate(String pageToken, Integer pageSize) {
		if (pageSize == null) {
			pageSize = 1000;
		}

		Metadata metaData = generateEmptyMetadataToken();
		metaData.getPagination().setCurrentPage(pageToken);
		metaData.getPagination().setPageSize(pageSize);
		return metaData;
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
		metaData.setStatus(getStatusMessages());
		
		IndexPagination pagination = new IndexPagination();
		pagination.setCurrentPage(0);
		pagination.setPageSize(0);
		pagination.setTotalCount(0);
		pagination.setTotalPages(0);
		
		metaData.setPagination(pagination);
		return metaData;
	}

	private List<Status> getStatusMessages() {
		List<Status> statusList = new ArrayList<>();
		
		SecurityContext context = SecurityContextHolder.getContext();
		if(context.getAuthentication().getDetails() != null && context.getAuthentication().getDetails() instanceof AuthDetails) {
			AuthDetails auth = (AuthDetails) context.getAuthentication().getDetails();
			Status expStatus = new Status();
			expStatus.setMessageType(MessageTypeEnum.WARNING);
			expStatus.setMessage("User token expires at " + auth.getExpirationTimestamp());
			statusList.add(expStatus);
		}
		
		return statusList;
	}

	protected Metadata generateEmptyMetadataToken() {
		Metadata metaData = new Metadata();
		metaData.setDatafiles(new ArrayList<>());
		metaData.setStatus(new ArrayList<>());
		TokenPagination pagination = new TokenPagination();
		pagination.setCurrentPageToken("");
		pagination.setNextPageToken("");
		pagination.setPrevPageToken("");
		pagination.setPageSize(0);
		pagination.setTotalCount(0);
		pagination.setTotalPages(0);
		
		metaData.setPagination(pagination);
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
	
	protected void validateSecurityContext(HttpServletRequest request, String...acceptableRoles) throws BrAPIServerException {

		SecurityContext context = SecurityContextHolder.getContext();
		
		Set<String> acceptableRolesSet = Sets.newHashSet(acceptableRoles);
		Set<String> userRolesSet = context.getAuthentication().getAuthorities().stream().map(auth -> auth.getAuthority()).collect(Collectors.toSet());
		
		acceptableRolesSet.retainAll(userRolesSet);
		
		if(acceptableRolesSet.isEmpty()) {
			String username = "";
			if(context.getAuthentication().getPrincipal() != null) { 
				username = context.getAuthentication().getPrincipal().toString();
			}
			
			throw new BrAPIServerException(HttpStatus.FORBIDDEN, "The user \""+ username 
					+"\" does not have sufficient privileges to access the endpoint \""+ request.getMethod() + " " + request.getRequestURI() +"\"");
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

	public <T extends BrAPIResponse<R>, R extends BrAPIResponseResult<S>, S> ResponseEntity<T> responseOK(T response, R result, List<S> data, Metadata metadata) {
		result.setData(data);
		response.setMetadata(metadata);
		response.setResult(result);
		return new ResponseEntity<T>(response, HttpStatus.OK);
	}
	
	public ResponseEntity<Model202AcceptedSearchResponse> responseAccepted(String searchReqDbId){
		Model202AcceptedSearchResponseResult result = new Model202AcceptedSearchResponseResult();
		result.setSearchResultsDbId(searchReqDbId);
		Model202AcceptedSearchResponse response = new Model202AcceptedSearchResponse();
		response.setMetadata(generateEmptyMetadata());
		response.setResult(result);
		return new ResponseEntity<Model202AcceptedSearchResponse>(response, HttpStatus.ACCEPTED);
	}

}
