package jbr.webflux;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import jbr.webflux.model.Product;
import reactor.core.publisher.Flux;

public class ProductWebClient {

  private WebClient webClient = WebClient.create("http://localhost:6060");

  public String hello() {
    return webClient.get()
        .uri("/hello")
        .accept(MediaType.TEXT_PLAIN)
        .exchange()
        .flatMap(res -> res.bodyToMono(String.class))
        .block();
  }

  public Flux<Product> getAllProducts() {
    return webClient.get()
        .uri("/products/all")
        .accept(MediaType.APPLICATION_STREAM_JSON)
        .exchange()
        .map(e -> e.bodyToFlux(Product.class))
        .block();
  }
}
