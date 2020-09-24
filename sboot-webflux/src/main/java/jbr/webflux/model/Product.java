package jbr.webflux.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document(value = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
	@Id
	private String id;
	private String name;
	private String category;
	private int price;
}
