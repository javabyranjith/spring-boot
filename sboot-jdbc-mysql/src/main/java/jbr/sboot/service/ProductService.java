package jbr.sboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jbr.sboot.dao.ProductDao;
import jbr.sboot.model.Product;

@Service
public class ProductService {

  @Autowired
  private ProductDao prodDao;

  public void addProduct() {
    prodDao.addProduct();
  }

  public List<Product> getAllProducts() {
    return prodDao.getAllProducts();
  }
}
