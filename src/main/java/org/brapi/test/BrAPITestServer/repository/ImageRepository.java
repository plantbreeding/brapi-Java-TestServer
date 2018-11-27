package org.brapi.test.BrAPITestServer.repository;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.entity.ImageEntity;
import org.brapi.test.BrAPITestServer.model.entity.StudyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ImageRepository extends PagingAndSortingRepository<ImageEntity, String>, ImageRepositoryCustom{

}
