package jbr.sboot.restapi.service;

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

import com.fasterxml.jackson.databind.ObjectMapper;

import jbr.sboot.restapi.model.ProductApiResponse;
import jbr.sboot.restapi.model.ProductDto;
import jbr.sboot.restapi.model.ProductModel;
import jbr.sboot.restapi.product.ProductController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductController.class)
public class ProductServiceTest {
  private final String baseUrl = "http://localhost:6060/sboot-rest/api/product";

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
    Assert.assertTrue(result.getBody()
        .contains("All products are retrieved successfully."));
  }

  @Test
  public void testGetAllProductsJson() throws URISyntaxException {
    URI uri = new URI(baseUrl + "/all");

    ProductApiResponse<ProductModel> result = restTemplate.getForObject(uri, ProductApiResponse.class);

    Assert.assertTrue(result.getMessage()
        .contains("All products are retrieved successfully."));
    List<ProductModel> products = (List<ProductModel>) result.getResult();
    Assert.assertEquals(13, products.size());
  }

  @Test
  public void testGetProductById() throws URISyntaxException {
    ObjectMapper mapper = new ObjectMapper();
    URI uri = new URI(baseUrl + "/100");
    ProductApiResponse<ProductModel> response = restTemplate.getForObject(uri, ProductApiResponse.class);
    ProductModel product = mapper.convertValue(response.getResult(), ProductModel.class);
    Assert.assertEquals("Product retrieved successfully.", response.getMessage());
    Assert.assertEquals("100", product.getId());
  }

  @Test
  public void testPostAddProduct() throws URISyntaxException {
    URI uri = new URI(baseUrl + "/add");

    ProductDto productDto = new ProductDto(100L, "testPostAddProduct", "JUnit", 0);

    restTemplate.postForObject(uri, productDto, ProductModel.class);

    URI uriAll = new URI(baseUrl + "/all");
    ResponseEntity<String> resultAll = restTemplate.getForEntity(uriAll, String.class);
    Assert.assertTrue(resultAll.getBody()
        .contains("testPostAddProduct"));
  }

}
