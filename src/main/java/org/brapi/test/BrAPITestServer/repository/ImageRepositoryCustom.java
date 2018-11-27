package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.ImageEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.swagger.model.ImagesSearchRequest;

public interface ImageRepositoryCustom {

	public Page<ImageEntity> findBySearch(ImagesSearchRequest request, Pageable pageReq);
}
