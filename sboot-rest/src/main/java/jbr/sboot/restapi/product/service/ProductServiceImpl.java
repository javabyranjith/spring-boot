package jbr.sboot.restapi.product.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jbr.sboot.restapi.exception.DaoException;
import jbr.sboot.restapi.exception.ServiceException;
import jbr.sboot.restapi.product.dao.ProductDao;
import jbr.sboot.restapi.product.dao.entity.ProductEntity;
import jbr.sboot.restapi.product.dto.ProductDto;
import jbr.sboot.restapi.util.ProductModelMapper;
import lombok.extern.slf4j.Slf4j;

@Transactional
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao prodDao;

    @Override
    public ProductEntity addProduct(ProductDto productDto) throws ServiceException {
        log.info("Adding product: " + productDto.toString());
        try {
            return prodDao.addProduct(ProductModelMapper.getProductEntity(productDto));
        } catch (Exception e) {
            log.error("Exception in addProduct" + e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<ProductEntity> getAllProducts() throws ServiceException {
        log.info("Retrieving all products.");
        List<ProductEntity> products;

        try {
            products = prodDao.getAllProducts();
        } catch (DaoException e) {
            log.error("Exception in getAllProducts" + e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }

        return products;
    }

    @Override
    public ProductEntity getProductById(Long id) throws ServiceException {
        log.info("Retrieving product with id: " + id);
        try {
            return prodDao.getProductById(id);
        } catch (DaoException e) {
            log.error("Exception in getProductById" + e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) throws ServiceException {
        log.info("Updating product: " + productDto.toString());
        ProductEntity product = getProductById(productDto.getId());

        if (null != product) {
            // BeanUtils.copyProperties(productDto, product);
            if (StringUtils.isNotEmpty(productDto.getName())) product.setName(productDto.getName());
            if (StringUtils.isNotEmpty(productDto.getCategory())) product.setCategory(productDto.getCategory());
            if (null != productDto.getPrice()) product.setPrice(productDto.getPrice());

            try {
                prodDao.addProduct(product);
            } catch (DaoException e) {
                log.error("Exception in updateProduct" + e.getMessage());
                throw new ServiceException(e.getMessage(), e);
            }
        }
        
        Map<String, String> map = new HashMap<>();
        map.put("Name", "Ranjith");
        map.put("Address","Chennai");        
        
        return productDto;
    }

    @Override
    public void deleteProduct(Long id) throws ServiceException {
        log.info("Deleting produt with id: " + id);
        try {
            prodDao.deleteProduct(id);
        } catch (DaoException e) {
            log.error("Exception in deleteProduct" + e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
    }

}
