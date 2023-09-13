package org.brapi.test.BrAPITestServer.model.entity.geno;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;

@Entity
@Table(name = "variantset_analysis")
public class VariantSetAnalysisEntity extends BrAPIBaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	private VariantSetEntity variantSet;
	@Column
	private String analysisName;
	@Column
	private Date created;
	@Column
	private String description;
	@ElementCollection
	private List<String> software;
	@Column
	private String type;
	@Column
	private Date updated;
	
	public VariantSetEntity getVariantSet() {
		return variantSet;
	}
	public void setVariantSet(VariantSetEntity variantSet) {
		this.variantSet = variantSet;
	}
	public String getAnalysisName() {
		return analysisName;
	}
	public void setAnalysisName(String analysisName) {
		this.analysisName = analysisName;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getSoftware() {
		return software;
	}
	public void setSoftware(List<String> software) {
		this.software = software;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
}
