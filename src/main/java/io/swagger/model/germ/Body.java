package io.swagger.model.germ;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.germ.SeedLotNewTransactionRequest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * Body
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
public class Body   {
  @JsonProperty("seedLots")
  @Valid
  private List<SeedLotNewTransactionRequest> seedLots = null;

  public Body seedLots(List<SeedLotNewTransactionRequest> seedLots) {
    this.seedLots = seedLots;
    return this;
  }

  public Body addSeedLotsItem(SeedLotNewTransactionRequest seedLotsItem) {
    if (this.seedLots == null) {
      this.seedLots = new ArrayList<SeedLotNewTransactionRequest>();
    }
    this.seedLots.add(seedLotsItem);
    return this;
  }

  /**
   * Get seedLots
   * @return seedLots
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<SeedLotNewTransactionRequest> getSeedLots() {
    return seedLots;
  }

  public void setSeedLots(List<SeedLotNewTransactionRequest> seedLots) {
    this.seedLots = seedLots;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Body body = (Body) o;
    return Objects.equals(this.seedLots, body.seedLots);
  }

  @Override
  public int hashCode() {
    return Objects.hash(seedLots);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Body {\n");
    
    sb.append("    seedLots: ").append(toIndentedString(seedLots)).append("\n");
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
