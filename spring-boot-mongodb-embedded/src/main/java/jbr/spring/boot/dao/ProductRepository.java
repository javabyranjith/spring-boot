package jbr.spring.boot.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import jbr.spring.boot.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

}
