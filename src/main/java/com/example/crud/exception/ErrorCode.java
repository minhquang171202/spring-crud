package com.example.crud.exception;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(999, "chua phan loai ngoai le "),
    INVALID_KEY(1001, "Key khong hop le "),
    USER_EXISTED(1002, "User has been exited"),
    USERNAME_INVALID(1003, "Username is invalid"),
    PASSWORD_INVALID(1004, "Password is invalid"),
    USER_NOT_EXISTED(1005, "User not exited"),
    UNAUTHENTICATED(1006, "Unauthenticated"),
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}