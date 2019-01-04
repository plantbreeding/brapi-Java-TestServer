package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.NewObservationsRequestDeprecatedData;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * NewObservationsRequestDeprecated
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class NewObservationsRequestDeprecated   {
  @JsonProperty("commit")
  private String commit = null;

  @JsonProperty("data")
  @Valid
  private List<NewObservationsRequestDeprecatedData> data = null;

  @JsonProperty("transactionDbId")
  private String transactionDbId = null;

  public NewObservationsRequestDeprecated commit(String commit) {
    this.commit = commit;
    return this;
  }

  /**
   * Should these changes be commited
   * @return commit
  **/
  @ApiModelProperty(value = "Should these changes be commited")


  public String getCommit() {
    return commit;
  }

  public void setCommit(String commit) {
    this.commit = commit;
  }

  public NewObservationsRequestDeprecated data(List<NewObservationsRequestDeprecatedData> data) {
    this.data = data;
    return this;
  }

  public NewObservationsRequestDeprecated addDataItem(NewObservationsRequestDeprecatedData dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<NewObservationsRequestDeprecatedData>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * Required array of marker-name/score pairs
   * @return data
  **/
  @ApiModelProperty(value = "Required array of marker-name/score pairs")

  @Valid

  public List<NewObservationsRequestDeprecatedData> getData() {
    return data;
  }

  public void setData(List<NewObservationsRequestDeprecatedData> data) {
    this.data = data;
  }

  public NewObservationsRequestDeprecated transactionDbId(String transactionDbId) {
    this.transactionDbId = transactionDbId;
    return this;
  }

  /**
   * The ID representing this transaction
   * @return transactionDbId
  **/
  @ApiModelProperty(value = "The ID representing this transaction")


  public String getTransactionDbId() {
    return transactionDbId;
  }

  public void setTransactionDbId(String transactionDbId) {
    this.transactionDbId = transactionDbId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NewObservationsRequestDeprecated newObservationsRequestDeprecated = (NewObservationsRequestDeprecated) o;
    return Objects.equals(this.commit, newObservationsRequestDeprecated.commit) &&
        Objects.equals(this.data, newObservationsRequestDeprecated.data) &&
        Objects.equals(this.transactionDbId, newObservationsRequestDeprecated.transactionDbId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(commit, data, transactionDbId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewObservationsRequestDeprecated {\n");
    
    sb.append("    commit: ").append(toIndentedString(commit)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    transactionDbId: ").append(toIndentedString(transactionDbId)).append("\n");
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

