package org.brapi.test.BrAPITestServer.repository;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.entity.MarkerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MarkerRepository extends PagingAndSortingRepository<MarkerEntity, String>{

	public Page<MarkerEntity> findAllByLinkageGroup_GenomeMapDbId(String mapDbId, Pageable pageRequest);
	public Page<MarkerEntity> findAllByLinkageGroup_GenomeMapDbIdAndLocationGreaterThanEqual(String mapDbId, Integer min, Pageable pageRequest);
	public Page<MarkerEntity> findAllByLinkageGroup_GenomeMapDbIdAndLocationLessThanEqual(String mapDbId, Integer max, Pageable pageRequest);
	public Page<MarkerEntity> findAllByLinkageGroup_GenomeMapDbIdAndLocationGreaterThanEqualAndLocationLessThanEqual(String mapDbId, Integer min, Integer max, Pageable pageRequest);

	public Page<MarkerEntity> findAllByLinkageGroup_GenomeMapDbIdAndLinkageGroup_LinkageGroupName(String mapDbId, String linkageGroupName, Pageable pageReq);
	public Page<MarkerEntity> findAllByLinkageGroup_GenomeMapDbIdAndLinkageGroup_LinkageGroupNameAndLocationGreaterThanEqual(String mapDbId, String linkageGroupName, Integer min, Pageable pageReq);
	public Page<MarkerEntity> findAllByLinkageGroup_GenomeMapDbIdAndLinkageGroup_LinkageGroupNameAndLocationLessThanEqual(String mapDbId, String linkageGroupName, Integer max, Pageable pageReq);
	public Page<MarkerEntity> findAllByLinkageGroup_GenomeMapDbIdAndLinkageGroup_LinkageGroupNameAndLocationGreaterThanEqualAndLocationLessThanEqual(String mapDbId, String linkageGroupName, Integer min, Integer max, Pageable pageReq);

	public Page<MarkerEntity> findAllByType(String type, Pageable pageRequest);
	
	public Page<MarkerEntity> findAllByIdIn(List<String> markerDbIds, Pageable pageRequest);

	public Page<MarkerEntity> findAllByMarkerNameOrSynonyms_Synonym(String markerName, String synonym, Pageable pageRequest);
	
	public Page<MarkerEntity> findAllByMarkerNameOrSynonyms_SynonymAndType(String markerName, String synonym, String type, Pageable pageRequest);
	
	public Page<MarkerEntity> findAllByMarkerNameLikeIgnoreCaseOrSynonyms_SynonymLikeIgnoreCase(String markerName, String synonym, Pageable pageRequest);
	
	public Page<MarkerEntity> findAllByMarkerNameLikeIgnoreCaseOrSynonyms_SynonymLikeIgnoreCaseAndType(String markerName, String synonym, String type, Pageable pageRequest);

}
