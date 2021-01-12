package com.javatpoint.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ResponseError {
  private LocalDateTime timestamp;
  private HttpStatus errorCode;
  private String details;
/**
 * @return the timestamp
 */
public LocalDateTime getTimestamp() {
	return timestamp;
}
/**
 * @param timestamp the timestamp to set
 */
public void setTimestamp(LocalDateTime timestamp) {
	this.timestamp = timestamp;
}

/**
 * @return the errorCode
 */
public HttpStatus getErrorCode() {
	return errorCode;
}
/**
 * @param errorCode the errorCode to set
 */
public void setErrorCode(HttpStatus errorCode) {
	this.errorCode = errorCode;
}
/**
 * @return the details
 */
public String getDetails() {
	return details;
}
/**
 * @param details the details to set
 */
public void setDetails(String details) {
	this.details = details;
}
  
}
