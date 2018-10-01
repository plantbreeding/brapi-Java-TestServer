package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.PlateEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PlateRepository extends PagingAndSortingRepository<PlateEntity, String> {

}
