package org.brapi.test.BrAPITestServer.model.entity.germ;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;

import io.swagger.model.germ.CrossType;
import io.swagger.model.germ.PlannedCrossNewRequest.PlannedCrossStatusEnum;

@Entity
@Table(name="cross_entity")
public class CrossEntity extends BrAPIPrimaryEntity {
	@Column
    private CrossType crossType;
    @ManyToOne(fetch = FetchType.LAZY)
    private CrossingProjectEntity crossingProject;
    @Column
    private String name;
    @Column
    private PlannedCrossStatusEnum status;
    @OneToOne(fetch = FetchType.LAZY)
    private CrossEntity plannedCross;
    @OneToMany(mappedBy = "cross", cascade = CascadeType.ALL)
    private List<CrossParentEntity> parents;
    @OneToMany(mappedBy = "cross", cascade = CascadeType.ALL)
    private List<CrossPollinationEventEntity> pollinationEvents;
    @ElementCollection
    private List<String> crossAttributes;
    @Column
    private Boolean planned;

    
	public PlannedCrossStatusEnum getStatus() {
		return status;
	}
	public void setStatus(PlannedCrossStatusEnum status) {
		this.status = status;
	}
	public CrossEntity getPlannedCross() {
		return plannedCross;
	}
	public void setPlannedCross(CrossEntity plannedCross) {
		this.plannedCross = plannedCross;
	}
	public List<CrossPollinationEventEntity> getPollinationEvents() {
		return pollinationEvents;
	}
	public void setPollinationEvents(List<CrossPollinationEventEntity> pollinationEvents) {
		this.pollinationEvents = pollinationEvents;
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
