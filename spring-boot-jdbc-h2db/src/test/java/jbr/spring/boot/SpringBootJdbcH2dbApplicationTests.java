package jbr.spring.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import jbr.spring.boot.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJdbcH2dbApplicationTests {

  @Autowired
  private ProductService productService;

  @Test
  public void createTable() {
    productService.executeQuery("DROP TABLE product IF EXISTS");
    productService
        .executeQuery("CREATE TABLE product (id VARCHAR(30), name VARCHAR(20), type VARCHAR(30), price VARCHAR(30))");
  }
}
