package jbr.springboot.restapi.service;

import java.util.List;

import jbr.springboot.restapi.model.Product;

/**
 * Product Service.
 * 
 * @author Ranjith Sekar
 * @since 2018, Jun 20
 */
public interface ProductService {
  List<Product> getAllProducts();

  Product getProductById(String id);

  void addProduct(Product product);

  void updateProduct(Product product, String id);

  void deleteProduct(String id);
}
