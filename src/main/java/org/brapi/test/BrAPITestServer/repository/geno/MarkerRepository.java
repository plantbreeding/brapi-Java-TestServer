package org.brapi.test.BrAPITestServer.repository.geno;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.brapi.test.BrAPITestServer.model.entity.geno.MarkerEntity;
import org.brapi.test.BrAPITestServer.repository.core.BrAPIRepository;

public interface MarkerRepository extends BrAPIRepository<MarkerEntity, String>{

	public Page<MarkerEntity> findAllByLinkageGroup_GenomeMapDbId(String mapDbId, Pageable pageRequest);
	public Page<MarkerEntity> findAllByLinkageGroup_GenomeMapDbIdAndLocationGreaterThanEqual(String mapDbId, Integer min, Pageable pageRequest);
	public Page<MarkerEntity> findAllByLinkageGroup_GenomeMapDbIdAndLocationLessThanEqual(String mapDbId, Integer max, Pageable pageRequest);
	public Page<MarkerEntity> findAllByLinkageGroup_GenomeMapDbIdAndLocationGreaterThanEqualAndLocationLessThanEqual(String mapDbId, Integer min, Integer max, Pageable pageRequest);

	public Page<MarkerEntity> findAllByLinkageGroup_GenomeMapDbIdAndLinkageGroup_LinkageGroupName(String mapDbId, String linkageGroupName, Pageable pageReq);
	public Page<MarkerEntity> findAllByLinkageGroup_GenomeMapDbIdAndLinkageGroup_LinkageGroupNameAndLocationGreaterThanEqual(String mapDbId, String linkageGroupName, Integer min, Pageable pageReq);
	public Page<MarkerEntity> findAllByLinkageGroup_GenomeMapDbIdAndLinkageGroup_LinkageGroupNameAndLocationLessThanEqual(String mapDbId, String linkageGroupName, Integer max, Pageable pageReq);
	public Page<MarkerEntity> findAllByLinkageGroup_GenomeMapDbIdAndLinkageGroup_LinkageGroupNameAndLocationGreaterThanEqualAndLocationLessThanEqual(String mapDbId, String linkageGroupName, Integer min, Integer max, Pageable pageReq);

}
