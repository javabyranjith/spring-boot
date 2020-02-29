package jbr.springboot.restapi.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import jbr.springboot.restapi.model.Product;

/**
 * Product Service.
 * 
 * @author Ranjith Sekar
 * @since 2018, Jun 20
 */
@Service
public class ProductService {

  List<Product> products = Stream.of(new Product("100", "Galaxy S8", "Mobile", "50000"),
      new Product("200", "Honda Shine", "Vehicle", "60000"), new Product("300", "Dell Vostro", "Laptop", "75000"))
      .collect(Collectors.toList());

  public List<Product> getAllProducts() {
    return products;
  }

  public Product getProductById(String id) {
    return products.stream().filter(e -> e.getId().equals(id)).findFirst().get();
  }

  public void addProduct(Product product) {
    products.add(product);
  }

  public void updateProduct(Product product, String id) {
    System.out.println(product.toString());
    for (int i = 0; i < products.size(); i++) {
      Product currentProduct = products.get(i);

      if (currentProduct.getId().equals(id)) {
        products.set(i, product);
        return;
      }
    }
  }

  public void delete(String id) {
    products.remove(getProductById(id));
  }
}
