package jbr.spring.boot;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {

  public List<String> products() {
    return Arrays.asList("Mobile", "Laptop", "Tablet PC");
  }
}
