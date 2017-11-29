package org.brapi.test.BrAPITestServer.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="crop")
public class CropEntity extends BaseEntity {
	@Column(name="crop_name")
	private String cropName;
	
	@OneToMany(mappedBy="crop")
	private List<ProgramEntity> program;

	public String getCropName() {
		return cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
}
