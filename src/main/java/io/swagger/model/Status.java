package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Status
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-10-25T15:57:44.669-04:00[America/New_York]")

public class Status   {
  @JsonProperty("code")
  private String code = null;

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

  public Status code(String code) {
    this.code = code;
    return this;
  }

  /**
   * DEPRECATED in v1.3 - see Error Handling best practice documentation
   * @return code
  **/
  @ApiModelProperty(value = "DEPRECATED in v1.3 - see Error Handling best practice documentation")


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Status message(String message) {
    this.message = message;
    return this;
  }

  /**
   * A short message concerning the status of this request/response
   * @return message
  **/
  @ApiModelProperty(value = "A short message concerning the status of this request/response")


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
  @ApiModelProperty(value = "The logging level for the attached message")


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
    return Objects.equals(this.code, status.code) &&
        Objects.equals(this.message, status.message) &&
        Objects.equals(this.messageType, status.messageType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message, messageType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Status {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
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

