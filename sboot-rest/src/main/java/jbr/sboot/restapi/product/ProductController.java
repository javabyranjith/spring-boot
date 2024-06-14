package jbr.sboot.restapi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jbr.sboot.restapi.common.RestApiResponse;
import jbr.sboot.restapi.product.dao.entity.ProductEntity;
import jbr.sboot.restapi.product.dto.ProductDto;
import jbr.sboot.restapi.product.model.ProductResponse;
import jbr.sboot.restapi.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;

/**
 * Product Controller
 * 
 * @author Ranjith Sekar
 * @since 2018, Jun 20
 */
@RestController
@CrossOrigin(origins = "*")
@Slf4j
@RequestMapping(value = "${spring.data.rest.base-path}/products/v1")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/add")
	public ResponseEntity<RestApiResponse> addProduct(@RequestBody ProductDto productDto) {
		ProductEntity product = null;

		try {
			product = productService.addProduct(productDto);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new ResponseEntity<RestApiResponse>(
					new RestApiResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<RestApiResponse>(
				new RestApiResponse(HttpStatus.OK.value(), new ProductResponse(product)), HttpStatus.OK);
	}

//	@GetMapping("/all")
//	public ResponseEntity<RestApiResponse> getAllProducts() {
//		List<ProductEntity> products;
//
//		try {
//			products = productService.getAllProducts();
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			return new ResponseEntity<>(new RestApiResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()),
//					HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//		return new ResponseEntity<>(new RestApiResponse(HttpStatus.OK.value(), new ProductsResponse(products)),
//				HttpStatus.OK);
//	}

//	@PutMapping("/update")
//	public ProductApiResponse<ProductDto> updateProduct(@RequestBody ProductDto productDto) {
//		return new ProductApiResponse<ProductDto>(HttpStatus.OK.value(), "Product updated successfully.",
//				productService.updateProduct(productDto));
//	}
//
//	@DeleteMapping("/delete/{id}")
//	public ProductApiResponse<Void> deleteProduct(@PathVariable Long id) {
//		productService.deleteProduct(Long.valueOf(id));
//		return new ProductApiResponse<Void>(HttpStatus.OK.value(), "Product deleted successfully.", null);
//	}
//
//	@GetMapping("/{id}")
//	public ProductApiResponse<ProductEntity> getProductById(@PathVariable Long id) {
//		return new ProductApiResponse<ProductEntity>(HttpStatus.OK.value(), "Product retrieved successfully.",
//				productService.getProductById(id));
//	}
//
}
