package org.brapi.test.BrAPITestServer.model.rest;

public class Pedigree {
    private String germplasmDbId;
    private String defaultDisplayName;
    private String pedigree;
    private String parent1Id_dep;
    private String parent2Id_dep;
    private String parent1DbId;
    private String parent2DbId;
    
	public String getGermplasmDbId() {
		return germplasmDbId;
	}
	public void setGermplasmDbId(String germplasmDbId) {
		this.germplasmDbId = germplasmDbId;
	}
	public String getDefaultDisplayName() {
		return defaultDisplayName;
	}
	public void setDefaultDisplayName(String defaultDisplayName) {
		this.defaultDisplayName = defaultDisplayName;
	}
	public String getPedigree() {
		return pedigree;
	}
	public void setPedigree(String pedigree) {
		this.pedigree = pedigree;
	}
	public String getParent1Id() {
		return parent1Id_dep;
	}
	public void setParent1Id(String parent1Id) {
		this.parent1Id_dep = parent1Id;
	}
	public String getParent2Id() {
		return parent2Id_dep;
	}
	public void setParent2Id(String parent2Id) {
		this.parent2Id_dep = parent2Id;
	}
	public String getParent1DbId() {
		return parent1DbId;
	}
	public void setParent1DbId(String parent1DbId) {
		this.parent1DbId = parent1DbId;
	}
	public String getParent2DbId() {
		return parent2DbId;
	}
	public void setParent2DbId(String parent2DbId) {
		this.parent2DbId = parent2DbId;
	}
    
}
