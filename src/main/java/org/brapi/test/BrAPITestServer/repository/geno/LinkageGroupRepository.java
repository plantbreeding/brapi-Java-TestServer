package org.brapi.test.BrAPITestServer.repository.geno;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.brapi.test.BrAPITestServer.model.entity.geno.LinkageGroupEntity;
import org.brapi.test.BrAPITestServer.repository.core.BrAPIRepository;

public interface LinkageGroupRepository extends BrAPIRepository<LinkageGroupEntity, String>{

	public Page<LinkageGroupEntity> findAllByGenomeMapDbId(String mapDbId, Pageable pageRequest);

}
