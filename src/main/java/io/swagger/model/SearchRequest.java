package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface SearchRequest {
	@JsonIgnore
	public Integer getTotalParameterCount();
}
