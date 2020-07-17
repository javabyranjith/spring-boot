package jbr.springboot.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jbr.springboot.restapi.dao.ProductRepository;
import jbr.springboot.restapi.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Override
  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  @Override
  public Product getProductById(String id) {
    return productRepository.findById(id).get();
  }

  @Override
  public void addProduct(Product product) {

  }

  @Override
  public void updateProduct(Product product, String id) {

  }

  @Override
  public void deleteProduct(String id) {

  }

}
