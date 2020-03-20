package io.swagger.model.pheno;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

/**
 * Season
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:32:22.556Z[GMT]")
public class Season   {
  @JsonProperty("season")
  private String season = null;

  @JsonProperty("seasonDbId")
  private String seasonDbId = null;

  @JsonProperty("year")
  private Integer year = null;

  public Season season(String season) {
    this.season = season;
    return this;
  }

  /**
   * Name of the season. ex. 'Spring', 'Q2', 'Season A', etc.
   * @return season
  **/
  @ApiModelProperty(example = "Spring", value = "Name of the season. ex. 'Spring', 'Q2', 'Season A', etc.")
  
    public String getSeason() {
    return season;
  }

  public void setSeason(String season) {
    this.season = season;
  }

  public Season seasonDbId(String seasonDbId) {
    this.seasonDbId = seasonDbId;
    return this;
  }

  /**
   * The ID which uniquely identifies a season. For backward compatibility it can be a string like '2012', '1957-2004'
   * @return seasonDbId
  **/
  @ApiModelProperty(example = "Spring_2018", required = true, value = "The ID which uniquely identifies a season. For backward compatibility it can be a string like '2012', '1957-2004'")
      @NotNull

    public String getSeasonDbId() {
    return seasonDbId;
  }

  public void setSeasonDbId(String seasonDbId) {
    this.seasonDbId = seasonDbId;
  }

  public Season year(Integer year) {
    this.year = year;
    return this;
  }

  /**
   * The 4 digit year of the season.
   * @return year
  **/
  @ApiModelProperty(example = "2018", value = "The 4 digit year of the season.")
  
    public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Season season = (Season) o;
    return Objects.equals(this.season, season.season) &&
        Objects.equals(this.seasonDbId, season.seasonDbId) &&
        Objects.equals(this.year, season.year);
  }

  @Override
  public int hashCode() {
    return Objects.hash(season, seasonDbId, year);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Season {\n");
    
    sb.append("    season: ").append(toIndentedString(season)).append("\n");
    sb.append("    seasonDbId: ").append(toIndentedString(seasonDbId)).append("\n");
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
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
