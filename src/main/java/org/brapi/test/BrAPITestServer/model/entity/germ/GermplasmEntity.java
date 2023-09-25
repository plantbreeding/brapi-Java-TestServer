package org.brapi.test.BrAPITestServer.model.entity.germ;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.brapi.test.BrAPITestServer.model.entity.BrAPIPrimaryEntity;
import org.brapi.test.BrAPITestServer.model.entity.SearchRequestEntity;
import org.brapi.test.BrAPITestServer.model.entity.core.CropEntity;
import org.brapi.test.BrAPITestServer.model.entity.germ.GermplasmInstituteEntity.InstituteTypeEnum;
import org.brapi.test.BrAPITestServer.model.entity.pheno.ObservationUnitEntity;
import org.brapi.test.BrAPITestServer.model.entity.pheno.TaxonEntity;

import io.swagger.model.germ.BiologicalStatusOfAccessionCode;
import io.swagger.model.germ.GermplasmMCPD.AcquisitionSourceCodeEnum;
import io.swagger.model.germ.GermplasmMCPD.MlsStatusEnum;
import io.swagger.model.germ.GermplasmStorageTypesEnum;

@Entity
@Table(name = "germplasm")
public class GermplasmEntity extends BrAPIPrimaryEntity {
	@Column
	private String accessionNumber;
	@Column
	private Date acquisitionDate;
	@Column
	private AcquisitionSourceCodeEnum acquisitionSourceCode;
	@OneToMany(mappedBy = "germplasm")
	private List<GermplasmAttributeValueEntity> attributes;
	@Column
	private BiologicalStatusOfAccessionCode biologicalStatusOfAccessionCode;
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private BreedingMethodEntity breedingMethod;
	@Column
	private String collection;
	@Column
	private String countryOfOriginCode;
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private CropEntity crop;
	@Column
	private String defaultDisplayName;
	@Column
	private String documentationURL;
	@OneToMany(mappedBy = "germplasm", cascade = CascadeType.ALL)
	private List<DonorEntity> donors;
	@Column
	private String genus;
	@Column
	private String germplasmName;
	@OneToMany(mappedBy = "germplasm", cascade = CascadeType.ALL)
	private List<GermplasmOriginEntity> germplasmOrigin;
	@Column
	private String germplasmPreprocessing;
	@Column
	private String germplasmPUI;
	@OneToMany(mappedBy = "germplasm", cascade = CascadeType.ALL)
	private List<GermplasmInstituteEntity> institutes;
	@Column
	private MlsStatusEnum mlsStatus;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "germplasm", fetch = FetchType.LAZY)
	private PedigreeNodeEntity pedigree;
	@ManyToMany
	@JoinTable
	private List<SearchRequestEntity> searchResults;
	@Column
	private String seedSource;
	@Column
	private String seedSourceDescription;
	@Column
	private String species;
	@Column
	private String speciesAuthority;
	@Column
	private String subtaxa;
	@Column
	private String subtaxaAuthority;
	@OneToMany(mappedBy = "germplasm", cascade = CascadeType.ALL)
	private List<GermplasmSynonymEntity> synonyms;
	@OneToMany(mappedBy = "germplasm", cascade = CascadeType.ALL)
	private List<TaxonEntity> taxonIds;
	@OneToMany(mappedBy = "germplasm")
	private List<ObservationUnitEntity> observationUnits;
	@ElementCollection
	private List<GermplasmStorageTypesEnum> typeOfGermplasmStorageCode;

	public GermplasmInstituteEntity getHostInstitute() {
		if (getInstitutes() != null) {
			for (GermplasmInstituteEntity institute : getInstitutes()) {
				if (InstituteTypeEnum.HOST.equals(institute.getInstituteType())) {
					return institute;
				}
			}
		}
		return null;
	}

	public void setHostInstitute(String code, String name) {
		if (getInstitutes() == null)
			setInstitutes(new ArrayList<>());
		if (getHostInstitute() == null) {
			GermplasmInstituteEntity entity = new GermplasmInstituteEntity();
			entity.setGermplasm(this);
			entity.setInstituteCode(code);
			entity.setInstituteName(name);
			entity.setInstituteType(InstituteTypeEnum.HOST);
			getInstitutes().add(entity);
		} else {
			getHostInstitute().setInstituteCode(code);
			getHostInstitute().setInstituteName(name);
		}
	}

	public MlsStatusEnum getMlsStatus() {
		return mlsStatus;
	}

	public void setMlsStatus(MlsStatusEnum mlsStatus) {
		this.mlsStatus = mlsStatus;
	}

	public AcquisitionSourceCodeEnum getAcquisitionSourceCode() {
		return acquisitionSourceCode;
	}

	public void setAcquisitionSourceCode(AcquisitionSourceCodeEnum acquisitionSourceCode) {
		this.acquisitionSourceCode = acquisitionSourceCode;
	}

	public List<GermplasmInstituteEntity> getInstitutes() {
		return institutes;
	}

	public void setInstitutes(List<GermplasmInstituteEntity> institutes) {
		this.institutes = institutes;
	}

	public String getGermplasmPreprocessing() {
		return germplasmPreprocessing;
	}

	public void setGermplasmPreprocessing(String germplasmPreprocessing) {
		this.germplasmPreprocessing = germplasmPreprocessing;
	}

	public List<GermplasmOriginEntity> getGermplasmOrigin() {
		return germplasmOrigin;
	}

	public void setGermplasmOrigin(List<GermplasmOriginEntity> germplasmOrigin) {
		this.germplasmOrigin = germplasmOrigin;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public String getAccessionNumber() {
		return accessionNumber;
	}

	public Date getAcquisitionDate() {
		return acquisitionDate;
	}

	public List<GermplasmAttributeValueEntity> getAttributes() {
		return attributes;
	}

	public BiologicalStatusOfAccessionCode getBiologicalStatusOfAccessionCode() {
		return biologicalStatusOfAccessionCode;
	}

	public BreedingMethodEntity getBreedingMethod() {
		return breedingMethod;
	}

	public String getCountryOfOriginCode() {
		return countryOfOriginCode;
	}

	public CropEntity getCrop() {
		return crop;
	}

	public String getDefaultDisplayName() {
		return defaultDisplayName;
	}

	public String getDocumentationURL() {
		return documentationURL;
	}

	public List<DonorEntity> getDonors() {
		return donors;
	}

	public String getGenus() {
		return genus;
	}

	public String getGermplasmName() {
		return germplasmName;
	}

	public String getGermplasmPUI() {
		return germplasmPUI;
	}

	public PedigreeNodeEntity getPedigree() {
		return pedigree;
	}

	public List<SearchRequestEntity> getSearchResults() {
		return searchResults;
	}

	public String getSpecies() {
		return species;
	}

	public String getSpeciesAuthority() {
		return speciesAuthority;
	}

	public String getSubtaxa() {
		return subtaxa;
	}

	public String getSubtaxaAuthority() {
		return subtaxaAuthority;
	}

	public List<GermplasmSynonymEntity> getSynonyms() {
		return synonyms;
	}

	public List<TaxonEntity> getTaxonIds() {
		return taxonIds;
	}

	public List<GermplasmStorageTypesEnum> getTypeOfGermplasmStorageCode() {
		return typeOfGermplasmStorageCode;
	}

	public void setAccessionNumber(String accessionNumber) {
		this.accessionNumber = accessionNumber;
	}

	public void setAcquisitionDate(Date acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}

	public void setAttributes(List<GermplasmAttributeValueEntity> attributes) {
		this.attributes = attributes;
	}

	public void setBiologicalStatusOfAccessionCode(BiologicalStatusOfAccessionCode biologicalStatusOfAccessionCode) {
		this.biologicalStatusOfAccessionCode = biologicalStatusOfAccessionCode;
	}

	public void setBreedingMethod(BreedingMethodEntity breedingMethod) {
		this.breedingMethod = breedingMethod;
	}

	public void setCountryOfOriginCode(String countryOfOriginCode) {
		this.countryOfOriginCode = countryOfOriginCode;
	}

	public void setCrop(CropEntity crop) {
		this.crop = crop;
	}

	public void setDefaultDisplayName(String defaultDisplayName) {
		this.defaultDisplayName = defaultDisplayName;
	}

	public void setDocumentationURL(String documentationURL) {
		this.documentationURL = documentationURL;
	}

	public void setDonors(List<DonorEntity> donors) {
		this.donors = donors;
	}

	public void setGenus(String genus) {
		this.genus = genus;
	}

	public void setGermplasmName(String germplasmName) {
		this.germplasmName = germplasmName;
	}

	public void setGermplasmPUI(String germplasmPUI) {
		this.germplasmPUI = germplasmPUI;
	}

	public String getSeedSource() {
		return seedSource;
	}

	public void setSeedSource(String seedSource) {
		this.seedSource = seedSource;
	}

	public String getSeedSourceDescription() {
		return seedSourceDescription;
	}

	public void setSeedSourceDescription(String seedSourceDescription) {
		this.seedSourceDescription = seedSourceDescription;
	}

	public void setPedigree(PedigreeNodeEntity pedigree) {
		this.pedigree = pedigree;
	}

	public void setSearchResults(List<SearchRequestEntity> searchResults) {
		this.searchResults = searchResults;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public void setSpeciesAuthority(String speciesAuthority) {
		this.speciesAuthority = speciesAuthority;
	}

	public void setSubtaxa(String subtaxa) {
		this.subtaxa = subtaxa;
	}

	public void setSubtaxaAuthority(String subtaxaAuthority) {
		this.subtaxaAuthority = subtaxaAuthority;
	}

	public void setSynonyms(List<GermplasmSynonymEntity> synonyms) {
		this.synonyms = synonyms;
	}

	public void setTaxonIds(List<TaxonEntity> taxonIds) {
		this.taxonIds = taxonIds;
	}

	public void setTypeOfGermplasmStorageCode(List<GermplasmStorageTypesEnum> typeOfGermplasmStorageCode) {
		this.typeOfGermplasmStorageCode = typeOfGermplasmStorageCode;
	}

}
