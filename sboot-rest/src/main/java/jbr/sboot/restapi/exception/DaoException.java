package jbr.sboot.restapi.exception;

public class DaoException extends Exception {

	private static final long serialVersionUID = 3104974398900974517L;

	public DaoException() {
		super();
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(Throwable cause) {
		super(cause);
	}

	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}
}