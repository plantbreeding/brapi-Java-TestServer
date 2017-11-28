package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.ProgramEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProgramRepository extends PagingAndSortingRepository<ProgramEntity, String>{
	public Page<ProgramEntity> findAllByName(String name, Pageable pageReq);
	public Page<ProgramEntity> findAllByAbbreviation(String abbreviation, Pageable pageReq);
	public Page<ProgramEntity> findAllByNameAndAbbreviation(String name, String abbreviation, Pageable pageReq);
	
	public long countByName(String name);
	public long countByAbbreviation(String abbreviation);
	public long countByNameAndAbbreviation(String name, String abbreviation);
}
