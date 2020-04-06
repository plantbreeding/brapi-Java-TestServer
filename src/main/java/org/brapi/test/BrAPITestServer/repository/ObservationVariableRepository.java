package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.ObservationVariableEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.brapi.test.BrAPITestServer.repository.core.BrAPIRepository;
import org.springframework.data.repository.query.Param;

public interface ObservationVariableRepository extends BrAPIRepository<ObservationVariableEntity, String>{
}
