package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.MarkerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import io.swagger.model.MarkersSearchRequest;

public interface MarkerRepositoryCustom{
	public Page<MarkerEntity> findBySearch(MarkersSearchRequest request, Pageable pageReq);

}
