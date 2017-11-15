package org.brapi.test.BrAPITestServer.model.rest;

import java.util.List;

public class GermplasmSearchRequest {
	private List<String> germplasmPUIs;
	private List<String> germplasmDbIds;
	private  List<String> germplasmSpecies;
	private List<String> germplasmGenus;
	private List<String> germplasmNames;
	private  List<String> accessionNumbers;
	private  int pageSize;
	private  int page;
	public List<String> getGermplasmPUIs() {
		return germplasmPUIs;
	}
	public void setGermplasmPUIs(List<String> germplasmPUIs) {
		this.germplasmPUIs = germplasmPUIs;
	}
	public List<String> getGermplasmDbIds() {
		return germplasmDbIds;
	}
	public void setGermplasmDbIds(List<String> germplasmDbIds) {
		this.germplasmDbIds = germplasmDbIds;
	}
	public List<String> getGermplasmSpecies() {
		return germplasmSpecies;
	}
	public void setGermplasmSpecies(List<String> germplasmSpecies) {
		this.germplasmSpecies = germplasmSpecies;
	}
	public List<String> getGermplasmGenus() {
		return germplasmGenus;
	}
	public void setGermplasmGenus(List<String> germplasmGenus) {
		this.germplasmGenus = germplasmGenus;
	}
	public List<String> getGermplasmNames() {
		return germplasmNames;
	}
	public void setGermplasmNames(List<String> germplasmNames) {
		this.germplasmNames = germplasmNames;
	}
	public List<String> getAccessionNumbers() {
		return accessionNumbers;
	}
	public void setAccessionNumbers(List<String> accessionNumbers) {
		this.accessionNumbers = accessionNumbers;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	
}
