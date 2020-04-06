package org.brapi.test.BrAPITestServer.repository.geno;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.brapi.test.BrAPITestServer.model.entity.geno.AlleleEntity;
import org.brapi.test.BrAPITestServer.repository.core.BrAPIRepository;

public interface AlleleRepository extends BrAPIRepository<AlleleEntity, String>{
	public Page<AlleleEntity> findAllByMarkerProfile_Id(String markerProfileDbIds, Pageable pageReq);
	public Page<AlleleEntity> findAllByMarkerProfile_IdIn(List<String> markerProfileDbIds, Pageable pageReq);
	public Page<AlleleEntity> findAllByMarker_IdIn(List<String> markerDbIds, Pageable pageReq);
	public Page<AlleleEntity> findAllByMatrix_IdIn(List<String> matrixDbIds, Pageable pageReq);
}
