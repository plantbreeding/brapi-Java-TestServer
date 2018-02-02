package org.brapi.test.BrAPITestServer.repository;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.entity.PlateEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface VendorSampleRepository extends PagingAndSortingRepository<PlateEntity, String> {
	@Query("select p from PlateEntity p "
			+ "where ('' IN :vendorProjectDbIds OR p.vendorProjectDbId IN :vendorProjectDbIds) "
			+ "AND ('' IN :vendorPlateDbIds OR p.id IN :vendorPlateDbIds) "
			+ "AND ('' IN :clientPlateDbIds OR p.clientPlateDbId IN :clientPlateDbIds) ")
	Page<PlateEntity> findBySearch(
			@Param("vendorProjectDbIds") List<String> vendorProjectDbIds, 
			@Param("vendorPlateDbIds")List<String> vendorPlateDbIds,
			@Param("clientPlateDbIds")List<String> clientPlateDbIds,
			Pageable pageReq);

}
