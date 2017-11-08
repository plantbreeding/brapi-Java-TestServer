package org.brapi.test.BrAPITestServer.model.entity;

import java.util.List;

public class GermplasmSummary {
	private String germplasmDbId;
	private String entryNumber;
	private String germplasmName;
	private String pedigree;
	private String seedSource;
	private String accessionNumber;
	private String germplasmPUI;
	private List<String> synonyms;
	public String getGermplasmDbId() {
		return germplasmDbId;
	}
	public void setGermplasmDbId(String germplasmDbId) {
		this.germplasmDbId = germplasmDbId;
	}
	public String getEntryNumber() {
		return entryNumber;
	}
	public void setEntryNumber(String entryNumber) {
		this.entryNumber = entryNumber;
	}
	public String getGermplasmName() {
		return germplasmName;
	}
	public void setGermplasmName(String germplasmName) {
		this.germplasmName = germplasmName;
	}
	public String getPedigree() {
		return pedigree;
	}
	public void setPedigree(String pedigree) {
		this.pedigree = pedigree;
	}
	public String getSeedSource() {
		return seedSource;
	}
	public void setSeedSource(String seedSource) {
		this.seedSource = seedSource;
	}
	public String getAccessionNumber() {
		return accessionNumber;
	}
	public void setAccessionNumber(String accessionNumber) {
		this.accessionNumber = accessionNumber;
	}
	public String getGermplasmPUI() {
		return germplasmPUI;
	}
	public void setGermplasmPUI(String germplasmPUI) {
		this.germplasmPUI = germplasmPUI;
	}
	public List<String> getSynonyms() {
		return synonyms;
	}
	public void setSynonyms(List<String> synonyms) {
		this.synonyms = synonyms;
	}
}
