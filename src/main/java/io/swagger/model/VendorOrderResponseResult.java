package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.VendorOrderResponseResultShipmentForms;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Response to an order request
 */
@ApiModel(description = "Response to an order request")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-10-25T15:57:44.669-04:00[America/New_York]")

public class VendorOrderResponseResult   {
  @JsonProperty("orderId")
  private String orderId = null;

  @JsonProperty("shipmentForms")
  @Valid
  private List<VendorOrderResponseResultShipmentForms> shipmentForms = null;

  public VendorOrderResponseResult orderId(String orderId) {
    this.orderId = orderId;
    return this;
  }

  /**
   * A unique, alpha-numeric ID which identifies the order .
   * @return orderId
  **/
  @ApiModelProperty(value = "A unique, alpha-numeric ID which identifies the order .")


  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public VendorOrderResponseResult shipmentForms(List<VendorOrderResponseResultShipmentForms> shipmentForms) {
    this.shipmentForms = shipmentForms;
    return this;
  }

  public VendorOrderResponseResult addShipmentFormsItem(VendorOrderResponseResultShipmentForms shipmentFormsItem) {
    if (this.shipmentForms == null) {
      this.shipmentForms = new ArrayList<VendorOrderResponseResultShipmentForms>();
    }
    this.shipmentForms.add(shipmentFormsItem);
    return this;
  }

  /**
   * Array of paper forms which need to be printed and included with the physical shipment
   * @return shipmentForms
  **/
  @ApiModelProperty(value = "Array of paper forms which need to be printed and included with the physical shipment")

  @Valid

  public List<VendorOrderResponseResultShipmentForms> getShipmentForms() {
    return shipmentForms;
  }

  public void setShipmentForms(List<VendorOrderResponseResultShipmentForms> shipmentForms) {
    this.shipmentForms = shipmentForms;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VendorOrderResponseResult vendorOrderResponseResult = (VendorOrderResponseResult) o;
    return Objects.equals(this.orderId, vendorOrderResponseResult.orderId) &&
        Objects.equals(this.shipmentForms, vendorOrderResponseResult.shipmentForms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, shipmentForms);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VendorOrderResponseResult {\n");
    
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    shipmentForms: ").append(toIndentedString(shipmentForms)).append("\n");
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

