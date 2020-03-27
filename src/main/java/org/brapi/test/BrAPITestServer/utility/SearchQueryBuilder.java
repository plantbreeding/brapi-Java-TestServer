package org.brapi.test.BrAPITestServer.utility;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.threeten.bp.OffsetDateTime;

import io.swagger.model.common.GeoJSONSearchArea;

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
			this.query += "AND entity." + columnName + " in :" + columnName + " ";
			this.params.put(columnName, list);
		}
		return this;
	}

	public SearchQueryBuilder<T> appendSingle(String single, String columnName) {
		if (single != null && !single.isEmpty()) {
			this.query += "AND entity." + columnName + " = :" + columnName + " ";
			this.params.put(columnName, single);
		}
		return this;
	}

	public <E extends Enum<E>> SearchQueryBuilder<T> appendEnum(E enumVal, String columnName) {
		if (enumVal != null) {
			this.query += "AND entity." + columnName + " = :" + columnName + " ";
			this.params.put(columnName, enumVal);
		}
		return this;
	}

	public SearchQueryBuilder<T> appendDateRange(OffsetDateTime start, OffsetDateTime end, String columnName) {
		if (start != null && end != null) {
			query += "AND entity." + columnName + " BETWEEN :" + columnName + "Start AND :" + columnName + "End ";
			params.put(columnName + "Start", start);
			params.put(columnName + "End", end);
		} else if (start != null) {
			query += "AND entity." + columnName + " >= :" + columnName + "Start ";
			params.put(columnName + "Start", start);
		} else if (end != null) {
			query += "AND entity." + columnName + " <= :" + columnName + "End ";
			params.put(columnName + "End", end);
		}
		return this;
	}

	public SearchQueryBuilder<T> appendNumberRange(BigDecimal min, BigDecimal max, String columnName) {
		if (min != null && max != null) {
			query += "AND entity." + columnName + " BETWEEN :" + columnName + "Min AND :" + columnName + "Max ";
			params.put(columnName + "Min", min);
			params.put(columnName + "Max", max);
		} else if (min != null) {
			query += "AND entity." + columnName + " >= :" + columnName + "Min ";
			params.put(columnName + "Min", min);
		} else if (max != null) {
			query += "AND entity." + columnName + " <= :" + columnName + "Max ";
			params.put(columnName + "Max", max);
		}
		return this;
	}

	public SearchQueryBuilder<T> appendGeoJSONArea(GeoJSONSearchArea area) {
//		if (single != null && !single.isEmpty()) {
//			this.query += "AND entity." + columnName + " = :" + columnName + " ";
//			this.params.put(columnName, single);
//		}
		return this;
	}


	public SearchQueryBuilder<T> withExRefs(List<String> exRefIds, List<String> exRefSources) {
		if (exRefIds != null && !exRefIds.isEmpty()) {
			this.query += "AND externalrefernceid in :externalrefernceid ";
			this.params.put("externalrefernceid", exRefIds);
		}
		if (exRefSources != null && !exRefSources.isEmpty()) {
			this.query += "AND externalreferncesource in :externalreferncesource ";
			this.params.put("externalreferncesource", exRefSources);
		}
		return this;
	}
	


	private String prepParam(String param, boolean fuzzySearch) {
		if (param == null) {
			return "";
		} else {
			if (fuzzySearch) {
				return "%" + param + "%";
			} else {
				return param;
			}
		}
	}

}
