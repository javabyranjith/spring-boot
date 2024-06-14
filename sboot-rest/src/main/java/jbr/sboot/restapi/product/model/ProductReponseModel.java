package jbr.sboot.restapi.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductReponseModel {
	private String name;
	private String category;
	private Integer price;
}
