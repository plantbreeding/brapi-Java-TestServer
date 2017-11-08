package org.brapi.test.BrAPITestServer.model.rest;

import java.util.List;

public class Germplasm {
	private String germplasmDbId;
    private String defaultDisplayName;
    private String accessionNumber;
    private String germplasmName;
    private String germplasmPUI;
    private String pedigree;
    private String germplasmSeedSource;
    private List<String> synonyms;
    private String commonCropName;
    private String instituteCode;
    private String instituteName;
    private int biologicalStatusOfAccessionCode;
    private String countryOfOriginCode;
    private List<Integer> typeOfGermplasmStorageCode;
    private String genus;
    private String species;
    private List<TaxonID> taxonIds;
    private String speciesAuthority;
    private String subtaxa;
    private String subtaxaAuthority;
    private List<Donor> donors;
    private String acquisitionDate;
    
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
	public String getAccessionNumber() {
		return accessionNumber;
	}
	public void setAccessionNumber(String accessionNumber) {
		this.accessionNumber = accessionNumber;
	}
	public String getGermplasmName() {
		return germplasmName;
	}
	public void setGermplasmName(String germplasmName) {
		this.germplasmName = germplasmName;
	}
	public String getGermplasmPUI() {
		return germplasmPUI;
	}
	public void setGermplasmPUI(String germplasmPUI) {
		this.germplasmPUI = germplasmPUI;
	}
	public String getPedigree() {
		return pedigree;
	}
	public void setPedigree(String pedigree) {
		this.pedigree = pedigree;
	}
	public String getGermplasmSeedSource() {
		return germplasmSeedSource;
	}
	public void setGermplasmSeedSource(String germplasmSeedSource) {
		this.germplasmSeedSource = germplasmSeedSource;
	}
	public List<String> getSynonyms() {
		return synonyms;
	}
	public void setSynonyms(List<String> synonyms) {
		this.synonyms = synonyms;
	}
	public String getCommonCropName() {
		return commonCropName;
	}
	public void setCommonCropName(String commonCropName) {
		this.commonCropName = commonCropName;
	}
	public String getInstituteCode() {
		return instituteCode;
	}
	public void setInstituteCode(String instituteCode) {
		this.instituteCode = instituteCode;
	}
	public String getInstituteName() {
		return instituteName;
	}
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	public int getBiologicalStatusOfAccessionCode() {
		return biologicalStatusOfAccessionCode;
	}
	public void setBiologicalStatusOfAccessionCode(int biologicalStatusOfAccessionCode) {
		this.biologicalStatusOfAccessionCode = biologicalStatusOfAccessionCode;
	}
	public String getCountryOfOriginCode() {
		return countryOfOriginCode;
	}
	public void setCountryOfOriginCode(String countryOfOriginCode) {
		this.countryOfOriginCode = countryOfOriginCode;
	}
	public List<Integer> getTypeOfGermplasmStorageCode() {
		return typeOfGermplasmStorageCode;
	}
	public void setTypeOfGermplasmStorageCode(List<Integer> typeOfGermplasmStorageCode) {
		this.typeOfGermplasmStorageCode = typeOfGermplasmStorageCode;
	}
	public String getGenus() {
		return genus;
	}
	public void setGenus(String genus) {
		this.genus = genus;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public List<TaxonID> getTaxonIds() {
		return taxonIds;
	}
	public void setTaxonIds(List<TaxonID> taxonIds) {
		this.taxonIds = taxonIds;
	}
	public String getSpeciesAuthority() {
		return speciesAuthority;
	}
	public void setSpeciesAuthority(String speciesAuthority) {
		this.speciesAuthority = speciesAuthority;
	}
	public String getSubtaxa() {
		return subtaxa;
	}
	public void setSubtaxa(String subtaxa) {
		this.subtaxa = subtaxa;
	}
	public String getSubtaxaAuthority() {
		return subtaxaAuthority;
	}
	public void setSubtaxaAuthority(String subtaxaAuthority) {
		this.subtaxaAuthority = subtaxaAuthority;
	}
	public List<Donor> getDonors() {
		return donors;
	}
	public void setDonors(List<Donor> donors) {
		this.donors = donors;
	}
	public String getAcquisitionDate() {
		return acquisitionDate;
	}
	public void setAcquisitionDate(String acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}
    
    
}
