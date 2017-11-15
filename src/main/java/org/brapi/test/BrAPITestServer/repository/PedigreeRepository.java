package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.PedigreeEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PedigreeRepository extends PagingAndSortingRepository<PedigreeEntity, String> {
	public PedigreeEntity findByGermplasm_Id(String germplasmDbId);
	public PedigreeEntity findByGermplasm_IdAndNotation(String germplasmDbId, String notation);
}
