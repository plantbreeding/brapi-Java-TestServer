package org.brapi.test.BrAPITestServer.repository;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.entity.GermplasmAttributeValueEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GermplasmAttributeValueRepository extends PagingAndSortingRepository<GermplasmAttributeValueEntity, String>{

	Page<GermplasmAttributeValueEntity> findByGermplasm_Id(String germplasmDbId, Pageable pageReq);

	Page<GermplasmAttributeValueEntity> findByGermplasm_IdAndGermplasmAttributeDefinition_IdIsIn(String germplasmDbId, List<String> attributeList,
			Pageable pageReq);

}
