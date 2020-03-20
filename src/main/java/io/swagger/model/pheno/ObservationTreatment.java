package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * ObservationTreatment
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:22.556Z[GMT]")
public class ObservationTreatment   {
  @JsonProperty("factor")
  private String factor = null;

  @JsonProperty("modality")
  private String modality = null;

  public ObservationTreatment factor(String factor) {
    this.factor = factor;
    return this;
  }

  /**
   * The type of treatment/factor. ex. 'fertilizer', 'inoculation', 'irrigation', etc  MIAPPE V1.1 (DM-61) Experimental Factor type - Name/Acronym of the experimental factor.
   * @return factor
  **/
  @ApiModelProperty(example = "fertilizer", value = "The type of treatment/factor. ex. 'fertilizer', 'inoculation', 'irrigation', etc  MIAPPE V1.1 (DM-61) Experimental Factor type - Name/Acronym of the experimental factor.")
  
    public String getFactor() {
    return factor;
  }

  public void setFactor(String factor) {
    this.factor = factor;
  }

  public ObservationTreatment modality(String modality) {
    this.modality = modality;
    return this;
  }

  /**
   * The treatment/factor description. ex. 'low fertilizer', 'yellow rust inoculation', 'high water', etc  MIAPPE V1.1 (DM-62) Experimental Factor description - Free text description of the experimental factor. This includes all relevant treatments planned and protocol planned for all the plants targeted by a given experimental factor. 
   * @return modality
  **/
  @ApiModelProperty(example = "low fertilizer", value = "The treatment/factor description. ex. 'low fertilizer', 'yellow rust inoculation', 'high water', etc  MIAPPE V1.1 (DM-62) Experimental Factor description - Free text description of the experimental factor. This includes all relevant treatments planned and protocol planned for all the plants targeted by a given experimental factor. ")
  
    public String getModality() {
    return modality;
  }

  public void setModality(String modality) {
    this.modality = modality;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ObservationTreatment observationTreatment = (ObservationTreatment) o;
    return Objects.equals(this.factor, observationTreatment.factor) &&
        Objects.equals(this.modality, observationTreatment.modality);
  }

  @Override
  public int hashCode() {
    return Objects.hash(factor, modality);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObservationTreatment {\n");
    
    sb.append("    factor: ").append(toIndentedString(factor)).append("\n");
    sb.append("    modality: ").append(toIndentedString(modality)).append("\n");
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
