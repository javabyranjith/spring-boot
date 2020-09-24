package jbr.webflux.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import jbr.webflux.handler.ProdutHandler;

@Configuration
public class ProductRouter {

  @Bean
  public RouterFunction<ServerResponse> route(ProdutHandler handler) {
    return RouterFunctions.route(RequestPredicates.GET("/products/all")
        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::getAllProducts)
        .andRoute(RequestPredicates.POST("/products/add")
            .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::addProduct)
        .andRoute(RequestPredicates.GET("/hello")
            .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), handler::hello);
  }
}
