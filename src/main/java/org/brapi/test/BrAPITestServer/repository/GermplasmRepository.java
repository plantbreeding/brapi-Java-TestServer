package org.brapi.test.BrAPITestServer.repository;

import java.util.List;

import org.brapi.test.BrAPITestServer.model.entity.GermplasmEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import io.swagger.model.Germplasm;
import io.swagger.model.GermplasmSearchRequest;

public interface GermplasmRepository extends PagingAndSortingRepository<GermplasmEntity, String>, GermplasmRepositoryCustom {

}
