package org.brapi.test.BrAPITestServer.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="study_addtional_info")
public class StudyAddtionalInfoEntity extends BaseEntity{
	@Column
	private String studyDbId;
	@Column
	private String key;
	@Column
	private String value;
}
