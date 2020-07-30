package jbr.sboot.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jbr.sboot.rest.model.Product;
import jbr.sboot.rest.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping("/all")
  public ResponseEntity<List<Product>> getAllProducts() {
    return ResponseEntity.ok(productService.getAllProducts());
  }

  @GetMapping("/{id}")
  public Product getProductById(@PathVariable String id) {
    return productService.getProductById(id);
  }

  @PostMapping("/add")
  public void addProduct(@RequestBody Product product) {
    productService.addProduct(product);
  }

  @PutMapping("/update")
  public void updateProduct(@RequestBody Product product) {
    productService.updateProduct(product);
  }

  @DeleteMapping("/delete/{id}")
  public void deleteProduct(@PathVariable String id) {
    productService.delete(id);
  }
}
