package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Context;
import io.swagger.model.Metadata;
import io.swagger.model.Model202AcceptedSearchResponseResult;
import io.swagger.model.germ.GermplasmListResponseResult;

import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

/**
 * Model202AcceptedSearchResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class Model202AcceptedSearchResponse implements BrAPIResponse<Model202AcceptedSearchResponseResult>  {
  @JsonProperty("@context")
  private Context _atContext = null;

  @JsonProperty("metadata")
  private Metadata metadata = null;

  @JsonProperty("result")
  private Model202AcceptedSearchResponseResult result = null;

  public Model202AcceptedSearchResponse _atContext(Context _atContext) {
    this._atContext = _atContext;
    return this;
  }

  /**
   * Get _atContext
   * @return _atContext
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Context getAtContext() {
    return _atContext;
  }

  public void set_atContext(Context _atContext) {
    this._atContext = _atContext;
  }

  public Model202AcceptedSearchResponse metadata(Metadata metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * Get metadata
   * @return metadata
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Metadata getMetadata() {
    return metadata;
  }

  public void setMetadata(Metadata metadata) {
    this.metadata = metadata;
  }

  public Model202AcceptedSearchResponse result(Model202AcceptedSearchResponseResult result) {
    this.result = result;
    return this;
  }

  /**
   * Get result
   * @return result
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Model202AcceptedSearchResponseResult getResult() {
    return result;
  }

  public void setResult(Model202AcceptedSearchResponseResult result) {
    this.result = result;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Model202AcceptedSearchResponse _202AcceptedSearchResponse = (Model202AcceptedSearchResponse) o;
    return Objects.equals(this._atContext, _202AcceptedSearchResponse._atContext) &&
        Objects.equals(this.metadata, _202AcceptedSearchResponse.metadata) &&
        Objects.equals(this.result, _202AcceptedSearchResponse.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_atContext, metadata, result);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Model202AcceptedSearchResponse {\n");
    
    sb.append("    _atContext: ").append(toIndentedString(_atContext)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
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
