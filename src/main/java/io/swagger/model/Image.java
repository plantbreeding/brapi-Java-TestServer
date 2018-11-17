package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.GeoJSON;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Image
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-11-06T17:40:52.157-05:00[America/New_York]")

public class Image   {
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

  @JsonProperty("imageDbId")
  private String imageDbId = null;

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
  private LocalDate imageTimeStamp = null;

  @JsonProperty("imageURL")
  private String imageURL = null;

  @JsonProperty("imageWidth")
  private Integer imageWidth = null;

  @JsonProperty("mimeType")
  private String mimeType = null;

  @JsonProperty("observationDbIds")
  @Valid
  private List<String> observationDbIds = null;

  @JsonProperty("observationUnitDbId")
  private String observationUnitDbId = null;

  public Image additionalInfo(Map<String, String> additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  public Image putAdditionalInfoItem(String key, String additionalInfoItem) {
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

  public Image copyright(String copyright) {
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

  public Image description(String description) {
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

  public Image descriptiveOntologyTerms(List<String> descriptiveOntologyTerms) {
    this.descriptiveOntologyTerms = descriptiveOntologyTerms;
    return this;
  }

  public Image addDescriptiveOntologyTermsItem(String descriptiveOntologyTermsItem) {
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

  public Image imageDbId(String imageDbId) {
    this.imageDbId = imageDbId;
    return this;
  }

  /**
   * The unique identifier of an image
   * @return imageDbId
  **/
  @ApiModelProperty(value = "The unique identifier of an image")


  public String getImageDbId() {
    return imageDbId;
  }

  public void setImageDbId(String imageDbId) {
    this.imageDbId = imageDbId;
  }

  public Image imageFileName(String imageFileName) {
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

  public Image imageFileSize(Integer imageFileSize) {
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

  public Image imageHeight(Integer imageHeight) {
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

  public Image imageLocation(GeoJSON imageLocation) {
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

  public Image imageName(String imageName) {
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

  public Image imageTimeStamp(LocalDate imageTimeStamp) {
    this.imageTimeStamp = imageTimeStamp;
    return this;
  }

  /**
   * The date and time the image was taken
   * @return imageTimeStamp
  **/
  @ApiModelProperty(value = "The date and time the image was taken")

  @Valid

  public LocalDate getImageTimeStamp() {
    return imageTimeStamp;
  }

  public void setImageTimeStamp(LocalDate imageTimeStamp) {
    this.imageTimeStamp = imageTimeStamp;
  }

  public Image imageURL(String imageURL) {
    this.imageURL = imageURL;
    return this;
  }

  /**
   * The complete, absolute URI path to the image file. Images might be stored on a different host or path than the BrAPI web server.
   * @return imageURL
  **/
  @ApiModelProperty(value = "The complete, absolute URI path to the image file. Images might be stored on a different host or path than the BrAPI web server.")


  public String getImageURL() {
    return imageURL;
  }

  public void setImageURL(String imageURL) {
    this.imageURL = imageURL;
  }

  public Image imageWidth(Integer imageWidth) {
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

  public Image mimeType(String mimeType) {
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

  public Image observationDbIds(List<String> observationDbIds) {
    this.observationDbIds = observationDbIds;
    return this;
  }

  public Image addObservationDbIdsItem(String observationDbIdsItem) {
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

  public Image observationUnitDbId(String observationUnitDbId) {
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
    Image image = (Image) o;
    return Objects.equals(this.additionalInfo, image.additionalInfo) &&
        Objects.equals(this.copyright, image.copyright) &&
        Objects.equals(this.description, image.description) &&
        Objects.equals(this.descriptiveOntologyTerms, image.descriptiveOntologyTerms) &&
        Objects.equals(this.imageDbId, image.imageDbId) &&
        Objects.equals(this.imageFileName, image.imageFileName) &&
        Objects.equals(this.imageFileSize, image.imageFileSize) &&
        Objects.equals(this.imageHeight, image.imageHeight) &&
        Objects.equals(this.imageLocation, image.imageLocation) &&
        Objects.equals(this.imageName, image.imageName) &&
        Objects.equals(this.imageTimeStamp, image.imageTimeStamp) &&
        Objects.equals(this.imageURL, image.imageURL) &&
        Objects.equals(this.imageWidth, image.imageWidth) &&
        Objects.equals(this.mimeType, image.mimeType) &&
        Objects.equals(this.observationDbIds, image.observationDbIds) &&
        Objects.equals(this.observationUnitDbId, image.observationUnitDbId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalInfo, copyright, description, descriptiveOntologyTerms, imageDbId, imageFileName, imageFileSize, imageHeight, imageLocation, imageName, imageTimeStamp, imageURL, imageWidth, mimeType, observationDbIds, observationUnitDbId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Image {\n");
    
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    copyright: ").append(toIndentedString(copyright)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    descriptiveOntologyTerms: ").append(toIndentedString(descriptiveOntologyTerms)).append("\n");
    sb.append("    imageDbId: ").append(toIndentedString(imageDbId)).append("\n");
    sb.append("    imageFileName: ").append(toIndentedString(imageFileName)).append("\n");
    sb.append("    imageFileSize: ").append(toIndentedString(imageFileSize)).append("\n");
    sb.append("    imageHeight: ").append(toIndentedString(imageHeight)).append("\n");
    sb.append("    imageLocation: ").append(toIndentedString(imageLocation)).append("\n");
    sb.append("    imageName: ").append(toIndentedString(imageName)).append("\n");
    sb.append("    imageTimeStamp: ").append(toIndentedString(imageTimeStamp)).append("\n");
    sb.append("    imageURL: ").append(toIndentedString(imageURL)).append("\n");
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

