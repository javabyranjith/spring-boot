package jbr.sboot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import jbr.sboot.model.Product;
import jbr.sboot.util.ProductUtil;

@Repository
public class ProductRepo {

  public List<Product> getProducts() {
    return ProductUtil.getProducts();
  }
}
