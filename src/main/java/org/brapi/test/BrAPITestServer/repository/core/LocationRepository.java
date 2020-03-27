package org.brapi.test.BrAPITestServer.repository.core;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.brapi.test.BrAPITestServer.model.entity.core.LocationEntity;
import org.brapi.test.BrAPITestServer.repository.core.BrAPIRepository;

public interface LocationRepository extends BrAPIRepository<LocationEntity, String>{
}
