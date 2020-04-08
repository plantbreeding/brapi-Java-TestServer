package org.brapi.test.BrAPITestServer.repository.geno;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.brapi.test.BrAPITestServer.model.entity.geno.MarkerProfileEntity;
import org.brapi.test.BrAPITestServer.repository.core.BrAPIRepository;
import org.springframework.data.repository.query.Param;

public interface MarkerProfileRepository extends BrAPIRepository<MarkerProfileEntity, String> {
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