package jbr.springboot.service;

import java.util.List;
import java.util.Optional;

import jbr.springboot.model.Product;

public interface ProductService {

  Product addProduct(Product product);

	List<Product> addProducts(List<Product> products);

	Optional<Product> getProductById(String id);

	List<Product> getAllProducts();
}
