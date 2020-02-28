package jbr.swagger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jbr.swagger.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

  Product findProductByName(String name);
}
