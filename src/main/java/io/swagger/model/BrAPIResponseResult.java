package io.swagger.model;

import java.util.List;

import org.springframework.validation.annotation.Validated;

@Validated
public interface BrAPIResponseResult<T> {

	public List<T> getData();

	public void setData(List<T> data);
}
