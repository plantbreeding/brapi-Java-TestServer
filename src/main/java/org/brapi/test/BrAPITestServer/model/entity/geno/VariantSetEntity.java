package org.brapi.test.BrAPITestServer.model.entity.geno;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.StudyEntity;

@Entity
@Table(name = "variantset")
public class VariantSetEntity extends BrAPIPrimaryEntity {
	@OneToMany(mappedBy = "variantSet")
	private List<VariantSetAnalysisEntity> analysis;
	@OneToMany(mappedBy = "variantSet")
	private List<VariantSetAvailableFormatEntity> availableFormats;
	@ManyToMany
	@JoinTable
	private List<CallSetEntity> callSets;
	@ManyToOne
	private ReferenceSetEntity referenceSet;
	@ManyToOne
	private StudyEntity study;
	@OneToMany(mappedBy = "variantSet")
	private List<VariantEntity> variants;
	@Column
	private String variantSetName;
	
	public List<VariantSetAnalysisEntity> getAnalysis() {
		return analysis;
	}
	public void setAnalysis(List<VariantSetAnalysisEntity> analysis) {
		this.analysis = analysis;
	}
	public List<VariantSetAvailableFormatEntity> getAvailableFormats() {
		return availableFormats;
	}
	public void setAvailableFormats(List<VariantSetAvailableFormatEntity> availableFormats) {
		this.availableFormats = availableFormats;
	}
	public List<CallSetEntity> getCallSets() {
		return callSets;
	}
	public void setCallSets(List<CallSetEntity> callSets) {
		this.callSets = callSets;
	}
	public ReferenceSetEntity getReferenceSet() {
		return referenceSet;
	}
	public void setReferenceSet(ReferenceSetEntity referenceSet) {
		this.referenceSet = referenceSet;
	}
	public StudyEntity getStudy() {
		return study;
	}
	public void setStudy(StudyEntity study) {
		this.study = study;
	}
	public List<VariantEntity> getVariants() {
		return variants;
	}
	public void setVariants(List<VariantEntity> variants) {
		this.variants = variants;
	}
	public String getVariantSetName() {
		return variantSetName;
	}
	public void setVariantSetName(String variantSetName) {
		this.variantSetName = variantSetName;
	}
}
