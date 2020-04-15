package org.brapi.test.BrAPITestServer.model.entity.pheno;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;
import org.brapi.test.BrAPITestServer.model.entity.GeoJSONEntity;

@Entity
@Table(name = "image")
public class ImageEntity extends BrAPIPrimaryEntity {
	@Column
	private byte[] imageData;
	@ManyToOne(cascade = CascadeType.DETACH)
	private ObservationUnitEntity observationUnit;
	@Column
	private String name;
	@Column
	private String imageFileName;
	@Column
	private String description;
	@Column
	private String imageURL;
	@Column
	private Integer imageFileSize;
	@Column
	private Integer imageHeight;
	@Column
	private Integer imageWidth;
	@Column
	private String imageMIMEType;
	@ElementCollection
	private List<String> descriptiveOntologyTerms;
	@ManyToMany
	@JoinTable
	private List<ObservationEntity> observations;
	@Column
	private String copyright;
	@Column
	private Date timeStamp;
	@OneToOne
	private GeoJSONEntity coordinates;

	public List<String> getDescriptiveOntologyTerms() {
		return descriptiveOntologyTerms;
	}

	public void setDescriptiveOntologyTerms(List<String> descriptiveOntologyTerms) {
		this.descriptiveOntologyTerms = descriptiveOntologyTerms;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public GeoJSONEntity getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(GeoJSONEntity coordinates) {
		this.coordinates = coordinates;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	public ObservationUnitEntity getObservationUnit() {
		return observationUnit;
	}

	public void setObservationUnit(ObservationUnitEntity observationUnit) {
		this.observationUnit = observationUnit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public Integer getImageFileSize() {
		return imageFileSize;
	}

	public void setImageFileSize(Integer imageFileSize) {
		this.imageFileSize = imageFileSize;
	}

	public Integer getImageHeight() {
		return imageHeight;
	}

	public void setImageHeight(Integer imageHeight) {
		this.imageHeight = imageHeight;
	}

	public Integer getImageWidth() {
		return imageWidth;
	}

	public void setImageWidth(Integer imageWidth) {
		this.imageWidth = imageWidth;
	}

	public String getImageMIMEType() {
		return imageMIMEType;
	}

	public void setImageMIMEType(String imageMIMEType) {
		this.imageMIMEType = imageMIMEType;
	}

	public List<ObservationEntity> getObservations() {
		return observations;
	}

	public void setObservations(List<ObservationEntity> observations) {
		this.observations = observations;
	}

}
