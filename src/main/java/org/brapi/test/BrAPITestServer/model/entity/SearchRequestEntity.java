package org.brapi.test.BrAPITestServer.model.entity;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.exceptions.BrAPIServerException;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
@Table(name="search")
public class SearchRequestEntity extends BrAPIBaseEntity {
	@Column
	private SearchRequestTypes requestType;
	@Column
	private Integer responseCountdown;
	@Lob
	private String parameters;
	
	public SearchRequestTypes getRequestType() {
		return requestType;
	}
	
	public void setRequestType(SearchRequestTypes requestType) {
		this.requestType = requestType;
	}

	public Integer getResponseCountdown() {
		return responseCountdown;
	}

	public void setResponseCountdown(Integer responseCountdown) {
		this.responseCountdown = responseCountdown;
	}

	public String getParametersStr() {
		return parameters;
	}
	
	public <T> T getParameters(Class<T> clazz) throws BrAPIServerException {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(parameters, clazz);
		} catch (IOException e) {
			throw new BrAPIServerException(HttpStatus.BAD_REQUEST, "Could not de-serialize search request. Please POST request again.");
		}
	}
	
	public void setParameters(Object parameters) throws BrAPIServerException {
		ObjectMapper mapper = new ObjectMapper();
		try {
			this.parameters = mapper.writeValueAsString(parameters);
		} catch (JsonProcessingException e) {
			throw new BrAPIServerException(HttpStatus.BAD_REQUEST, "Could not serialize request. Please POST request again.");
		}
	}
	
	public enum SearchRequestTypes {CALLS, CALLSETS, MARKER_POSITIONS, REFERENCES, REFERENCESETS, VARIANTS, VARIANTSETS, GERMPLASM, GERMPLASM_ATTRIBUTES, GERMPLASM_ATTRIBUTE_VALUES, IMAGES, LISTS, LOCATIONS, MARKERS, OBSERVATIONS, OBSERVATION_TABLES, OBSERVATION_UNITS, PEOPLE, PROGRAMS, SAMPLES, STUDIES, TRIALS, VARIABLES};
	
}
