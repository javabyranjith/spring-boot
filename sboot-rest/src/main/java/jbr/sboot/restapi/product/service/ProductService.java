package jbr.sboot.restapi.product.service;

import java.util.List;

import jbr.sboot.restapi.exception.ServiceException;
import jbr.sboot.restapi.product.dao.entity.ProductEntity;
import jbr.sboot.restapi.product.dto.ProductDto;

/**
 * Product Service.
 * 
 * @author Ranjith Sekar
 * @since 2018, Jun 20
 */
public interface ProductService {
    ProductEntity addProduct(ProductDto productDto) throws ServiceException;

    List<ProductEntity> getAllProducts() throws ServiceException;;

    ProductEntity getProductById(Long id) throws ServiceException;;

    ProductDto updateProduct(ProductDto productDto) throws ServiceException;;

    void deleteProduct(Long id) throws ServiceException;;
}
