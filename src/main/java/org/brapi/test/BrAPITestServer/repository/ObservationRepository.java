package org.brapi.test.BrAPITestServer.repository;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.entity.ObservationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.brapi.test.BrAPITestServer.repository.core.BrAPIRepository;

public interface ObservationRepository extends BrAPIRepository<ObservationEntity, String> {

	Page<ObservationEntity> findAllByObservationUnit_Study_IdAndObservationVariable_IdIn(String studyDbId,
			List<String> observationVariableDbIds, Pageable pageReq);
	
	Page<ObservationEntity> findAllByObservationUnit_Study_Id(String studyDbId, Pageable pageReq);

}
