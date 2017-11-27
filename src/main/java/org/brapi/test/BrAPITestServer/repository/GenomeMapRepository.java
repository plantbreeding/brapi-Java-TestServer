package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.GenomeMapEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GenomeMapRepository extends PagingAndSortingRepository<GenomeMapEntity, String>{
	public Page<GenomeMapEntity> findBySpeciesAndType(String species, String type, Pageable pageReq);

	public Page<GenomeMapEntity> findByType(String type, Pageable pageRequest);

	public Page<GenomeMapEntity> findBySpecies(String speciesId, Pageable pageRequest); 
}
