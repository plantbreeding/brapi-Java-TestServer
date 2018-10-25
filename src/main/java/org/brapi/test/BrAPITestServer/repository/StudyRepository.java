package org.brapi.test.BrAPITestServer.repository;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.entity.GermplasmEntity;
import org.brapi.test.BrAPITestServer.model.entity.StudyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface StudyRepository extends PagingAndSortingRepository<StudyEntity, String> {
	@Query("select distinct s from StudyEntity s JOIN s.seasons season JOIN s.observationUnits ou JOIN ou.observations observation "
			+ "where ('' IN :studyTypeDbIds OR s.studyType.id IN :studyTypeDbIds) "
			+ "AND ('' IN :studyTypeNames OR s.studyType.name IN :studyTypeNames) "
			+ "AND ('' IN :programDbIds OR s.trial.program.id IN :programDbIds) "
			+ "AND ('' IN :trialDbIds OR s.trial.id IN :trialDbIds) "
			+ "AND ('' IN :studyDbIds OR s.id IN :studyDbIds) "
			+ "AND ('' IN :programNames OR s.trial.program.name IN :programNames) "
			+ "AND ('' IN :studyNames OR s.studyName IN :studyNames) "
			+ "AND ('' IN :locationDbIds OR s.location.id IN :locationDbIds) "
			+ "AND ('' IN :seasonDbIds OR season.id IN :seasonDbIds) "
			+ "AND ('' IN :germplasmDbIds OR ou.germplasm.id IN :germplasmDbIds) "
			+ "AND ('' IN :observationVariableDbIds OR observation.observationVariable.id IN :observationVariableDbIds) "
			+ "AND (:applyActiveFilter = false OR :active = s.active) ")
	public Page<StudyEntity> findBySearch(
			@Param("studyTypeDbIds") List<String> studyTypeDbIds,
			@Param("studyTypeNames") List<String> studyTypeNames, 
			@Param("programDbIds") List<String> programDbIds, 
			@Param("trialDbIds") List<String> trialDbIds, 
			@Param("studyDbIds") List<String> studyDbIds, 
			@Param("programNames") List<String> programNames,
			@Param("studyNames") List<String> studyNames, 
			@Param("locationDbIds") List<String> locationDbIds, 
			@Param("seasonDbIds") List<String> seasonDbIds,
			@Param("germplasmDbIds") List<String> germplasmDbIds, 
			@Param("observationVariableDbIds") List<String> observationVariableDbIds, 
			@Param("applyActiveFilter") boolean applyActiveFilter, @Param("active") boolean active, Pageable pageReq);

	@Query("select unit.germplasm from StudyEntity s JOIN s.observationUnits unit where s.id = :studyDbId")
	public Page<GermplasmEntity> findGermplasmsByStudy(@Param("studyDbId") String studyDbId, Pageable pageReq);
}
