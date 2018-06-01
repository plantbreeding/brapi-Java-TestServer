package org.brapi.test.BrAPITestServer.repository;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.entity.AlleleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AlleleRepository extends PagingAndSortingRepository<AlleleEntity, String>{
	public Page<AlleleEntity> findAllByMarkerProfile_Id(String markerProfileDbIds, Pageable pageReq);
	public Page<AlleleEntity> findAllByMarkerProfile_IdIn(List<String> markerProfileDbIds, Pageable pageReq);
	public Page<AlleleEntity> findAllByMarker_IdIn(List<String> markerDbIds, Pageable pageReq);
	public Page<AlleleEntity> findAllByMatrix_IdIn(List<String> matrixDbIds, Pageable pageReq);
}
