package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.GeoJSON;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * ImagesSearchRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class ImagesSearchRequest   {
  @JsonProperty("descriptiveOntologyTerms")
  @Valid
  private List<String> descriptiveOntologyTerms = null;

  @JsonProperty("imageFileNames")
  @Valid
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
  private GeoJSON imageLocation = null;

  @JsonProperty("imageNames")
  @Valid
  private List<String> imageNames = null;

  @JsonProperty("imageTimeStampRangeEnd")
  private LocalDate imageTimeStampRangeEnd = null;

  @JsonProperty("imageTimeStampRangeStart")
  private LocalDate imageTimeStampRangeStart = null;

  @JsonProperty("imageWidthMax")
  private Integer imageWidthMax = null;

  @JsonProperty("imageWidthMin")
  private Integer imageWidthMin = null;

  @JsonProperty("mimeTypes")
  @Valid
  private List<String> mimeTypes = null;

  @JsonProperty("observationDbIds")
  @Valid
  private List<String> observationDbIds = null;

  @JsonProperty("observationUnitDbIds")
  @Valid
  private List<String> observationUnitDbIds = null;

  public ImagesSearchRequest descriptiveOntologyTerms(List<String> descriptiveOntologyTerms) {
    this.descriptiveOntologyTerms = descriptiveOntologyTerms;
    return this;
  }

  public ImagesSearchRequest addDescriptiveOntologyTermsItem(String descriptiveOntologyTermsItem) {
    if (this.descriptiveOntologyTerms == null) {
      this.descriptiveOntologyTerms = new ArrayList<String>();
    }
    this.descriptiveOntologyTerms.add(descriptiveOntologyTermsItem);
    return this;
  }

  /**
   * A list of terms to formally describe the image to search for. Each item could be a simple Tag, an Ontology reference Id, or a full ontology URL.
   * @return descriptiveOntologyTerms
  **/
  @ApiModelProperty(value = "A list of terms to formally describe the image to search for. Each item could be a simple Tag, an Ontology reference Id, or a full ontology URL.")


  public List<String> getDescriptiveOntologyTerms() {
    return descriptiveOntologyTerms;
  }

  public void setDescriptiveOntologyTerms(List<String> descriptiveOntologyTerms) {
    this.descriptiveOntologyTerms = descriptiveOntologyTerms;
  }

  public ImagesSearchRequest imageFileNames(List<String> imageFileNames) {
    this.imageFileNames = imageFileNames;
    return this;
  }

  public ImagesSearchRequest addImageFileNamesItem(String imageFileNamesItem) {
    if (this.imageFileNames == null) {
      this.imageFileNames = new ArrayList<String>();
    }
    this.imageFileNames.add(imageFileNamesItem);
    return this;
  }

  /**
   * Image file names to search for.
   * @return imageFileNames
  **/
  @ApiModelProperty(value = "Image file names to search for.")


  public List<String> getImageFileNames() {
    return imageFileNames;
  }

  public void setImageFileNames(List<String> imageFileNames) {
    this.imageFileNames = imageFileNames;
  }

  public ImagesSearchRequest imageFileSizeMax(Integer imageFileSizeMax) {
    this.imageFileSizeMax = imageFileSizeMax;
    return this;
  }

  /**
   * A maximum image file size to search for.
   * @return imageFileSizeMax
  **/
  @ApiModelProperty(value = "A maximum image file size to search for.")


  public Integer getImageFileSizeMax() {
    return imageFileSizeMax;
  }

  public void setImageFileSizeMax(Integer imageFileSizeMax) {
    this.imageFileSizeMax = imageFileSizeMax;
  }

  public ImagesSearchRequest imageFileSizeMin(Integer imageFileSizeMin) {
    this.imageFileSizeMin = imageFileSizeMin;
    return this;
  }

  /**
   * A minimum image file size to search for.
   * @return imageFileSizeMin
  **/
  @ApiModelProperty(value = "A minimum image file size to search for.")


  public Integer getImageFileSizeMin() {
    return imageFileSizeMin;
  }

  public void setImageFileSizeMin(Integer imageFileSizeMin) {
    this.imageFileSizeMin = imageFileSizeMin;
  }

  public ImagesSearchRequest imageHeightMax(Integer imageHeightMax) {
    this.imageHeightMax = imageHeightMax;
    return this;
  }

  /**
   * A maximum image height to search for.
   * @return imageHeightMax
  **/
  @ApiModelProperty(value = "A maximum image height to search for.")


  public Integer getImageHeightMax() {
    return imageHeightMax;
  }

  public void setImageHeightMax(Integer imageHeightMax) {
    this.imageHeightMax = imageHeightMax;
  }

  public ImagesSearchRequest imageHeightMin(Integer imageHeightMin) {
    this.imageHeightMin = imageHeightMin;
    return this;
  }

  /**
   * A minimum image height to search for.
   * @return imageHeightMin
  **/
  @ApiModelProperty(value = "A minimum image height to search for.")


  public Integer getImageHeightMin() {
    return imageHeightMin;
  }

  public void setImageHeightMin(Integer imageHeightMin) {
    this.imageHeightMin = imageHeightMin;
  }

  public ImagesSearchRequest imageLocation(GeoJSON imageLocation) {
    this.imageLocation = imageLocation;
    return this;
  }

  /**
   * Get imageLocation
   * @return imageLocation
  **/
  @ApiModelProperty(value = "")

  @Valid

  public GeoJSON getImageLocation() {
    return imageLocation;
  }

  public void setImageLocation(GeoJSON imageLocation) {
    this.imageLocation = imageLocation;
  }

  public ImagesSearchRequest imageNames(List<String> imageNames) {
    this.imageNames = imageNames;
    return this;
  }

  public ImagesSearchRequest addImageNamesItem(String imageNamesItem) {
    if (this.imageNames == null) {
      this.imageNames = new ArrayList<String>();
    }
    this.imageNames.add(imageNamesItem);
    return this;
  }

  /**
   * Human readable names to search for.
   * @return imageNames
  **/
  @ApiModelProperty(value = "Human readable names to search for.")


  public List<String> getImageNames() {
    return imageNames;
  }

  public void setImageNames(List<String> imageNames) {
    this.imageNames = imageNames;
  }

  public ImagesSearchRequest imageTimeStampRangeEnd(LocalDate imageTimeStampRangeEnd) {
    this.imageTimeStampRangeEnd = imageTimeStampRangeEnd;
    return this;
  }

  /**
   * The latest timestamp to search for.
   * @return imageTimeStampRangeEnd
  **/
  @ApiModelProperty(value = "The latest timestamp to search for.")

  @Valid

  public LocalDate getImageTimeStampRangeEnd() {
    return imageTimeStampRangeEnd;
  }

  public void setImageTimeStampRangeEnd(LocalDate imageTimeStampRangeEnd) {
    this.imageTimeStampRangeEnd = imageTimeStampRangeEnd;
  }

  public ImagesSearchRequest imageTimeStampRangeStart(LocalDate imageTimeStampRangeStart) {
    this.imageTimeStampRangeStart = imageTimeStampRangeStart;
    return this;
  }

  /**
   * The earliest timestamp to search for.
   * @return imageTimeStampRangeStart
  **/
  @ApiModelProperty(value = "The earliest timestamp to search for.")

  @Valid

  public LocalDate getImageTimeStampRangeStart() {
    return imageTimeStampRangeStart;
  }

  public void setImageTimeStampRangeStart(LocalDate imageTimeStampRangeStart) {
    this.imageTimeStampRangeStart = imageTimeStampRangeStart;
  }

  public ImagesSearchRequest imageWidthMax(Integer imageWidthMax) {
    this.imageWidthMax = imageWidthMax;
    return this;
  }

  /**
   * A maximum image width to search for.
   * @return imageWidthMax
  **/
  @ApiModelProperty(value = "A maximum image width to search for.")


  public Integer getImageWidthMax() {
    return imageWidthMax;
  }

  public void setImageWidthMax(Integer imageWidthMax) {
    this.imageWidthMax = imageWidthMax;
  }

  public ImagesSearchRequest imageWidthMin(Integer imageWidthMin) {
    this.imageWidthMin = imageWidthMin;
    return this;
  }

  /**
   * A minimum image width to search for.
   * @return imageWidthMin
  **/
  @ApiModelProperty(value = "A minimum image width to search for.")


  public Integer getImageWidthMin() {
    return imageWidthMin;
  }

  public void setImageWidthMin(Integer imageWidthMin) {
    this.imageWidthMin = imageWidthMin;
  }

  public ImagesSearchRequest mimeTypes(List<String> mimeTypes) {
    this.mimeTypes = mimeTypes;
    return this;
  }

  public ImagesSearchRequest addMimeTypesItem(String mimeTypesItem) {
    if (this.mimeTypes == null) {
      this.mimeTypes = new ArrayList<String>();
    }
    this.mimeTypes.add(mimeTypesItem);
    return this;
  }

  /**
   * A set of image file types to search for.
   * @return mimeTypes
  **/
  @ApiModelProperty(value = "A set of image file types to search for.")


  public List<String> getMimeTypes() {
    return mimeTypes;
  }

  public void setMimeTypes(List<String> mimeTypes) {
    this.mimeTypes = mimeTypes;
  }

  public ImagesSearchRequest observationDbIds(List<String> observationDbIds) {
    this.observationDbIds = observationDbIds;
    return this;
  }

  public ImagesSearchRequest addObservationDbIdsItem(String observationDbIdsItem) {
    if (this.observationDbIds == null) {
      this.observationDbIds = new ArrayList<String>();
    }
    this.observationDbIds.add(observationDbIdsItem);
    return this;
  }

  /**
   * A list of observation Ids this image is associated with to search for
   * @return observationDbIds
  **/
  @ApiModelProperty(value = "A list of observation Ids this image is associated with to search for")


  public List<String> getObservationDbIds() {
    return observationDbIds;
  }

  public void setObservationDbIds(List<String> observationDbIds) {
    this.observationDbIds = observationDbIds;
  }

  public ImagesSearchRequest observationUnitDbIds(List<String> observationUnitDbIds) {
    this.observationUnitDbIds = observationUnitDbIds;
    return this;
  }

  public ImagesSearchRequest addObservationUnitDbIdsItem(String observationUnitDbIdsItem) {
    if (this.observationUnitDbIds == null) {
      this.observationUnitDbIds = new ArrayList<String>();
    }
    this.observationUnitDbIds.add(observationUnitDbIdsItem);
    return this;
  }

  /**
   * A set of observation unit identifiers to search for.
   * @return observationUnitDbIds
  **/
  @ApiModelProperty(value = "A set of observation unit identifiers to search for.")


  public List<String> getObservationUnitDbIds() {
    return observationUnitDbIds;
  }

  public void setObservationUnitDbIds(List<String> observationUnitDbIds) {
    this.observationUnitDbIds = observationUnitDbIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ImagesSearchRequest imagesSearchRequest = (ImagesSearchRequest) o;
    return Objects.equals(this.descriptiveOntologyTerms, imagesSearchRequest.descriptiveOntologyTerms) &&
        Objects.equals(this.imageFileNames, imagesSearchRequest.imageFileNames) &&
        Objects.equals(this.imageFileSizeMax, imagesSearchRequest.imageFileSizeMax) &&
        Objects.equals(this.imageFileSizeMin, imagesSearchRequest.imageFileSizeMin) &&
        Objects.equals(this.imageHeightMax, imagesSearchRequest.imageHeightMax) &&
        Objects.equals(this.imageHeightMin, imagesSearchRequest.imageHeightMin) &&
        Objects.equals(this.imageLocation, imagesSearchRequest.imageLocation) &&
        Objects.equals(this.imageNames, imagesSearchRequest.imageNames) &&
        Objects.equals(this.imageTimeStampRangeEnd, imagesSearchRequest.imageTimeStampRangeEnd) &&
        Objects.equals(this.imageTimeStampRangeStart, imagesSearchRequest.imageTimeStampRangeStart) &&
        Objects.equals(this.imageWidthMax, imagesSearchRequest.imageWidthMax) &&
        Objects.equals(this.imageWidthMin, imagesSearchRequest.imageWidthMin) &&
        Objects.equals(this.mimeTypes, imagesSearchRequest.mimeTypes) &&
        Objects.equals(this.observationDbIds, imagesSearchRequest.observationDbIds) &&
        Objects.equals(this.observationUnitDbIds, imagesSearchRequest.observationUnitDbIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(descriptiveOntologyTerms, imageFileNames, imageFileSizeMax, imageFileSizeMin, imageHeightMax, imageHeightMin, imageLocation, imageNames, imageTimeStampRangeEnd, imageTimeStampRangeStart, imageWidthMax, imageWidthMin, mimeTypes, observationDbIds, observationUnitDbIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImagesSearchRequest {\n");
    
    sb.append("    descriptiveOntologyTerms: ").append(toIndentedString(descriptiveOntologyTerms)).append("\n");
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
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

