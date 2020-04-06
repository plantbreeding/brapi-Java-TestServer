package org.brapi.test.BrAPITestServer.model.entity.geno;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.StudyEntity;

@Entity
@Table(name="allele_matrix")
public class AlleleMatrixEntity extends BrAPIBaseEntity{
	@Column()
	private String name;
	@Column()
	private String description;
	@Column()
	private Date lastUpdated;
	@ManyToOne(cascade=CascadeType.DETACH)
	private StudyEntity study;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public StudyEntity getStudy() {
		return study;
	}
	public void setStudy(StudyEntity study) {
		this.study = study;
	}
	
}
