package jbr.spring.boot.dao;

import org.springframework.data.repository.CrudRepository;

import jbr.spring.boot.model.Product;

public interface ProductRepository extends CrudRepository<Product, String> {

}
