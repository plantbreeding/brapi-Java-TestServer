package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * TrialPublications
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-05T14:32:54.779-05:00[America/New_York]")

public class TrialPublications   {
  @JsonProperty("publicationPUI")
  private String publicationPUI = null;

  @JsonProperty("publicationReference")
  private String publicationReference = null;

  public TrialPublications publicationPUI(String publicationPUI) {
    this.publicationPUI = publicationPUI;
    return this;
  }

  /**
   * Get publicationPUI
   * @return publicationPUI
  **/
  @ApiModelProperty(value = "")


  public String getPublicationPUI() {
    return publicationPUI;
  }

  public void setPublicationPUI(String publicationPUI) {
    this.publicationPUI = publicationPUI;
  }

  public TrialPublications publicationReference(String publicationReference) {
    this.publicationReference = publicationReference;
    return this;
  }

  /**
   * Get publicationReference
   * @return publicationReference
  **/
  @ApiModelProperty(value = "")


  public String getPublicationReference() {
    return publicationReference;
  }

  public void setPublicationReference(String publicationReference) {
    this.publicationReference = publicationReference;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TrialPublications trialPublications = (TrialPublications) o;
    return Objects.equals(this.publicationPUI, trialPublications.publicationPUI) &&
        Objects.equals(this.publicationReference, trialPublications.publicationReference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(publicationPUI, publicationReference);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TrialPublications {\n");
    
    sb.append("    publicationPUI: ").append(toIndentedString(publicationPUI)).append("\n");
    sb.append("    publicationReference: ").append(toIndentedString(publicationReference)).append("\n");
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

