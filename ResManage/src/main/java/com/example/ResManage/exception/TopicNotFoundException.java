package com.example.ResManage.exception;

public class TopicNotFoundException extends RuntimeException {
    private final ErrorCode errorCode;

    public TopicNotFoundException(String message) {
        super(message);
        this.errorCode = ErrorCode.TOPIC_NOT_FOUND;
    }

    public TopicNotFoundException() {
        super(ErrorCode.TOPIC_NOT_FOUND.getMessage());
        this.errorCode = ErrorCode.TOPIC_NOT_FOUND;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}