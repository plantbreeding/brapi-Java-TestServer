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
	private PedigreeNodeEntity thisNode;
	@ManyToOne
	private PedigreeNodeEntity conncetedNode;
	@Column
	private ParentType parentType;
	@Column
	private EdgeType edgeType;
	

	public PedigreeNodeEntity getThisNode() {
		return thisNode;
	}
	public void setThisNode(PedigreeNodeEntity thisNode) {
		this.thisNode = thisNode;
	}
	public EdgeType getEdgeType() {
		return edgeType;
	}
	public void setEdgeType(EdgeType edgeType) {
		this.edgeType = edgeType;
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
    
	public enum EdgeType{
		parent, child, sibling
	}
}
