package org.brapi.test.BrAPITestServer.model.entity.geno;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.GermplasmEntity;


@Entity
@Table(name="reference")
public class ReferenceEntity extends BrAPIPrimaryEntity {
	@Column
	private Boolean isDerived;
	@Column
	private Integer length;
	@Column
	private String md5checksum;
	@Column
	private String referenceName;
	@ManyToOne
	private ReferenceSetEntity referenceSet;
	@ManyToOne
	private GermplasmEntity sourceGermplasm;
	@Column
	private BigDecimal sourceDivergence;
	@Column
	private String sourceURI;
	@Column
	private String speciesOntologyTerm;
	@Column
	private String speciesOntologyTermURI;
	
	public Boolean getIsDerived() {
		return isDerived;
	}
	public void setIsDerived(Boolean isDerived) {
		this.isDerived = isDerived;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public String getMd5checksum() {
		return md5checksum;
	}
	public void setMd5checksum(String md5checksum) {
		this.md5checksum = md5checksum;
	}
	public String getReferenceName() {
		return referenceName;
	}
	public void setReferenceName(String referenceName) {
		this.referenceName = referenceName;
	}
	public ReferenceSetEntity getReferenceSet() {
		return referenceSet;
	}
	public void setReferenceSet(ReferenceSetEntity referenceSet) {
		this.referenceSet = referenceSet;
	}
	public GermplasmEntity getSourceGermplasm() {
		return sourceGermplasm;
	}
	public void setSourceGermplasm(GermplasmEntity sourceGermplasm) {
		this.sourceGermplasm = sourceGermplasm;
	}
	public BigDecimal getSourceDivergence() {
		return sourceDivergence;
	}
	public void setSourceDivergence(BigDecimal sourceDivergence) {
		this.sourceDivergence = sourceDivergence;
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
