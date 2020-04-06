package org.brapi.test.BrAPITestServer.repository.germ;

import org.brapi.test.BrAPITestServer.model.entity.germ.GermplasmEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.swagger.model.germ.GermplasmSearchRequest;

public interface GermplasmRepositoryCustom{
	Page<GermplasmEntity> findBySearch(GermplasmSearchRequest request, Pageable pageRequest);

}
