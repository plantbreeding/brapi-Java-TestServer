package org.brapi.test.BrAPITestServer.model.entity.germ;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;
import io.swagger.model.germ.ParentType;

@Entity
@Table(name="pedigree_edge")
public class PedigreeEdgeEntity extends BrAPIBaseEntity{
	@ManyToOne
	private PedigreeNodeEntity parentNode;
	@ManyToOne
	private PedigreeNodeEntity childNode;
	@ManyToOne
	private PedigreeNodeEntity siblingNode;
	@ManyToOne
	private PedigreeNodeEntity conncetedNode;
	@Column
	private ParentType parentType;
	
	public PedigreeNodeEntity getParentNode() {
		return parentNode;
	}
	public void setParentNode(PedigreeNodeEntity parentNode) {
		this.parentNode = parentNode;
	}
	public PedigreeNodeEntity getChildNode() {
		return childNode;
	}
	public void setChildNode(PedigreeNodeEntity childNode) {
		this.childNode = childNode;
	}
	public PedigreeNodeEntity getSiblingNode() {
		return siblingNode;
	}
	public void setSiblingNode(PedigreeNodeEntity siblingNode) {
		this.siblingNode = siblingNode;
	}
	public PedigreeNodeEntity getConncetedNode() {
		return conncetedNode;
	}
	public void setConncetedNode(PedigreeNodeEntity conncetedNode) {
		this.conncetedNode = conncetedNode;
	}
	public ParentType getParentType() {
		return parentType;
	}
	public void setParentType(ParentType parentType) {
		this.parentType = parentType;
	}
    
}
