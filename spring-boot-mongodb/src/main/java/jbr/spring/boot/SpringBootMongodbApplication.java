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
public class SpringBootMongodbApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(SpringBootMongodbApplication.class);

	@Autowired
	private ProductRepository prodRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongodbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		prodRepository.save(new Product("400", "Samsonite Bag", "Bag", "1000"));
		prodRepository.findAll().forEach(e -> log.info(e.toString()));
		log.info(prodRepository.findById("200").get().toString());
	}
}
