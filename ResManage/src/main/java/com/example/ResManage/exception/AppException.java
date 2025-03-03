package com.example.ResManage.exception;

import lombok.Getter;

@Getter
public class AppException extends RuntimeException {
    private final ErrorCode errorCode;

    public AppException(ErrorCode errorCode) {
        super(errorCode.getMessage()); // Lấy message từ enum ErrorCode
        this.errorCode = errorCode;
    }
}
