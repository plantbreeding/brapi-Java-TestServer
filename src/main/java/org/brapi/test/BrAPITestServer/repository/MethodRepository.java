package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.MethodEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MethodRepository extends PagingAndSortingRepository<MethodEntity, String> {

}
