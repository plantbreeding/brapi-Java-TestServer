package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ObservationTreatment
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T21:50:05.517Z")

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
   * The type of treatment/factor. ex. 'fertilizer', 'inoculation', 'irrigation', etc
   * @return factor
  **/
  @ApiModelProperty(value = "The type of treatment/factor. ex. 'fertilizer', 'inoculation', 'irrigation', etc")


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
   * The treatment/factor descritpion. ex. 'low fertilizer', 'yellow rust inoculation', 'high water', etc
   * @return modality
  **/
  @ApiModelProperty(value = "The treatment/factor descritpion. ex. 'low fertilizer', 'yellow rust inoculation', 'high water', etc")


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

