package jbr.spring.boot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import jbr.springboot.model.Product;
import jbr.springboot.service.ProductService;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class SpringBootMongodbApplicationTests {

  @Autowired
  ProductService productService;

  @Test
  public void testAddProducts() {
    List<Product> input = new ArrayList<>();
    input.add(new Product("100", "Fan", "Electrical", "1000"));
    input.add(new Product("200", "Mobile", "Electronics", "20000"));
    input.add(new Product("300", "Airconditioner", "Home Appliances", "35000"));

    List<Product> output = productService.addProducts(input);
    Assert.assertEquals(input.size(), output.size());
  }

  @Test
  public void testAddProduct() {
    Product product = productService.addProduct(new Product("400", "Samsonite Bag", "Bag", "1000"));
    Assert.assertEquals("400", product.getId());
  }

  @Test
  public void testGetAllProducts() {
    List<Product> output = productService.getAllProducts();
    Assert.assertEquals(4, output.size());
  }

  @Test
  public void testGetProductById() {
    Optional<Product> output = productService.getProductById("3000");
    Assert.assertEquals("35000", output.get().getPrice());
  }

}
