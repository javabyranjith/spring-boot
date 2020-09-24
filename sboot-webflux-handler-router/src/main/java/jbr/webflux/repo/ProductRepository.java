package jbr.webflux.repo;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import jbr.webflux.model.Product;
import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
	@Query("{ 'name' : ?0 }")
	Flux<Product> findByName(final String name);
}
