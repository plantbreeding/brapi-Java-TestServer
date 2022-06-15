package io.swagger.model.germ;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.pheno.VariableBaseClass;

public class GermplasmAttributeNewRequest extends VariableBaseClass {
	@JsonProperty("attributeCategory")
	private String attributeCategory = null;

	@JsonProperty("attributeDescription")
	private String attributeDescription = null;

	@JsonProperty("attributeName")
	private String attributeName = null;

	@JsonProperty("attributePUI")
	private String attributePUI = null;

	public String getAttributePUI() {
		return attributePUI;
	}

	public void setAttributePUI(String attributePUI) {
		this.attributePUI = attributePUI;
	}

	public GermplasmAttributeNewRequest attributeCategory(String attributeCategory) {
		this.attributeCategory = attributeCategory;
		return this;
	}

	public String getAttributeCategory() {
		return attributeCategory;
	}

	public void setAttributeCategory(String attributeCategory) {
		this.attributeCategory = attributeCategory;
	}

	public GermplasmAttributeNewRequest attributeDescription(String attributeDescription) {
		this.attributeDescription = attributeDescription;
		return this;
	}

	public String getAttributeDescription() {
		return attributeDescription;
	}

	public void setAttributeDescription(String attributeDescription) {
		this.attributeDescription = attributeDescription;
	}

	public GermplasmAttributeNewRequest attributeName(String attributeName) {
		this.attributeName = attributeName;
		return this;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		GermplasmAttributeNewRequest germplasmAttributeNewRequest = (GermplasmAttributeNewRequest) o;
		return Objects.equals(this.attributeCategory, germplasmAttributeNewRequest.attributeCategory)
				&& Objects.equals(this.attributeDescription, germplasmAttributeNewRequest.attributeDescription)
				&& Objects.equals(this.attributePUI, germplasmAttributeNewRequest.attributePUI)
				&& Objects.equals(this.attributeName, germplasmAttributeNewRequest.attributeName) && super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(attributeCategory, attributeDescription, attributeName, attributePUI, super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class GermplasmAttributeNewRequest {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    attributeCategory: ").append(toIndentedString(attributeCategory)).append("\n");
		sb.append("    attributeDescription: ").append(toIndentedString(attributeDescription)).append("\n");
		sb.append("    attributeName: ").append(toIndentedString(attributeName)).append("\n");
		sb.append("    attributePUI: ").append(toIndentedString(attributePUI)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
