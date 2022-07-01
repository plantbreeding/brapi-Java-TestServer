package io.swagger.model.germ;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.SearchRequest;
import java.util.ArrayList;
import java.util.List;

public class GermplasmSearchRequest extends SearchRequest {
	@JsonProperty("accessionNumbers")
	private List<String> accessionNumbers = null;

	@JsonProperty("binomialNames")
	private List<String> binomialNames = null;

	@JsonProperty("collections")
	private List<String> collections = null;

	@JsonProperty("commonCropNames")
	private List<String> commonCropNames = null;

	@JsonProperty("familyCodes")
	private List<String> familyCodes = null;

	@JsonProperty("genus")
	private List<String> genus = null;

	@JsonProperty("germplasmDbIds")
	private List<String> germplasmDbIds = null;

	@JsonProperty("germplasmNames")
	private List<String> germplasmNames = null;

	@JsonProperty("germplasmPUIs")
	private List<String> germplasmPUIs = null;

	@JsonProperty("instituteCodes")
	private List<String> instituteCodes = null;

	@JsonProperty("parentDbIds")
	private List<String> parentDbIds = null;

	@JsonProperty("progenyDbIds")
	private List<String> progenyDbIds = null;

	@JsonProperty("programDbIds")
	private List<String> programDbIds = null;

	@JsonProperty("programNames")
	private List<String> programNames = null;

	@JsonProperty("species")
	private List<String> species = null;

	@JsonProperty("studyDbIds")
	private List<String> studyDbIds = null;

	@JsonProperty("studyNames")
	private List<String> studyNames = null;

	@JsonProperty("synonyms")
	private List<String> synonyms = null;

	@JsonProperty("trialDbIds")
	private List<String> trialDbIds = null;

	@JsonProperty("trialNames")
	private List<String> trialNames = null;

	public GermplasmSearchRequest accessionNumbers(List<String> accessionNumbers) {
		this.accessionNumbers = accessionNumbers;
		return this;
	}

	public GermplasmSearchRequest addAccessionNumbersItem(String accessionNumbersItem) {
		if (this.accessionNumbers == null) {
			this.accessionNumbers = new ArrayList<String>();
		}
		this.accessionNumbers.add(accessionNumbersItem);
		return this;
	}

	public List<String> getAccessionNumbers() {
		return accessionNumbers;
	}

	public void setAccessionNumbers(List<String> accessionNumbers) {
		this.accessionNumbers = accessionNumbers;
	}

	public GermplasmSearchRequest binomialNames(List<String> binomialNames) {
		this.binomialNames = binomialNames;
		return this;
	}

	public GermplasmSearchRequest addBinomialNamesItem(String binomialNamesItem) {
		if (this.binomialNames == null) {
			this.binomialNames = new ArrayList<String>();
		}
		this.binomialNames.add(binomialNamesItem);
		return this;
	}

	public List<String> getBinomialNames() {
		return binomialNames;
	}

	public void setBinomialNames(List<String> binomialNames) {
		this.binomialNames = binomialNames;
	}

	public GermplasmSearchRequest collections(List<String> collections) {
		this.collections = collections;
		return this;
	}

	public GermplasmSearchRequest addCollectionsItem(String collectionsItem) {
		if (this.collections == null) {
			this.collections = new ArrayList<String>();
		}
		this.collections.add(collectionsItem);
		return this;
	}

	public List<String> getCollections() {
		return collections;
	}

	public void setCollections(List<String> collections) {
		this.collections = collections;
	}

	public GermplasmSearchRequest commonCropNames(List<String> commonCropNames) {
		this.commonCropNames = commonCropNames;
		return this;
	}

	public GermplasmSearchRequest addCommonCropNamesItem(String commonCropNamesItem) {
		if (this.commonCropNames == null) {
			this.commonCropNames = new ArrayList<String>();
		}
		this.commonCropNames.add(commonCropNamesItem);
		return this;
	}

	public List<String> getCommonCropNames() {
		return commonCropNames;
	}

	public void setCommonCropNames(List<String> commonCropNames) {
		this.commonCropNames = commonCropNames;
	}

	public GermplasmSearchRequest familyCodes(List<String> familyCodes) {
		this.familyCodes = familyCodes;
		return this;
	}

	public GermplasmSearchRequest addFamilyCodesItem(String familyCodesItem) {
		if (this.familyCodes == null) {
			this.familyCodes = new ArrayList<String>();
		}
		this.familyCodes.add(familyCodesItem);
		return this;
	}

	public List<String> getFamilyCodes() {
		return familyCodes;
	}

	public void setFamilyCodes(List<String> familyCodes) {
		this.familyCodes = familyCodes;
	}

	public GermplasmSearchRequest genus(List<String> genus) {
		this.genus = genus;
		return this;
	}

	public GermplasmSearchRequest addGenusItem(String genusItem) {
		if (this.genus == null) {
			this.genus = new ArrayList<String>();
		}
		this.genus.add(genusItem);
		return this;
	}

	public List<String> getGenus() {
		return genus;
	}

	public void setGenus(List<String> genus) {
		this.genus = genus;
	}

	public GermplasmSearchRequest germplasmDbIds(List<String> germplasmDbIds) {
		this.germplasmDbIds = germplasmDbIds;
		return this;
	}

	public GermplasmSearchRequest addGermplasmDbIdsItem(String germplasmDbIdsItem) {
		if (this.germplasmDbIds == null) {
			this.germplasmDbIds = new ArrayList<String>();
		}
		this.germplasmDbIds.add(germplasmDbIdsItem);
		return this;
	}

	public List<String> getGermplasmDbIds() {
		return germplasmDbIds;
	}

	public void setGermplasmDbIds(List<String> germplasmDbIds) {
		this.germplasmDbIds = germplasmDbIds;
	}

	public GermplasmSearchRequest germplasmNames(List<String> germplasmNames) {
		this.germplasmNames = germplasmNames;
		return this;
	}

	public GermplasmSearchRequest addGermplasmNamesItem(String germplasmNamesItem) {
		if (this.germplasmNames == null) {
			this.germplasmNames = new ArrayList<String>();
		}
		this.germplasmNames.add(germplasmNamesItem);
		return this;
	}

	public List<String> getGermplasmNames() {
		return germplasmNames;
	}

	public void setGermplasmNames(List<String> germplasmNames) {
		this.germplasmNames = germplasmNames;
	}

	public GermplasmSearchRequest germplasmPUIs(List<String> germplasmPUIs) {
		this.germplasmPUIs = germplasmPUIs;
		return this;
	}

	public GermplasmSearchRequest addGermplasmPUIsItem(String germplasmPUIsItem) {
		if (this.germplasmPUIs == null) {
			this.germplasmPUIs = new ArrayList<String>();
		}
		this.germplasmPUIs.add(germplasmPUIsItem);
		return this;
	}

	public List<String> getGermplasmPUIs() {
		return germplasmPUIs;
	}

	public void setGermplasmPUIs(List<String> germplasmPUIs) {
		this.germplasmPUIs = germplasmPUIs;
	}

	public GermplasmSearchRequest instituteCodes(List<String> instituteCodes) {
		this.instituteCodes = instituteCodes;
		return this;
	}

	public GermplasmSearchRequest addInstituteCodesItem(String instituteCodesItem) {
		if (this.instituteCodes == null) {
			this.instituteCodes = new ArrayList<String>();
		}
		this.instituteCodes.add(instituteCodesItem);
		return this;
	}

	public List<String> getInstituteCodes() {
		return instituteCodes;
	}

	public void setInstituteCodes(List<String> instituteCodes) {
		this.instituteCodes = instituteCodes;
	}

	public GermplasmSearchRequest parentDbIds(List<String> parentDbIds) {
		this.parentDbIds = parentDbIds;
		return this;
	}

	public GermplasmSearchRequest addParentDbIdsItem(String parentDbIdsItem) {
		if (this.parentDbIds == null) {
			this.parentDbIds = new ArrayList<String>();
		}
		this.parentDbIds.add(parentDbIdsItem);
		return this;
	}

	public List<String> getParentDbIds() {
		return parentDbIds;
	}

	public void setParentDbIds(List<String> parentDbIds) {
		this.parentDbIds = parentDbIds;
	}

	public GermplasmSearchRequest progenyDbIds(List<String> progenyDbIds) {
		this.progenyDbIds = progenyDbIds;
		return this;
	}

	public GermplasmSearchRequest addProgenyDbIdsItem(String progenyDbIdsItem) {
		if (this.progenyDbIds == null) {
			this.progenyDbIds = new ArrayList<String>();
		}
		this.progenyDbIds.add(progenyDbIdsItem);
		return this;
	}

	public List<String> getProgenyDbIds() {
		return progenyDbIds;
	}

	public void setProgenyDbIds(List<String> progenyDbIds) {
		this.progenyDbIds = progenyDbIds;
	}

	public GermplasmSearchRequest programDbIds(List<String> programDbIds) {
		this.programDbIds = programDbIds;
		return this;
	}

	public GermplasmSearchRequest addProgramDbIdsItem(String programDbIdsItem) {
		if (this.programDbIds == null) {
			this.programDbIds = new ArrayList<String>();
		}
		this.programDbIds.add(programDbIdsItem);
		return this;
	}

	public List<String> getProgramDbIds() {
		return programDbIds;
	}

	public void setProgramDbIds(List<String> programDbIds) {
		this.programDbIds = programDbIds;
	}

	public GermplasmSearchRequest programNames(List<String> programNames) {
		this.programNames = programNames;
		return this;
	}

	public GermplasmSearchRequest addProgramNamesItem(String programNamesItem) {
		if (this.programNames == null) {
			this.programNames = new ArrayList<String>();
		}
		this.programNames.add(programNamesItem);
		return this;
	}

	public List<String> getProgramNames() {
		return programNames;
	}

	public void setProgramNames(List<String> programNames) {
		this.programNames = programNames;
	}

	public GermplasmSearchRequest species(List<String> species) {
		this.species = species;
		return this;
	}

	public GermplasmSearchRequest addSpeciesItem(String speciesItem) {
		if (this.species == null) {
			this.species = new ArrayList<String>();
		}
		this.species.add(speciesItem);
		return this;
	}

	public List<String> getSpecies() {
		return species;
	}

	public void setSpecies(List<String> species) {
		this.species = species;
	}

	public GermplasmSearchRequest studyDbIds(List<String> studyDbIds) {
		this.studyDbIds = studyDbIds;
		return this;
	}

	public GermplasmSearchRequest addStudyDbIdsItem(String studyDbIdsItem) {
		if (this.studyDbIds == null) {
			this.studyDbIds = new ArrayList<String>();
		}
		this.studyDbIds.add(studyDbIdsItem);
		return this;
	}

	public List<String> getStudyDbIds() {
		return studyDbIds;
	}

	public void setStudyDbIds(List<String> studyDbIds) {
		this.studyDbIds = studyDbIds;
	}

	public GermplasmSearchRequest studyNames(List<String> studyNames) {
		this.studyNames = studyNames;
		return this;
	}

	public GermplasmSearchRequest addStudyNamesItem(String studyNamesItem) {
		if (this.studyNames == null) {
			this.studyNames = new ArrayList<String>();
		}
		this.studyNames.add(studyNamesItem);
		return this;
	}

	public List<String> getStudyNames() {
		return studyNames;
	}

	public void setStudyNames(List<String> studyNames) {
		this.studyNames = studyNames;
	}

	public GermplasmSearchRequest synonyms(List<String> synonyms) {
		this.synonyms = synonyms;
		return this;
	}

	public GermplasmSearchRequest addSynonymsItem(String synonymsItem) {
		if (this.synonyms == null) {
			this.synonyms = new ArrayList<String>();
		}
		this.synonyms.add(synonymsItem);
		return this;
	}

	public List<String> getSynonyms() {
		return synonyms;
	}

	public void setSynonyms(List<String> synonyms) {
		this.synonyms = synonyms;
	}

	public GermplasmSearchRequest trialDbIds(List<String> trialDbIds) {
		this.trialDbIds = trialDbIds;
		return this;
	}

	public GermplasmSearchRequest addTrialDbIdsItem(String trialDbIdsItem) {
		if (this.trialDbIds == null) {
			this.trialDbIds = new ArrayList<String>();
		}
		this.trialDbIds.add(trialDbIdsItem);
		return this;
	}

	public List<String> getTrialDbIds() {
		return trialDbIds;
	}

	public void setTrialDbIds(List<String> trialDbIds) {
		this.trialDbIds = trialDbIds;
	}

	public GermplasmSearchRequest trialNames(List<String> trialNames) {
		this.trialNames = trialNames;
		return this;
	}

	public GermplasmSearchRequest addTrialNamesItem(String trialNamesItem) {
		if (this.trialNames == null) {
			this.trialNames = new ArrayList<String>();
		}
		this.trialNames.add(trialNamesItem);
		return this;
	}

	public List<String> getTrialNames() {
		return trialNames;
	}

	public void setTrialNames(List<String> trialNames) {
		this.trialNames = trialNames;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		GermplasmSearchRequest germplasmSearchRequest = (GermplasmSearchRequest) o;
		return Objects.equals(this.accessionNumbers, germplasmSearchRequest.accessionNumbers)
				&& Objects.equals(this.binomialNames, germplasmSearchRequest.binomialNames)
				&& Objects.equals(this.collections, germplasmSearchRequest.collections)
				&& Objects.equals(this.commonCropNames, germplasmSearchRequest.commonCropNames)
				&& Objects.equals(this.externalReferenceIds, germplasmSearchRequest.externalReferenceIds)
				&& Objects.equals(this.externalReferenceSources, germplasmSearchRequest.externalReferenceSources)
				&& Objects.equals(this.familyCodes, germplasmSearchRequest.familyCodes)
				&& Objects.equals(this.genus, germplasmSearchRequest.genus)
				&& Objects.equals(this.germplasmDbIds, germplasmSearchRequest.germplasmDbIds)
				&& Objects.equals(this.germplasmNames, germplasmSearchRequest.germplasmNames)
				&& Objects.equals(this.germplasmPUIs, germplasmSearchRequest.germplasmPUIs)
				&& Objects.equals(this.instituteCodes, germplasmSearchRequest.instituteCodes)
				&& Objects.equals(this.page, germplasmSearchRequest.page)
				&& Objects.equals(this.pageSize, germplasmSearchRequest.pageSize)
				&& Objects.equals(this.parentDbIds, germplasmSearchRequest.parentDbIds)
				&& Objects.equals(this.progenyDbIds, germplasmSearchRequest.progenyDbIds)
				&& Objects.equals(this.programDbIds, germplasmSearchRequest.programDbIds)
				&& Objects.equals(this.programNames, germplasmSearchRequest.programNames)
				&& Objects.equals(this.species, germplasmSearchRequest.species)
				&& Objects.equals(this.studyDbIds, germplasmSearchRequest.studyDbIds)
				&& Objects.equals(this.studyNames, germplasmSearchRequest.studyNames)
				&& Objects.equals(this.synonyms, germplasmSearchRequest.synonyms)
				&& Objects.equals(this.trialDbIds, germplasmSearchRequest.trialDbIds)
				&& Objects.equals(this.trialNames, germplasmSearchRequest.trialNames);
	}

	@Override
	public int hashCode() {
		return Objects.hash(accessionNumbers, binomialNames, collections, commonCropNames, externalReferenceIds,
				externalReferenceSources, familyCodes, genus, germplasmDbIds, germplasmNames, germplasmPUIs,
				instituteCodes, page, pageSize, parentDbIds, progenyDbIds, programDbIds, programNames, species,
				studyDbIds, studyNames, synonyms, trialDbIds, trialNames);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class GermplasmSearchRequest {\n");

		sb.append("    accessionNumbers: ").append(toIndentedString(accessionNumbers)).append("\n");
		sb.append("    binomialNames: ").append(toIndentedString(binomialNames)).append("\n");
		sb.append("    collections: ").append(toIndentedString(collections)).append("\n");
		sb.append("    commonCropNames: ").append(toIndentedString(commonCropNames)).append("\n");
		sb.append("    externalReferenceIds: ").append(toIndentedString(externalReferenceIds)).append("\n");
		sb.append("    externalReferenceSources: ").append(toIndentedString(externalReferenceSources)).append("\n");
		sb.append("    familyCodes: ").append(toIndentedString(familyCodes)).append("\n");
		sb.append("    genus: ").append(toIndentedString(genus)).append("\n");
		sb.append("    germplasmDbIds: ").append(toIndentedString(germplasmDbIds)).append("\n");
		sb.append("    germplasmNames: ").append(toIndentedString(germplasmNames)).append("\n");
		sb.append("    germplasmPUIs: ").append(toIndentedString(germplasmPUIs)).append("\n");
		sb.append("    instituteCodes: ").append(toIndentedString(instituteCodes)).append("\n");
		sb.append("    page: ").append(toIndentedString(page)).append("\n");
		sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
		sb.append("    parentDbIds: ").append(toIndentedString(parentDbIds)).append("\n");
		sb.append("    progenyDbIds: ").append(toIndentedString(progenyDbIds)).append("\n");
		sb.append("    programDbIds: ").append(toIndentedString(programDbIds)).append("\n");
		sb.append("    programNames: ").append(toIndentedString(programNames)).append("\n");
		sb.append("    species: ").append(toIndentedString(species)).append("\n");
		sb.append("    studyDbIds: ").append(toIndentedString(studyDbIds)).append("\n");
		sb.append("    studyNames: ").append(toIndentedString(studyNames)).append("\n");
		sb.append("    synonyms: ").append(toIndentedString(synonyms)).append("\n");
		sb.append("    trialDbIds: ").append(toIndentedString(trialDbIds)).append("\n");
		sb.append("    trialNames: ").append(toIndentedString(trialNames)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

	@Override
	@JsonIgnore
	public Integer getTotalParameterCount() {
		Integer count = 0;
		if (this.accessionNumbers != null)
			count += this.accessionNumbers.size();
		if (this.binomialNames != null)
			count += this.binomialNames.size();
		if (this.collections != null)
			count += this.collections.size();
		if (this.commonCropNames != null)
			count += this.commonCropNames.size();
		if (this.externalReferenceIds != null)
			count += this.externalReferenceIds.size();
		if (this.externalReferenceSources != null)
			count += this.externalReferenceSources.size();
		if (this.familyCodes != null)
			count += this.familyCodes.size();
		if (this.genus != null)
			count += this.genus.size();
		if (this.germplasmDbIds != null)
			count += this.germplasmDbIds.size();
		if (this.germplasmNames != null)
			count += this.germplasmNames.size();
		if (this.germplasmPUIs != null)
			count += this.germplasmPUIs.size();
		if (this.instituteCodes != null)
			count += this.instituteCodes.size();
		if (this.parentDbIds != null)
			count += this.parentDbIds.size();
		if (this.progenyDbIds != null)
			count += this.progenyDbIds.size();
		if (this.programDbIds != null)
			count += this.programDbIds.size();
		if (this.programNames != null)
			count += this.programNames.size();
		if (this.species != null)
			count += this.species.size();
		if (this.studyDbIds != null)
			count += this.studyDbIds.size();
		if (this.studyNames != null)
			count += this.studyNames.size();
		if (this.synonyms != null)
			count += this.synonyms.size();
		if (this.trialDbIds != null)
			count += this.trialDbIds.size();
		if (this.trialNames != null)
			count += this.trialNames.size();

		return count;
	}
}
