package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.PlateEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VendorSampleRepository extends PagingAndSortingRepository<PlateEntity, String> {

}
