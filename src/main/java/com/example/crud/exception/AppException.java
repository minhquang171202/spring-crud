package com.example.crud.exception;

public class AppException extends RuntimeException {//exeption ton tai user

    public AppException(ErrorCode errorCode) {
        super(errorCode.getMessage()); // goi contructor lop cha
        this.errorCode = errorCode;
    }

    private ErrorCode errorCode;

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
