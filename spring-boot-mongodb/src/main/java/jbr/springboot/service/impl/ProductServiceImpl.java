package jbr.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jbr.springboot.dao.ProductRepository;
import jbr.springboot.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  ProductRepository productRepository;

  @Override
  public Product addProduct(Product product) {
    return productRepository.save(product);
  }

  @Override
  public List<Product> addProducts(List<Product> products) {
    return productRepository.saveAll(products);
  }

  @Override
  public Optional<Product> getProductById(String id) {
    return productRepository.findById(id);
  }

  @Override
  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

}
