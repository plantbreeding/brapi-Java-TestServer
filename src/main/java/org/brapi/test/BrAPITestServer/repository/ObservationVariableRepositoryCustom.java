package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.ObservationVariableEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import io.swagger.model.ObservationVariableSearchRequest;

public interface ObservationVariableRepositoryCustom {
	public Page<ObservationVariableEntity> findBySearch(ObservationVariableSearchRequest request, Pageable pageReq);
}
