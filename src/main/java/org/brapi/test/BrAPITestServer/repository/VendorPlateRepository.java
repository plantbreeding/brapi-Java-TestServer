package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.vendor.VendorPlateSubmissionEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VendorPlateRepository extends PagingAndSortingRepository<VendorPlateSubmissionEntity, String> {

}
