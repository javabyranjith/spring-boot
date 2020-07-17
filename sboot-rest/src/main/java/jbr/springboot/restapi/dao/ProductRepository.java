package jbr.springboot.restapi.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jbr.springboot.restapi.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

  Product findProductByName(String name);
}
