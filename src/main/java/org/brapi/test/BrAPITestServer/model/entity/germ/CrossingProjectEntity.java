package org.brapi.test.BrAPITestServer.model.entity.germ;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.ProgramEntity;

@Entity
@Table(name = "crossing_project")
public class CrossingProjectEntity extends BrAPIPrimaryEntity {
	@Column
	private String name;
	@Column
	private String description;
	@ManyToOne
	private ProgramEntity program;

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
