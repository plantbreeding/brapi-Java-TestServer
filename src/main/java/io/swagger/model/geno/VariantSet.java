package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * A VariantSet is a collection of variants and variant calls intended to be analyzed together.
 */
@ApiModel(description = "A VariantSet is a collection of variants and variant calls intended to be analyzed together.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
public class VariantSet   {
  @JsonProperty("additionalInfo")
  @Valid
  private Map<String, Object> additionalInfo = null;

  @JsonProperty("analysis")
  @Valid
  private List<Analysis> analysis = null;

  @JsonProperty("availableFormats")
  @Valid
  private List<VariantSetAvailableFormats> availableFormats = null;

  @JsonProperty("callSetCount")
  private Integer callSetCount = null;

  @JsonProperty("referenceSetDbId")
  private String referenceSetDbId = null;

  @JsonProperty("studyDbId")
  private String studyDbId = null;

  @JsonProperty("variantCount")
  private Integer variantCount = null;

  @JsonProperty("variantSetDbId")
  private String variantSetDbId = null;

  @JsonProperty("variantSetName")
  private String variantSetName = null;

  public VariantSet additionalInfo(Map<String, Object> additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  public VariantSet putAdditionalInfoItem(String key, String additionalInfoItem) {
    if (this.additionalInfo == null) {
      this.additionalInfo = new HashMap<String, Object>();
    }
    this.additionalInfo.put(key, additionalInfoItem);
    return this;
  }

  /**
   * Additional arbitrary info
   * @return additionalInfo
  **/
  @ApiModelProperty(value = "Additional arbitrary info")
  
    public Map<String, Object> getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(Map<String, Object> additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  public VariantSet analysis(List<Analysis> analysis) {
    this.analysis = analysis;
    return this;
  }

  public VariantSet addAnalysisItem(Analysis analysisItem) {
    if (this.analysis == null) {
      this.analysis = new ArrayList<Analysis>();
    }
    this.analysis.add(analysisItem);
    return this;
  }

  /**
   * Set of Analysis descriptors for this VariantSet
   * @return analysis
  **/
  @ApiModelProperty(value = "Set of Analysis descriptors for this VariantSet")
      @Valid
    public List<Analysis> getAnalysis() {
    return analysis;
  }

  public void setAnalysis(List<Analysis> analysis) {
    this.analysis = analysis;
  }

  public VariantSet availableFormats(List<VariantSetAvailableFormats> availableFormats) {
    this.availableFormats = availableFormats;
    return this;
  }

  public VariantSet addAvailableFormatsItem(VariantSetAvailableFormats availableFormatsItem) {
    if (this.availableFormats == null) {
      this.availableFormats = new ArrayList<VariantSetAvailableFormats>();
    }
    this.availableFormats.add(availableFormatsItem);
    return this;
  }

  /**
   * When the data for a VariantSet is retrieved, it can be retrieved in a variety of data formats and file formats.   dataFormat defines the structure of the data within a file (ie DartSeq, VCF, Hapmap, tabular, etc)  fileFormat defines the MIME type of the file (ie text/csv, application/excel, application/zip). This should also be reflected in the Accept and ContentType HTTP headers for every relevant request and response.
   * @return availableFormats
  **/
  @ApiModelProperty(example = "[{\"dataFormat\":\"VCF\",\"fileFormat\":\"application/excel\",\"fileURL\":\"https://brapi.org/example/VCF_1.xlsx\"},{\"dataFormat\":\"VCF\",\"fileFormat\":\"text/csv\",\"fileURL\":\"https://brapi.org/example/VCF_2.csv\"}]", value = "When the data for a VariantSet is retrieved, it can be retrieved in a variety of data formats and file formats.   dataFormat defines the structure of the data within a file (ie DartSeq, VCF, Hapmap, tabular, etc)  fileFormat defines the MIME type of the file (ie text/csv, application/excel, application/zip). This should also be reflected in the Accept and ContentType HTTP headers for every relevant request and response.")
      @Valid
    public List<VariantSetAvailableFormats> getAvailableFormats() {
    return availableFormats;
  }

  public void setAvailableFormats(List<VariantSetAvailableFormats> availableFormats) {
    this.availableFormats = availableFormats;
  }

  public VariantSet callSetCount(Integer callSetCount) {
    this.callSetCount = callSetCount;
    return this;
  }

  /**
   * The number of CallSets included in this VariantSet
   * @return callSetCount
  **/
  @ApiModelProperty(example = "341", value = "The number of CallSets included in this VariantSet")
  
    public Integer getCallSetCount() {
    return callSetCount;
  }

  public void setCallSetCount(Integer callSetCount) {
    this.callSetCount = callSetCount;
  }

  public VariantSet referenceSetDbId(String referenceSetDbId) {
    this.referenceSetDbId = referenceSetDbId;
    return this;
  }

  /**
   * The ID of the reference set that describes the sequences used by the variants in this set.
   * @return referenceSetDbId
  **/
  @ApiModelProperty(example = "57eae639", value = "The ID of the reference set that describes the sequences used by the variants in this set.")
  
    public String getReferenceSetDbId() {
    return referenceSetDbId;
  }

  public void setReferenceSetDbId(String referenceSetDbId) {
    this.referenceSetDbId = referenceSetDbId;
  }

  public VariantSet studyDbId(String studyDbId) {
    this.studyDbId = studyDbId;
    return this;
  }

  /**
   * The ID of the dataset this variant set belongs to.
   * @return studyDbId
  **/
  @ApiModelProperty(example = "2fc3b034", value = "The ID of the dataset this variant set belongs to.")
  
    public String getStudyDbId() {
    return studyDbId;
  }

  public void setStudyDbId(String studyDbId) {
    this.studyDbId = studyDbId;
  }

  public VariantSet variantCount(Integer variantCount) {
    this.variantCount = variantCount;
    return this;
  }

  /**
   * The number of Variants included in this VariantSet
   * @return variantCount
  **/
  @ApiModelProperty(example = "250", value = "The number of Variants included in this VariantSet")
  
    public Integer getVariantCount() {
    return variantCount;
  }

  public void setVariantCount(Integer variantCount) {
    this.variantCount = variantCount;
  }

  public VariantSet variantSetDbId(String variantSetDbId) {
    this.variantSetDbId = variantSetDbId;
    return this;
  }

  /**
   * The variant set ID.
   * @return variantSetDbId
  **/
  @ApiModelProperty(example = "87a6ac1e", value = "The variant set ID.")
  
    public String getVariantSetDbId() {
    return variantSetDbId;
  }

  public void setVariantSetDbId(String variantSetDbId) {
    this.variantSetDbId = variantSetDbId;
  }

  public VariantSet variantSetName(String variantSetName) {
    this.variantSetName = variantSetName;
    return this;
  }

  /**
   * The variant set name.
   * @return variantSetName
  **/
  @ApiModelProperty(example = "Maize QC DataSet 002334", value = "The variant set name.")
  
    public String getVariantSetName() {
    return variantSetName;
  }

  public void setVariantSetName(String variantSetName) {
    this.variantSetName = variantSetName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VariantSet variantSet = (VariantSet) o;
    return Objects.equals(this.additionalInfo, variantSet.additionalInfo) &&
        Objects.equals(this.analysis, variantSet.analysis) &&
        Objects.equals(this.availableFormats, variantSet.availableFormats) &&
        Objects.equals(this.callSetCount, variantSet.callSetCount) &&
        Objects.equals(this.referenceSetDbId, variantSet.referenceSetDbId) &&
        Objects.equals(this.studyDbId, variantSet.studyDbId) &&
        Objects.equals(this.variantCount, variantSet.variantCount) &&
        Objects.equals(this.variantSetDbId, variantSet.variantSetDbId) &&
        Objects.equals(this.variantSetName, variantSet.variantSetName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalInfo, analysis, availableFormats, callSetCount, referenceSetDbId, studyDbId, variantCount, variantSetDbId, variantSetName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VariantSet {\n");
    
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
    sb.append("    analysis: ").append(toIndentedString(analysis)).append("\n");
    sb.append("    availableFormats: ").append(toIndentedString(availableFormats)).append("\n");
    sb.append("    callSetCount: ").append(toIndentedString(callSetCount)).append("\n");
    sb.append("    referenceSetDbId: ").append(toIndentedString(referenceSetDbId)).append("\n");
    sb.append("    studyDbId: ").append(toIndentedString(studyDbId)).append("\n");
    sb.append("    variantCount: ").append(toIndentedString(variantCount)).append("\n");
    sb.append("    variantSetDbId: ").append(toIndentedString(variantSetDbId)).append("\n");
    sb.append("    variantSetName: ").append(toIndentedString(variantSetName)).append("\n");
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
