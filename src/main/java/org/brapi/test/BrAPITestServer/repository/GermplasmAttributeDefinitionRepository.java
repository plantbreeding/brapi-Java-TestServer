package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.GermplasmAttributeDefinitionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.brapi.test.BrAPITestServer.repository.core.BrAPIRepository;

public interface GermplasmAttributeDefinitionRepository extends BrAPIRepository<GermplasmAttributeDefinitionEntity, String> {
	Page<GermplasmAttributeDefinitionEntity> findByAttributeCategory_Id(String attributeCategoryDbId, Pageable pageReq);

}
