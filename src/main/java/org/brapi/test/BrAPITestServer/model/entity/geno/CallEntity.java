package org.brapi.test.BrAPITestServer.model.entity.geno;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;

@Entity
@Table(name="allele_call")
public class CallEntity extends BrAPIPrimaryEntity {
	@ManyToOne
	private CallSetEntity callSet;
	@Column
	private String genotype;
	@Column
	private Integer readDepth;
	@Column
	private Double genotypeLikelihood;
	@Column 
	private String phaseSet;
	@ManyToOne
	private VariantEntity variant;

	public CallEntity() {
		super();
	}
	public CallEntity(CallEntity call) {
		this.setCallSet(call.getCallSet());
		this.setGenotype(call.getGenotype());
		this.setReadDepth(call.getReadDepth());
		this.setGenotypeLikelihood(call.getGenotypeLikelihood());
		this.setId(call.getId());
		this.setPhaseSet(call.getPhaseSet());
		this.setVariant(call.getVariant());
	}
	
	public Integer getReadDepth() {
		return readDepth;
	}
	public void setReadDepth(Integer readDepth) {
		this.readDepth = readDepth;
	}
	public CallSetEntity getCallSet() {
		return callSet;
	}
	public void setCallSet(CallSetEntity callSet) {
		this.callSet = callSet;
	}
	public String getGenotype() {
		return genotype;
	}
	public void setGenotype(String genotype) {
		this.genotype = genotype;
	}
	public Double getGenotypeLikelihood() {
		return genotypeLikelihood;
	}
	public void setGenotypeLikelihood(Double genotypeLikelihood) {
		this.genotypeLikelihood = genotypeLikelihood;
	}
	public String getPhaseSet() {
		return phaseSet;
	}
	public void setPhaseSet(String phaseSet) {
		this.phaseSet = phaseSet;
	}
	public VariantEntity getVariant() {
		return variant;
	}
	public void setVariant(VariantEntity variant) {
		this.variant = variant;
	}
}
