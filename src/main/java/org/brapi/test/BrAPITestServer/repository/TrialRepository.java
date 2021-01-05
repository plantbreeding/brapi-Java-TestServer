package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.TrialEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface TrialRepository extends PagingAndSortingRepository<TrialEntity, String> {

	@Query("select t from TrialEntity t left join t.studies s "
			+ "where ('' = :programDbId OR t.program.id = :programDbId) "
			+ "AND ('' = :commonCropName OR t.program.crop.cropName = :commonCropName) "
			+ "AND ('' = :locationDbId OR :locationDbId IN s.location.id) "
			+ "AND (:applyActiveFilter = false OR :active = t.active)")
	Page<TrialEntity> findBySearch(
			@Param("commonCropName") String commonCropName,
			@Param("programDbId") String programDbId, 
			@Param("locationDbId") String locationDbId, 
			@Param("applyActiveFilter") boolean applyActiveFilter, 
			@Param("active") boolean active, Pageable pageReq);

}
