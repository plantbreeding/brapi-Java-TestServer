package org.brapi.test.BrAPITestServer.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="genome_map")
public class GenomeMapEntity extends BaseEntity{
	@Column
	private String name;
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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public List<LinkageGroupEntity> getLinkageGroups() {
		return linkageGroups;
	}
	public void setLinkageGroups(List<LinkageGroupEntity> linkageGroups) {
		this.linkageGroups = linkageGroups;
	}
}
