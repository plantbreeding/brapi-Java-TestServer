package io.swagger.model.germ;

import org.brapi.test.BrAPITestServer.serializer.CustomGermplasmStorageTypesDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = CustomGermplasmStorageTypesDeserializer.class)
public class GermplasmStorageTypes {
	private GermplasmStorageTypesEnum code;
	private String description;

	public GermplasmStorageTypes(GermplasmStorageTypesEnum code) {
		this.code = code;
		this.description = code.getDescription();
	}

	public GermplasmStorageTypesEnum getCode() {
		return code;
	}

	public void setCode(GermplasmStorageTypesEnum code) {
		this.code = code;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
