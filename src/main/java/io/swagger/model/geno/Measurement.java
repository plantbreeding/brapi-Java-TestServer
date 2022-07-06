package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

/**
 * A value with units
 */
@ApiModel(description = "A value with units")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
public class Measurement   {
  @JsonProperty("units")
  private String units = null;

  @JsonProperty("value")
  private BigDecimal value = null;

  public Measurement units(String units) {
    this.units = units;
    return this;
  }

  /**
   * Units (example: \"ng/ul\")
   * @return units
  **/
  @ApiModelProperty(example = "ng/ul", value = "Units (example: \"ng/ul\")")
  
    public String getUnits() {
    return units;
  }

  public void setUnits(String units) {
    this.units = units;
  }

  public Measurement value(BigDecimal value) {
    this.value = value;
    return this;
  }

  /**
   * Value (example: \"2.3\")
   * @return value
  **/
  @ApiModelProperty(example = "2.3", value = "Value (example: \"2.3\")")
  
    @Valid
    public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Measurement measurement = (Measurement) o;
    return Objects.equals(this.units, measurement.units) &&
        Objects.equals(this.value, measurement.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(units, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Measurement {\n");
    
    sb.append("    units: ").append(toIndentedString(units)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
