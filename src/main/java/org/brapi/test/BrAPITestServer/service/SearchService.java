package org.brapi.test.BrAPITestServer.service;

import java.util.Optional;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity.SearchRequestTypes;
import org.brapi.test.BrAPITestServer.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class SearchService {
	private SearchRepository searchRepository;

	@Autowired
	public SearchService(SearchRepository searchRepository) {
		this.searchRepository = searchRepository;
	}

	public String saveSearchRequest(Object body, SearchRequestTypes type) throws BrAPIServerException {

		SearchRequestEntity searchEntity = new SearchRequestEntity();
		searchEntity.setRequestType(type);
		searchEntity.setParameters(body);

		SearchRequestEntity savedEntity = searchRepository.save(searchEntity);

		return savedEntity.getId();
	}

	public SearchRequestEntity findById(String searchResultsDbId) throws BrAPIServerException {
		Optional<SearchRequestEntity> searchEntityOpt = searchRepository.findById(searchResultsDbId);
		if (searchEntityOpt.isPresent()) {
			return searchEntityOpt.get();
		} else {
			throw new BrAPIServerException(HttpStatus.NOT_FOUND,
					"Search Request not found. Check Db Id or POST new request.");
		}
	}
}
