package io.swagger.model.core;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

/**
 * Study
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class Study extends StudyNewRequest  {
  @JsonProperty("studyDbId")
  private String studyDbId = null;

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Study study = (Study) o;
    return Objects.equals(this.studyDbId, study.studyDbId) &&
        super.equals(o);
  }

  /**
   * The ID which uniquely identifies a study within the given database server  MIAPPE V1.1 (DM-11) Study unique ID - Unique identifier comprising the name or identifier for the institution/database hosting the submission of the study data, and the identifier of the study in that institution.
   * @return studyDbId
  **/
  @ApiModelProperty(example = "175ac75a", required = true, value = "The ID which uniquely identifies a study within the given database server  MIAPPE V1.1 (DM-11) Study unique ID - Unique identifier comprising the name or identifier for the institution/database hosting the submission of the study data, and the identifier of the study in that institution.")
      @NotNull

    public String getStudyDbId() {
    return studyDbId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(studyDbId, super.hashCode());
  }


  public void setStudyDbId(String studyDbId) {
    this.studyDbId = studyDbId;
  }

  public Study studyDbId(String studyDbId) {
    this.studyDbId = studyDbId;
    return this;
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

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Study {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    studyDbId: ").append(toIndentedString(studyDbId)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
