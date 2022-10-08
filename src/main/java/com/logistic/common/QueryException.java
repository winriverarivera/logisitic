package com.logistic.common;

public class QueryException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5874580979873394905L;

	public QueryException() {
        super();
    }

    public QueryException(String errorCode) {
        super(errorCode);
    }
    
    public QueryException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
    
    public QueryException(String errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    public QueryException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public QueryException(Throwable cause) {
        super(cause);
    }
    
}
