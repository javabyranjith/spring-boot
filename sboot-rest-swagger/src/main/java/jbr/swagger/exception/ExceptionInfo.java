package jbr.swagger.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Custom Exception Details class.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionInfo {
  private Date timestamp;
  private String message;
  private String exceptionInfo;
}
