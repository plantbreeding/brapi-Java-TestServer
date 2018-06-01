package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * MarkersSearchRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-01T19:24:22.162Z")

public class MarkersSearchRequest   {
  @JsonProperty("includeSynonyms")
  private Boolean includeSynonyms = null;

  @JsonProperty("markerDbIds")
  @Valid
  private List<String> markerDbIds = null;

  /**
   * How to perform string matching during search. 'exact' will search for exact, case sensitive matches only. 'case_insensitive' will search for exact matches, but case insensitive. 'wildcard' will allow the special characters '*' (star) and '%' (percent) to represent variable length arbitrary strings, and the special character '?' (question) to represent one arbitrary character.
   */
  public enum MatchMethodEnum {
    EXACT("exact"),
    
    CASE_INSENSITIVE("case_insensitive"),
    
    WILDCARD("wildcard");

    private String value;

    MatchMethodEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static MatchMethodEnum fromValue(String text) {
      for (MatchMethodEnum b : MatchMethodEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("matchMethod")
  private MatchMethodEnum matchMethod = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("page")
  private Integer page = null;

  @JsonProperty("pageSize")
  private Integer pageSize = null;

  @JsonProperty("type")
  private String type = null;

  public MarkersSearchRequest includeSynonyms(Boolean includeSynonyms) {
    this.includeSynonyms = includeSynonyms;
    return this;
  }

   /**
   * Should an array of synonyms be included in the response
   * @return includeSynonyms
  **/
  @ApiModelProperty(value = "Should an array of synonyms be included in the response")


  public Boolean isIncludeSynonyms() {
    return includeSynonyms;
  }

  public void setIncludeSynonyms(Boolean includeSynonyms) {
    this.includeSynonyms = includeSynonyms;
  }

  public MarkersSearchRequest markerDbIds(List<String> markerDbIds) {
    this.markerDbIds = markerDbIds;
    return this;
  }

  public MarkersSearchRequest addMarkerDbIdsItem(String markerDbIdsItem) {
    if (this.markerDbIds == null) {
      this.markerDbIds = new ArrayList<String>();
    }
    this.markerDbIds.add(markerDbIdsItem);
    return this;
  }

   /**
   * List of IDs which uniquely identify markers 
   * @return markerDbIds
  **/
  @ApiModelProperty(value = "List of IDs which uniquely identify markers ")


  public List<String> getMarkerDbIds() {
    return markerDbIds;
  }

  public void setMarkerDbIds(List<String> markerDbIds) {
    this.markerDbIds = markerDbIds;
  }

  public MarkersSearchRequest matchMethod(MatchMethodEnum matchMethod) {
    this.matchMethod = matchMethod;
    return this;
  }

   /**
   * How to perform string matching during search. 'exact' will search for exact, case sensitive matches only. 'case_insensitive' will search for exact matches, but case insensitive. 'wildcard' will allow the special characters '*' (star) and '%' (percent) to represent variable length arbitrary strings, and the special character '?' (question) to represent one arbitrary character.
   * @return matchMethod
  **/
  @ApiModelProperty(value = "How to perform string matching during search. 'exact' will search for exact, case sensitive matches only. 'case_insensitive' will search for exact matches, but case insensitive. 'wildcard' will allow the special characters '*' (star) and '%' (percent) to represent variable length arbitrary strings, and the special character '?' (question) to represent one arbitrary character.")


  public MatchMethodEnum getMatchMethod() {
    return matchMethod;
  }

  public void setMatchMethod(MatchMethodEnum matchMethod) {
    this.matchMethod = matchMethod;
  }

  public MarkersSearchRequest name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The search pattern for the marker name or synonym.
   * @return name
  **/
  @ApiModelProperty(value = "The search pattern for the marker name or synonym.")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public MarkersSearchRequest page(Integer page) {
    this.page = page;
    return this;
  }

   /**
   * Which page of the \"data\" array to return. The page indexing starts at 0 (page=0 will return the first page). Default is 0.
   * @return page
  **/
  @ApiModelProperty(value = "Which page of the \"data\" array to return. The page indexing starts at 0 (page=0 will return the first page). Default is 0.")


  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public MarkersSearchRequest pageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return this;
  }

   /**
   * The maximum number of items to return per page of the \"data\" array. Default is 1000.
   * @return pageSize
  **/
  @ApiModelProperty(value = "The maximum number of items to return per page of the \"data\" array. Default is 1000.")


  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public MarkersSearchRequest type(String type) {
    this.type = type;
    return this;
  }

   /**
   * The type of marker, e.g. SNP
   * @return type
  **/
  @ApiModelProperty(value = "The type of marker, e.g. SNP")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MarkersSearchRequest markersSearchRequest = (MarkersSearchRequest) o;
    return Objects.equals(this.includeSynonyms, markersSearchRequest.includeSynonyms) &&
        Objects.equals(this.markerDbIds, markersSearchRequest.markerDbIds) &&
        Objects.equals(this.matchMethod, markersSearchRequest.matchMethod) &&
        Objects.equals(this.name, markersSearchRequest.name) &&
        Objects.equals(this.page, markersSearchRequest.page) &&
        Objects.equals(this.pageSize, markersSearchRequest.pageSize) &&
        Objects.equals(this.type, markersSearchRequest.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(includeSynonyms, markerDbIds, matchMethod, name, page, pageSize, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MarkersSearchRequest {\n");
    
    sb.append("    includeSynonyms: ").append(toIndentedString(includeSynonyms)).append("\n");
    sb.append("    markerDbIds: ").append(toIndentedString(markerDbIds)).append("\n");
    sb.append("    matchMethod: ").append(toIndentedString(matchMethod)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

