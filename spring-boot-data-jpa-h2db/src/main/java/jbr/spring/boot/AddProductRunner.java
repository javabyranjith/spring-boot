package jbr.spring.boot;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;

import jbr.spring.boot.service.ProductService;

@Order(value = 1)
@SpringBootApplication
public class AddProductRunner implements CommandLineRunner {
  
  @Autowired
  ProductService productService;

  private static final Logger log = LoggerFactory.getLogger(AddProductRunner.class);

  @Override
  public void run(String... args) throws Exception {
    log.info("inside AddProductRunner");
    //productService.addProduct();
  }

}
