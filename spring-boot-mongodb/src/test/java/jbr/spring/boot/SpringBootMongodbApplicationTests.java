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

import jbr.springboot.SpringBootMongodbApplication;
import jbr.springboot.model.Product;
import jbr.springboot.model.dto.ProductVO;
import jbr.springboot.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringBootMongodbApplication.class })
public class SpringBootMongodbApplicationTests {

  @Autowired
  ProductService productService;

  public void testAddProducts() {
    List<ProductVO> input = new ArrayList<>();
    input.add(new ProductVO("Fan", "Electrical", "1000"));
    input.add(new ProductVO("Mobile", "Electronics", "20000"));
    input.add(new ProductVO("Airconditioner", "Home Appliances", "35000"));

    List<Product> output = productService.addProducts(input);
    Assert.assertEquals(input.size(), output.size());
  }

  @Test
  public void testAddProduct() {
    Product product = productService.addProduct(new ProductVO("Samsonite Bag", "Bag", "1000"));
    Assert.assertEquals(1, product.getId());
  }

  public void testGetAllProducts() {
    List<Product> output = productService.getAllProducts();
    Assert.assertEquals(4, output.size());
  }

  public void testGetProductById() {
    Optional<Product> output = productService.getProductById("3000");
    Assert.assertEquals("35000", output.get().getPrice());
  }

}
