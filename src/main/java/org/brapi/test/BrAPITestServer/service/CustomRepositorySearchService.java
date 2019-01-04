package org.brapi.test.BrAPITestServer.service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomRepositorySearchService<ResponseEntityType> {

	public Page<ResponseEntityType> findAllBySearch(String queryStr, Map<String, Object> params, Pageable pageReq,
			Class<ResponseEntityType> returnClass, EntityManager em) {
		CustomRepositorySearchContext<ResponseEntityType> context = new CustomRepositorySearchContext<ResponseEntityType>(
				queryStr, params, returnClass, em, pageReq);

		List<ResponseEntityType> content = getPagedContent(context);
		Long totalCount = getTotalCount(context);

		Page<ResponseEntityType> page = new PageImpl<>(content, context.getPageReq(), totalCount);

		return page;
	}

	private List<ResponseEntityType> getPagedContent(CustomRepositorySearchContext<ResponseEntityType> context) {
		TypedQuery<ResponseEntityType> query = context.getEm().createQuery(context.getQueryStr(),
				context.getReturnClass());
		for (Entry<String, Object> entry : context.getParams().entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}

		query.setFirstResult((int) context.getPageReq().getOffset());
		query.setMaxResults(context.getPageReq().getPageSize());

		List<ResponseEntityType> content = query.getResultList();
		return content;
	}

	private Long getTotalCount(CustomRepositorySearchContext<ResponseEntityType> context) {
		String queryStr = context.getQueryStr();
		queryStr = queryStr.replaceFirst("(select|Select|SELECT) ([^\\s]*) ", "select count($2) ");
		
		TypedQuery<Long> query = context.getEm().createQuery(queryStr, Long.class);
		for (Entry<String, Object> entry : context.getParams().entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}

		List<Long> content = query.getResultList();
		if (content.size() > 0) {
			return content.get(0);
		}
		return 0L;
	}

	class CustomRepositorySearchContext<ResponseEntityType2> {
		private String queryStr;
		private Map<String, Object> params;
		private Class<ResponseEntityType2> returnClass;
		private EntityManager em;
		private Pageable pageReq;

		public CustomRepositorySearchContext(String queryStr, Map<String, Object> params,
				Class<ResponseEntityType2> returnClass, EntityManager em, Pageable pageReq) {
			super();
			this.queryStr = queryStr;
			this.params = params;
			this.returnClass = returnClass;
			this.em = em;
			this.pageReq = pageReq;
		}

		public Pageable getPageReq() {
			return pageReq;
		}

		public void setPageReq(Pageable pageReq) {
			this.pageReq = pageReq;
		}

		public String getQueryStr() {
			return queryStr;
		}

		public void setQueryStr(String queryStr) {
			this.queryStr = queryStr;
		}

		public Map<String, Object> getParams() {
			return params;
		}

		public void setParams(Map<String, Object> params) {
			this.params = params;
		}

		public Class<ResponseEntityType2> getReturnClass() {
			return returnClass;
		}

		public void setReturnClass(Class<ResponseEntityType2> returnClass) {
			this.returnClass = returnClass;
		}

		public EntityManager getEm() {
			return em;
		}

		public void setEm(EntityManager em) {
			this.em = em;
		}
	}
}
