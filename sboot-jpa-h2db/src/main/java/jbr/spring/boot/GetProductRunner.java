package jbr.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;

import jbr.spring.boot.service.ProductService;
import lombok.extern.slf4j.Slf4j;

@Order(value = 2)
@SpringBootApplication
@Slf4j
public class GetProductRunner implements CommandLineRunner {

  @Autowired
  ProductService service;

  @Override
  public void run(String... args) throws Exception {
    log.info("inside GetProductRunner");
    service.getAllProducts();
  }

}
