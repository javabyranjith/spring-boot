package jbr.swagger.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice
public class CustomGlobalExceptionHandler {

  @ExceptionHandler(ProductNameNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ExceptionInfo productNameNotFound(ProductNameNotFoundException ex) {
    return new ExceptionInfo(new Date(),
        "In CustomGlobalExceptionHandler(@RestControllerAdvice) :product name not found", ex.getMessage());
  }
}
