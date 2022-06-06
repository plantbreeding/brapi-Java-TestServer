package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.GeoJSONSearchArea;
import io.swagger.model.SearchRequest;
import java.util.ArrayList;
import java.util.List;
import java.time.OffsetDateTime;

public class ImageSearchRequest extends SearchRequest {
	@JsonProperty("commonCropNames")
	private List<String> commonCropNames = null;

	@JsonProperty("descriptiveOntologyTerms")
	private List<String> descriptiveOntologyTerms = null;

	@JsonProperty("imageDbIds")
	private List<String> imageDbIds = null;

	@JsonProperty("imageFileNames")
	private List<String> imageFileNames = null;

	@JsonProperty("imageFileSizeMax")
	private Integer imageFileSizeMax = null;

	@JsonProperty("imageFileSizeMin")
	private Integer imageFileSizeMin = null;

	@JsonProperty("imageHeightMax")
	private Integer imageHeightMax = null;

	@JsonProperty("imageHeightMin")
	private Integer imageHeightMin = null;

	@JsonProperty("imageLocation")
	private GeoJSONSearchArea imageLocation = null;

	@JsonProperty("imageNames")
	private List<String> imageNames = null;

	@JsonProperty("imageTimeStampRangeEnd")
	private OffsetDateTime imageTimeStampRangeEnd = null;

	@JsonProperty("imageTimeStampRangeStart")
	private OffsetDateTime imageTimeStampRangeStart = null;

	@JsonProperty("imageWidthMax")
	private Integer imageWidthMax = null;

	@JsonProperty("imageWidthMin")
	private Integer imageWidthMin = null;

	@JsonProperty("mimeTypes")
	private List<String> mimeTypes = null;

	@JsonProperty("observationDbIds")
	private List<String> observationDbIds = null;

	@JsonProperty("observationUnitDbIds")
	private List<String> observationUnitDbIds = null;

	@JsonProperty("programDbIds")
	private List<String> programDbIds = null;

	@JsonProperty("programNames")
	private List<String> programNames = null;

	public ImageSearchRequest commonCropNames(List<String> commonCropNames) {
		this.commonCropNames = commonCropNames;
		return this;
	}

	public ImageSearchRequest addCommonCropNamesItem(String commonCropNamesItem) {
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

	public ImageSearchRequest addImageDbIdsItem(String imageDbIdsItem) {
		if (this.imageDbIds == null) {
			this.imageDbIds = new ArrayList<String>();
		}
		this.imageDbIds.add(imageDbIdsItem);
		return this;
	}

	public List<String> getImageDbIds() {
		return imageDbIds;
	}

	public void setImageDbIds(List<String> imageDbIds) {
		this.imageDbIds = imageDbIds;
	}

	public ImageSearchRequest descriptiveOntologyTerms(List<String> descriptiveOntologyTerms) {
		this.descriptiveOntologyTerms = descriptiveOntologyTerms;
		return this;
	}

	public ImageSearchRequest addDescriptiveOntologyTermsItem(String descriptiveOntologyTermsItem) {
		if (this.descriptiveOntologyTerms == null) {
			this.descriptiveOntologyTerms = new ArrayList<String>();
		}
		this.descriptiveOntologyTerms.add(descriptiveOntologyTermsItem);
		return this;
	}

	public List<String> getDescriptiveOntologyTerms() {
		return descriptiveOntologyTerms;
	}

	public void setDescriptiveOntologyTerms(List<String> descriptiveOntologyTerms) {
		this.descriptiveOntologyTerms = descriptiveOntologyTerms;
	}

	public ImageSearchRequest imageFileNames(List<String> imageFileNames) {
		this.imageFileNames = imageFileNames;
		return this;
	}

	public ImageSearchRequest addImageFileNamesItem(String imageFileNamesItem) {
		if (this.imageFileNames == null) {
			this.imageFileNames = new ArrayList<String>();
		}
		this.imageFileNames.add(imageFileNamesItem);
		return this;
	}

	public List<String> getImageFileNames() {
		return imageFileNames;
	}

	public void setImageFileNames(List<String> imageFileNames) {
		this.imageFileNames = imageFileNames;
	}

	public ImageSearchRequest imageFileSizeMax(Integer imageFileSizeMax) {
		this.imageFileSizeMax = imageFileSizeMax;
		return this;
	}

	public Integer getImageFileSizeMax() {
		return imageFileSizeMax;
	}

	public void setImageFileSizeMax(Integer imageFileSizeMax) {
		this.imageFileSizeMax = imageFileSizeMax;
	}

	public ImageSearchRequest imageFileSizeMin(Integer imageFileSizeMin) {
		this.imageFileSizeMin = imageFileSizeMin;
		return this;
	}

	public Integer getImageFileSizeMin() {
		return imageFileSizeMin;
	}

	public void setImageFileSizeMin(Integer imageFileSizeMin) {
		this.imageFileSizeMin = imageFileSizeMin;
	}

	public ImageSearchRequest imageHeightMax(Integer imageHeightMax) {
		this.imageHeightMax = imageHeightMax;
		return this;
	}

	public Integer getImageHeightMax() {
		return imageHeightMax;
	}

	public void setImageHeightMax(Integer imageHeightMax) {
		this.imageHeightMax = imageHeightMax;
	}

	public ImageSearchRequest imageHeightMin(Integer imageHeightMin) {
		this.imageHeightMin = imageHeightMin;
		return this;
	}

	public Integer getImageHeightMin() {
		return imageHeightMin;
	}

	public void setImageHeightMin(Integer imageHeightMin) {
		this.imageHeightMin = imageHeightMin;
	}

	public ImageSearchRequest imageLocation(GeoJSONSearchArea imageLocation) {
		this.imageLocation = imageLocation;
		return this;
	}

	public GeoJSONSearchArea getImageLocation() {
		return imageLocation;
	}

	public void setImageLocation(GeoJSONSearchArea imageLocation) {
		this.imageLocation = imageLocation;
	}

	public ImageSearchRequest imageNames(List<String> imageNames) {
		this.imageNames = imageNames;
		return this;
	}

	public ImageSearchRequest addImageNamesItem(String imageNamesItem) {
		if (this.imageNames == null) {
			this.imageNames = new ArrayList<String>();
		}
		this.imageNames.add(imageNamesItem);
		return this;
	}

	public List<String> getImageNames() {
		return imageNames;
	}

	public void setImageNames(List<String> imageNames) {
		this.imageNames = imageNames;
	}

	public ImageSearchRequest imageTimeStampRangeEnd(OffsetDateTime imageTimeStampRangeEnd) {
		this.imageTimeStampRangeEnd = imageTimeStampRangeEnd;
		return this;
	}

	public OffsetDateTime getImageTimeStampRangeEnd() {
		return imageTimeStampRangeEnd;
	}

	public void setImageTimeStampRangeEnd(OffsetDateTime imageTimeStampRangeEnd) {
		this.imageTimeStampRangeEnd = imageTimeStampRangeEnd;
	}

	public ImageSearchRequest imageTimeStampRangeStart(OffsetDateTime imageTimeStampRangeStart) {
		this.imageTimeStampRangeStart = imageTimeStampRangeStart;
		return this;
	}

	public OffsetDateTime getImageTimeStampRangeStart() {
		return imageTimeStampRangeStart;
	}

	public void setImageTimeStampRangeStart(OffsetDateTime imageTimeStampRangeStart) {
		this.imageTimeStampRangeStart = imageTimeStampRangeStart;
	}

	public ImageSearchRequest imageWidthMax(Integer imageWidthMax) {
		this.imageWidthMax = imageWidthMax;
		return this;
	}

	public Integer getImageWidthMax() {
		return imageWidthMax;
	}

	public void setImageWidthMax(Integer imageWidthMax) {
		this.imageWidthMax = imageWidthMax;
	}

	public ImageSearchRequest imageWidthMin(Integer imageWidthMin) {
		this.imageWidthMin = imageWidthMin;
		return this;
	}

	public Integer getImageWidthMin() {
		return imageWidthMin;
	}

	public void setImageWidthMin(Integer imageWidthMin) {
		this.imageWidthMin = imageWidthMin;
	}

	public ImageSearchRequest mimeTypes(List<String> mimeTypes) {
		this.mimeTypes = mimeTypes;
		return this;
	}

	public ImageSearchRequest addMimeTypesItem(String mimeTypesItem) {
		if (this.mimeTypes == null) {
			this.mimeTypes = new ArrayList<String>();
		}
		this.mimeTypes.add(mimeTypesItem);
		return this;
	}

	public List<String> getMimeTypes() {
		return mimeTypes;
	}

	public void setMimeTypes(List<String> mimeTypes) {
		this.mimeTypes = mimeTypes;
	}

	public ImageSearchRequest observationDbIds(List<String> observationDbIds) {
		this.observationDbIds = observationDbIds;
		return this;
	}

	public ImageSearchRequest addObservationDbIdsItem(String observationDbIdsItem) {
		if (this.observationDbIds == null) {
			this.observationDbIds = new ArrayList<String>();
		}
		this.observationDbIds.add(observationDbIdsItem);
		return this;
	}

	public List<String> getObservationDbIds() {
		return observationDbIds;
	}

	public void setObservationDbIds(List<String> observationDbIds) {
		this.observationDbIds = observationDbIds;
	}

	public ImageSearchRequest observationUnitDbIds(List<String> observationUnitDbIds) {
		this.observationUnitDbIds = observationUnitDbIds;
		return this;
	}

	public ImageSearchRequest addObservationUnitDbIdsItem(String observationUnitDbIdsItem) {
		if (this.observationUnitDbIds == null) {
			this.observationUnitDbIds = new ArrayList<String>();
		}
		this.observationUnitDbIds.add(observationUnitDbIdsItem);
		return this;
	}

	public List<String> getObservationUnitDbIds() {
		return observationUnitDbIds;
	}

	public void setObservationUnitDbIds(List<String> observationUnitDbIds) {
		this.observationUnitDbIds = observationUnitDbIds;
	}

	public ImageSearchRequest programDbIds(List<String> programDbIds) {
		this.programDbIds = programDbIds;
		return this;
	}

	public ImageSearchRequest addProgramDbIdsItem(String programDbIdsItem) {
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

	public ImageSearchRequest programNames(List<String> programNames) {
		this.programNames = programNames;
		return this;
	}

	public ImageSearchRequest addProgramNamesItem(String programNamesItem) {
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

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ImageSearchRequest imageSearchRequest = (ImageSearchRequest) o;
		return Objects.equals(this.commonCropNames, imageSearchRequest.commonCropNames)
				&& Objects.equals(this.descriptiveOntologyTerms, imageSearchRequest.descriptiveOntologyTerms)
				&& Objects.equals(this.externalReferenceIds, imageSearchRequest.externalReferenceIds)
				&& Objects.equals(this.externalReferenceSources, imageSearchRequest.externalReferenceSources)
				&& Objects.equals(this.imageDbIds, imageSearchRequest.imageDbIds)
				&& Objects.equals(this.imageFileNames, imageSearchRequest.imageFileNames)
				&& Objects.equals(this.imageFileSizeMax, imageSearchRequest.imageFileSizeMax)
				&& Objects.equals(this.imageFileSizeMin, imageSearchRequest.imageFileSizeMin)
				&& Objects.equals(this.imageHeightMax, imageSearchRequest.imageHeightMax)
				&& Objects.equals(this.imageHeightMin, imageSearchRequest.imageHeightMin)
				&& Objects.equals(this.imageLocation, imageSearchRequest.imageLocation)
				&& Objects.equals(this.imageNames, imageSearchRequest.imageNames)
				&& Objects.equals(this.imageTimeStampRangeEnd, imageSearchRequest.imageTimeStampRangeEnd)
				&& Objects.equals(this.imageTimeStampRangeStart, imageSearchRequest.imageTimeStampRangeStart)
				&& Objects.equals(this.imageWidthMax, imageSearchRequest.imageWidthMax)
				&& Objects.equals(this.imageWidthMin, imageSearchRequest.imageWidthMin)
				&& Objects.equals(this.mimeTypes, imageSearchRequest.mimeTypes)
				&& Objects.equals(this.observationDbIds, imageSearchRequest.observationDbIds)
				&& Objects.equals(this.observationUnitDbIds, imageSearchRequest.observationUnitDbIds)
				&& Objects.equals(this.programDbIds, imageSearchRequest.programDbIds)
				&& Objects.equals(this.programNames, imageSearchRequest.programNames) && super.equals(o);
	}

	@Override
	public int hashCode() {
		return Objects.hash(commonCropNames, descriptiveOntologyTerms, externalReferenceIds, externalReferenceSources,
				imageDbIds, imageFileNames, imageFileSizeMax, imageFileSizeMin, imageHeightMax, imageHeightMin,
				imageLocation, imageNames, imageTimeStampRangeEnd, imageTimeStampRangeStart, imageWidthMax,
				imageWidthMin, mimeTypes, observationDbIds, observationUnitDbIds, programDbIds, programNames,
				super.hashCode());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ImageSearchRequest {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    commonCropNames: ").append(toIndentedString(commonCropNames)).append("\n");
		sb.append("    descriptiveOntologyTerms: ").append(toIndentedString(descriptiveOntologyTerms)).append("\n");
		sb.append("    externalReferenceIds: ").append(toIndentedString(externalReferenceIds)).append("\n");
		sb.append("    externalReferenceSources: ").append(toIndentedString(externalReferenceSources)).append("\n");
		sb.append("    imageDbIds: ").append(toIndentedString(imageDbIds)).append("\n");
		sb.append("    imageFileNames: ").append(toIndentedString(imageFileNames)).append("\n");
		sb.append("    imageFileSizeMax: ").append(toIndentedString(imageFileSizeMax)).append("\n");
		sb.append("    imageFileSizeMin: ").append(toIndentedString(imageFileSizeMin)).append("\n");
		sb.append("    imageHeightMax: ").append(toIndentedString(imageHeightMax)).append("\n");
		sb.append("    imageHeightMin: ").append(toIndentedString(imageHeightMin)).append("\n");
		sb.append("    imageLocation: ").append(toIndentedString(imageLocation)).append("\n");
		sb.append("    imageNames: ").append(toIndentedString(imageNames)).append("\n");
		sb.append("    imageTimeStampRangeEnd: ").append(toIndentedString(imageTimeStampRangeEnd)).append("\n");
		sb.append("    imageTimeStampRangeStart: ").append(toIndentedString(imageTimeStampRangeStart)).append("\n");
		sb.append("    imageWidthMax: ").append(toIndentedString(imageWidthMax)).append("\n");
		sb.append("    imageWidthMin: ").append(toIndentedString(imageWidthMin)).append("\n");
		sb.append("    mimeTypes: ").append(toIndentedString(mimeTypes)).append("\n");
		sb.append("    observationDbIds: ").append(toIndentedString(observationDbIds)).append("\n");
		sb.append("    observationUnitDbIds: ").append(toIndentedString(observationUnitDbIds)).append("\n");
		sb.append("    programDbIds: ").append(toIndentedString(programDbIds)).append("\n");
		sb.append("    programNames: ").append(toIndentedString(programNames)).append("\n");
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
	public Integer getTotalParameterCount() {
		Integer count = 0;
		if (this.commonCropNames != null)
			count += this.commonCropNames.size();
		if (this.descriptiveOntologyTerms != null)
			count += this.descriptiveOntologyTerms.size();
		if (this.externalReferenceIds != null)
			count += this.externalReferenceIds.size();
		if (this.externalReferenceSources != null)
			count += this.externalReferenceSources.size();
		if (this.imageDbIds != null)
			count += this.imageDbIds.size();
		if (this.imageFileNames != null)
			count += this.imageFileNames.size();
		if (this.imageFileSizeMax != null)
			count += 1;
		if (this.imageFileSizeMin != null)
			count += 1;
		if (this.imageHeightMax != null)
			count += 1;
		if (this.imageHeightMin != null)
			count += 1;
		if (this.imageLocation != null)
			count += 1;
		if (this.imageNames != null)
			count += this.imageNames.size();
		if (this.imageTimeStampRangeEnd != null)
			count += 1;
		if (this.imageTimeStampRangeStart != null)
			count += 1;
		if (this.imageWidthMax != null)
			count += 1;
		if (this.imageWidthMin != null)
			count += 1;
		if (this.mimeTypes != null)
			count += this.mimeTypes.size();
		if (this.observationDbIds != null)
			count += this.observationDbIds.size();
		if (this.observationUnitDbIds != null)
			count += this.observationUnitDbIds.size();
		if (this.programDbIds != null)
			count += this.programDbIds.size();
		if (this.programNames != null)
			count += this.programNames.size();
		return count;
	}
}
