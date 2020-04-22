package org.brapi.test.BrAPITestServer.model.entity.geno;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;

@Entity
@Table(name = "variant")
public class VariantEntity extends BrAPIPrimaryEntity {
	@Column
	private String variantName;
	@ManyToOne
	private VariantSetEntity variantSet;

	public String getVariantName() {
		return variantName;
	}

	public void setVariantName(String variantName) {
		this.variantName = variantName;
	}

	public VariantSetEntity getVariantSet() {
		return variantSet;
	}

	public void setVariantSet(VariantSetEntity variantSet) {
		this.variantSet = variantSet;
	}

}
