package org.brapi.test.BrAPITestServer.model.entity.geno;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIBaseEntity;

import io.swagger.model.WSMIMEDataTypes;
import io.swagger.model.geno.GenoFileDataFormatEnum;

@Entity
@Table(name = "variantset_format")
public class VariantSetAvailableFormatEntity extends BrAPIBaseEntity {
	@ManyToOne
	private VariantSetEntity variantSet;
	@Column
	private GenoFileDataFormatEnum dataFormat;
	@Column
	private WSMIMEDataTypes fileFormat;
	@Column
	private String fileURL;
	
	public VariantSetEntity getVariantSet() {
		return variantSet;
	}
	public void setVariantSet(VariantSetEntity variantSet) {
		this.variantSet = variantSet;
	}
	public GenoFileDataFormatEnum getDataFormat() {
		return dataFormat;
	}
	public void setDataFormat(GenoFileDataFormatEnum dataFormat) {
		this.dataFormat = dataFormat;
	}
	public WSMIMEDataTypes getFileFormat() {
		return fileFormat;
	}
	public void setFileFormat(WSMIMEDataTypes fileFormat) {
		this.fileFormat = fileFormat;
	}
	public String getFileURL() {
		return fileURL;
	}
	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}
}
