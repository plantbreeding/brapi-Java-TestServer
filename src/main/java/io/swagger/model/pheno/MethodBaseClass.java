package io.swagger.model.pheno;

import java.util.Objects;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.BrAPIDataModel;
import io.swagger.model.OntologyReference;

import org.brapi.test.BrAPITestServer.service.UpdateUtility;

public class MethodBaseClass extends BrAPIDataModel {

	@JsonProperty("bibliographicalReference")
	private Optional<String> bibliographicalReference = null;

	@JsonProperty("description")
	private Optional<String> description = null;

	@JsonProperty("formula")
	private Optional<String> formula = null;

	@JsonProperty("methodClass")
	private Optional<String> methodClass = null;

	@JsonProperty("methodName")
	private Optional<String> methodName = null;

	@JsonProperty("methodPUI")
	private Optional<String> methodPUI = null;

	@JsonProperty("ontologyReference")
	private Optional<OntologyReference> ontologyReference = null;

	public Optional<String> getMethodPUI() {
		return methodPUI;
	}

	public void setMethodPUI(String methodPUI) {
		this.methodPUI = UpdateUtility.setField(methodPUI);
	}

	public MethodBaseClass bibliographicalReference(String bibliographicalReference) {
		this.bibliographicalReference = UpdateUtility.setField(bibliographicalReference);
		return this;
	}

	public Optional<String> getBibliographicalReference() {
		return bibliographicalReference;
	}

	public void setBibliographicalReference(String bibliographicalReference) {
		this.bibliographicalReference = UpdateUtility.setField(bibliographicalReference);
	}

	public MethodBaseClass description(String description) {
		this.description = UpdateUtility.setField(description);
		return this;
	}

	public Optional<String> getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = UpdateUtility.setField(description);
	}

	public MethodBaseClass formula(String formula) {
		this.formula = UpdateUtility.setField(formula);
		return this;
	}

	public Optional<String> getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = UpdateUtility.setField(formula);
	}

	public MethodBaseClass methodClass(String methodClass) {
		this.methodClass = UpdateUtility.setField(methodClass);
		return this;
	}

	public Optional<String> getMethodClass() {
		return methodClass;
	}

	public void setMethodClass(String methodClass) {
		this.methodClass = UpdateUtility.setField(methodClass);
	}

	public MethodBaseClass methodName(String methodName) {
		this.methodName = UpdateUtility.setField(methodName);
		return this;
	}

	public Optional<String> getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = UpdateUtility.setField(methodName);
	}

	public MethodBaseClass ontologyReference(OntologyReference ontologyReference) {
		this.ontologyReference = UpdateUtility.setField(ontologyReference);
		return this;
	}

	public Optional<OntologyReference> getOntologyReference() {
		return ontologyReference;
	}

	public void setOntologyReference(OntologyReference ontologyReference) {
		this.ontologyReference = UpdateUtility.setField(ontologyReference);
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
				&& Objects.equals(this.methodPUI, methodBaseClass.methodPUI)
				&& Objects.equals(this.ontologyReference, methodBaseClass.ontologyReference);
	}

	@Override
	public int hashCode() {
		return Objects.hash(additionalInfo, bibliographicalReference, description, externalReferences, formula,
				methodClass, methodName, methodPUI, ontologyReference);
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
		sb.append("    methodPUI: ").append(toIndentedString(methodPUI)).append("\n");
		sb.append("    ontologyReference: ").append(toIndentedString(ontologyReference)).append("\n");
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
