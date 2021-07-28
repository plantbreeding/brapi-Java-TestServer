package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ExternalReferences;
import io.swagger.model.OntologyReference;

import java.util.HashMap;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * MethodBaseClass
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class MethodBaseClass {
	@JsonProperty("additionalInfo")
	@Valid
	private Map<String, Object> additionalInfo = null;

	@JsonProperty("bibliographicalReference")
	private String bibliographicalReference = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("externalReferences")
	private ExternalReferences externalReferences = null;

	@JsonProperty("formula")
	private String formula = null;

	@JsonProperty("methodClass")
	private String methodClass = null;

	@JsonProperty("methodName")
	private String methodName = null;

	@JsonProperty("ontologyReference")
	private OntologyReference ontologyReference = null;

	public MethodBaseClass additionalInfo(Map<String, Object> additionalInfo) {
		this.additionalInfo = additionalInfo;
		return this;
	}

	public MethodBaseClass putAdditionalInfoItem(String key, String additionalInfoItem) {
		if (this.additionalInfo == null) {
			this.additionalInfo = new HashMap<String, Object>();
		}
		this.additionalInfo.put(key, additionalInfoItem);
		return this;
	}

	/**
	 * Additional arbitrary info
	 * 
	 * @return additionalInfo
	 **/
	@ApiModelProperty(value = "Additional arbitrary info")

	public Map<String, Object> getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(Map<String, Object> additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public MethodBaseClass bibliographicalReference(String bibliographicalReference) {
		this.bibliographicalReference = bibliographicalReference;
		return this;
	}

	/**
	 * Bibliographical reference describing the method. MIAPPE V1.1 (DM-91)
	 * Reference associated to the method - URI/DOI of reference describing the
	 * method.
	 * 
	 * @return bibliographicalReference
	 **/
	@ApiModelProperty(example = "Smith, 1893, Really Cool Paper, Popular Journal", value = "Bibliographical reference describing the method.  MIAPPE V1.1 (DM-91) Reference associated to the method - URI/DOI of reference describing the method.")

	public String getBibliographicalReference() {
		return bibliographicalReference;
	}

	public void setBibliographicalReference(String bibliographicalReference) {
		this.bibliographicalReference = bibliographicalReference;
	}

	public MethodBaseClass description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Method description MIAPPE V1.1 (DM-90) Method description - Textual
	 * description of the method, which may extend a method defined in an external
	 * reference with specific parameters, e.g. growth stage, inoculation precise
	 * organ (leaf number)
	 * 
	 * @return description
	 **/
	@ApiModelProperty(example = "A measuring tape was used", value = "Method description  MIAPPE V1.1 (DM-90) Method description - Textual description of the method, which may extend a method defined in an external reference with specific parameters, e.g. growth stage, inoculation precise organ (leaf number)")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MethodBaseClass externalReferences(ExternalReferences externalReferences) {
		this.externalReferences = externalReferences;
		return this;
	}

	/**
	 * Get externalReferences
	 * 
	 * @return externalReferences
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public ExternalReferences getExternalReferences() {
		return externalReferences;
	}

	public void setExternalReferences(ExternalReferences externalReferences) {
		this.externalReferences = externalReferences;
	}

	public MethodBaseClass formula(String formula) {
		this.formula = formula;
		return this;
	}

	/**
	 * For computational methods i.e., when the method consists in assessing the
	 * trait by computing measurements, write the generic formula used for the
	 * calculation
	 * 
	 * @return formula
	 **/
	@ApiModelProperty(example = "a^2 + b^2 = c^2", value = "For computational methods i.e., when the method consists in assessing the trait by computing measurements, write the generic formula used for the calculation")

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public MethodBaseClass methodClass(String methodClass) {
		this.methodClass = methodClass;
		return this;
	}

	/**
	 * Method class (examples: \"Measurement\", \"Counting\", \"Estimation\",
	 * \"Computation\", etc.)
	 * 
	 * @return methodClass
	 **/
	@ApiModelProperty(example = "Measurement", value = "Method class (examples: \"Measurement\", \"Counting\", \"Estimation\", \"Computation\", etc.)")

	public String getMethodClass() {
		return methodClass;
	}

	public void setMethodClass(String methodClass) {
		this.methodClass = methodClass;
	}

	public MethodBaseClass methodName(String methodName) {
		this.methodName = methodName;
		return this;
	}

	/**
	 * Human readable name for the method MIAPPE V1.1 (DM-88) Method Name of the
	 * method of observation
	 * 
	 * @return methodName
	 **/
	@ApiModelProperty(example = "Measuring Tape", value = "Human readable name for the method  MIAPPE V1.1 (DM-88) Method  Name of the method of observation")

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public MethodBaseClass ontologyReference(OntologyReference ontologyReference) {
		this.ontologyReference = ontologyReference;
		return this;
	}

	/**
	 * Get ontologyReference
	 * 
	 * @return ontologyReference
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public OntologyReference getOntologyReference() {
		return ontologyReference;
	}

	public void setOntologyReference(OntologyReference ontologyReference) {
		this.ontologyReference = ontologyReference;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		MethodBaseClass methodBaseClass = (MethodBaseClass) o;
		return Objects.equals(this.additionalInfo, methodBaseClass.additionalInfo)
				&& Objects.equals(this.bibliographicalReference, methodBaseClass.bibliographicalReference)
				&& Objects.equals(this.description, methodBaseClass.description)
				&& Objects.equals(this.externalReferences, methodBaseClass.externalReferences)
				&& Objects.equals(this.formula, methodBaseClass.formula)
				&& Objects.equals(this.methodClass, methodBaseClass.methodClass)
				&& Objects.equals(this.methodName, methodBaseClass.methodName)
				&& Objects.equals(this.ontologyReference, methodBaseClass.ontologyReference);
	}

	@Override
	public int hashCode() {
		return Objects.hash(additionalInfo, bibliographicalReference, description, externalReferences, formula,
				methodClass, methodName, ontologyReference);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class MethodBaseClass {\n");

		sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
		sb.append("    bibliographicalReference: ").append(toIndentedString(bibliographicalReference)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    externalReferences: ").append(toIndentedString(externalReferences)).append("\n");
		sb.append("    formula: ").append(toIndentedString(formula)).append("\n");
		sb.append("    methodClass: ").append(toIndentedString(methodClass)).append("\n");
		sb.append("    methodName: ").append(toIndentedString(methodName)).append("\n");
		sb.append("    ontologyReference: ").append(toIndentedString(ontologyReference)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
