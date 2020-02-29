package jbr.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;

import jbr.spring.boot.service.ProductService;
import lombok.extern.slf4j.Slf4j;

@Order(value = 1)
@SpringBootApplication
@Slf4j
public class AddProductRunner implements CommandLineRunner {
  
  @Autowired
  ProductService productService;

  @Override
  public void run(String... args) throws Exception {
    log.info("inside AddProductRunner");
    //productService.addProduct();
  }

}
