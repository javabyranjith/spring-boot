package jbr.sboot.restapi.common;

import java.io.Serializable;
import lombok.Data;

@Data
public class RestApiResponse implements Serializable {

	private static final long serialVersionUID = -4660527318987875887L;

	private int code;

	private BaseResponse response;

	private String error;

	public RestApiResponse() {
		super();
	}

	public RestApiResponse(int code) {
		super();
		this.code = code;
	}

	public RestApiResponse(int code, BaseResponse response) {
		super();
		this.code = code;
		this.response = response;
	}

	public RestApiResponse(int code, BaseResponse response, String error) {
		super();
		this.code = code;
		this.response = response;
		this.error = error;
	}

	public RestApiResponse(int code, String error) {
		super();
		this.code = code;
		this.error = error;
	}

}
