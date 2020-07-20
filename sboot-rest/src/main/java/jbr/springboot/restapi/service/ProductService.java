package jbr.springboot.restapi.service;

import java.util.List;

import jbr.springboot.restapi.model.Product;
import jbr.springboot.restapi.model.ProductDto;

/**
 * Product Service.
 * 
 * @author Ranjith Sekar
 * @since 2018, Jun 20
 */
public interface ProductService {
  List<Product> getAllProducts();

  Product getProductById(String id);

  Product addProduct(ProductDto productDto);

  ProductDto updateProduct(ProductDto productDto);

  void deleteProduct(String id);
}
