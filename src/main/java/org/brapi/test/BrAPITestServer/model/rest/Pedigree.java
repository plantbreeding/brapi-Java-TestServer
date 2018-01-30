package org.brapi.test.BrAPITestServer.model.rest;

public class Pedigree {
    private String germplasmDbId;
    private String defaultDisplayName;
    private String pedigree;
    private String parent1Id;
    private String parent2Id;
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
	public String getParent1Id_dep() {
		return parent1Id;
	}
	public void setParent1Id_dep(String parent1Id) {
		this.parent1Id = parent1Id;
	}
	public String getParent2Id_dep() {
		return parent2Id;
	}
	public void setParent2Id_dep(String parent2Id) {
		this.parent2Id = parent2Id;
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
