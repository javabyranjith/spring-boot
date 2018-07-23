package jbr.spring.boot;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {

  public List<Product> products() {

    return Arrays.asList(new Product("Samsung galaxy j7", "Mobile", 40000));
  }
}
