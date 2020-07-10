package jbr.sboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jbr.sboot.dao.ProductRepo;
import jbr.sboot.model.Product;

@Service
public class ProductService {

  @Autowired
  private ProductRepo productRepo;

  public List<Product> getProducts() {
    return productRepo.getProducts();
  }
}
