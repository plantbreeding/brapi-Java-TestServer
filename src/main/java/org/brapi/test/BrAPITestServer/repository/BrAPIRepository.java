package org.brapi.test.BrAPITestServer.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BrAPIRepository<T extends BrAPIPrimaryEntity, ID extends Serializable> extends JpaRepository<T, ID> {

	public Page<T> findAllBySearch(SearchQueryBuilder<T> searchQuery, Pageable pageReq);

	public Optional<T> findById(ID id);

	public <S extends T> S save(S entity);

	public <S extends T> List<S> saveAll(Iterable<S> entities);
	
	public <S extends T> void refresh(S entity);

	public void fetchXrefs(Page<T> page, Class<T> searchClass);
}