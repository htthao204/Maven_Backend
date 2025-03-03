package com.example.ResManage.exception;
public enum ErrorCode {
    SYSTEM_ERROR(9999, "Lỗi hệ thống, vui lòng thử lại sau"),
    TOPIC_NOT_FOUND(2001, "Không tìm thấy đề tài"),
    DATA_INTEGRITY_VIOLATION(2002, "Lỗi ràng buộc dữ liệu"),
    INVALID_ARGUMENT(2003, "Dữ liệu đầu vào không hợp lệ"),
    CONSTRAINT_VIOLATION(2004, "Vi phạm ràng buộc dữ liệu"),
    MISSING_REQUIRED_FIELD(2005, "Trường bắt buộc không được bỏ trống");

    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
