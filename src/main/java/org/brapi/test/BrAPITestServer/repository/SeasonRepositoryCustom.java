package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.SeasonEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.brapi.test.BrAPITestServer.repository.core.BrAPIRepository;

public interface SeasonRepositoryCustom {
	public Page<SeasonEntity> findBySearch(String seasonDbId, String season, Integer year, Pageable pageReq);
	
}
