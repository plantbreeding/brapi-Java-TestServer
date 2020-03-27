package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.GermplasmEntity;
import org.brapi.test.BrAPITestServer.repository.core.BrAPIRepository;

public interface GermplasmRepository extends BrAPIRepository<GermplasmEntity, String>, GermplasmRepositoryCustom {

}
