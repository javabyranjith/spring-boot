package jbr.sboot.restapi.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Product DTO.
 * 
 * @author Ranjith Sekar
 * @since 2018, Jun 20
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
  private Long id;
  private String name;
  private String category;
  private Integer price;
}
