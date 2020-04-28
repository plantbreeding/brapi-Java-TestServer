package io.swagger.model.germ;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.germ.SeedLotNewRequest;
import org.springframework.validation.annotation.Validated;


/**
 * SeedLot
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:33:36.513Z[GMT]")
public class SeedLot extends SeedLotNewRequest  {
  @JsonProperty("seedLotDbId")
  private String seedLotDbId = null;

  public SeedLot seedLotDbId(String seedLotDbId) {
    this.seedLotDbId = seedLotDbId;
    return this;
  }

  /**
   * Unique DbId for the Seed Lot
   * @return seedLotDbId
  **/
  @ApiModelProperty(example = "261ecb09", required = true, value = "Unique DbId for the Seed Lot")
      

    public String getSeedLotDbId() {
    return seedLotDbId;
  }

  public void setSeedLotDbId(String seedLotDbId) {
    this.seedLotDbId = seedLotDbId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SeedLot seedLot = (SeedLot) o;
    return Objects.equals(this.seedLotDbId, seedLot.seedLotDbId) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(seedLotDbId, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SeedLot {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    seedLotDbId: ").append(toIndentedString(seedLotDbId)).append("\n");
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
