package jbr.spring.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jbr.spring.boot.dao.ProductDao;
import jbr.spring.boot.model.Product;

@Service
public class ProductService {

  @Autowired
  private ProductDao productDao;

  public void executeQuery(String query) {
    productDao.executeQuery(query);
  }

  public void addProduct() {
    productDao.addProduct();
  }

  public List<Product> getAllProducts() {
    return productDao.getAllProducts();
  }
}
