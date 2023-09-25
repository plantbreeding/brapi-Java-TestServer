package org.brapi.test.BrAPITestServer.model.entity.germ;

import java.util.List;

import javax.persistence.*;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.ProgramEntity;

@Entity
@Table(name = "crossing_project")
public class CrossingProjectEntity extends BrAPIPrimaryEntity {
	@Column
	private String name;
	@Column
	private String description;
	@ManyToOne(fetch = FetchType.LAZY)
	private ProgramEntity program;
	@OneToMany(mappedBy = "crossingProject")
	private List<CrossParentEntity> potentialParents;

	public List<CrossParentEntity> getPotentialParents() {
		return potentialParents;
	}

	public void setPotentialParents(List<CrossParentEntity> potentialParents) {
		this.potentialParents = potentialParents;
	}

	public ProgramEntity getProgram() {
		return program;
	}

	public void setProgram(ProgramEntity program) {
		this.program = program;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
