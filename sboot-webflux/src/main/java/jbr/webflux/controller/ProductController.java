package jbr.webflux.controller;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jbr.webflux.model.Product;
import jbr.webflux.service.ProductService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping("/")
  public Mono<String> home() {
    return Mono.just("Welcome!! You are at Home Page!!!");
  }

  @GetMapping("/message")
  public Flux<String> message() {
    return Flux.fromStream(Stream.of("Apple", "Banana", "Orange"));
  }

  @GetMapping("/products/{name}")
  public Flux<Product> getProductsByName(@PathVariable String name) {
    return productService.findByName(name);
  }

  @GetMapping("/products/{id}")
  public Mono<Product> getProductsById(@PathVariable String id) {
    return productService.findById(id);
  }

  @GetMapping("/products/all")
  public Flux<Product> getAllProducts() {
    return productService.findAll()
        .delayElements(Duration.ofSeconds(5))
        .log();
  }

  @PostMapping("/products/add")
  public Mono<Product> addProduct(@RequestBody Product product) {
    return productService.addProduct(product);
  }

  @PostMapping("/products/add-multiple")
  public Flux<Product> addProducts(@RequestBody List<Product> products) {
    return productService.addProducts(products);
  }

  @GetMapping(value = "/products-flux/all", produces = MediaType.APPLICATION_JSON_VALUE)
  public Flux<Product> getAllProductsFlux() {
    return productService.findAll();
  }

}
