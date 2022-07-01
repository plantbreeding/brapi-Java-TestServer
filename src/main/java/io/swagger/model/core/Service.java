package io.swagger.model.core;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.model.WSMIMEDataTypes;

import java.util.ArrayList;
import java.util.List;

public class Service {

	public enum MethodsEnum {
		GET("GET"),

		POST("POST"),

		PUT("PUT"),

		DELETE("DELETE");

		@JsonCreator
		public static MethodsEnum fromValue(String text) {
			for (MethodsEnum b : MethodsEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}

		private String value;

		MethodsEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}
	}

	public enum VersionsEnum {
		V20("2.0"),

		V21("2.1"),

		V22("2.2");

		@JsonCreator
		public static VersionsEnum fromValue(String text) {
			for (VersionsEnum b : VersionsEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}

		private String value;

		VersionsEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}
	}

	@JsonProperty("dataTypes")
	private List<WSMIMEDataTypes> dataTypes = null;

	@JsonProperty("contentTypes")
	private List<WSMIMEDataTypes> contentTypes = null;

	@JsonProperty("methods")
	private List<MethodsEnum> methods = new ArrayList<MethodsEnum>();

	@JsonProperty("service")
	private String service = null;

	@JsonProperty("versions")
	private List<VersionsEnum> versions = new ArrayList<VersionsEnum>();

	public Service addDataTypesItem(WSMIMEDataTypes dataTypesItem) {
		if (this.dataTypes == null) {
			this.dataTypes = new ArrayList<WSMIMEDataTypes>();
		}
		if (this.contentTypes == null) {
			this.contentTypes = new ArrayList<WSMIMEDataTypes>();
		}
		this.dataTypes.add(dataTypesItem);
		this.contentTypes.add(dataTypesItem);
		return this;
	}

	public Service addContentTypesItem(WSMIMEDataTypes contentTypesItem) {
		if (this.dataTypes == null) {
			this.dataTypes = new ArrayList<WSMIMEDataTypes>();
		}
		if (this.contentTypes == null) {
			this.contentTypes = new ArrayList<WSMIMEDataTypes>();
		}
		this.dataTypes.add(contentTypesItem);
		this.contentTypes.add(contentTypesItem);
		return this;
	}

	public Service addMethodsItem(MethodsEnum methodsItem) {
		this.methods.add(methodsItem);
		return this;
	}

	public Service addVersionsItem(VersionsEnum versionsItem) {
		this.versions.add(versionsItem);
		return this;
	}

	public Service dataTypes(List<WSMIMEDataTypes> dataTypes) {
		this.dataTypes = dataTypes;
		this.contentTypes = dataTypes;
		return this;
	}

	public Service contentTypes(List<WSMIMEDataTypes> contentTypes) {
		this.dataTypes = contentTypes;
		this.contentTypes = contentTypes;
		return this;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Service service = (Service) o;
		return Objects.equals(this.dataTypes, service.dataTypes)
				&& Objects.equals(this.contentTypes, service.contentTypes)
				&& Objects.equals(this.methods, service.methods) && Objects.equals(this.service, service.service)
				&& Objects.equals(this.versions, service.versions);
	}

	public List<WSMIMEDataTypes> getDataTypes() {
		return dataTypes;
	}

	public List<WSMIMEDataTypes> getContentTypes() {
		return contentTypes;
	}

	public List<MethodsEnum> getMethods() {
		return methods;
	}

	public String getService() {
		return service;
	}

	public List<VersionsEnum> getVersions() {
		return versions;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataTypes, contentTypes, methods, service, versions);
	}

	public Service methods(List<MethodsEnum> methods) {
		this.methods = methods;
		return this;
	}

	public Service service(String service) {
		this.service = service;
		return this;
	}

	public void setDataTypes(List<WSMIMEDataTypes> dataTypes) {
		this.dataTypes = dataTypes;
		this.contentTypes = dataTypes;
	}

	public void setContentTypes(List<WSMIMEDataTypes> contentTypes) {
		this.dataTypes = contentTypes;
		this.contentTypes = contentTypes;
	}

	public void setMethods(List<MethodsEnum> methods) {
		this.methods = methods;
	}

	public void setService(String service) {
		this.service = service;
	}

	public void setVersions(List<VersionsEnum> versions) {
		this.versions = versions;
	}

	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Service {\n");

		sb.append("    dataTypes: ").append(toIndentedString(dataTypes)).append("\n");
		sb.append("    contentTypes: ").append(toIndentedString(contentTypes)).append("\n");
		sb.append("    methods: ").append(toIndentedString(methods)).append("\n");
		sb.append("    service: ").append(toIndentedString(service)).append("\n");
		sb.append("    versions: ").append(toIndentedString(versions)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	public Service versions(List<VersionsEnum> versions) {
		this.versions = versions;
		return this;
	}
}
