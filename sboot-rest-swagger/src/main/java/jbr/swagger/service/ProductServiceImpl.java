package jbr.swagger.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jbr.swagger.exception.ProductExistsException;
import jbr.swagger.exception.ProductNotFoundException;
import jbr.swagger.model.Product;
import jbr.swagger.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

  @Autowired
  ProductRepository productRepository;

  @Override
  public Product addProduct(Product newProduct) throws ProductExistsException {
    log.info("addProduct: " + newProduct.getId());
    Optional<Product> product = productRepository.findById(newProduct.getId());

    if (product.isPresent()) {
      throw new ProductExistsException("Product already found!!");
    }

    return productRepository.save(newProduct);
  }

  @Override
  public List<Product> addProducts(List<Product> newProducts) {
    log.info("addProducts: " + newProducts.stream()
        .map(e -> e.getId())
        .collect(Collectors.joining(",")));

    return productRepository.saveAll(newProducts);
  }

  @Override
  public List<Product> getAllProducts() {
    log.info("getAllProducts");
    return productRepository.findAll();
  }

  @Override
  public Optional<Product> getProductById(String id) throws ProductNotFoundException {
    log.info("getProductById: " + id);
    Optional<Product> product = productRepository.findById(id);

    if (!product.isPresent()) {
      throw new ProductNotFoundException("Product not found in the repository!!");
    }
    return productRepository.findById(id);
  }

  @Override
  public Product updateProduct(String id, Product product) throws ProductNotFoundException {
    log.info("addProduct: " + product.getId());
    Optional<Product> prod = productRepository.findById(id);

    if (!prod.isPresent()) {
      throw new ProductNotFoundException("Product not found in the repository to update!!");
    }
    return productRepository.save(product);
  }

  @Override
  public void deleteProduct(String id) {
    log.info("deleteProduct: " + id);
    productRepository.deleteById(id);
  }

  @Override
  public Product getProductByName(String name) {
    return productRepository.findProductByName(name);
  }
}
