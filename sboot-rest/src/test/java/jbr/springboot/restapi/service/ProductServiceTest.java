package jbr.springboot.restapi.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import jbr.springboot.restapi.model.Product;
import jbr.springboot.restapi.model.ProductApiResponse;
import jbr.springboot.restapi.model.ProductDto;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductServiceTest {
  private final String baseUrl = "http://localhost:6060/springboot-restapi/products";

  private RestTemplate restTemplate;

  @Before
  public void setUp() throws Exception {
    restTemplate = new RestTemplate();
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testGetAllProducts() throws URISyntaxException {
    URI uri = new URI(baseUrl + "/all");

    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

    Assert.assertEquals(200, result.getStatusCodeValue());
    Assert.assertTrue(result.getBody().contains("All products are retrieved successfully."));
  }

  @Test
  public void testGetAllProductsJson() throws URISyntaxException {
    URI uri = new URI(baseUrl + "/all");

    ProductApiResponse<Product> result = restTemplate.getForObject(uri, ProductApiResponse.class);

    Assert.assertTrue(result.getMessage().contains("All products are retrieved successfully."));
    List<Product> products = (List<Product>) result.getResult();
    Assert.assertEquals(13, products.size());
  }

  @Test
  public void testGetProductById() throws URISyntaxException {
    URI uri = new URI(baseUrl + "/100");
    ProductApiResponse<Product> result = restTemplate.getForObject(uri, ProductApiResponse.class);
    Product product = (Product) result.getResult();

    Assert.assertEquals("Product retrieved successfully.", result.getMessage());
    Assert.assertEquals(100, product.getId());
  }

  @Test
  public void testPostAddProduct() throws URISyntaxException {
    URI uri = new URI(baseUrl + "/add");

    ProductDto productDto = new ProductDto("100", "testPostAddProduct", "Jnit", "0");

    restTemplate.postForObject(uri, productDto, Product.class);

    URI uriAll = new URI(baseUrl + "/all");
    ResponseEntity<String> resultAll = restTemplate.getForEntity(uriAll, String.class);
    Assert.assertTrue(resultAll.getBody().contains("testPostAddProduct"));
  }

}
