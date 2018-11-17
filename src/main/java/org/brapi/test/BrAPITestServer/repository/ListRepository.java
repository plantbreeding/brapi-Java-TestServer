package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.ListEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import io.swagger.model.ListTypes;

public interface ListRepository extends PagingAndSortingRepository<ListEntity, String>{

	@Query("select list from ListEntity list "
			+ "where ('' = :listDbId OR list.id = :listDbId) "
			+ "AND ('' = :listName OR list.listName LIKE :listName) "
			+ "AND ('' = :listSource OR list.listSource LIKE :listSource) ")
	Page<ListEntity> findBySearch(
			@Param("listName") String listName,
			@Param("listDbId") String listDbId,
			@Param("listSource") String listSource, Pageable pageReq);
	

	@Query("select list from ListEntity list "
			+ "where ('' = :listType OR list.listType = :listType) "
			+ "AND ('' = :listDbId OR list.id = :listDbId) "
			+ "AND ('' = :listName OR list.listName LIKE :listName) "
			+ "AND ('' = :listSource OR list.listSource LIKE :listSource) ")
	Page<ListEntity> findBySearch(
			@Param("listType") ListTypes listType,
			@Param("listName") String listName,
			@Param("listDbId") String listDbId,
			@Param("listSource") String listSource, Pageable pageReq);
}
