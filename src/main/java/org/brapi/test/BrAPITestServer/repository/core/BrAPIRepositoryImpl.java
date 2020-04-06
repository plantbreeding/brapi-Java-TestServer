package org.brapi.test.BrAPITestServer.repository.core;

import java.io.Serializable;
import java.util.List;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class BrAPIRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
		implements BrAPIRepository<T, ID> {
	private EntityManager entityManager;

	public BrAPIRepositoryImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
	}

	public Page<T> findAllBySearch(SearchQueryBuilder<T> searchQuery, Pageable pageReq) {
		List<T> content = getPagedContent(searchQuery, pageReq);
		Long totalCount = getTotalCount(searchQuery);

		Page<T> page = new PageImpl<>(content, pageReq, totalCount);

		return page;
	}

	private List<T> getPagedContent(SearchQueryBuilder<T> searchQuery, Pageable pageReq) {
		TypedQuery<T> query = entityManager.createQuery(searchQuery.getQuery(), searchQuery.getClazz());

		for (Entry<String, Object> entry : searchQuery.getParams().entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}

		query.setFirstResult((int) pageReq.getOffset());
		query.setMaxResults(pageReq.getPageSize());

		List<T> content = query.getResultList();
		return content;
	}

	private Long getTotalCount(SearchQueryBuilder<T> searchQuery) {
		String countQueryStr = searchQuery.getQuery()
				.replaceFirst("(select|Select|SELECT)( distinct)? ([^\\s]*) ", "select count($2 $3) ")
				.replaceFirst("(order by|Order By|ORDER BY) .*", "");

		TypedQuery<Long> query = entityManager.createQuery(countQueryStr, Long.class);
		for (Entry<String, Object> entry : searchQuery.getParams().entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}

		List<Long> content = query.getResultList();
		if (content.size() > 0) {
			return content.get(0);
		}
		return 0L;
	}
}
