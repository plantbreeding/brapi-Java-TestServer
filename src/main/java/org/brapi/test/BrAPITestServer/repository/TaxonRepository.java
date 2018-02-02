package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.TaxonEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TaxonRepository extends PagingAndSortingRepository<TaxonEntity, String> {

}
