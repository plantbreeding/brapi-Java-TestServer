package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.AlleleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AlleleRepository extends PagingAndSortingRepository<AlleleEntity, String>{
	public Page<AlleleEntity> findAllByMarkerProfileDbId(String markerProfileDbId, Pageable pageReq);
}
