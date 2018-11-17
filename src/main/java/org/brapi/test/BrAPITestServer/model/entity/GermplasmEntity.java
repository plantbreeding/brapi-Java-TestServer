package org.brapi.test.BrAPITestServer.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="germplasm")
public class GermplasmEntity extends BaseEntity{
	@Column
    private String germplasmPUI;
	@Column
    private String germplasmName;
	@Column
    private String defaultDisplayName;
	@Column
	private String commonCropName;
	@Column
    private String accessionNumber;
	@OneToOne(cascade=CascadeType.ALL, mappedBy="germplasm")
    private PedigreeEntity pedigree;
	@ManyToOne(cascade=CascadeType.DETACH)
    private BreedingMethodEntity breedingMethod;
	@Column
    private String germplasmSeedSource;
	@Column
    private String synonyms;
	@Column
    private String instituteCode;
	@Column
    private String instituteName;
	@Column
    private String biologicalStatusOfAccessionCode;
	@Column
    private String countryOfOriginCode;
	@Column
    private String genus;
	@Column
    private String species;
	@Column
    private String speciesAuthority;
	@Column
    private String subtaxa;
	@Column
    private String subtaxaAuthority;
	@Column
    private Date acquisitionDate;
	@Column
    private String documentationURL;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "germplasm_germplasm_type_storage_code", joinColumns = { @JoinColumn(name = "germplasm_dbid", referencedColumnName="id") }, inverseJoinColumns = { @JoinColumn(name = "germplasm_type_storage_code_dbid", referencedColumnName="id") })
    private List<GermplasmTypeStorageCodeEntity> typeOfGermplasmStorageCode;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "germplasm_taxon", joinColumns = { @JoinColumn(name = "germplasm_dbid", referencedColumnName="id") }, inverseJoinColumns = { @JoinColumn(name = "taxon_dbid", referencedColumnName="id") })
    private List<TaxonEntity> taxonIds;
	
	@OneToMany(mappedBy="germplasmDbId", targetEntity=DonorEntity.class)
    private List<DonorEntity> donors;
	
	@OneToMany(mappedBy="germplasm", targetEntity=GermplasmAttributeValueEntity.class)
	private List<GermplasmAttributeValueEntity> attributes;

	@OneToMany(mappedBy="germplasmDbId", targetEntity=MarkerProfileEntity.class)
	private List<MarkerProfileEntity> markerProfiles;
	
	@OneToMany(mappedBy="germplasm")
	private List<ObservationUnitEntity> observationUnits;

	public String getDocumentationURL() {
		return documentationURL;
	}

	public void setDocumentationURL(String documentationURL) {
		this.documentationURL = documentationURL;
	}

	public BreedingMethodEntity getBreedingMethod() {
		return breedingMethod;
	}

	public void setBreedingMethod(BreedingMethodEntity breedingMethod) {
		this.breedingMethod = breedingMethod;
	}

	public List<ObservationUnitEntity> getObservationUnits() {
		return observationUnits;
	}

	public void setObservationUnits(List<ObservationUnitEntity> observationUnits) {
		this.observationUnits = observationUnits;
	}

	public List<MarkerProfileEntity> getMarkerProfiles() {
		return markerProfiles;
	}

	public void setMarkerProfiles(List<MarkerProfileEntity> markerProfiles) {
		this.markerProfiles = markerProfiles;
	}

	public String getGermplasmPUI() {
		return germplasmPUI;
	}

	public void setGermplasmPUI(String germplasmPUI) {
		this.germplasmPUI = germplasmPUI;
	}

	public String getGermplasmName() {
		return germplasmName;
	}

	public void setGermplasmName(String germplasmName) {
		this.germplasmName = germplasmName;
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

	public PedigreeEntity getPedigree() {
		return pedigree;
	}

	public void setPedigree(PedigreeEntity pedigree) {
		this.pedigree = pedigree;
	}

	public String getGermplasmSeedSource() {
		return germplasmSeedSource;
	}

	public void setGermplasmSeedSource(String germplasmSeedSource) {
		this.germplasmSeedSource = germplasmSeedSource;
	}

	public String getSynonyms() {
		return synonyms;
	}

	public void setSynonyms(String synonyms) {
		this.synonyms = synonyms;
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

	public String getBiologicalStatusOfAccessionCode() {
		return biologicalStatusOfAccessionCode;
	}

	public void setBiologicalStatusOfAccessionCode(String biologicalStatusOfAccessionCode) {
		this.biologicalStatusOfAccessionCode = biologicalStatusOfAccessionCode;
	}

	public String getCountryOfOriginCode() {
		return countryOfOriginCode;
	}

	public void setCountryOfOriginCode(String countryOfOriginCode) {
		this.countryOfOriginCode = countryOfOriginCode;
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

	public Date getAcquisitionDate() {
		return acquisitionDate;
	}

	public void setAcquisitionDate(Date acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}

	public List<GermplasmTypeStorageCodeEntity> getTypeOfGermplasmStorageCode() {
		return typeOfGermplasmStorageCode;
	}

	public void setTypeOfGermplasmStorageCode(List<GermplasmTypeStorageCodeEntity> typeOfGermplasmStorageCode) {
		this.typeOfGermplasmStorageCode = typeOfGermplasmStorageCode;
	}

	public List<TaxonEntity> getTaxonIds() {
		return taxonIds;
	}

	public void setTaxonIds(List<TaxonEntity> taxonIds) {
		this.taxonIds = taxonIds;
	}

	public List<DonorEntity> getDonors() {
		return donors;
	}

	public void setDonors(List<DonorEntity> donors) {
		this.donors = donors;
	}

	public List<GermplasmAttributeValueEntity> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<GermplasmAttributeValueEntity> attributes) {
		this.attributes = attributes;
	}

	public String getCommonCropName() {
		return commonCropName;
	}

	public void setCommonCropName(String commonCropName) {
		this.commonCropName = commonCropName;
	}
    
}
