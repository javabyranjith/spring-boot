package jbr.sboot.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jbr.sboot.rest.dao.ProductRepository;
import jbr.sboot.rest.model.Product;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public List<Product> getAllProducts() {
    List<Product> products = new ArrayList<>();
    productRepository.findAll().forEach(products::add);
    return products;
  }

  public Product getProductById(String id) {
    return productRepository.findById(id).get();
  }

  public void addProduct(Product product) {
    productRepository.save(product);
  }

  public void updateProduct(Product product) {
    productRepository.save(product);
  }

  public void delete(String id) {
    productRepository.deleteById(id);
  }
}
