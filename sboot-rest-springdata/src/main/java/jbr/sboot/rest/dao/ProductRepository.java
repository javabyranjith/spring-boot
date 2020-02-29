package jbr.sboot.rest.dao;

import org.springframework.data.repository.CrudRepository;

import jbr.sboot.rest.model.Product;

public interface ProductRepository extends CrudRepository<Product, String> {

}
