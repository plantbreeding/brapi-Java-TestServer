package org.brapi.test.BrAPITestServer.repository;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.entity.ObservationUnitEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.brapi.test.BrAPITestServer.repository.core.BrAPIRepository;

public interface ObservationUnitRepository extends BrAPIRepository<ObservationUnitEntity, String>, ObservationUnitRepositoryCustom {
	public Page<ObservationUnitEntity> findAllByStudy_IdAndObservationLevel(String studyDbId, String observationLevel, Pageable pageReq);

	public Page<ObservationUnitEntity> findAllByStudy_Id(String studyDbId, Pageable pageReq);

	@Query("select o.observationLevel from ObservationUnitEntity o")
	public Page<String> findObservationLevels(Pageable pageReq);

	public List<ObservationUnitEntity> findAllByStudy_Id(String studyDbId);
}
