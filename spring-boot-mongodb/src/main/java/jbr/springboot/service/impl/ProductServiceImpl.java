package jbr.springboot.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jbr.springboot.dao.ProductRepository;
import jbr.springboot.model.Product;
import jbr.springboot.model.dto.ProductVO;
import jbr.springboot.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  ProductRepository productRepository;

  @Override
  public Product addProduct(ProductVO product) {
    return productRepository
        .save(new Product(lastProductId() + 1, product.getName(), product.getType(), product.getPrice()));
  }

  @Override
  public List<Product> addProducts(List<ProductVO> products) {
    boolean flag = false;
    int productId = 0;
    if (!flag) productId = lastProductId() + 1;

    List<Product> newProducts = new ArrayList<>();
    for (ProductVO product : products) {
      flag = true;
      Product newProduct = new Product(productId, product.getName(), product.getType(), product.getPrice());
      newProducts.add(newProduct);
      productId = productId + 1;
    }

    return productRepository.saveAll(newProducts);
  }

  @Override
  public Optional<Product> getProductById(String id) {
    return productRepository.findById(id);
  }

  @Override
  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  @Override
  public Product updateProduct(ProductVO product) {
    return null;
  }

  @Override
  public void deleteProduct(ProductVO product) {

  }

  @Override
  public int lastProductId() {
    return productRepository.findAll().stream().map(e -> e.getId()).collect(Collectors.toList()).stream()
        .max(Comparator.comparing(Integer::valueOf)).get();
  }

}
