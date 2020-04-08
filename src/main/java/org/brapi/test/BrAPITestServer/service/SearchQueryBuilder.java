package org.brapi.test.BrAPITestServer.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.threeten.bp.OffsetDateTime;

import io.swagger.model.GeoJSONSearchArea;
import io.swagger.model.core.SortOrder;

public class SearchQueryBuilder<T> {
	public static final String LIST_ENTITY = "ListEntity";
	public static final String LOCATION_ENTITY = "LocationEntity";

	private String query;
	private Map<String, Object> params;
	private Class<T> clazz;

	public SearchQueryBuilder(Class<T> clazz) {
		this.query = "SELECT entity FROM " + clazz.getSimpleName() + " entity where 1=1 ";
		this.params = new HashMap<>();
		this.clazz = clazz;
	}

	public String getQuery() {
		return query;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public Class<T> getClazz() {
		return clazz;
	}

	public SearchQueryBuilder<T> appendList(List<String> list, String columnName) {
		if (list != null && !list.isEmpty()) {
			this.query += "AND " + entityPrefix(columnName) + " in :" + columnName + " ";
			this.params.put(columnName, list);
		}
		return this;
	}

	public SearchQueryBuilder<T> appendSingle(Boolean single, String columnName) {
		if (single != null) {
			this.query += "AND " + entityPrefix(columnName) + " = :" + columnName + " ";
			this.params.put(columnName, single);
		}
		return this;
	}

	public SearchQueryBuilder<T> appendSingle(Integer single, String columnName) {
		if (single != null) {
			this.query += "AND " + entityPrefix(columnName) + " = :" + columnName + " ";
			this.params.put(columnName, single);
		}
		return this;
	}

	public SearchQueryBuilder<T> appendSingle(String single, String columnName) {
		if (single != null && !single.isEmpty()) {
			this.query += "AND " + entityPrefix(columnName) + " = :" + columnName + " ";
			this.params.put(columnName, single);
		}
		return this;
	}

	public <E extends Enum<E>> SearchQueryBuilder<T> appendEnum(E enumVal, String columnName) {
		if (enumVal != null) {
			this.query += "AND " + entityPrefix(columnName) + " = :" + columnName + " ";
			this.params.put(columnName, enumVal);
		}
		return this;
	}

	public SearchQueryBuilder<T> appendDateRange(OffsetDateTime start, OffsetDateTime end, String columnName) {
		if (start != null && end != null) {
			query += "AND " + entityPrefix(columnName) + " BETWEEN :" + columnName + "Start AND :" + columnName + "End ";
			params.put(columnName + "Start", start);
			params.put(columnName + "End", end);
		} else if (start != null) {
			query += "AND " + entityPrefix(columnName) + " >= :" + columnName + "Start ";
			params.put(columnName + "Start", start);
		} else if (end != null) {
			query += "AND " + entityPrefix(columnName) + " <= :" + columnName + "End ";
			params.put(columnName + "End", end);
		}
		return this;
	}

	public SearchQueryBuilder<T> appendNumberRange(BigDecimal min, BigDecimal max, String columnName) {
		if (min != null && max != null) {
			query += "AND " + entityPrefix(columnName) + " BETWEEN :" + columnName + "Min AND :" + columnName + "Max ";
			params.put(columnName + "Min", min);
			params.put(columnName + "Max", max);
		} else if (min != null) {
			query += "AND " + entityPrefix(columnName) + " >= :" + columnName + "Min ";
			params.put(columnName + "Min", min);
		} else if (max != null) {
			query += "AND " + entityPrefix(columnName) + " <= :" + columnName + "Max ";
			params.put(columnName + "Max", max);
		}
		return this;
	}

	public SearchQueryBuilder<T> appendGeoJSONArea(GeoJSONSearchArea area) {
		// if (single != null && !single.isEmpty()) {
		// this.query += "AND " + entityPrefix(columnName) + " = :" + columnName + " ";
		// this.params.put(columnName, single);
		// }
		return this;
	}

	public SearchQueryBuilder<T> withExRefs(List<String> exRefIds, List<String> exRefSources) {
		if (exRefIds != null && !exRefIds.isEmpty()) {
			this.query += "AND entity.externalReferences.externalReferenceId in :externalReferenceId ";
			this.params.put("externalReferenceId", exRefIds);
		}
		if (exRefSources != null && !exRefSources.isEmpty()) {
			this.query += "AND entity.externalReferences.externalReferenceSource in :externalReferenceSource ";
			this.params.put("externalReferenceSource", exRefSources);
		}
		return this;
	}

	public SearchQueryBuilder<T> join(String join, String name) {
		this.query = query.replaceAll("where", "JOIN " + entityPrefix(join) + " " + name + " where");
		return this;
	}
	
	private String entityPrefix(String field) {
		if(field.startsWith("*")) {
			return field.substring(1);
		}else {
			return "entity." + field;
		}
	}

	public SearchQueryBuilder<T> withSort(String sortByStr, SortOrder sortOrder) {
		String sortOrderStr = "ASC";
		if(sortOrder != null) {
			sortOrderStr = sortOrder.toString();
		}
		
		this.query += " ORDER BY " + entityPrefix(sortByStr) + " " + sortOrderStr;
		
		return this;
	}
}
