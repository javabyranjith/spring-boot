package jbr.sboot.dao;

import org.springframework.data.repository.CrudRepository;

import jbr.sboot.model.Product;

public interface ProductRepository extends CrudRepository<Product, String> {

}
