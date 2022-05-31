package io.swagger.model.core;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

/**
 * ServerInfo
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class ServerInfo   {
  @JsonProperty("calls")
  @Valid
  private List<Service> calls = new ArrayList<Service>();

  @JsonProperty("contactEmail")
  private String contactEmail = null;

  @JsonProperty("documentationURL")
  private String documentationURL = null;

  @JsonProperty("location")
  private String location = null;

  @JsonProperty("organizationName")
  private String organizationName = null;

  @JsonProperty("organizationURL")
  private String organizationURL = null;

  @JsonProperty("serverDescription")
  private String serverDescription = null;

  @JsonProperty("serverName")
  private String serverName = null;

  public ServerInfo calls(List<Service> calls) {
    this.calls = calls;
    return this;
  }

  public ServerInfo addCallsItem(Service callsItem) {
    this.calls.add(callsItem);
    return this;
  }

  /**
   * Array of available calls on this server
   * @return calls
  **/
  @ApiModelProperty(required = true, value = "Array of available calls on this server")
      
    @Valid
    public List<Service> getCalls() {
    return calls;
  }

  public void setCalls(List<Service> calls) {
    this.calls = calls;
  }

  public ServerInfo contactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
    return this;
  }

  /**
   * A contact email address for this server management
   * @return contactEmail
  **/
  @ApiModelProperty(example = "contact@institute.org", value = "A contact email address for this server management")
  
    public String getContactEmail() {
    return contactEmail;
  }

  public void setContactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
  }

  public ServerInfo documentationURL(String documentationURL) {
    this.documentationURL = documentationURL;
    return this;
  }

  /**
   * A URL to the human readable documentation of this object
   * @return documentationURL
  **/
  @ApiModelProperty(example = "institute.org/server", value = "A URL to the human readable documentation of this object")
  
    public String getDocumentationURL() {
    return documentationURL;
  }

  public void setDocumentationURL(String documentationURL) {
    this.documentationURL = documentationURL;
  }

  public ServerInfo location(String location) {
    this.location = location;
    return this;
  }

  /**
   * Physical location of this server (ie. City, Country)
   * @return location
  **/
  @ApiModelProperty(example = "USA", value = "Physical location of this server (ie. City, Country)")
  
    public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public ServerInfo organizationName(String organizationName) {
    this.organizationName = organizationName;
    return this;
  }

  /**
   * The name of the organization that manages this server and data
   * @return organizationName
  **/
  @ApiModelProperty(example = "The Institute", value = "The name of the organization that manages this server and data")
  
    public String getOrganizationName() {
    return organizationName;
  }

  public void setOrganizationName(String organizationName) {
    this.organizationName = organizationName;
  }

  public ServerInfo organizationURL(String organizationURL) {
    this.organizationURL = organizationURL;
    return this;
  }

  /**
   * The URL of the organization that manages this server and data
   * @return organizationURL
  **/
  @ApiModelProperty(example = "institute.org/home", value = "The URL of the organization that manages this server and data")
  
    public String getOrganizationURL() {
    return organizationURL;
  }

  public void setOrganizationURL(String organizationURL) {
    this.organizationURL = organizationURL;
  }

  public ServerInfo serverDescription(String serverDescription) {
    this.serverDescription = serverDescription;
    return this;
  }

  /**
   * A description of this server
   * @return serverDescription
  **/
  @ApiModelProperty(example = "The BrAPI Test Server Web Server - Apache Tomcat 7.0.32 Database - Postgres 10 Supported BrAPI Version - V2.0", value = "A description of this server")
  
    public String getServerDescription() {
    return serverDescription;
  }

  public void setServerDescription(String serverDescription) {
    this.serverDescription = serverDescription;
  }

  public ServerInfo serverName(String serverName) {
    this.serverName = serverName;
    return this;
  }

  /**
   * The name of this server
   * @return serverName
  **/
  @ApiModelProperty(example = "The BrAPI Test Server", value = "The name of this server")
  
    public String getServerName() {
    return serverName;
  }

  public void setServerName(String serverName) {
    this.serverName = serverName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServerInfo serverInfo = (ServerInfo) o;
    return Objects.equals(this.calls, serverInfo.calls) &&
        Objects.equals(this.contactEmail, serverInfo.contactEmail) &&
        Objects.equals(this.documentationURL, serverInfo.documentationURL) &&
        Objects.equals(this.location, serverInfo.location) &&
        Objects.equals(this.organizationName, serverInfo.organizationName) &&
        Objects.equals(this.organizationURL, serverInfo.organizationURL) &&
        Objects.equals(this.serverDescription, serverInfo.serverDescription) &&
        Objects.equals(this.serverName, serverInfo.serverName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(calls, contactEmail, documentationURL, location, organizationName, organizationURL, serverDescription, serverName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServerInfo {\n");
    
    sb.append("    calls: ").append(toIndentedString(calls)).append("\n");
    sb.append("    contactEmail: ").append(toIndentedString(contactEmail)).append("\n");
    sb.append("    documentationURL: ").append(toIndentedString(documentationURL)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    organizationName: ").append(toIndentedString(organizationName)).append("\n");
    sb.append("    organizationURL: ").append(toIndentedString(organizationURL)).append("\n");
    sb.append("    serverDescription: ").append(toIndentedString(serverDescription)).append("\n");
    sb.append("    serverName: ").append(toIndentedString(serverName)).append("\n");
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
