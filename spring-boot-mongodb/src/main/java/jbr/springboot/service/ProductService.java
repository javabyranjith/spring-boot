package jbr.springboot.service;

import java.util.List;
import java.util.Optional;

import jbr.springboot.model.Product;
import jbr.springboot.model.dto.ProductVO;

public interface ProductService {

  Product addProduct(ProductVO product);

  List<Product> addProducts(List<ProductVO> products);

  Optional<Product> getProductById(String id);

  List<Product> getAllProducts();

  Product updateProduct(ProductVO product);

  void deleteProduct(ProductVO product);
  
  int lastProductId();
  
}
