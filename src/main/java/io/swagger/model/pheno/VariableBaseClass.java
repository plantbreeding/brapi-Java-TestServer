package io.swagger.model.pheno;

import java.util.Objects;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.BrAPIDataModel;
import io.swagger.model.OntologyReference;

import java.util.ArrayList;
import java.util.List;
import java.time.OffsetDateTime;

import org.brapi.test.BrAPITestServer.service.UpdateUtility;

public class VariableBaseClass extends BrAPIDataModel {

	@JsonProperty("commonCropName")
	private Optional<String> commonCropName = null;

	@JsonProperty("contextOfUse")
	private Optional<List<String>> contextOfUse = null;

	@JsonProperty("defaultValue")
	private Optional<String> defaultValue = null;

	@JsonProperty("documentationURL")
	private Optional<String> documentationURL = null;

	@JsonProperty("growthStage")
	private Optional<String> growthStage = null;

	@JsonProperty("institution")
	private Optional<String> institution = null;

	@JsonProperty("language")
	private Optional<String> language = null;

	@JsonProperty("method")
	private Optional<Method> method = null;

	@JsonProperty("ontologyReference")
	private Optional<OntologyReference> ontologyReference = null;

	@JsonProperty("scale")
	private Optional<Scale> scale = null;

	@JsonProperty("scientist")
	private Optional<String> scientist = null;

	@JsonProperty("status")
	private Optional<String> status = null;

	@JsonProperty("submissionTimestamp")
	private Optional<OffsetDateTime> submissionTimestamp = null;

	@JsonProperty("synonyms")
	private Optional<List<String>> synonyms = null;

	@JsonProperty("trait")
	private Optional<Trait> trait = null;

	public VariableBaseClass commonCropName(String commonCropName) {
		this.commonCropName = UpdateUtility.setField(commonCropName);
		return this;
	}

	public Optional<String> getCommonCropName() {
		return commonCropName;
	}

	public void setCommonCropName(String commonCropName) {
		this.commonCropName = UpdateUtility.setField(commonCropName);
	}

	public VariableBaseClass contextOfUse(List<String> contextOfUse) {
		this.contextOfUse = UpdateUtility.setField(contextOfUse);
		return this;
	}

	public VariableBaseClass addContextOfUseItem(String contextOfUseItem) {
		if (this.contextOfUse == null) {
			this.contextOfUse = UpdateUtility.setField(new ArrayList<String>());
		}
		this.contextOfUse.get().add(contextOfUseItem);
		return this;
	}

	public Optional<List<String>> getContextOfUse() {
		return contextOfUse;
	}

	public void setContextOfUse(List<String> contextOfUse) {
		this.contextOfUse = UpdateUtility.setField(contextOfUse);
	}

	public VariableBaseClass defaultValue(String defaultValue) {
		this.defaultValue = UpdateUtility.setField(defaultValue);
		return this;
	}

	public Optional<String> getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = UpdateUtility.setField(defaultValue);
	}

	public VariableBaseClass documentationURL(String documentationURL) {
		this.documentationURL = UpdateUtility.setField(documentationURL);
		return this;
	}

	public Optional<String> getDocumentationURL() {
		return documentationURL;
	}

	public void setDocumentationURL(String documentationURL) {
		this.documentationURL = UpdateUtility.setField(documentationURL);
	}

	public VariableBaseClass growthStage(String growthStage) {
		this.growthStage = UpdateUtility.setField(growthStage);
		return this;
	}

	public Optional<String> getGrowthStage() {
		return growthStage;
	}

	public void setGrowthStage(String growthStage) {
		this.growthStage = UpdateUtility.setField(growthStage);
	}

	public VariableBaseClass institution(String institution) {
		this.institution = UpdateUtility.setField(institution);
		return this;
	}

	public Optional<String> getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = UpdateUtility.setField(institution);
	}

	public VariableBaseClass language(String language) {
		this.language = UpdateUtility.setField(language);
		return this;
	}

	public Optional<String> getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = UpdateUtility.setField(language);
	}

	public VariableBaseClass method(Method method) {
		this.method = UpdateUtility.setField(method);
		return this;
	}

	public Optional<Method> getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = UpdateUtility.setField(method);
	}

	public VariableBaseClass ontologyReference(OntologyReference ontologyReference) {
		this.ontologyReference = UpdateUtility.setField(ontologyReference);
		return this;
	}

	public Optional<OntologyReference> getOntologyReference() {
		return ontologyReference;
	}

	public void setOntologyReference(OntologyReference ontologyReference) {
		this.ontologyReference = UpdateUtility.setField(ontologyReference);
	}

	public VariableBaseClass scale(Scale scale) {
		this.scale = UpdateUtility.setField(scale);
		return this;
	}

	public Optional<Scale> getScale() {
		return scale;
	}

	public void setScale(Scale scale) {
		this.scale = UpdateUtility.setField(scale);
	}

	public VariableBaseClass scientist(String scientist) {
		this.scientist = UpdateUtility.setField(scientist);
		return this;
	}

	public Optional<String> getScientist() {
		return scientist;
	}

	public void setScientist(String scientist) {
		this.scientist = UpdateUtility.setField(scientist);
	}

	public VariableBaseClass status(String status) {
		this.status = UpdateUtility.setField(status);
		return this;
	}

	public Optional<String> getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = UpdateUtility.setField(status);
	}

	public VariableBaseClass submissionTimestamp(OffsetDateTime submissionTimestamp) {
		this.submissionTimestamp = UpdateUtility.setField(submissionTimestamp);
		return this;
	}

	public Optional<OffsetDateTime> getSubmissionTimestamp() {
		return submissionTimestamp;
	}

	public void setSubmissionTimestamp(OffsetDateTime submissionTimestamp) {
		this.submissionTimestamp = UpdateUtility.setField(submissionTimestamp);
	}

	public VariableBaseClass synonyms(List<String> synonyms) {
		this.synonyms = UpdateUtility.setField(synonyms);
		return this;
	}

	public VariableBaseClass addSynonymsItem(String synonymsItem) {
		if (this.synonyms == null) {
			this.synonyms = UpdateUtility.setField(new ArrayList<String>());
		}
		this.synonyms.get().add(synonymsItem);
		return this;
	}

	public Optional<List<String>> getSynonyms() {
		return synonyms;
	}

	public void setSynonyms(List<String> synonyms) {
		this.synonyms = UpdateUtility.setField(synonyms);
	}

	public VariableBaseClass trait(Trait trait) {
		this.trait = UpdateUtility.setField(trait);
		return this;
	}

	public Optional<Trait> getTrait() {
		return trait;
	}

	public void setTrait(Trait trait) {
		this.trait = UpdateUtility.setField(trait);
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		VariableBaseClass variableBaseClass = (VariableBaseClass) o;
		return Objects.equals(this.additionalInfo, variableBaseClass.additionalInfo)
				&& Objects.equals(this.commonCropName, variableBaseClass.commonCropName)
				&& Objects.equals(this.contextOfUse, variableBaseClass.contextOfUse)
				&& Objects.equals(this.defaultValue, variableBaseClass.defaultValue)
				&& Objects.equals(this.documentationURL, variableBaseClass.documentationURL)
				&& Objects.equals(this.externalReferences, variableBaseClass.externalReferences)
				&& Objects.equals(this.growthStage, variableBaseClass.growthStage)
				&& Objects.equals(this.institution, variableBaseClass.institution)
				&& Objects.equals(this.language, variableBaseClass.language)
				&& Objects.equals(this.method, variableBaseClass.method)
				&& Objects.equals(this.ontologyReference, variableBaseClass.ontologyReference)
				&& Objects.equals(this.scale, variableBaseClass.scale)
				&& Objects.equals(this.scientist, variableBaseClass.scientist)
				&& Objects.equals(this.status, variableBaseClass.status)
				&& Objects.equals(this.submissionTimestamp, variableBaseClass.submissionTimestamp)
				&& Objects.equals(this.synonyms, variableBaseClass.synonyms)
				&& Objects.equals(this.trait, variableBaseClass.trait);
	}

	@Override
	public int hashCode() {
		return Objects.hash(additionalInfo, commonCropName, contextOfUse, defaultValue, documentationURL,
				externalReferences, growthStage, institution, language, method, ontologyReference, scale, scientist,
				status, submissionTimestamp, synonyms, trait);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class VariableBaseClass {\n");

		sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
		sb.append("    commonCropName: ").append(toIndentedString(commonCropName)).append("\n");
		sb.append("    contextOfUse: ").append(toIndentedString(contextOfUse)).append("\n");
		sb.append("    defaultValue: ").append(toIndentedString(defaultValue)).append("\n");
		sb.append("    documentationURL: ").append(toIndentedString(documentationURL)).append("\n");
		sb.append("    externalReferences: ").append(toIndentedString(externalReferences)).append("\n");
		sb.append("    growthStage: ").append(toIndentedString(growthStage)).append("\n");
		sb.append("    institution: ").append(toIndentedString(institution)).append("\n");
		sb.append("    language: ").append(toIndentedString(language)).append("\n");
		sb.append("    method: ").append(toIndentedString(method)).append("\n");
		sb.append("    ontologyReference: ").append(toIndentedString(ontologyReference)).append("\n");
		sb.append("    scale: ").append(toIndentedString(scale)).append("\n");
		sb.append("    scientist: ").append(toIndentedString(scientist)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
		sb.append("    submissionTimestamp: ").append(toIndentedString(submissionTimestamp)).append("\n");
		sb.append("    synonyms: ").append(toIndentedString(synonyms)).append("\n");
		sb.append("    trait: ").append(toIndentedString(trait)).append("\n");
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
