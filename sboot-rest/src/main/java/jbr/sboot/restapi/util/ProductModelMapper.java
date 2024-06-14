package jbr.sboot.restapi.util;

import java.time.LocalDateTime;

import jbr.sboot.restapi.product.dao.entity.ProductEntity;
import jbr.sboot.restapi.product.dto.ProductDto;

public class ProductModelMapper {

	public static ProductEntity getProductEntity(ProductDto prodDto) {
		return new ProductEntity(null, prodDto.getName(), prodDto.getCategory(), prodDto.getPrice(),
				LocalDateTime.now(), LocalDateTime.now());
	}
}
