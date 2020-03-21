package jbr.sboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jbr.sboot.service.ProductService;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringBootJdbcMysqlApplication implements CommandLineRunner {
  
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
