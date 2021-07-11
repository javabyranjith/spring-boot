package jbr.graphql.dao;

import org.springframework.data.repository.CrudRepository;

import jbr.graphql.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
