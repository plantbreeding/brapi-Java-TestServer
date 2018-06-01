package org.brapi.test.BrAPITestServer.repository;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.entity.MarkerProfileEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface MarkerProfileRepository extends PagingAndSortingRepository<MarkerProfileEntity, String> {
	public List<MarkerProfileEntity> findByGermplasmDbId(String germplasmDbId);

	@Query("select mp from MarkerProfileEntity mp join mp.studies study"
			+ " where (:germplasmDbId is null OR mp.germplasmDbId = :germplasmDbId)"
			+ " AND (:studyDbId is null OR study.id = :studyDbId)"
			+ " AND (:sampleDbId is null OR mp.sampleDbId = :sampleDbId)"
			+ " AND (:extractDbId is null OR mp.extractDbId = :extractDbId)")
	public Page<MarkerProfileEntity> findBySearchOptions(
			@Param("germplasmDbId") String germplasmDbId, 
			@Param("studyDbId") String studyDbId, 
			@Param("sampleDbId") String sampleDbId, 
			@Param("extractDbId") String extractDbId, 
			Pageable pageReq);
}
