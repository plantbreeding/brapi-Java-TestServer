package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SearchRepository extends PagingAndSortingRepository<SearchRequestEntity, String>{

}
