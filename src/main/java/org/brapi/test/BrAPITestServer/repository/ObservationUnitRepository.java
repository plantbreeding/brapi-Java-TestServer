package org.brapi.test.BrAPITestServer.repository;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.entity.ObservationUnitEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ObservationUnitRepository extends PagingAndSortingRepository<ObservationUnitEntity, String> {
	public Page<ObservationUnitEntity> findAllByStudyDbIdAndObservationLevel(String studyDbId, String observationLevel, Pageable pageReq);

	public Page<ObservationUnitEntity> findAllByStudyDbId(String studyDbId, Pageable pageReq);

	@Query("select o.observationLevel from ObservationUnitEntity o")
	public Page<String> findObservationLevels(Pageable pageReq);
}
