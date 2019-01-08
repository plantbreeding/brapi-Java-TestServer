package io.swagger.model;

public class GenomeMapSearchRequest {
	private String speciesId;
	private String commonCropName;
	private String scientificName;
	private String type;
	
	public GenomeMapSearchRequest(String speciesId, String commonCropName, String scientificName, String type) {
		super();
		this.speciesId = speciesId;
		this.commonCropName = commonCropName;
		this.scientificName = scientificName;
		this.type = type;
	}
	
	public String getSpeciesId() {
		return speciesId;
	}
	public void setSpeciesId(String speciesId) {
		this.speciesId = speciesId;
	}
	public String getCommonCropName() {
		return commonCropName;
	}
	public void setCommonCropName(String commonCropName) {
		this.commonCropName = commonCropName;
	}
	public String getScientificName() {
		return scientificName;
	}
	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}

