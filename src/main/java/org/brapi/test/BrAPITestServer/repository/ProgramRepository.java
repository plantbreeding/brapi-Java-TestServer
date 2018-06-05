package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.ProgramEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ProgramRepository extends PagingAndSortingRepository<ProgramEntity, String>{
	@Query("select p from ProgramEntity p "
			+ "where (:abbreviation is null OR p.abbreviation = :abbreviation) "
			+ "and (:leadPerson is null OR p.leadPerson = :leadPerson) "
			+ "and (:name is null OR p.name = :name) "
			+ "and (:objective is null OR p.objective = :objective) "
			+ "and (:programDbId is null OR p.id = :programDbId) ")
	public Page<ProgramEntity> findAllBySearch(
			@Param("abbreviation") String abbreviation, 
			@Param("leadPerson") String leadPerson, 
			@Param("name") String name, 
			@Param("objective") String objective,
			@Param("programDbId") String programDbId, Pageable pageReq);
}
