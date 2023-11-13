package org.brapi.test.BrAPITestServer.repository;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;
import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;
import org.brapi.test.BrAPITestServer.model.entity.ExternalReferenceEntity;
import org.brapi.test.BrAPITestServer.service.SearchQueryBuilder;
import org.hibernate.jpa.QueryHints;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class BrAPIRepositoryImpl<T extends BrAPIPrimaryEntity, ID extends Serializable>
		extends SimpleJpaRepository<T, ID> implements BrAPIRepository<T, ID> {
	private EntityManager entityManager;

	public BrAPIRepositoryImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
	}

	public Page<T> findAllBySearch(SearchQueryBuilder<T> searchQuery, Pageable pageReq) {
		searchQuery = applyUserId(searchQuery);
		List<T> content = getPagedContent(searchQuery, pageReq);
		Long totalCount = getTotalCount(searchQuery);

		Page<T> page = new PageImpl<>(content, pageReq, totalCount);

		return page;
	}

	public Optional<T> findById(ID id) {
		Optional<T> response = super.findById(id);
		if (response.isPresent()) {
			String userId = getCurrentUserId();
			if (!(null == response.get().getAuthUserId()
					|| userId.equals(response.get().getAuthUserId())
					|| "anonymousUser".equals(response.get().getAuthUserId()))) {
				response = Optional.empty();
			}
		}
		return response;
	}

	public <S extends T> S save(S entity) {
		entity.setAuthUserId(getCurrentUserId());
		return super.save(entity);
	}

	public <S extends T> List<S> saveAll(Iterable<S> entities) {
		for (S entity : entities) {
			entity.setAuthUserId(getCurrentUserId());
		}
		return super.saveAll(entities);
	}
	
	public <S extends T> void refresh(S entity) {
		this.entityManager.refresh(entity);
	}

	public void fetchXrefs(Page<T> page, Class<T> searchClass) {
		SearchQueryBuilder<T> searchQuery = new SearchQueryBuilder<T>(searchClass);
		searchQuery.leftJoinFetch("externalReferences", "externalReferences")
				   .appendList(page.stream().map(BrAPIBaseEntity::getId).collect(Collectors.toList()), "id");

		Page<T> xrefs = findAllBySearch(searchQuery, PageRequest.of(0, page.getSize()));

		Map<String, List<ExternalReferenceEntity>> xrefByEntity = new HashMap<>();
		xrefs.forEach(entity -> xrefByEntity.put(entity.getId(), entity.getExternalReferences()));

		page.forEach(entity -> entity.setExternalReferences(xrefByEntity.get(entity.getId())));
	}

	private String getCurrentUserId() {
		SecurityContext context = SecurityContextHolder.getContext();
		String userId = "";
		if (context.getAuthentication().getPrincipal() != null) {
			userId = context.getAuthentication().getPrincipal().toString();
		}
		return userId;
	}

	private SearchQueryBuilder<T> applyUserId(SearchQueryBuilder<T> searchQuery) {

		SecurityContext context = SecurityContextHolder.getContext();
		Set<String> userRolesSet = context.getAuthentication().getAuthorities().stream()
				.map(auth -> auth.getAuthority()).collect(Collectors.toSet());

		List<String> userIds = new ArrayList<>();
		userIds.add(getCurrentUserId());
		if (userRolesSet.contains("ROLE_ADMIN")) {
			return searchQuery;
		} else if (userRolesSet.contains("ROLE_USER")) {
			userIds.add("anonymousUser");
		}

		searchQuery.appendList(userIds, "authUserId");

		return searchQuery;
	}

	private List<T> getPagedContent(SearchQueryBuilder<T> searchQuery, Pageable pageReq) {
		TypedQuery<T> query = entityManager.createQuery(searchQuery.getQuery(), searchQuery.getClazz());
		query.setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false);

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
			    .replaceAll("LEFT JOIN FETCH", "LEFT JOIN")
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
