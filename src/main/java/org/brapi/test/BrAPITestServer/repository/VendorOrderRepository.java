package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.vendor.VendorOrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.brapi.test.BrAPITestServer.repository.core.BrAPIRepository;

public interface VendorOrderRepository extends BrAPIRepository<VendorOrderEntity, String> {
	public Page<VendorOrderEntity> findByPlateSubmission_Id(String submissionId, Pageable pageReq);
}
