package com.loginExercise.exceptions;
import com.loginExercise.enums.ErrorType;


public class ServerException extends Exception {

    private ErrorType errorType;

    public ServerException(ErrorType errorType) {
        this.errorType = errorType;
    }

    public ServerException(ErrorType errorType, String message) {
        super(errorType.getErrorMessage()+" "+message);
        this.errorType = errorType;
    }

    public ServerException(Exception e, ErrorType errorType, String message) {
        super(errorType.getErrorMessage()+" "+e+" "+message);
        this.errorType = errorType;
    }
    public ServerException(Exception e, ErrorType errorType){
        super(e+" " +errorType.getErrorMessage());
        this.errorType=errorType;
    }

    public ErrorType getErrorType() {
        return errorType;
    }
}
