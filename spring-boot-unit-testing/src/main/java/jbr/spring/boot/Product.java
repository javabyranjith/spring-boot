package jbr.spring.boot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Product {
  private String name;
  private String category;
  private Integer price;
}
