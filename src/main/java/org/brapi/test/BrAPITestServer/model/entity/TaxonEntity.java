package org.brapi.test.BrAPITestServer.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="taxon")
public class TaxonEntity extends BaseEntity {
	@Column
	private String sourceName;
	@Column
	private String taxonId;
	
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	public String getTaxonId() {
		return taxonId;
	}
	public void setTaxonId(String taxonId) {
		this.taxonId = taxonId;
	}
	
}
