package com.logistic.common;

public class ProcedureException extends BaseException {

	public ProcedureException() {
        super();
    }

    public ProcedureException(String errorCode) {
        super(errorCode);
    }
    
    public ProcedureException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
    
    public ProcedureException(String errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    public ProcedureException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public ProcedureException(Throwable cause) {
        super(cause);
    }

}
