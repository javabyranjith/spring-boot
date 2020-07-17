package jbr.swagger.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jbr.swagger.exception.ProductExistsException;
import jbr.swagger.exception.ProductNameNotFoundException;
import jbr.swagger.exception.ProductNotFoundException;
import jbr.swagger.model.Product;
import jbr.swagger.service.ProductServiceImpl;

@RestController
@Api(value = "Product API Doc", description = "Get Product APIs")
@CrossOrigin(origins = "http://localhost:4200")
@Validated
public class ProductController {

  @Autowired
  private ProductServiceImpl productService;

  @GetMapping("/")
  public String hello() {
    return "Hello. Welcome!!!";
  }

  @ApiOperation("Get all available products")
  @GetMapping("getAllProducts")
  public List<Product> getAllProducts() {
    return productService.getAllProducts();
  }

  @ApiOperation("Get a product by id")
  @ApiResponses(value = { @ApiResponse(code = 1000, message = "SUCCESS"), @ApiResponse(code = 2000, message = "FAIL") })
  @GetMapping("getProductById/{id}")
  public Optional<Product> getProductById(@Valid @PathVariable @Min(1) String id) {
    try {
      return productService.getProductById(id);
    } catch (ProductNotFoundException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    }
  }

  @ApiOperation("Get a product by name")
  @ApiResponses(value = { @ApiResponse(code = 1000, message = "SUCCESS"), @ApiResponse(code = 2000, message = "FAIL") })
  @GetMapping("getProductByName/{name}")
  public Product getProductByName(@PathVariable("name") String name) throws ProductNameNotFoundException {
    Product product = productService.getProductByName(name);

    if (null == product)
      throw new ProductNameNotFoundException("Product name: '" + name + "' Not found in the product repository");

    return product;
  }

  @ApiOperation("Add a product")
  @PostMapping("addProduct")
  public ResponseEntity<Void> addProduct(@Valid @RequestBody Product product, UriComponentsBuilder builder) {

    try {
      productService.addProduct(product);
      HttpHeaders headers = new HttpHeaders();
      headers.setLocation(builder.path("/addProduct").buildAndExpand(product.getId()).toUri());
      return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    } catch (ProductExistsException ex) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

  }

  @ApiOperation("Add multiple products")
  @PostMapping("addProducts")
  public List<Product> addProducts(@RequestBody Product[] products) {
    return productService.addProducts(Arrays.asList(products));
  }

  @ApiOperation("Update a product detail using id")
  @PutMapping("updateProduct/{id}")
  public void updateProduct(@RequestBody Product product, @PathVariable String id) {
    try {
      productService.updateProduct(id, product);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  @ApiOperation("Delete a product using id")
  @DeleteMapping("deleteProduct/{id}")
  public void deleteProduct(@PathVariable String id) {
    productService.deleteProduct(id);
  }

}
