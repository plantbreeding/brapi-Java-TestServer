package io.swagger.model;

import org.springframework.validation.annotation.Validated;

@Validated
public interface BrAPIResponse<T> {

	public void set_atContext(Context _atContext);

	public Metadata getMetadata();

	public void setMetadata(Metadata metadata);

	public T getResult();

	public void setResult(T result);

}
