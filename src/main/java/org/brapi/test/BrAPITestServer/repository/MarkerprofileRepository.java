package org.brapi.test.BrAPITestServer.repository;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.entity.MarkerprofileEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MarkerprofileRepository extends PagingAndSortingRepository<MarkerprofileEntity, String>{
	public List<MarkerprofileEntity> findByGermplasmDbId(String germplasmDbId);
}
