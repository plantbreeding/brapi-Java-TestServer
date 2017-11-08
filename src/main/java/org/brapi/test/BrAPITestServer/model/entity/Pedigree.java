package org.brapi.test.BrAPITestServer.model.entity;

public class Pedigree {
    private String germplasmDbId;
    private String defaultDisplayName;
    private String pedigree;
    private String parent1Id;
    private String parent2Id;
    
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
		return parent1Id;
	}
	public void setParent1Id(String parent1Id) {
		this.parent1Id = parent1Id;
	}
	public String getParent2Id() {
		return parent2Id;
	}
	public void setParent2Id(String parent2Id) {
		this.parent2Id = parent2Id;
	}
    
}
