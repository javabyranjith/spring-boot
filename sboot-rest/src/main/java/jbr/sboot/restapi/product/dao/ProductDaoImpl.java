package jbr.sboot.restapi.product.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jbr.sboot.restapi.exception.DaoException;
import jbr.sboot.restapi.product.dao.entity.ProductEntity;
import jbr.sboot.restapi.product.dto.ProductDto;
import jbr.sboot.restapi.product.repo.ProductRepository;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private ProductRepository prodRepo;

    @Override
    public ProductEntity addProduct(ProductEntity product) throws DaoException {
        try {
            return prodRepo.save(product);
        } catch (Exception e) {
            log.error("Exception in addProduct" + e.getMessage());
            throw new DaoException(e.getMessage(), e);
        }
    }

    @Override
    public List<ProductEntity> getAllProducts() throws DaoException {
        return prodRepo.findAll();
    }

    @Override
    public ProductEntity getProductById(Long id) throws DaoException {
        return prodRepo.findById(id).get();
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) throws DaoException {
        return null;
    }

    @Override
    public void deleteProduct(Long id) throws DaoException {
    }

}
