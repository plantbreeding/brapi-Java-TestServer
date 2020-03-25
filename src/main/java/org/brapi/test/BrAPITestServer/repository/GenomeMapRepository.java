package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.GenomeMapEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GenomeMapRepository extends PagingAndSortingRepository<GenomeMapEntity, String>{
}
