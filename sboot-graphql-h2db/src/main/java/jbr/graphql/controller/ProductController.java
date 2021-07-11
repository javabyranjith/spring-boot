package jbr.graphql.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jbr.graphql.dao.ProductRepository;
import jbr.graphql.model.Product;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

  @Autowired
  private ProductRepository productRepository;

  @GetMapping("/greeting")
  public ResponseEntity<Object> greeting() {
    log.info("enter - greeting()");
    return new ResponseEntity<Object>("Hello", HttpStatus.OK);
  }

  @GetMapping("/all")
  public ResponseEntity<Object> getAllProducts() {
    List<Product> products = new ArrayList<>();
    productRepository.findAll()
        .forEach(e ->
          {
            Product prod = new Product();
            prod.setId(e.getId());
            prod.setName(e.getName());
            prod.setCategory(e.getCategory());
            prod.setPrice(e.getPrice());

            products.add(prod);
          });

    return new ResponseEntity<Object>(products, HttpStatus.OK);
  }
}
