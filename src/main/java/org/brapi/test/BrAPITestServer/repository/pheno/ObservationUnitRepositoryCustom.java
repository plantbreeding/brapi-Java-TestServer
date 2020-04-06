package org.brapi.test.BrAPITestServer.repository.pheno;

import org.brapi.test.BrAPITestServer.model.entity.pheno.ObservationUnitEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.swagger.model.pheno.ObservationUnitSearchRequest;

public interface ObservationUnitRepositoryCustom {
	
	public Page<ObservationUnitEntity> findBySearch(ObservationUnitSearchRequest request, Pageable pageReq);

}
