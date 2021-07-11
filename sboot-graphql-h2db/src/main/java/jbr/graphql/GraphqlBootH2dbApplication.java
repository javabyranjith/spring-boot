package jbr.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jbr.graphql.dao.ProductRepository;
import jbr.graphql.model.Product;

@SpringBootApplication
public class GraphqlBootH2dbApplication implements CommandLineRunner {

  @Autowired
  private ProductRepository productRepository;

  public static void main(String[] args) {
    SpringApplication.run(GraphqlBootH2dbApplication.class, args);
  }
  
  @Override
  public void run(String... args) throws Exception {
    productRepository.save(new Product(100L, "Samsung S10", "Mobile", 90000L));
  }

}
