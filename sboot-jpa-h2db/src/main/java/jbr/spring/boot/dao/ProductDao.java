package jbr.spring.boot.dao;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jbr.spring.boot.model.Product;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ProductDao {

  @Autowired
  ProductRepository productRepository;

  /*public void addProduct() {
    log.info("prod add start ");
    productRepository.saveAll(Arrays.asList(new Product("100", "Samsung S8", "Mobile", "75000"),
        new Product("200", "Usha Fan", "Fan", "6000"), new Product("300", "Dell Vostro", "Laptop", "79000"),
        new Product("400", "IFB Washer", "Washing Machine", "25000")));
  }*/

  public List<Product> getAllProducts() {
    log.info("get prod start ");
    return productRepository.findAll();
  }

  public List<Product> getCustomProd(String prodName) {
    log.info("get custom prod start ");
    return null;//productRepository.getCustomProd(prodName);
  }

}
