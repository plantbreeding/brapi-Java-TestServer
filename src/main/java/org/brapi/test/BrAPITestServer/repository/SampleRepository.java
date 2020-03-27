package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.SampleEntity;
import org.brapi.test.BrAPITestServer.repository.core.BrAPIRepository;

public interface SampleRepository extends BrAPIRepository<SampleEntity, String>, SampleRepositoryCustom {

}
