package jbr.sboot.restapi.product.model;

import jbr.sboot.restapi.common.BaseResponse;
import jbr.sboot.restapi.product.dao.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse implements BaseResponse {
	private static final long serialVersionUID = 8673971949028082193L;
	private ProductEntity product;
}
