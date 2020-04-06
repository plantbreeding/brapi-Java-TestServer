package org.brapi.test.BrAPITestServer.model.entity.geno.vendor;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;
import org.brapi.test.BrAPITestServer.model.entity.geno.SampleEntity;

@Entity
@Table(name = "vendor_file")
public class VendorFileEntity extends BrAPIBaseEntity {
	@Column
	private String filename;
	@Column
	private String URL;
	@Column
	private String md5sum;
	@Column
	private String fileType;
	@ManyToOne
	private VendorOrderEntity order;
	@ManyToMany(cascade= CascadeType.ALL)
	@JoinTable(name = "vendor_file_sample", joinColumns = {
			@JoinColumn(name = "verndor_file_dbid", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "sample_dbid", referencedColumnName = "id") })
	private List<SampleEntity> samples;

	public VendorOrderEntity getOrder() {
		return order;
	}

	public void setOrder(VendorOrderEntity order) {
		this.order = order;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getMd5sum() {
		return md5sum;
	}

	public void setMd5sum(String md5sum) {
		this.md5sum = md5sum;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public List<SampleEntity> getSamples() {
		return samples;
	}

	public void setSamples(List<SampleEntity> samples) {
		this.samples = samples;
	}
}
