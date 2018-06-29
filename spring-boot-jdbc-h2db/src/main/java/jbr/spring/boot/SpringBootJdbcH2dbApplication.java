package jbr.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jbr.spring.boot.service.ProductService;

@SpringBootApplication
public class SpringBootJdbcH2dbApplication implements CommandLineRunner {
  private static final Logger log = LoggerFactory.getLogger(SpringBootJdbcH2dbApplication.class);

  @Autowired
  ProductService productService;

  public static void main(String[] args) {
    SpringApplication.run(SpringBootJdbcH2dbApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    productService.addProduct();
    productService.getAllProducts().forEach(e -> log.info(e.toString()));
  }
}
