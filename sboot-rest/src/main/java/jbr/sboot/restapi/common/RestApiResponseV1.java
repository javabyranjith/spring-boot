package jbr.sboot.restapi.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestApiResponseV1<T> {
	private int status;
	private String message;
	private Object result;
}
