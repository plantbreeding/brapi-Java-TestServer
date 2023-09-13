package org.brapi.test.BrAPITestServer.model.entity.geno;

import javax.persistence.*;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;

@Entity
@Table(name="marker_position")
public class MarkerPositionEntity extends BrAPIPrimaryEntity{
	@ManyToOne(fetch = FetchType.LAZY)
	private LinkageGroupEntity linkageGroup;
	@ManyToOne(fetch = FetchType.LAZY)
	private VariantEntity variant;
	@Column
	private Integer position;
	
	public LinkageGroupEntity getLinkageGroup() {
		return linkageGroup;
	}
	public void setLinkageGroup(LinkageGroupEntity linkageGroup) {
		this.linkageGroup = linkageGroup;
	}
	public VariantEntity getVariant() {
		return variant;
	}
	public void setVariant(VariantEntity variant) {
		this.variant = variant;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
}
