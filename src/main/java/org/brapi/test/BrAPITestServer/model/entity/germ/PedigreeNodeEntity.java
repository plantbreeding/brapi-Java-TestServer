package org.brapi.test.BrAPITestServer.model.entity.germ;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;

import io.swagger.model.germ.ParentType;

@Entity
@Table(name = "pedigree_node")
public class PedigreeNodeEntity extends BrAPIPrimaryEntity {
	@ManyToOne
	private CrossingProjectEntity crossingProject;
	@Column
	private Integer crossingYear;
	@Column
	private String familyCode;
	@OneToOne(cascade = CascadeType.ALL)
	private GermplasmEntity germplasm;
	@Column
	private String pedigreeString;
	@OneToMany(mappedBy = "parentNode")
	private List<PedigreeEdgeEntity> parents;
	@OneToMany(mappedBy = "childNode")
	private List<PedigreeEdgeEntity> progeny;
	@OneToMany(mappedBy = "siblingNode")
	private List<PedigreeEdgeEntity> siblings;

	public CrossingProjectEntity getCrossingProject() {
		return crossingProject;
	}

	public void setCrossingProject(CrossingProjectEntity crossingProject) {
		this.crossingProject = crossingProject;
	}

	public Integer getCrossingYear() {
		return crossingYear;
	}

	public void setCrossingYear(Integer crossingYear) {
		this.crossingYear = crossingYear;
	}

	public String getFamilyCode() {
		return familyCode;
	}

	public void setFamilyCode(String familyCode) {
		this.familyCode = familyCode;
	}

	public GermplasmEntity getGermplasm() {
		return germplasm;
	}

	public void setGermplasm(GermplasmEntity germplasm) {
		this.germplasm = germplasm;
	}

	public String getPedigreeString() {
		return pedigreeString;
	}

	public void setPedigreeString(String pedigreeString) {
		this.pedigreeString = pedigreeString;
	}

	public List<PedigreeEdgeEntity> getParentEdges() {
		return parents;
	}

	public List<PedigreeNodeEntity> getParentNodes() {
		return parents.stream().map(edge -> edge.getConncetedNode()).collect(Collectors.toList());
	}

	public void setParents(List<PedigreeEdgeEntity> parents) {
		this.parents = parents;
	}

	public List<PedigreeEdgeEntity> getProgenyEdges() {
		return progeny;
	}

	public List<PedigreeNodeEntity> getProgenyNodes() {
		return progeny.stream().map(edge -> edge.getConncetedNode()).collect(Collectors.toList());
	}

	public void setProgeny(List<PedigreeEdgeEntity> progeny) {
		this.progeny = progeny;
	}

	public List<PedigreeEdgeEntity> getSiblingEdges() {
		return siblings;
	}

	public List<PedigreeNodeEntity> getSiblingNodes() {
		return siblings.stream().map(edge -> edge.getConncetedNode()).collect(Collectors.toList());
	}

	public void setSiblings(List<PedigreeEdgeEntity> siblings) {
		this.siblings = siblings;
	}

	public void addParent(PedigreeNodeEntity node, ParentType type) {
		PedigreeEdgeEntity edge = new PedigreeEdgeEntity();
		edge.setParentNode(this);
		edge.setConncetedNode(node);
		edge.setParentType(type);
		if(getParentEdges() == null) {
			setParents(new ArrayList<>());
		}
		getParentEdges().add(edge);
	}

	public void addProgeny(PedigreeNodeEntity node, ParentType type) {
		PedigreeEdgeEntity edge = new PedigreeEdgeEntity();
		edge.setChildNode(this);
		edge.setConncetedNode(node);
		edge.setParentType(type);
		if(getProgenyEdges() == null) {
			setProgeny(new ArrayList<>());
		}
		getProgenyEdges().add(edge);
	}

	public void addSibling(PedigreeNodeEntity node) {
		PedigreeEdgeEntity edge = new PedigreeEdgeEntity();
		edge.setSiblingNode(this);
		edge.setConncetedNode(node);
		if(getSiblingEdges() == null) {
			setSiblings(new ArrayList<>());
		}
		getSiblingEdges().add(edge);
	}

}
