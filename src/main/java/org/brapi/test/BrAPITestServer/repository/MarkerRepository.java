package org.brapi.test.BrAPITestServer.repository;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.entity.MarkerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MarkerRepository extends PagingAndSortingRepository<MarkerEntity, String>{
	public Page<MarkerEntity> findAllByLinkageGroup_IdAndLinkageGroup_GenomeMapDbId(String linkageGroupDbId, String mapDbId, Pageable pageReq);

	public Page<MarkerEntity> findAllByLinkageGroup_GenomeMapDbId(String mapDbId, Pageable pageRequest);

	public Page<MarkerEntity> findAllByType(String type, Pageable pageRequest);
	
	public Page<MarkerEntity> findAllByIdIn(List<String> markerDbIds, Pageable pageRequest);

	public Page<MarkerEntity> findAllByMarkerNameOrSynonyms_Synonym(String markerName, String synonym, Pageable pageRequest);
	
	public Page<MarkerEntity> findAllByMarkerNameOrSynonyms_SynonymAndType(String markerName, String synonym, String type, Pageable pageRequest);
	
	public Page<MarkerEntity> findAllByMarkerNameLikeIgnoreCaseOrSynonyms_SynonymLikeIgnoreCase(String markerName, String synonym, Pageable pageRequest);
	
	public Page<MarkerEntity> findAllByMarkerNameLikeIgnoreCaseOrSynonyms_SynonymLikeIgnoreCaseAndType(String markerName, String synonym, String type, Pageable pageRequest);

}
