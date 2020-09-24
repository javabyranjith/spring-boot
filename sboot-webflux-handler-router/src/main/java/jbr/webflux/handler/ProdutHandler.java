package jbr.webflux.handler;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import jbr.webflux.model.Product;
import jbr.webflux.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class ProdutHandler {

  @Autowired
  private ProductService productService;

  public Mono<ServerResponse> hello(ServerRequest request) {
    log.info("in hello........");

    return ServerResponse.ok()
        .contentType(MediaType.TEXT_PLAIN)
        .body(BodyInserters.fromValue("Hello!! Spring Reactive!"));
  }

  public Mono<ServerResponse> getAllProducts(ServerRequest request) {
    log.info("in getAllProducts....");

    return ServerResponse.ok()
        .contentType(MediaType.APPLICATION_STREAM_JSON)
        .body(productService.findAll(), Product.class);
  }

  public Flux<Product> getAllProductsFlux(ServerRequest request) {
    return productService.findAll()
        .delayElements(Duration.ofSeconds(10));
  }

  public Mono<ServerResponse> addProduct(ServerRequest request) {
    log.info("in handler.. addProduct.....");

    Mono<Product> productToSave = request.bodyToMono(Product.class);

    return productToSave.flatMap(product -> ServerResponse.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(productService.addProduct(product), Product.class));
  }
}
