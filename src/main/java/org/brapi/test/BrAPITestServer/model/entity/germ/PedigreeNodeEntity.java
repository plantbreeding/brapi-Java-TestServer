package org.brapi.test.BrAPITestServer.model.entity.germ;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.*;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.PedigreeEdgeEntity.EdgeType;

import io.swagger.model.germ.ParentType;

@Entity
@Table(name = "pedigree_node",
		indexes = {
			@Index(name = "pedigree_node_germplasm_id", columnList = "germplasm_id"),
		}
)
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
	@OneToMany(mappedBy = "thisNode", cascade = CascadeType.ALL)
	private List<PedigreeEdgeEntity> edges = new ArrayList<>();

	@Override
	public int hashCode() {
		return Objects.hash(germplasm);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedigreeNodeEntity other = (PedigreeNodeEntity) obj;
		return Objects.equals(germplasm, other.germplasm);
	}

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
		return edges.stream().filter(e -> {
			return e.getEdgeType() == EdgeType.parent;
		}).collect(Collectors.toList());
	}

	public List<PedigreeNodeEntity> getParentNodes() {
		return edges.stream().filter(e -> {
			return e.getEdgeType() == EdgeType.parent;
		}).map(edge -> edge.getConncetedNode()).collect(Collectors.toList());
	}

	public List<PedigreeEdgeEntity> getProgenyEdges() {
		return edges.stream().filter(e -> {
			return e.getEdgeType() == EdgeType.child;
		}).collect(Collectors.toList());
	}

	public List<PedigreeNodeEntity> getProgenyNodes() {
		return edges.stream().filter(e -> {
			return e.getEdgeType() == EdgeType.child;
		}).map(edge -> edge.getConncetedNode()).collect(Collectors.toList());
	}

	public void addParent(PedigreeNodeEntity node, ParentType type) {
		PedigreeEdgeEntity edge = new PedigreeEdgeEntity();
		edge.setThisNode(this);
		edge.setConncetedNode(node);
		edge.setParentType(type);
		edge.setEdgeType(EdgeType.parent);
		if(edges == null) 
			edges = new ArrayList<>();
		edges.add(edge);
	}

	public void addProgeny(PedigreeNodeEntity node, ParentType type) {
		PedigreeEdgeEntity edge = new PedigreeEdgeEntity();
		edge.setThisNode(this);
		edge.setConncetedNode(node);
		edge.setParentType(type);
		edge.setEdgeType(EdgeType.child);
		if(edges == null) 
			edges = new ArrayList<>();
		edges.add(edge);
	}
}
