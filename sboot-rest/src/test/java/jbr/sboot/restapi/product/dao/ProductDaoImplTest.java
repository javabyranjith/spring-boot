package jbr.sboot.restapi.product.dao;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import jbr.sboot.restapi.product.dao.entity.ProductEntity;
import jbr.sboot.restapi.product.repo.ProductRepository;

@ExtendWith(MockitoExtension.class)
public class ProductDaoImplTest {

	@Mock
	private ProductRepository productRepo;

	@InjectMocks
	private ProductDaoImpl productDao;

	@Test
	final void testAddProduct() throws Exception {

		ProductEntity input = new ProductEntity(1L, "Dell Vostro", "Laptop", 12000, LocalDateTime.now(),
				LocalDateTime.now());

		when(productRepo.save(any(ProductEntity.class))).thenReturn(input);

		ProductEntity output = productDao.addProduct(input);

		Assertions.assertNotNull(output);
		Assertions.assertEquals(output.getPrice(), input.getPrice());

	}
}
