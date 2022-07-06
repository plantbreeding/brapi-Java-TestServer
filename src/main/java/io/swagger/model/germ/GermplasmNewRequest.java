package io.swagger.model.germ;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.BrAPIDataModel;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class GermplasmNewRequest extends BrAPIDataModel {
	@JsonProperty("accessionNumber")
	private String accessionNumber = null;

	@JsonProperty("acquisitionDate")
	private LocalDate acquisitionDate = null;

	@JsonProperty("biologicalStatusOfAccessionCode")
	private BiologicalStatusOfAccessionCode biologicalStatusOfAccessionCode = null;

	@JsonProperty("biologicalStatusOfAccessionDescription")
	private String biologicalStatusOfAccessionDescription = null;

	@JsonProperty("breedingMethodDbId")
	private String breedingMethodDbId = null;
	
	@JsonProperty("breedingMethodName")
	private String breedingMethodName = null;

	@JsonProperty("collection")
	private String collection = null;

	@JsonProperty("commonCropName")
	private String commonCropName = null;

	@JsonProperty("countryOfOriginCode")
	private String countryOfOriginCode = null;

	@JsonProperty("defaultDisplayName")
	private String defaultDisplayName = null;

	@JsonProperty("documentationURL")
	private String documentationURL = null;

	@JsonProperty("donors")
	private List<GermplasmNewRequestDonors> donors = null;

	@JsonProperty("genus")
	private String genus = null;

	@JsonProperty("germplasmName")
	private String germplasmName = null;

	@JsonProperty("germplasmOrigin")
	private List<GermplasmOrigin> germplasmOrigin = null;

	@JsonProperty("germplasmPUI")
	private String germplasmPUI = null;

	@JsonProperty("germplasmPreprocessing")
	private String germplasmPreprocessing = null;

	@JsonProperty("instituteCode")
	private String instituteCode = null;

	@JsonProperty("instituteName")
	private String instituteName = null;

	@JsonProperty("pedigree")
	private String pedigree = null;

	@JsonProperty("seedSource")
	private String seedSource = null;

	@JsonProperty("seedSourceDescription")
	private String seedSourceDescription = null;

	@JsonProperty("species")
	private String species = null;

	@JsonProperty("speciesAuthority")
	private String speciesAuthority = null;

	@JsonProperty("storageTypes")
	private List<GermplasmStorageTypes> storageTypes = null;

	@JsonProperty("subtaxa")
	private String subtaxa = null;

	@JsonProperty("subtaxaAuthority")
	private String subtaxaAuthority = null;

	@JsonProperty("synonyms")
	private List<GermplasmNewRequestSynonyms> synonyms = null;

	@JsonProperty("taxonIds")
	private List<TaxonID> taxonIds = null;

	public String getBreedingMethodName() {
		return breedingMethodName;
	}

	public void setBreedingMethodName(String breedingMethodName) {
		this.breedingMethodName = breedingMethodName;
	}

	public GermplasmNewRequest accessionNumber(String accessionNumber) {
		this.accessionNumber = accessionNumber;
		return this;
	}

	public String getAccessionNumber() {
		return accessionNumber;
	}

	public void setAccessionNumber(String accessionNumber) {
		this.accessionNumber = accessionNumber;
	}

	public GermplasmNewRequest acquisitionDate(LocalDate acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
		return this;
	}

	public LocalDate getAcquisitionDate() {
		return acquisitionDate;
	}

	public void setAcquisitionDate(LocalDate acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}

	public GermplasmNewRequest biologicalStatusOfAccessionCode(
			BiologicalStatusOfAccessionCode biologicalStatusOfAccessionCode) {
		this.biologicalStatusOfAccessionCode = biologicalStatusOfAccessionCode;
		return this;
	}

	public BiologicalStatusOfAccessionCode getBiologicalStatusOfAccessionCode() {
		return biologicalStatusOfAccessionCode;
	}

	public void setBiologicalStatusOfAccessionCode(BiologicalStatusOfAccessionCode biologicalStatusOfAccessionCode) {
		this.biologicalStatusOfAccessionCode = biologicalStatusOfAccessionCode;
	}

	public GermplasmNewRequest biologicalStatusOfAccessionDescription(String biologicalStatusOfAccessionDescription) {
		this.biologicalStatusOfAccessionDescription = biologicalStatusOfAccessionDescription;
		return this;
	}

	public String getBiologicalStatusOfAccessionDescription() {
		return biologicalStatusOfAccessionDescription;
	}

	public void setBiologicalStatusOfAccessionDescription(String biologicalStatusOfAccessionDescription) {
		this.biologicalStatusOfAccessionDescription = biologicalStatusOfAccessionDescription;
	}

	public GermplasmNewRequest breedingMethodDbId(String breedingMethodDbId) {
		this.breedingMethodDbId = breedingMethodDbId;
		return this;
	}

	public String getBreedingMethodDbId() {
		return breedingMethodDbId;
	}

	public void setBreedingMethodDbId(String breedingMethodDbId) {
		this.breedingMethodDbId = breedingMethodDbId;
	}

	public GermplasmNewRequest collection(String collection) {
		this.collection = collection;
		return this;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public GermplasmNewRequest commonCropName(String commonCropName) {
		this.commonCropName = commonCropName;
		return this;
	}

	public String getCommonCropName() {
		return commonCropName;
	}

	public void setCommonCropName(String commonCropName) {
		this.commonCropName = commonCropName;
	}

	public GermplasmNewRequest countryOfOriginCode(String countryOfOriginCode) {
		this.countryOfOriginCode = countryOfOriginCode;
		return this;
	}

	public String getCountryOfOriginCode() {
		return countryOfOriginCode;
	}

	public void setCountryOfOriginCode(String countryOfOriginCode) {
		this.countryOfOriginCode = countryOfOriginCode;
	}

	public GermplasmNewRequest defaultDisplayName(String defaultDisplayName) {
		this.defaultDisplayName = defaultDisplayName;
		return this;
	}

	public String getDefaultDisplayName() {
		return defaultDisplayName;
	}

	public void setDefaultDisplayName(String defaultDisplayName) {
		this.defaultDisplayName = defaultDisplayName;
	}

	public GermplasmNewRequest documentationURL(String documentationURL) {
		this.documentationURL = documentationURL;
		return this;
	}

	public String getDocumentationURL() {
		return documentationURL;
	}

	public void setDocumentationURL(String documentationURL) {
		this.documentationURL = documentationURL;
	}

	public GermplasmNewRequest donors(List<GermplasmNewRequestDonors> donors) {
		this.donors = donors;
		return this;
	}

	public GermplasmNewRequest addDonorsItem(GermplasmNewRequestDonors donorsItem) {
		if (this.donors == null) {
			this.donors = new ArrayList<GermplasmNewRequestDonors>();
		}
		this.donors.add(donorsItem);
		return this;
	}

	public List<GermplasmNewRequestDonors> getDonors() {
		return donors;
	}

	public void setDonors(List<GermplasmNewRequestDonors> donors) {
		this.donors = donors;
	}

	public GermplasmNewRequest genus(String genus) {
		this.genus = genus;
		return this;
	}

	public String getGenus() {
		return genus;
	}

	public void setGenus(String genus) {
		this.genus = genus;
	}

	public GermplasmNewRequest germplasmName(String germplasmName) {
		this.germplasmName = germplasmName;
		return this;
	}

	public String getGermplasmName() {
		return germplasmName;
	}

	public void setGermplasmName(String germplasmName) {
		this.germplasmName = germplasmName;
	}

	public GermplasmNewRequest germplasmOrigin(List<GermplasmOrigin> germplasmOrigin) {
		this.germplasmOrigin = germplasmOrigin;
		return this;
	}

	public GermplasmNewRequest addGermplasmOriginItem(GermplasmOrigin germplasmOriginItem) {
		if (this.germplasmOrigin == null) {
			this.germplasmOrigin = new ArrayList<GermplasmOrigin>();
		}
		this.germplasmOrigin.add(germplasmOriginItem);
		return this;
	}

	public List<GermplasmOrigin> getGermplasmOrigin() {
		return germplasmOrigin;
	}

	public void setGermplasmOrigin(List<GermplasmOrigin> germplasmOrigin) {
		this.germplasmOrigin = germplasmOrigin;
	}

	public GermplasmNewRequest germplasmPUI(String germplasmPUI) {
		this.germplasmPUI = germplasmPUI;
		return this;
	}

	public String getGermplasmPUI() {
		return germplasmPUI;
	}

	public void setGermplasmPUI(String germplasmPUI) {
		this.germplasmPUI = germplasmPUI;
	}

	public GermplasmNewRequest germplasmPreprocessing(String germplasmPreprocessing) {
		this.germplasmPreprocessing = germplasmPreprocessing;
		return this;
	}

	public String getGermplasmPreprocessing() {
		return germplasmPreprocessing;
	}

	public void setGermplasmPreprocessing(String germplasmPreprocessing) {
		this.germplasmPreprocessing = germplasmPreprocessing;
	}

	public GermplasmNewRequest instituteCode(String instituteCode) {
		this.instituteCode = instituteCode;
		return this;
	}

	public String getInstituteCode() {
		return instituteCode;
	}

	public void setInstituteCode(String instituteCode) {
		this.instituteCode = instituteCode;
	}

	public GermplasmNewRequest instituteName(String instituteName) {
		this.instituteName = instituteName;
		return this;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public GermplasmNewRequest pedigree(String pedigree) {
		this.pedigree = pedigree;
		return this;
	}

	public String getPedigree() {
		return pedigree;
	}

	public void setPedigree(String pedigree) {
		this.pedigree = pedigree;
	}

	public GermplasmNewRequest seedSource(String seedSource) {
		this.seedSource = seedSource;
		return this;
	}

	public String getSeedSource() {
		return seedSource;
	}

	public void setSeedSource(String seedSource) {
		this.seedSource = seedSource;
	}

	public GermplasmNewRequest seedSourceDescription(String seedSourceDescription) {
		this.seedSourceDescription = seedSourceDescription;
		return this;
	}

	public String getSeedSourceDescription() {
		return seedSourceDescription;
	}

	public void setSeedSourceDescription(String seedSourceDescription) {
		this.seedSourceDescription = seedSourceDescription;
	}

	public GermplasmNewRequest species(String species) {
		this.species = species;
		return this;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public GermplasmNewRequest speciesAuthority(String speciesAuthority) {
		this.speciesAuthority = speciesAuthority;
		return this;
	}

	public String getSpeciesAuthority() {
		return speciesAuthority;
	}

	public void setSpeciesAuthority(String speciesAuthority) {
		this.speciesAuthority = speciesAuthority;
	}

	public GermplasmNewRequest storageTypes(List<GermplasmStorageTypes> storageTypes) {
		this.storageTypes = storageTypes;
		return this;
	}

	public GermplasmNewRequest addStorageTypesItem(GermplasmStorageTypes storageTypesItem) {
		if (this.storageTypes == null) {
			this.storageTypes = new ArrayList<GermplasmStorageTypes>();
		}
		this.storageTypes.add(storageTypesItem);
		return this;
	}

	public List<GermplasmStorageTypes> getStorageTypes() {
		return storageTypes;
	}

	public void setStorageTypes(List<GermplasmStorageTypes> storageTypes) {
		this.storageTypes = storageTypes;
	}

	public GermplasmNewRequest subtaxa(String subtaxa) {
		this.subtaxa = subtaxa;
		return this;
	}

	public String getSubtaxa() {
		return subtaxa;
	}

	public void setSubtaxa(String subtaxa) {
		this.subtaxa = subtaxa;
	}

	public GermplasmNewRequest subtaxaAuthority(String subtaxaAuthority) {
		this.subtaxaAuthority = subtaxaAuthority;
		return this;
	}

	public String getSubtaxaAuthority() {
		return subtaxaAuthority;
	}

	public void setSubtaxaAuthority(String subtaxaAuthority) {
		this.subtaxaAuthority = subtaxaAuthority;
	}

	public GermplasmNewRequest synonyms(List<GermplasmNewRequestSynonyms> synonyms) {
		this.synonyms = synonyms;
		return this;
	}

	public GermplasmNewRequest addSynonymsItem(GermplasmNewRequestSynonyms synonymsItem) {
		if (this.synonyms == null) {
			this.synonyms = new ArrayList<GermplasmNewRequestSynonyms>();
		}
		this.synonyms.add(synonymsItem);
		return this;
	}

	public List<GermplasmNewRequestSynonyms> getSynonyms() {
		return synonyms;
	}

	public void setSynonyms(List<GermplasmNewRequestSynonyms> synonyms) {
		this.synonyms = synonyms;
	}

	public GermplasmNewRequest taxonIds(List<TaxonID> taxonIds) {
		this.taxonIds = taxonIds;
		return this;
	}

	public GermplasmNewRequest addTaxonIdsItem(TaxonID taxonIdsItem) {
		if (this.taxonIds == null) {
			this.taxonIds = new ArrayList<TaxonID>();
		}
		this.taxonIds.add(taxonIdsItem);
		return this;
	}

	public List<TaxonID> getTaxonIds() {
		return taxonIds;
	}

	public void setTaxonIds(List<TaxonID> taxonIds) {
		this.taxonIds = taxonIds;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		GermplasmNewRequest germplasmNewRequest = (GermplasmNewRequest) o;
		return Objects.equals(this.accessionNumber, germplasmNewRequest.accessionNumber)
				&& Objects.equals(this.acquisitionDate, germplasmNewRequest.acquisitionDate)
				&& Objects.equals(this.additionalInfo, germplasmNewRequest.additionalInfo)
				&& Objects.equals(this.biologicalStatusOfAccessionCode,
						germplasmNewRequest.biologicalStatusOfAccessionCode)
				&& Objects.equals(this.biologicalStatusOfAccessionDescription,
						germplasmNewRequest.biologicalStatusOfAccessionDescription)
				&& Objects.equals(this.breedingMethodDbId, germplasmNewRequest.breedingMethodDbId)
				&& Objects.equals(this.collection, germplasmNewRequest.collection)
				&& Objects.equals(this.commonCropName, germplasmNewRequest.commonCropName)
				&& Objects.equals(this.countryOfOriginCode, germplasmNewRequest.countryOfOriginCode)
				&& Objects.equals(this.defaultDisplayName, germplasmNewRequest.defaultDisplayName)
				&& Objects.equals(this.documentationURL, germplasmNewRequest.documentationURL)
				&& Objects.equals(this.donors, germplasmNewRequest.donors)
				&& Objects.equals(this.externalReferences, germplasmNewRequest.externalReferences)
				&& Objects.equals(this.genus, germplasmNewRequest.genus)
				&& Objects.equals(this.germplasmName, germplasmNewRequest.germplasmName)
				&& Objects.equals(this.germplasmOrigin, germplasmNewRequest.germplasmOrigin)
				&& Objects.equals(this.germplasmPUI, germplasmNewRequest.germplasmPUI)
				&& Objects.equals(this.germplasmPreprocessing, germplasmNewRequest.germplasmPreprocessing)
				&& Objects.equals(this.instituteCode, germplasmNewRequest.instituteCode)
				&& Objects.equals(this.instituteName, germplasmNewRequest.instituteName)
				&& Objects.equals(this.pedigree, germplasmNewRequest.pedigree)
				&& Objects.equals(this.seedSource, germplasmNewRequest.seedSource)
				&& Objects.equals(this.seedSourceDescription, germplasmNewRequest.seedSourceDescription)
				&& Objects.equals(this.species, germplasmNewRequest.species)
				&& Objects.equals(this.speciesAuthority, germplasmNewRequest.speciesAuthority)
				&& Objects.equals(this.storageTypes, germplasmNewRequest.storageTypes)
				&& Objects.equals(this.subtaxa, germplasmNewRequest.subtaxa)
				&& Objects.equals(this.subtaxaAuthority, germplasmNewRequest.subtaxaAuthority)
				&& Objects.equals(this.synonyms, germplasmNewRequest.synonyms)
				&& Objects.equals(this.taxonIds, germplasmNewRequest.taxonIds);
	}

	@Override
	public int hashCode() {
		return Objects.hash(accessionNumber, acquisitionDate, additionalInfo, biologicalStatusOfAccessionCode,
				biologicalStatusOfAccessionDescription, breedingMethodDbId, collection, commonCropName,
				countryOfOriginCode, defaultDisplayName, documentationURL, donors, externalReferences, genus,
				germplasmName, germplasmOrigin, germplasmPUI, germplasmPreprocessing, instituteCode, instituteName,
				pedigree, seedSource, seedSourceDescription, species, speciesAuthority, storageTypes, subtaxa,
				subtaxaAuthority, synonyms, taxonIds);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class GermplasmNewRequest {\n");

		sb.append("    accessionNumber: ").append(toIndentedString(accessionNumber)).append("\n");
		sb.append("    acquisitionDate: ").append(toIndentedString(acquisitionDate)).append("\n");
		sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
		sb.append("    biologicalStatusOfAccessionCode: ").append(toIndentedString(biologicalStatusOfAccessionCode))
				.append("\n");
		sb.append("    biologicalStatusOfAccessionDescription: ")
				.append(toIndentedString(biologicalStatusOfAccessionDescription)).append("\n");
		sb.append("    breedingMethodDbId: ").append(toIndentedString(breedingMethodDbId)).append("\n");
		sb.append("    collection: ").append(toIndentedString(collection)).append("\n");
		sb.append("    commonCropName: ").append(toIndentedString(commonCropName)).append("\n");
		sb.append("    countryOfOriginCode: ").append(toIndentedString(countryOfOriginCode)).append("\n");
		sb.append("    defaultDisplayName: ").append(toIndentedString(defaultDisplayName)).append("\n");
		sb.append("    documentationURL: ").append(toIndentedString(documentationURL)).append("\n");
		sb.append("    donors: ").append(toIndentedString(donors)).append("\n");
		sb.append("    externalReferences: ").append(toIndentedString(externalReferences)).append("\n");
		sb.append("    genus: ").append(toIndentedString(genus)).append("\n");
		sb.append("    germplasmName: ").append(toIndentedString(germplasmName)).append("\n");
		sb.append("    germplasmOrigin: ").append(toIndentedString(germplasmOrigin)).append("\n");
		sb.append("    germplasmPUI: ").append(toIndentedString(germplasmPUI)).append("\n");
		sb.append("    germplasmPreprocessing: ").append(toIndentedString(germplasmPreprocessing)).append("\n");
		sb.append("    instituteCode: ").append(toIndentedString(instituteCode)).append("\n");
		sb.append("    instituteName: ").append(toIndentedString(instituteName)).append("\n");
		sb.append("    pedigree: ").append(toIndentedString(pedigree)).append("\n");
		sb.append("    seedSource: ").append(toIndentedString(seedSource)).append("\n");
		sb.append("    seedSourceDescription: ").append(toIndentedString(seedSourceDescription)).append("\n");
		sb.append("    species: ").append(toIndentedString(species)).append("\n");
		sb.append("    speciesAuthority: ").append(toIndentedString(speciesAuthority)).append("\n");
		sb.append("    storageTypes: ").append(toIndentedString(storageTypes)).append("\n");
		sb.append("    subtaxa: ").append(toIndentedString(subtaxa)).append("\n");
		sb.append("    subtaxaAuthority: ").append(toIndentedString(subtaxaAuthority)).append("\n");
		sb.append("    synonyms: ").append(toIndentedString(synonyms)).append("\n");
		sb.append("    taxonIds: ").append(toIndentedString(taxonIds)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
