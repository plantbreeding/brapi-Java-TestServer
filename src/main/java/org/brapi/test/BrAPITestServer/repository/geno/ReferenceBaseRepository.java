package org.brapi.test.BrAPITestServer.repository.geno;

import org.brapi.test.BrAPITestServer.model.entity.geno.ReferenceBasesPageEntity;
import org.brapi.test.BrAPITestServer.repository.BrAPIRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReferenceBaseRepository extends BrAPIRepository<ReferenceBasesPageEntity, String>  {
	public Page<ReferenceBasesPageEntity> findByReferenceIdAndPageNumber(String referenceId, int pageNumber, Pageable pageReq);
}
