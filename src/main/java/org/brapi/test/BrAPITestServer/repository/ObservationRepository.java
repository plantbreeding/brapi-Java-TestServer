package org.brapi.test.BrAPITestServer.repository;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.entity.ObservationEntity;
import org.brapi.test.BrAPITestServer.model.entity.ObservationUnitEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ObservationRepository extends PagingAndSortingRepository<ObservationEntity, String> {

	Page<ObservationEntity> findAllByObservationUnit_StudyDbIdAndObservationVariable_IdIn(String studyDbId,
			List<String> observationVariableDbIds, Pageable pageReq);

}
