package org.brapi.test.BrAPITestServer.model.entity.germ;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;

import io.swagger.model.germ.CrossType;

@Entity
@Table(name="cross_entity")
public class CrossEntity extends BrAPIPrimaryEntity {
	@Column
    private CrossType crossType;
    @ManyToOne
    private CrossingProjectEntity crossingProject;
    @Column
    private String name;
    @OneToMany(mappedBy = "cross")
    private List<CrossParentEntity> parents;
    @Column
    private Date pollinationTimeStamp;
    @ElementCollection
    private List<String> crossAttributes;
    @Column
    private Boolean planned;
    
	public Date getPollinationTimeStamp() {
		return pollinationTimeStamp;
	}
	public void setPollinationTimeStamp(Date pollinationTimeStamp) {
		this.pollinationTimeStamp = pollinationTimeStamp;
	}
	public List<String> getCrossAttributes() {
		return crossAttributes;
	}
	public void setCrossAttributes(List<String> crossAttributes) {
		this.crossAttributes = crossAttributes;
	}
	public Boolean getPlanned() {
		return planned;
	}
	public void setPlanned(Boolean planned) {
		this.planned = planned;
	}
	public CrossType getCrossType() {
		return crossType;
	}
	public void setCrossType(CrossType crossType) {
		this.crossType = crossType;
	}
	public CrossingProjectEntity getCrossingProject() {
		return crossingProject;
	}
	public void setCrossingProject(CrossingProjectEntity crossingProject) {
		this.crossingProject = crossingProject;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<CrossParentEntity> getParents() {
		return parents;
	}
	public void setParents(List<CrossParentEntity> parents) {
		this.parents = parents;
	}
	public void addParentItem(CrossParentEntity parent) {
		if (getParents() == null)
			setParents(new ArrayList<>());
		getParents().add(parent);
	}
}
