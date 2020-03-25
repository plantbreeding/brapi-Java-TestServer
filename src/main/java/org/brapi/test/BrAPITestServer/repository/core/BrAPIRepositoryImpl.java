package org.brapi.test.BrAPITestServer.repository.core;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public class BrAPIRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
		implements BrAPIRepository<T, ID> {
	private EntityManager entityManager;

	public BrAPIRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
		this.entityManager = entityManager;
	}

	public Page<T> findAllBySearch(String queryStr, Map<String, Object> params, Pageable pageReq,
			Class<T> returnClass) {
		List<T> content = getPagedContent(queryStr, params, pageReq, returnClass);
		Long totalCount = getTotalCount(queryStr, params);

		Page<T> page = new PageImpl<>(content, pageReq, totalCount);

		return page;
	}

	private List<T> getPagedContent(String queryStr, Map<String, Object> params, Pageable pageReq,
			Class<T> returnClass) {
		TypedQuery<T> query = entityManager.createQuery(queryStr, returnClass);

		for (Entry<String, Object> entry : params.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}

		query.setFirstResult((int) pageReq.getOffset());
		query.setMaxResults(pageReq.getPageSize());

		List<T> content = query.getResultList();
		return content;
	}

	private Long getTotalCount(final String queryStr, Map<String, Object> params) {
		String countQueryStr = queryStr
				.replaceFirst("(select|Select|SELECT)( distinct)? ([^\\s]*) ", "select count($2 $3) ")
				.replaceFirst("(order by|Order By|ORDER BY) .*", "");

		TypedQuery<Long> query = entityManager.createQuery(countQueryStr, Long.class);
		for (Entry<String, Object> entry : params.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}

		List<Long> content = query.getResultList();
		if (content.size() > 0) {
			return content.get(0);
		}
		return 0L;
	}
}
