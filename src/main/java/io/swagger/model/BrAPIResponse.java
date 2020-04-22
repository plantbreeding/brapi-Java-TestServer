package io.swagger.model;

import org.springframework.validation.annotation.Validated;

@Validated
public interface BrAPIResponse<T> {

	public void setMetadata(Metadata metadata);
	public void setResult(T result);

}
