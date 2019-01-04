package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.GermplasmEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import io.swagger.model.GermplasmSearchRequest;

public interface GermplasmRepositoryCustom{
	Page<GermplasmEntity> findBySearch(GermplasmSearchRequest request, Pageable pageRequest);

}
