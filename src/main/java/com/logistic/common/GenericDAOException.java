package com.logistic.common;

public class GenericDAOException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8382303650698667443L;

	public GenericDAOException() {
        super();
    }

    public GenericDAOException(String errorCode) {
        super(errorCode);
    }
    
    public GenericDAOException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
    
    public GenericDAOException(String errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    public GenericDAOException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public GenericDAOException(Throwable cause) {
        super(cause);
    }

}

