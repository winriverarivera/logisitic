package com.logistic.common;


public class ServiceException extends BaseException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceException() {
        super();
    }

    public ServiceException(String errorMessage) {
        super(ErrorCodeConstant.SERV_ERROR, errorMessage);
    }
    
    public ServiceException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
    
    public ServiceException(String errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public ServiceException(Throwable cause) {
        super(cause);
    }
}
