package org.brapi.test.BrAPITestServer.repository.pheno;

import org.brapi.test.BrAPITestServer.model.entity.pheno.ImageEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.swagger.model.pheno.ImageSearchRequest;

public interface ImageRepositoryCustom {

	public Page<ImageEntity> findBySearch(ImageSearchRequest request, Pageable pageReq);
}
