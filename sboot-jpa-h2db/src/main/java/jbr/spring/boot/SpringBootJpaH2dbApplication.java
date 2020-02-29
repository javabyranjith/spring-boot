package jbr.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import jbr.spring.boot.service.ProductService;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringBootJpaH2dbApplication implements CommandLineRunner {

  @Autowired
  ProductService productService;

  public static void main(String[] args) {
    SpringApplication.run(SpringBootJpaH2dbApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    log.info("inside main run");
  }

  @Bean
  CommandLineRunner runMe(ProductService productService) {
    log.info("Inside runMe");
    return output -> {
      log.info("ADD PRODUCTS");
      //productService.addProduct();

      log.info("GET ALL PRODUCTS");
      productService.getAllProducts().forEach(e -> log.info(e.toString()));

      log.info("CUSTOM PRODUCTS");
      //productService.getCustomProd("sh").forEach(e -> log.info(e.toString()));
    };
  }
}
