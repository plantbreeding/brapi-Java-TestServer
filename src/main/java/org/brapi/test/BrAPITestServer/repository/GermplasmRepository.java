package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.GermplasmEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GermplasmRepository extends PagingAndSortingRepository<GermplasmEntity, String>, GermplasmRepositoryCustom {

}
