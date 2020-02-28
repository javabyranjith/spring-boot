package jbr.swagger.service;

import java.util.List;
import java.util.Optional;

import jbr.swagger.exception.ProductExistsException;
import jbr.swagger.exception.ProductNotFoundException;
import jbr.swagger.model.Product;

public interface ProductService {

  Product addProduct(Product newProduct) throws ProductExistsException;

  List<Product> addProducts(List<Product> newProducts);

  List<Product> getAllProducts();

  Optional<Product> getProductById(String id) throws ProductNotFoundException;

  Product getProductByName(String name);

  Product updateProduct(String id, Product product) throws ProductNotFoundException;

  void deleteProduct(String id);
}
