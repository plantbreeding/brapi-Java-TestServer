package org.brapi.test.BrAPITestServer.repository.core;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrAPIRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

	public Page<T> findAllBySearch(String queryStr, Map<String, Object> params, Pageable pageReq, Class<T> returnClass) ;
}