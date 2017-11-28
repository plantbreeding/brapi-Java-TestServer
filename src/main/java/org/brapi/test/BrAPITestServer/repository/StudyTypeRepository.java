package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.StudyTypeEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudyTypeRepository extends PagingAndSortingRepository<StudyTypeEntity, String> {

}
