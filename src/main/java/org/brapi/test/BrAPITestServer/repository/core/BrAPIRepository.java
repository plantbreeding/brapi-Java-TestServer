package org.brapi.test.BrAPITestServer.repository.core;

import java.io.Serializable;

import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BrAPIRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

	public Page<T> findAllBySearch(SearchQueryBuilder<T> searchQuery, Pageable pageReq) ;
}