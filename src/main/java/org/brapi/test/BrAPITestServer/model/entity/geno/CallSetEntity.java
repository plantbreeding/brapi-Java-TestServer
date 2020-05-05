package org.brapi.test.BrAPITestServer.model.entity.geno;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;

@Entity
@Table(name = "callset")
public class CallSetEntity extends BrAPIPrimaryEntity {
	@Column
	private String callSetName;
	@Column
	private Date created;
	@ManyToOne
	private SampleEntity sample;
	@Column
	private Date updated;
	@ManyToMany
	private List<VariantSetEntity> variantSets;

	public CallSetEntity() {
		super();
	}

	public CallSetEntity(CallSetEntity callSet) {
		this.setCallSetName(callSet.getCallSetName());
		this.setCreated(callSet.getCreated());
		this.setId(callSet.getId());
		this.setSample(callSet.getSample());
		this.setUpdated(callSet.getUpdated());
		this.setVariantSets(new ArrayList<>());
		this.getVariantSets().addAll(callSet.getVariantSets());
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public SampleEntity getSample() {
		return sample;
	}

	public void setSample(SampleEntity sample) {
		this.sample = sample;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public List<VariantSetEntity> getVariantSets() {
		return variantSets;
	}

	public void setVariantSets(List<VariantSetEntity> variantSets) {
		this.variantSets = variantSets;
	}

	public String getCallSetName() {
		return callSetName;
	}

	public void setCallSetName(String callSetName) {
		this.callSetName = callSetName;
	}

}
