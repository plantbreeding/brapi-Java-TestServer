package org.brapi.test.BrAPITestServer.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="program")
public class ProgramEntity extends BaseEntity{
	@Column
	private String name;
	@Column
	private String abbreviation;
	@Column
	private String objective;
	@Column
	private String leadPerson;
	@ManyToOne
	private CropEntity crop;
	@OneToMany(mappedBy="program")
	private List<TrialEntity> trials;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public String getObjective() {
		return objective;
	}
	public void setObjective(String objective) {
		this.objective = objective;
	}
	public String getLeadPerson() {
		return leadPerson;
	}
	public void setLeadPerson(String leadPerson) {
		this.leadPerson = leadPerson;
	}
}
