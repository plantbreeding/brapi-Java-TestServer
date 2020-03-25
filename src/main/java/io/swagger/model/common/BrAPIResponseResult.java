package io.swagger.model.common;

import java.util.List;

import org.springframework.validation.annotation.Validated;

@Validated
public interface BrAPIResponseResult<T> {
	public void setData(List<T> data);
}
