package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.DataFile;
import io.swagger.model.Status;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * MetadataBase
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class MetadataBase   {
  @JsonProperty("datafiles")
  @Valid
  private List<DataFile> datafiles = null;

  @JsonProperty("status")
  @Valid
  private List<Status> status = null;

  public MetadataBase datafiles(List<DataFile> datafiles) {
    this.datafiles = datafiles;
    return this;
  }

  public MetadataBase addDatafilesItem(DataFile datafilesItem) {
    if (this.datafiles == null) {
      this.datafiles = new ArrayList<DataFile>();
    }
    this.datafiles.add(datafilesItem);
    return this;
  }

  /**
   * The datafiles contains a list of file URLs and metadata.  These files contain additional information related to the returned object and can be retrieved by a subsequent call.  This could be a supplementary data file, an informational file, the uploaded file where the data originated from, a generated file representing the whole dataset in a particular format, or any other related file. 
   * @return datafiles
  **/
  @ApiModelProperty(value = "The datafiles contains a list of file URLs and metadata.  These files contain additional information related to the returned object and can be retrieved by a subsequent call.  This could be a supplementary data file, an informational file, the uploaded file where the data originated from, a generated file representing the whole dataset in a particular format, or any other related file. ")
      @Valid
    public List<DataFile> getDatafiles() {
    return datafiles;
  }

  public void setDatafiles(List<DataFile> datafiles) {
    this.datafiles = datafiles;
  }

  public MetadataBase status(List<Status> status) {
    this.status = status;
    return this;
  }

  public MetadataBase addStatusItem(Status statusItem) {
    if (this.status == null) {
      this.status = new ArrayList<Status>();
    }
    this.status.add(statusItem);
    return this;
  }

  /**
   * The status field contains a list of informational status messages from the server.  If no status is reported, an empty list should be returned. See Error Reporting for more information.
   * @return status
  **/
  @ApiModelProperty(value = "The status field contains a list of informational status messages from the server.  If no status is reported, an empty list should be returned. See Error Reporting for more information.")
      @Valid
    public List<Status> getStatus() {
    return status;
  }

  public void setStatus(List<Status> status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MetadataBase metadataBase = (MetadataBase) o;
    return Objects.equals(this.datafiles, metadataBase.datafiles) &&
        Objects.equals(this.status, metadataBase.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(datafiles, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MetadataBase {\n");
    
    sb.append("    datafiles: ").append(toIndentedString(datafiles)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
