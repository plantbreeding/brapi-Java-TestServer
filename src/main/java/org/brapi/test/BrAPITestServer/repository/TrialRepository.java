package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.TrialEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TrialRepository extends PagingAndSortingRepository<TrialEntity, String> {

}
