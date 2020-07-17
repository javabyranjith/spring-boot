package jbr.springboot.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductApiResponse<T> {
  private int status;
  private String message;
  private Object result;
}
