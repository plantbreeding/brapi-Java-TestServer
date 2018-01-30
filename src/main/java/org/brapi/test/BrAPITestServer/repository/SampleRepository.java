package org.brapi.test.BrAPITestServer.repository;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.entity.SampleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface SampleRepository extends PagingAndSortingRepository<SampleEntity, String> {
	@Query("select s from SampleEntity s "
			+ "where ('' IN :sampleDbIds OR s.id IN :sampleDbIds) "
			+ "AND ('' IN :observationUnitDbIds OR s.observationUnit.id IN :observationUnitDbIds) "
			+ "AND ('' IN :plateDbIds OR s.plateDbId IN :plateDbIds) "
			+ "AND ('' IN :germplasmDbIds OR s.observationUnit.germplasm.id IN :germplasmDbIds) ")
	Page<SampleEntity> findBySearch(
			@Param("sampleDbIds") List<String> sampleDbIds, 
			@Param("observationUnitDbIds")List<String> observationUnitDbIds,
			@Param("plateDbIds")List<String> plateDbIds, 
			@Param("germplasmDbIds")List<String> germplasmDbIds, Pageable pageReq);

}
