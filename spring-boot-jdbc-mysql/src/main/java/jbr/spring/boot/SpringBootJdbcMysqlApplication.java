package jbr.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jbr.spring.boot.service.ProductService;

@SpringBootApplication
public class SpringBootJdbcMysqlApplication implements CommandLineRunner {
  private static final Logger log = LoggerFactory.getLogger(SpringBootJdbcMysqlApplication.class);
  
  @Autowired
  ProductService productService;

  public static void main(String[] args) {
    SpringApplication.run(SpringBootJdbcMysqlApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    productService.addProduct();
    productService.getAllProducts().forEach(e -> log.info(e.toString()));
  }
}
