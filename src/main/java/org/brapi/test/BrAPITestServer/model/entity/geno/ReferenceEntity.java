package org.brapi.test.BrAPITestServer.model.entity.geno;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;


@Entity
@Table(name="reference")
public class ReferenceEntity extends BrAPIPrimaryEntity {
	@Column
	private Integer length;
	@Column
	private String md5checksum;
	@Column
	private String referenceName;
	@ManyToOne
	private ReferenceSetEntity referenceSet;
	@Column
	private BigDecimal sourceDivergence;
	
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
	public BigDecimal getSourceDivergence() {
		return sourceDivergence;
	}
	public void setSourceDivergence(BigDecimal sourceDivergence) {
		this.sourceDivergence = sourceDivergence;
	}

}
