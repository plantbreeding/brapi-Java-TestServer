package org.brapi.test.BrAPITestServer.repository.core;

import org.brapi.test.BrAPITestServer.model.entity.ProgramEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProgramRepository extends PagingAndSortingRepository<ProgramEntity, String>, ProgramRepositoryCustom{

}
