package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.LinkageGroupEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.brapi.test.BrAPITestServer.repository.core.BrAPIRepository;

public interface LinkageGroupRepository extends BrAPIRepository<LinkageGroupEntity, String>{

	public Page<LinkageGroupEntity> findAllByGenomeMapDbId(String mapDbId, Pageable pageRequest);

}
