package org.brapi.test.BrAPITestServer.model.entity.core;

import java.util.Date;

import javax.persistence.*;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;

@Entity
@Table(name = "study_last_update")
public class StudyLastUpdateEntity extends BrAPIBaseEntity {
	@Column
	private Date timestamp;
	@Column
	private String version;
	@OneToOne(fetch = FetchType.LAZY)
	private StudyEntity study;

	public StudyEntity getStudy() {
		return study;
	}

	public void setStudy(StudyEntity study) {
		this.study = study;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
