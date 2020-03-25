package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.ObservationUnitEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.swagger.model.pheno.ObservationUnitSearchRequest;

public interface ObservationUnitRepositoryCustom {
	
	public Page<ObservationUnitEntity> findBySearch(ObservationUnitSearchRequest request, Pageable pageReq);

}
