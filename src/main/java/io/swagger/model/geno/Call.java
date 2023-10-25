package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Call {
	@JsonProperty("additionalInfo")
	private Object additionalInfo = null;

	@JsonProperty("callSetDbId")
	private String callSetDbId = null;

	@JsonProperty("callSetName")
	private String callSetName = null;

	@JsonProperty("genotype")
	private ListValue genotype = null;

	@JsonProperty("genotypeValue")
	private String genotypeValue = null;

	@JsonProperty("genotypeMetadata")
	private List<CallGenotypeMetadata> genotypeMetadata = null;

	@JsonProperty("genotype_likelihood")
	private List<Double> genotypeLikelihood = null;

	@JsonProperty("phaseSet")
	private String phaseSet = null;

	@JsonProperty("variantDbId")
	private String variantDbId = null;

	@JsonProperty("variantName")
	private String variantName = null;

	@JsonProperty("variantSetDbId")
	private String variantSetDbId = null;

	@JsonProperty("variantSetName")
	private String variantSetName = null;

	public String getGenotypeValue() {
		return genotypeValue;
	}

	public void setGenotypeValue(String genotypeValue) {
		this.genotypeValue = genotypeValue;
	}

	public List<CallGenotypeMetadata> getGenotypeMetadata() {
		return genotypeMetadata;
	}

	public void setGenotypeMetadata(List<CallGenotypeMetadata> genotypeMetadata) {
		this.genotypeMetadata = genotypeMetadata;
	}


	public String getGenotypeMetadataValue(String dataMatrixAbbreviation) {
		for(CallGenotypeMetadata data: this.genotypeMetadata) {
			if(data.getFieldAbbreviation().equalsIgnoreCase(dataMatrixAbbreviation)) {
				return data.getFieldValue();
			}
		}
		return "";
	}

	public Call addGenotypeMetadataItem(CallGenotypeMetadata genotypeMetadata) {
		if (this.genotypeMetadata == null) {
			this.genotypeMetadata = new ArrayList<CallGenotypeMetadata>();
		}
		this.genotypeMetadata.add(genotypeMetadata);
		return this;
	}
	
	public Call additionalInfo(Object additionalInfo) {
		this.additionalInfo = additionalInfo;
		return this;
	}

	public Object getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(Object additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public Call callSetDbId(String callSetDbId) {
		this.callSetDbId = callSetDbId;
		return this;
	}

	public String getCallSetDbId() {
		return callSetDbId;
	}

	public void setCallSetDbId(String callSetDbId) {
		this.callSetDbId = callSetDbId;
	}

	public Call callSetName(String callSetName) {
		this.callSetName = callSetName;
		return this;
	}

	public String getCallSetName() {
		return callSetName;
	}

	public void setCallSetName(String callSetName) {
		this.callSetName = callSetName;
	}

	public Call genotype(ListValue genotype) {
		this.genotype = genotype;
		return this;
	}

	public ListValue getGenotype() {
		return genotype;
	}

	public void setGenotype(ListValue genotype) {
		this.genotype = genotype;
	}

	public Call genotypeLikelihood(List<Double> genotypeLikelihood) {
		this.genotypeLikelihood = genotypeLikelihood;
		return this;
	}

	public Call addGenotypeLikelihoodItem(Double genotypeLikelihoodItem) {
		if (this.genotypeLikelihood == null) {
			this.genotypeLikelihood = new ArrayList<Double>();
		}
		this.genotypeLikelihood.add(genotypeLikelihoodItem);
		return this;
	}

	public List<Double> getGenotypeLikelihood() {
		return genotypeLikelihood;
	}

	public void setGenotypeLikelihood(List<Double> genotypeLikelihood) {
		this.genotypeLikelihood = genotypeLikelihood;
	}

	public Call phaseSet(String phaseSet) {
		this.phaseSet = phaseSet;
		return this;
	}

	public String getPhaseSet() {
		return phaseSet;
	}

	public void setPhaseSet(String phaseSet) {
		this.phaseSet = phaseSet;
	}

	public Call variantDbId(String variantDbId) {
		this.variantDbId = variantDbId;
		return this;
	}

	public String getVariantDbId() {
		return variantDbId;
	}

	public void setVariantDbId(String variantDbId) {
		this.variantDbId = variantDbId;
	}

	public Call variantName(String variantName) {
		this.variantName = variantName;
		return this;
	}

	public String getVariantName() {
		return variantName;
	}

	public void setVariantName(String variantName) {
		this.variantName = variantName;
	}
	
	


	public Call variantSetDbId(String variantSetDbId) {
		this.variantSetDbId = variantSetDbId;
		return this;
	}

	public String getVariantSetDbId() {
		return variantSetDbId;
	}

	public void setVariantSetDbId(String variantSetDbId) {
		this.variantSetDbId = variantSetDbId;
	}

	public Call variantSetName(String variantSetName) {
		this.variantSetName = variantSetName;
		return this;
	}

	public String getVariantSetName() {
		return variantSetName;
	}

	public void setVariantSetName(String variantSetName) {
		this.variantSetName = variantSetName;
	}
	
	

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Call call = (Call) o;
		return Objects.equals(this.additionalInfo, call.additionalInfo)
				&& Objects.equals(this.callSetDbId, call.callSetDbId)
				&& Objects.equals(this.callSetName, call.callSetName) 
				&& Objects.equals(this.genotype, call.genotype)
				&& Objects.equals(this.genotypeLikelihood, call.genotypeLikelihood)
				&& Objects.equals(this.phaseSet, call.phaseSet) 
				&& Objects.equals(this.variantDbId, call.variantDbId)
				&& Objects.equals(this.variantName, call.variantName)
				&& Objects.equals(this.variantSetDbId, call.variantSetDbId)
				&& Objects.equals(this.variantSetName, call.variantSetName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(additionalInfo, callSetDbId, callSetName, genotype, genotypeLikelihood, phaseSet,
				variantDbId, variantName, variantSetDbId, variantSetName);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Call {\n");

		sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
		sb.append("    callSetDbId: ").append(toIndentedString(callSetDbId)).append("\n");
		sb.append("    callSetName: ").append(toIndentedString(callSetName)).append("\n");
		sb.append("    genotype: ").append(toIndentedString(genotype)).append("\n");
		sb.append("    genotypeLikelihood: ").append(toIndentedString(genotypeLikelihood)).append("\n");
		sb.append("    phaseSet: ").append(toIndentedString(phaseSet)).append("\n");
		sb.append("    variantDbId: ").append(toIndentedString(variantDbId)).append("\n");
		sb.append("    variantName: ").append(toIndentedString(variantName)).append("\n");
		sb.append("    variantSetDbId: ").append(toIndentedString(variantSetDbId)).append("\n");
		sb.append("    variantSetName: ").append(toIndentedString(variantSetName)).append("\n");
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
