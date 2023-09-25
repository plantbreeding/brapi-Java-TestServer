package org.brapi.test.BrAPITestServer.model.entity.core;

import javax.persistence.*;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;

@Entity
@Table(name = "study_data_link")
public class DataLinkEntity extends BrAPIBaseEntity {
	@Column
	private String dataFormat;
	@Column
	private String description;
	@Column
	private String fileFormat;
	@Column
	private String name;
	@Column
	private String provenance;
	@Column
	private String scientificType;
	@Column
	private String url;
	@Column
	private String version;
	@ManyToOne(fetch = FetchType.LAZY)
	private StudyEntity study;

	public String getDataFormat() {
		return dataFormat;
	}

	public void setDataFormat(String dataFormat) {
		this.dataFormat = dataFormat;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFileFormat() {
		return fileFormat;
	}

	public void setFileFormat(String fileFormat) {
		this.fileFormat = fileFormat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProvenance() {
		return provenance;
	}

	public void setProvenance(String provenance) {
		this.provenance = provenance;
	}

	public String getScientificType() {
		return scientificType;
	}

	public void setScientificType(String scientificType) {
		this.scientificType = scientificType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
