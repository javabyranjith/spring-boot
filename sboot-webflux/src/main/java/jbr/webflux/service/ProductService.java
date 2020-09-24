package jbr.webflux.service;

import java.util.List;

import jbr.webflux.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
	Mono<Product> addProduct(Product product);
	Flux<Product> addProducts(List<Product> products);
	Mono<Product> findById(String id);
	Flux<Product> findByName(String name);
	Flux<Product> findAll();
}
