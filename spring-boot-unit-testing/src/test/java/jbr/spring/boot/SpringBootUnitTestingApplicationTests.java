package jbr.spring.boot;

import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootUnitTestingApplicationTests {

  @Autowired
  ProductService productService;

  @MockBean
  ProductDao productDao;

  @Test
  public void contextLoads() {
  }

  @Test
  public void testAll() {
    when(productService.allProducts()).thenReturn(Arrays.asList(new Product("Samsung galaxy j7", "Mobile", 40000)));
    Assert.assertTrue(productService.hasProducts(productService.allProducts()));
  }

}
