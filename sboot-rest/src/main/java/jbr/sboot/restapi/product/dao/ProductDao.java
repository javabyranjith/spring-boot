package jbr.sboot.restapi.product.dao;

import java.util.List;

import jbr.sboot.restapi.exception.DaoException;
import jbr.sboot.restapi.product.dao.entity.ProductEntity;
import jbr.sboot.restapi.product.dto.ProductDto;

public interface ProductDao {
    ProductEntity addProduct(ProductEntity product) throws DaoException;

    List<ProductEntity> getAllProducts() throws DaoException;;

    ProductEntity getProductById(Long id) throws DaoException;;

    ProductDto updateProduct(ProductDto productDto) throws DaoException;;

    void deleteProduct(Long id) throws DaoException;;
}
