package io.swagger.model.germ;

import org.springframework.validation.annotation.Validated;

/**
 * GermplasmNewRequestStorageTypes
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
public class GermplasmStorageTypes {
	private GermplasmStorageTypesEnum value;
	private String description;

	public GermplasmStorageTypes(GermplasmStorageTypesEnum value) {
		this.value = value;
		this.description = value.getDescription();
	}

	public GermplasmStorageTypesEnum getValue() {
		return value;
	}

	public void setValue(GermplasmStorageTypesEnum value) {
		this.value = value;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
