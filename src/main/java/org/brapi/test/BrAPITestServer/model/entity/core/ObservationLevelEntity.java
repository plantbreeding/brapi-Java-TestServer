package org.brapi.test.BrAPITestServer.model.entity.core;

import javax.persistence.*;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;

@Entity
@Table(name = "study_observation_level")
public class ObservationLevelEntity extends BrAPIBaseEntity {
	@Column
	private String levelName;
	@Column
	private Integer levelOrder;
	@ManyToOne(fetch = FetchType.LAZY)
	private StudyEntity study;
	
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	public Integer getLevelOrder() {
		return levelOrder;
	}
	public void setLevelOrder(Integer levelOrder) {
		this.levelOrder = levelOrder;
	}
}
