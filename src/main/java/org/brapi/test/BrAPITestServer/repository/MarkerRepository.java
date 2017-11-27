package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.MarkerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface MarkerRepository extends PagingAndSortingRepository<MarkerEntity, String>{
	public Page<MarkerEntity> findAllByLinkageGroup_IdAndLinkageGroup_GenomeMapDbId(String linkageGroupDbId, String mapDbId, Pageable pageReq);

	public Page<MarkerEntity> findAllByLinkageGroup_GenomeMapDbId(String mapDbId, Pageable pageRequest);

	public Page<MarkerEntity> findAllByType(String type, Pageable pageRequest);
	public long countByType(String type);

	public Page<MarkerEntity> findAllByMarkerNameOrSynonyms_Synonym(String markerName, String synonym, Pageable pageRequest);
	public long countByMarkerNameOrSynonyms_Synonym(String markerName, String synonym);
	
	public Page<MarkerEntity> findAllByMarkerNameOrSynonyms_SynonymAndType(String markerName, String synonym, String type, Pageable pageRequest);
	public long countByMarkerNameOrSynonyms_SynonymAndType(String markerName, String synonym, String type);
	
	public Page<MarkerEntity> findAllByMarkerNameLikeIgnoreCaseOrSynonyms_SynonymLikeIgnoreCase(String markerName, String synonym, Pageable pageRequest);
	public long countByMarkerNameLikeIgnoreCaseOrSynonyms_SynonymLikeIgnoreCase(String markerName, String synonym);
	
	public Page<MarkerEntity> findAllByMarkerNameLikeIgnoreCaseOrSynonyms_SynonymLikeIgnoreCaseAndType(String markerName, String synonym, String type, Pageable pageRequest);
	public long countByMarkerNameLikeIgnoreCaseOrSynonyms_SynonymLikeIgnoreCaseAndType(String markerName, String synonym, String type);

}
