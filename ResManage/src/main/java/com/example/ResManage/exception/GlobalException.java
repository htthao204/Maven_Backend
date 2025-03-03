package com.example.ResManage.exception;

import com.example.ResManage.domain.dto.request.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIResponse<List<String>>> handleValidationException(MethodArgumentNotValidException exception) {
        List<String> errorCodes = exception.getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> ((FieldError) error).getDefaultMessage()) // Chỉ lấy mã lỗi
                .collect(Collectors.toList());

        APIResponse<List<String>> apiResponse = new APIResponse<>(HttpStatus.BAD_REQUEST.value(), "VALIDATION_ERROR", errorCodes);
        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponse<String>> handleGeneralException(Exception exception) {
        APIResponse<String> apiResponse = new APIResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "SYSTEM_ERROR", exception.getMessage());
        return ResponseEntity.internalServerError().body(apiResponse);
    }
}
