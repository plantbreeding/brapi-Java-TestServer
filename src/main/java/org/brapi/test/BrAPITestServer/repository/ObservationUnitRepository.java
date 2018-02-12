package org.brapi.test.BrAPITestServer.repository;

import java.util.Date;
import java.util.List;

import org.brapi.test.BrAPITestServer.model.entity.ObservationUnitEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ObservationUnitRepository extends PagingAndSortingRepository<ObservationUnitEntity, String> {
	public Page<ObservationUnitEntity> findAllByStudy_IdAndObservationLevel(String studyDbId, String observationLevel, Pageable pageReq);

	public Page<ObservationUnitEntity> findAllByStudy_Id(String studyDbId, Pageable pageReq);

	@Query("select o.observationLevel from ObservationUnitEntity o")
	public Page<String> findObservationLevels(Pageable pageReq);
	
	@Query("select o from ObservationUnitEntity o "
			+ "join o.observations observation "
			+ "where ('' in :germplasmDbIds or o.germplasm.id in :germplasmDbIds) "
			+ "AND ('' in :observationVariableDbIds or observation.observationVariable.id in :observationVariableDbIds) "
			+ "AND ('' in :studyDbIds or o.study.id in :studyDbIds) "
			+ "AND ('' in :locationDbIds or o.study.location.id in :locationDbIds) "
			+ "AND ('' in :programDbIds or o.study.trial.program.id in :programDbIds) "
			+ "AND ('' in :seasonDbIds or observation.season.id in :seasonDbIds) "
			+ "AND ('' in :observationLevel or o.observationLevel in :observationLevel) "
			+ "AND (observation.observationTimeStamp BETWEEN :observationTimeStart AND :observationTimeEnd) ")
	public Page<ObservationUnitEntity> findBySearch_byDate(
	@Param("germplasmDbIds") List<String> germplasmDbIds,
	@Param("observationVariableDbIds") List<String> observationVariableDbIds,
	@Param("studyDbIds") List<String> studyDbIds,
	@Param("locationDbIds") List<String> locationDbIds,
	@Param("programDbIds") List<String> programDbIds,
	@Param("seasonDbIds") List<String> seasonDbIds,
	@Param("observationLevel") List<String> observationLevel,
	@Param("observationTimeStart") Date observationTimeStart,
	@Param("observationTimeEnd") Date observationTimeEnd,
	Pageable pageReq);
	
	@Query("select o from ObservationUnitEntity o "
			+ "join o.observations observation "
			+ "where ('' in :germplasmDbIds or o.germplasm.id in :germplasmDbIds) "
			+ "AND ('' in :observationVariableDbIds or observation.observationVariable.id in :observationVariableDbIds) "
			+ "AND ('' in :studyDbIds or o.study.id in :studyDbIds) "
			+ "AND ('' in :locationDbIds or o.study.location.id in :locationDbIds) "
			+ "AND ('' in :programDbIds or o.study.trial.program.id in :programDbIds) "
			+ "AND ('' in :seasonDbIds or observation.season.id in :seasonDbIds) "
			+ "AND ('' in :observationLevel or o.observationLevel in :observationLevel) ")
	public Page<ObservationUnitEntity> findBySearch(
	@Param("germplasmDbIds") List<String> germplasmDbIds,
	@Param("observationVariableDbIds") List<String> observationVariableDbIds,
	@Param("studyDbIds") List<String> studyDbIds,
	@Param("locationDbIds") List<String> locationDbIds,
	@Param("programDbIds") List<String> programDbIds,
	@Param("seasonDbIds") List<String> seasonDbIds,
	@Param("observationLevel") List<String> observationLevel,
	Pageable pageReq);

	public List<ObservationUnitEntity> findAllByStudy_Id(String studyDbId);
}
