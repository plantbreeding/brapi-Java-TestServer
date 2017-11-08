package org.brapi.test.BrAPITestServer.model.rest;

public class Program {
	private String programDbId;
	private String name;
	private String abbreviation;
	private String objective;
	private String leadPerson;
	public String getProgramDbId() {
		return programDbId;
	}
	public void setProgramDbId(String programDbId) {
		this.programDbId = programDbId;
	}
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
