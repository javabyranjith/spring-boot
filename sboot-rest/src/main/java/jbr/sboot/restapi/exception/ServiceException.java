package jbr.sboot.restapi.exception;

public class ServiceException extends Exception {

	private static final long serialVersionUID = -7045716807999606647L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
