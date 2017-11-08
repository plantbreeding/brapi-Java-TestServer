package org.brapi.test.BrAPITestServer.repository;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.entity.CallDataTypeEntity;
import org.brapi.test.BrAPITestServer.model.entity.CallEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CallRepository extends PagingAndSortingRepository<CallEntity, String>{
	
	Page<CallEntity> findByDataTypes_DataType(String dataType, Pageable page);
	long countByDataTypes_DataType(String dataType);
}
