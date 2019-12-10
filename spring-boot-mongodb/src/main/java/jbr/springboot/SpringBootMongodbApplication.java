package jbr.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jbr.springboot.model.Product;
import jbr.springboot.service.ProductService;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringBootMongodbApplication implements CommandLineRunner {

  @Autowired
  private ProductService productService;

  public static void main(String[] args) {
    SpringApplication.run(SpringBootMongodbApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    productService.addProducts(products());
    productService.addProduct(new Product("400", "Samsonite Bag", "Bag", "1000"));
    productService.getAllProducts().forEach(e -> log.info(e.toString()));
    log.info(productService.getProductById("200").toString());
  }

  private List<Product> products() {
    List<Product> products = new ArrayList<>();
    products.add(new Product("100", "Fan", "Electrical", "1000"));
    products.add(new Product("200", "Mobile", "Electronics", "20000"));
    products.add(new Product("300", "Airconditioner", "Home Appliances", "35000"));

    return products;
  }
}
