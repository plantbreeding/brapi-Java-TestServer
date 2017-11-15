package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.GermplasmAttributeCategoryEntity;
import org.brapi.test.BrAPITestServer.model.entity.GermplasmAttributeEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GermplasmAttributeCategoryRepository extends PagingAndSortingRepository<GermplasmAttributeCategoryEntity, String> {

}
