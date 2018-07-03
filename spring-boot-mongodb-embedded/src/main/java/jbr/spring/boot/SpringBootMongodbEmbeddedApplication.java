package jbr.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jbr.spring.boot.dao.ProductRepository;
import jbr.spring.boot.model.Product;

@SpringBootApplication
public class SpringBootMongodbEmbeddedApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(SpringBootMongodbEmbeddedApplication.class);
	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongodbEmbeddedApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productRepository.save(new Product("100", "Samsung J8 Plus", "Phone", "20000"));
		productRepository.findAll().forEach(e -> log.info(e.toString()));
	}
}
