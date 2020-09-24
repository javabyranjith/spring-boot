package jbr.webflux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jbr.webflux.model.Product;
import jbr.webflux.repo.ProductRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;

	@Override
	public Mono<Product> addProduct(Product product) {
		return productRepo.save(product);
	}

	@Override
	public Flux<Product> addProducts(List<Product> products) {
		return productRepo.saveAll(products);
	}

	@Override
	public Mono<Product> findById(String id) {
		return productRepo.findById(id);
	}

	@Override
	public Flux<Product> findByName(String name) {
		return productRepo.findByName(name);
	}

	@Override
	public Flux<Product> findAll() {
		return productRepo.findAll();
	}

}
