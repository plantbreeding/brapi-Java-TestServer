package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.ObservationVariableEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.brapi.test.BrAPITestServer.repository.core.BrAPIRepository;
import org.springframework.data.repository.query.Param;

public interface ObservationVariableRepository extends BrAPIRepository<ObservationVariableEntity, String>, ObservationVariableRepositoryCustom{
	@Query("select distinct o.scale.dataType from ObservationVariableEntity o")
	public Page<String> findDistinctScale_DatatypeAll(Pageable pageReq);
	
	public Page<ObservationVariableEntity> findAllByTrait_TraitClass(String traitClass, Pageable pageReq);
	
	@Query("select distinct o.observationVariable from ObservationEntity o "
			+ "where o.observationUnit.study.id = :studyDbId")
	public Page<ObservationVariableEntity> findAllForStudy(@Param("studyDbId") String studyDbId, Pageable pageReq);
}
