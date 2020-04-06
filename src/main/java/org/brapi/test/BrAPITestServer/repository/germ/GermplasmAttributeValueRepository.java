package org.brapi.test.BrAPITestServer.repository.germ;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.brapi.test.BrAPITestServer.model.entity.germ.GermplasmAttributeValueEntity;
import org.brapi.test.BrAPITestServer.repository.core.BrAPIRepository;

public interface GermplasmAttributeValueRepository extends BrAPIRepository<GermplasmAttributeValueEntity, String>{

	Page<GermplasmAttributeValueEntity> findByGermplasm_Id(String germplasmDbId, Pageable pageReq);

	Page<GermplasmAttributeValueEntity> findByGermplasm_IdAndGermplasmAttributeDefinition_IdIsIn(String germplasmDbId, List<String> attributeList,
			Pageable pageReq);

}
