package org.brapi.test.BrAPITestServer.model.entity;

import java.util.List;

public class GermplasmAttribute {
	private String attributeCategoryDbId;
	private String code;
	private String uri;
	private String name;
	private String description;
	private String datatype;
	private List<String> values;
	public String getAttributeCategoryDbId() {
		return attributeCategoryDbId;
	}
	public void setAttributeCategoryDbId(String attributeCategoryDbId) {
		this.attributeCategoryDbId = attributeCategoryDbId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDatatype() {
		return datatype;
	}
	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}
	public List<String> getValues() {
		return values;
	}
	public void setValues(List<String> values) {
		this.values = values;
	}
}
