package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.ImageEntity;
import org.brapi.test.BrAPITestServer.repository.core.BrAPIRepository;

public interface ImageRepository extends BrAPIRepository<ImageEntity, String>, ImageRepositoryCustom{

}
