package jbr.spring.boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  @Autowired
  private ProductDao productDao;

  public List<Product> allProducts() {
    return productDao.products();
  }

  public boolean hasProducts(List<Product> prods) {
    return null != prods && !prods.isEmpty() ? true : false;
  }
}
