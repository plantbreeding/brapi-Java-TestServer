package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.SeasonEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SeasonRepository extends PagingAndSortingRepository<SeasonEntity, String>{
	public Page<SeasonEntity> findAllByYear(int year, Pageable pageReq);
	public Page<SeasonEntity> findAllByYearAndSeason(int year, String season, Pageable pageReq);
	
}
