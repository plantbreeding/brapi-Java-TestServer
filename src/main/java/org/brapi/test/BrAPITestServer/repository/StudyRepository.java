package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.GermplasmEntity;
import org.brapi.test.BrAPITestServer.model.entity.StudyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface StudyRepository extends PagingAndSortingRepository<StudyEntity, String>, StudyRepositoryCustom {
	@Query("select unit.germplasm from StudyEntity s LEFT JOIN s.observationUnits unit where s.id = :studyDbId")
	public Page<GermplasmEntity> findGermplasmsByStudy(@Param("studyDbId") String studyDbId, Pageable pageReq);
}
