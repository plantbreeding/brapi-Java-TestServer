package io.swagger.model.geno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;


/**
 * Response to an order request
 */
@ApiModel(description = "Response to an order request")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:53.794Z[GMT]")
public class VendorOrderSubmission   {
  @JsonProperty("orderId")
  private String orderId = null;

  @JsonProperty("shipmentForms")
  @Valid
  private List<ShipmentForm> shipmentForms = null;

  public VendorOrderSubmission orderId(String orderId) {
    this.orderId = orderId;
    return this;
  }

  /**
   * A unique, alpha-numeric ID which identifies the order
   * @return orderId
  **/
  @ApiModelProperty(example = "b5144468", required = true, value = "A unique, alpha-numeric ID which identifies the order")
      

    public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public VendorOrderSubmission shipmentForms(List<ShipmentForm> shipmentForms) {
    this.shipmentForms = shipmentForms;
    return this;
  }

  public VendorOrderSubmission addShipmentFormsItem(ShipmentForm shipmentFormsItem) {
    if (this.shipmentForms == null) {
      this.shipmentForms = new ArrayList<ShipmentForm>();
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
    public List<ShipmentForm> getShipmentForms() {
    return shipmentForms;
  }

  public void setShipmentForms(List<ShipmentForm> shipmentForms) {
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
    VendorOrderSubmission vendorOrderSubmission = (VendorOrderSubmission) o;
    return Objects.equals(this.orderId, vendorOrderSubmission.orderId) &&
        Objects.equals(this.shipmentForms, vendorOrderSubmission.shipmentForms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, shipmentForms);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VendorOrderSubmission {\n");
    
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
