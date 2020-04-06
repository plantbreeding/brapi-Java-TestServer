package io.swagger.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

/**
 * An array of status messages to convey technical logging information from the server to the client.
 */
@ApiModel(description = "An array of status messages to convey technical logging information from the server to the client.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-20T16:31:52.030Z[GMT]")
public class Status   {
  @JsonProperty("message")
  private String message = null;

  /**
   * The logging level for the attached message
   */
  public enum MessageTypeEnum {
    DEBUG("DEBUG"),
    
    ERROR("ERROR"),
    
    WARNING("WARNING"),
    
    INFO("INFO");

    private String value;

    MessageTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static MessageTypeEnum fromValue(String text) {
      for (MessageTypeEnum b : MessageTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("messageType")
  private MessageTypeEnum messageType = null;

  public Status message(String message) {
    this.message = message;
    return this;
  }

  /**
   * A short message concerning the status of this request/response
   * @return message
  **/
  @ApiModelProperty(example = "Request accepted, response successful", required = true, value = "A short message concerning the status of this request/response")
      @NotNull

    public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Status messageType(MessageTypeEnum messageType) {
    this.messageType = messageType;
    return this;
  }

  /**
   * The logging level for the attached message
   * @return messageType
  **/
  @ApiModelProperty(example = "INFO", required = true, value = "The logging level for the attached message")
      @NotNull

    public MessageTypeEnum getMessageType() {
    return messageType;
  }

  public void setMessageType(MessageTypeEnum messageType) {
    this.messageType = messageType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Status status = (Status) o;
    return Objects.equals(this.message, status.message) &&
        Objects.equals(this.messageType, status.messageType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, messageType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Status {\n");
    
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    messageType: ").append(toIndentedString(messageType)).append("\n");
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
