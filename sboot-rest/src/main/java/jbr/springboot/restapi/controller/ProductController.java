package jbr.springboot.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jbr.springboot.restapi.model.Product;
import jbr.springboot.restapi.model.ProductApiResponse;
import jbr.springboot.restapi.service.ProductService;

/**
 * Product Controller
 * 
 * @author Ranjith Sekar
 * @since 2018, Jun 20
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/product")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping("/all")
  public ProductApiResponse<List<Product>> getAllProducts() {
    return new ProductApiResponse<>(HttpStatus.OK.value(), "All products are retrieved successfully.",
        productService.getAllProducts());
  }

  @GetMapping("/{id}")
  public ProductApiResponse<Product> getProductById(@PathVariable String id) {
    return new ProductApiResponse<Product>(HttpStatus.OK.value(), "Product retrieved successfully.",
        productService.getProductById(id));
  }

  @PostMapping("/add")
  public void addProduct(@RequestBody Product product) {
    productService.addProduct(product);
  }

  @PutMapping(value = "/update/{id}")
  public void updateProduct(@RequestBody Product product, @PathVariable String id) {
    productService.updateProduct(product, id);
  }

  @DeleteMapping("/delete/{id}")
  public void deleteProduct(@PathVariable String id) {
    productService.deleteProduct(id);
  }
}
