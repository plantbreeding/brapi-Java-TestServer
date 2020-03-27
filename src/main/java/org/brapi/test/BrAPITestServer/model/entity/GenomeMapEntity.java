package org.brapi.test.BrAPITestServer.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="genome_map")
public class GenomeMapEntity extends BrAPIBaseEntity{

	@Column
	private String name;
	@Column
	private String commonCropName;
	@Column
	private String documentationURL;
	@Column
	private String scientificName;
	@Column
	private String species;
	@Column
	private String type;
	@Column
	private String unit;
	@Column
	private Date publishedDate;
	@Column
	private String comments;
	@OneToMany(mappedBy="genomeMapDbId")
	private List<LinkageGroupEntity> linkageGroups;
	
	public String getCommonCropName() {
		return commonCropName;
	}
	public void setCommonCropName(String commonCropName) {
		this.commonCropName = commonCropName;
	}
	public String getDocumentationURL() {
		return documentationURL;
	}
	public void setDocumentationURL(String documentationURL) {
		this.documentationURL = documentationURL;
	}
	public String getScientificName() {
		return scientificName;
	}
	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}
	public String getComments() {
		return comments;
	}
	public List<LinkageGroupEntity> getLinkageGroups() {
		return linkageGroups;
	}
	public String getName() {
		return name;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public String getSpecies() {
		return species;
	}
	public String getType() {
		return type;
	}
	public String getUnit() {
		return unit;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public void setLinkageGroups(List<LinkageGroupEntity> linkageGroups) {
		this.linkageGroups = linkageGroups;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
}
