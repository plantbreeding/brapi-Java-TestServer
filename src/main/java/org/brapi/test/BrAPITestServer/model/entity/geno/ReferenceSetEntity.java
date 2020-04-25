package org.brapi.test.BrAPITestServer.model.entity.geno;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.GermplasmEntity;

@Entity
@Table(name="reference_set")
public class ReferenceSetEntity extends BrAPIPrimaryEntity  {
	@Column
	private String assemblyPUI;
	@Column
	private String description;
	@Column
	private Boolean isDerived;
	@Column
	private String md5checksum;
	@Column
	private String referenceSetName;
	@ManyToOne
	private GermplasmEntity sourceGermplasm;
	@Column
	private String sourceURI;
	@Column
	private String speciesOntologyTerm;
	@Column
	private String speciesOntologyTermURI;
	
	public String getAssemblyPUI() {
		return assemblyPUI;
	}
	public void setAssemblyPUI(String assemblyPUI) {
		this.assemblyPUI = assemblyPUI;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getIsDerived() {
		return isDerived;
	}
	public void setIsDerived(Boolean isDerived) {
		this.isDerived = isDerived;
	}
	public String getMd5checksum() {
		return md5checksum;
	}
	public void setMd5checksum(String md5checksum) {
		this.md5checksum = md5checksum;
	}
	public String getReferenceSetName() {
		return referenceSetName;
	}
	public void setReferenceSetName(String referenceSetName) {
		this.referenceSetName = referenceSetName;
	}
	public GermplasmEntity getSourceGermplasm() {
		return sourceGermplasm;
	}
	public void setSourceGermplasm(GermplasmEntity sourceGermplasm) {
		this.sourceGermplasm = sourceGermplasm;
	}
	public String getSourceURI() {
		return sourceURI;
	}
	public void setSourceURI(String sourceURI) {
		this.sourceURI = sourceURI;
	}
	public String getSpeciesOntologyTerm() {
		return speciesOntologyTerm;
	}
	public void setSpeciesOntologyTerm(String speciesOntologyTerm) {
		this.speciesOntologyTerm = speciesOntologyTerm;
	}
	public String getSpeciesOntologyTermURI() {
		return speciesOntologyTermURI;
	}
	public void setSpeciesOntologyTermURI(String speciesOntologyTermURI) {
		this.speciesOntologyTermURI = speciesOntologyTermURI;
	}
}
