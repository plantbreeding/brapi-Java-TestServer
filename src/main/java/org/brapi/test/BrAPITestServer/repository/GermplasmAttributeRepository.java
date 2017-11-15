package org.brapi.test.BrAPITestServer.repository;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.entity.GermplasmAttributeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GermplasmAttributeRepository extends PagingAndSortingRepository<GermplasmAttributeEntity, String> {
	Page<GermplasmAttributeEntity> findByAttributeCategory_Id(String attributeCategoryDbId, Pageable pageReq);
	Page<GermplasmAttributeEntity> findByGermplasmDbId(String germplasmDbId, Pageable pageReq);
	Page<GermplasmAttributeEntity> findByGermplasmDbIdAndIdIsIn(String germplasmDbId, List<String> attributeCategoryDbId, Pageable pageReq);
	long countByGermplasmDbId(String germplasmDbId);
	long countByGermplasmDbIdAndIdIsIn(String germplasmDbId, List<String> attributeCategoryDbId);

}
