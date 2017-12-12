package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.GermplasmAttributeDefinitionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GermplasmAttributeDefinitionRepository extends PagingAndSortingRepository<GermplasmAttributeDefinitionEntity, String> {
	Page<GermplasmAttributeDefinitionEntity> findByAttributeCategory_Id(String attributeCategoryDbId, Pageable pageReq);

}
