package org.brapi.test.BrAPITestServer.repository;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.entity.ObservationVariableEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ObservationVariableRepository extends PagingAndSortingRepository<ObservationVariableEntity, String>, ObservationVariableRepositoryCustom{
	@Query("select distinct o.scale.dataType from ObservationVariableEntity o")
	public Page<String> findDistinctScale_DatatypeAll(Pageable pageReq);
	
	public Page<ObservationVariableEntity> findAllByTrait_TraitClass(String traitClass, Pageable pageReq);
	
	@Query("select distinct o.observationVariable from ObservationEntity o "
			+ "where o.observationUnit.study.id = :studyDbId")
	public List<ObservationVariableEntity> findAllForStudy(@Param("studyDbId") String studyDbId);
}
