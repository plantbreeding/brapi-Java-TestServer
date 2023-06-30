package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.GeoJSON;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;
import java.time.OffsetDateTime;

import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * NewImageRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class NewImageRequest   {
  @JsonProperty("additionalInfo")
  @Valid
  private Map<String, String> additionalInfo = null;

  @JsonProperty("copyright")
  private String copyright = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("descriptiveOntologyTerms")
  @Valid
  private List<String> descriptiveOntologyTerms = null;

  @JsonProperty("imageFileName")
  private String imageFileName = null;

  @JsonProperty("imageFileSize")
  private Integer imageFileSize = null;

  @JsonProperty("imageHeight")
  private Integer imageHeight = null;

  @JsonProperty("imageLocation")
  private GeoJSON imageLocation = null;

  @JsonProperty("imageName")
  private String imageName = null;

  @JsonProperty("imageTimeStamp")
  private OffsetDateTime imageTimeStamp = null;

  @JsonProperty("imageWidth")
  private Integer imageWidth = null;

  @JsonProperty("mimeType")
  private String mimeType = null;

  @JsonProperty("observationDbIds")
  @Valid
  private List<String> observationDbIds = null;

  @JsonProperty("observationUnitDbId")
  private String observationUnitDbId = null;

  public NewImageRequest additionalInfo(Map<String, String> additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  public NewImageRequest putAdditionalInfoItem(String key, String additionalInfoItem) {
    if (this.additionalInfo == null) {
      this.additionalInfo = null;
    }
    this.additionalInfo.put(key, additionalInfoItem);
    return this;
  }

  /**
   * Get additionalInfo
   * @return additionalInfo
  **/
  @ApiModelProperty(value = "")


  public Map<String, String> getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(Map<String, String> additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  public NewImageRequest copyright(String copyright) {
    this.copyright = copyright;
    return this;
  }

  /**
   * The copyright information of this image. Example 'Copyright 2018 Bob Robertson'
   * @return copyright
  **/
  @ApiModelProperty(value = "The copyright information of this image. Example 'Copyright 2018 Bob Robertson'")


  public String getCopyright() {
    return copyright;
  }

  public void setCopyright(String copyright) {
    this.copyright = copyright;
  }

  public NewImageRequest description(String description) {
    this.description = description;
    return this;
  }

  /**
   * The human readable description of an image.
   * @return description
  **/
  @ApiModelProperty(value = "The human readable description of an image.")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public NewImageRequest descriptiveOntologyTerms(List<String> descriptiveOntologyTerms) {
    this.descriptiveOntologyTerms = descriptiveOntologyTerms;
    return this;
  }

  public NewImageRequest addDescriptiveOntologyTermsItem(String descriptiveOntologyTermsItem) {
    if (this.descriptiveOntologyTerms == null) {
      this.descriptiveOntologyTerms = new ArrayList<String>();
    }
    this.descriptiveOntologyTerms.add(descriptiveOntologyTermsItem);
    return this;
  }

  /**
   * A list of terms to formally describe the image. Each item could be a simple Tag, an Ontology reference Id, or a full ontology URL.
   * @return descriptiveOntologyTerms
  **/
  @ApiModelProperty(value = "A list of terms to formally describe the image. Each item could be a simple Tag, an Ontology reference Id, or a full ontology URL.")


  public List<String> getDescriptiveOntologyTerms() {
    return descriptiveOntologyTerms;
  }

  public void setDescriptiveOntologyTerms(List<String> descriptiveOntologyTerms) {
    this.descriptiveOntologyTerms = descriptiveOntologyTerms;
  }

  public NewImageRequest imageFileName(String imageFileName) {
    this.imageFileName = imageFileName;
    return this;
  }

  /**
   * The name of the image file. Might be the same as 'imageName', but could be different.
   * @return imageFileName
  **/
  @ApiModelProperty(value = "The name of the image file. Might be the same as 'imageName', but could be different.")


  public String getImageFileName() {
    return imageFileName;
  }

  public void setImageFileName(String imageFileName) {
    this.imageFileName = imageFileName;
  }

  public NewImageRequest imageFileSize(Integer imageFileSize) {
    this.imageFileSize = imageFileSize;
    return this;
  }

  /**
   * The size of the image in Bytes.
   * @return imageFileSize
  **/
  @ApiModelProperty(value = "The size of the image in Bytes.")


  public Integer getImageFileSize() {
    return imageFileSize;
  }

  public void setImageFileSize(Integer imageFileSize) {
    this.imageFileSize = imageFileSize;
  }

  public NewImageRequest imageHeight(Integer imageHeight) {
    this.imageHeight = imageHeight;
    return this;
  }

  /**
   * The height of the image in Pixels.
   * @return imageHeight
  **/
  @ApiModelProperty(value = "The height of the image in Pixels.")


  public Integer getImageHeight() {
    return imageHeight;
  }

  public void setImageHeight(Integer imageHeight) {
    this.imageHeight = imageHeight;
  }

  public NewImageRequest imageLocation(GeoJSON imageLocation) {
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

  public NewImageRequest imageName(String imageName) {
    this.imageName = imageName;
    return this;
  }

  /**
   * The human readable name of an image. Might be the same as 'imageFileName', but could be different.
   * @return imageName
  **/
  @ApiModelProperty(value = "The human readable name of an image. Might be the same as 'imageFileName', but could be different.")


  public String getImageName() {
    return imageName;
  }

  public void setImageName(String imageName) {
    this.imageName = imageName;
  }

  public NewImageRequest imageTimeStamp(OffsetDateTime imageTimeStamp) {
    this.imageTimeStamp = imageTimeStamp;
    return this;
  }

  /**
   * The date and time the image was taken
   * @return imageTimeStamp
  **/
  @ApiModelProperty(value = "The date and time the image was taken")

  @Valid

  public OffsetDateTime getImageTimeStamp() {
    return imageTimeStamp;
  }

  public void setImageTimeStamp(OffsetDateTime imageTimeStamp) {
    this.imageTimeStamp = imageTimeStamp;
  }

  public NewImageRequest imageWidth(Integer imageWidth) {
    this.imageWidth = imageWidth;
    return this;
  }

  /**
   * The width of the image in Pixels.
   * @return imageWidth
  **/
  @ApiModelProperty(value = "The width of the image in Pixels.")


  public Integer getImageWidth() {
    return imageWidth;
  }

  public void setImageWidth(Integer imageWidth) {
    this.imageWidth = imageWidth;
  }

  public NewImageRequest mimeType(String mimeType) {
    this.mimeType = mimeType;
    return this;
  }

  /**
   * The file type of the image. Examples 'image/jpeg', 'image/png', 'image/svg', etc
   * @return mimeType
  **/
  @ApiModelProperty(value = "The file type of the image. Examples 'image/jpeg', 'image/png', 'image/svg', etc")

@Pattern(regexp="image/.*") 
  public String getMimeType() {
    return mimeType;
  }

  public void setMimeType(String mimeType) {
    this.mimeType = mimeType;
  }

  public NewImageRequest observationDbIds(List<String> observationDbIds) {
    this.observationDbIds = observationDbIds;
    return this;
  }

  public NewImageRequest addObservationDbIdsItem(String observationDbIdsItem) {
    if (this.observationDbIds == null) {
      this.observationDbIds = new ArrayList<String>();
    }
    this.observationDbIds.add(observationDbIdsItem);
    return this;
  }

  /**
   * A list of observation Ids this image is associated with, if applicable.
   * @return observationDbIds
  **/
  @ApiModelProperty(value = "A list of observation Ids this image is associated with, if applicable.")


  public List<String> getObservationDbIds() {
    return observationDbIds;
  }

  public void setObservationDbIds(List<String> observationDbIds) {
    this.observationDbIds = observationDbIds;
  }

  public NewImageRequest observationUnitDbId(String observationUnitDbId) {
    this.observationUnitDbId = observationUnitDbId;
    return this;
  }

  /**
   * The related observation unit identifier, if relevent.
   * @return observationUnitDbId
  **/
  @ApiModelProperty(value = "The related observation unit identifier, if relevent.")


  public String getObservationUnitDbId() {
    return observationUnitDbId;
  }

  public void setObservationUnitDbId(String observationUnitDbId) {
    this.observationUnitDbId = observationUnitDbId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NewImageRequest newImageRequest = (NewImageRequest) o;
    return Objects.equals(this.additionalInfo, newImageRequest.additionalInfo) &&
        Objects.equals(this.copyright, newImageRequest.copyright) &&
        Objects.equals(this.description, newImageRequest.description) &&
        Objects.equals(this.descriptiveOntologyTerms, newImageRequest.descriptiveOntologyTerms) &&
        Objects.equals(this.imageFileName, newImageRequest.imageFileName) &&
        Objects.equals(this.imageFileSize, newImageRequest.imageFileSize) &&
        Objects.equals(this.imageHeight, newImageRequest.imageHeight) &&
        Objects.equals(this.imageLocation, newImageRequest.imageLocation) &&
        Objects.equals(this.imageName, newImageRequest.imageName) &&
        Objects.equals(this.imageTimeStamp, newImageRequest.imageTimeStamp) &&
        Objects.equals(this.imageWidth, newImageRequest.imageWidth) &&
        Objects.equals(this.mimeType, newImageRequest.mimeType) &&
        Objects.equals(this.observationDbIds, newImageRequest.observationDbIds) &&
        Objects.equals(this.observationUnitDbId, newImageRequest.observationUnitDbId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalInfo, copyright, description, descriptiveOntologyTerms, imageFileName, imageFileSize, imageHeight, imageLocation, imageName, imageTimeStamp, imageWidth, mimeType, observationDbIds, observationUnitDbId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewImageRequest {\n");
    
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    copyright: ").append(toIndentedString(copyright)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    descriptiveOntologyTerms: ").append(toIndentedString(descriptiveOntologyTerms)).append("\n");
    sb.append("    imageFileName: ").append(toIndentedString(imageFileName)).append("\n");
    sb.append("    imageFileSize: ").append(toIndentedString(imageFileSize)).append("\n");
    sb.append("    imageHeight: ").append(toIndentedString(imageHeight)).append("\n");
    sb.append("    imageLocation: ").append(toIndentedString(imageLocation)).append("\n");
    sb.append("    imageName: ").append(toIndentedString(imageName)).append("\n");
    sb.append("    imageTimeStamp: ").append(toIndentedString(imageTimeStamp)).append("\n");
    sb.append("    imageWidth: ").append(toIndentedString(imageWidth)).append("\n");
    sb.append("    mimeType: ").append(toIndentedString(mimeType)).append("\n");
    sb.append("    observationDbIds: ").append(toIndentedString(observationDbIds)).append("\n");
    sb.append("    observationUnitDbId: ").append(toIndentedString(observationUnitDbId)).append("\n");
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

