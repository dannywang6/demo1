package com.exercise.exception;

import com.exercise.common.ApiResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 业务运行时异常
    @ExceptionHandler(RuntimeException.class)
    public ApiResponse<?> handleRuntimeException(RuntimeException e) {
        return ApiResponse.error(500, e.getMessage());
    }

    // @Valid 参数校验异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse<?> handleValidationException(MethodArgumentNotValidException e) {
        String message = e.getBindingResult()
                .getFieldError()
                .getDefaultMessage();

        return ApiResponse.error(400, message);
    }

    // HTTP 请求方法错误，例如 GET 调 POST 接口
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ApiResponse<?> handleMethodNotSupportedException(
            HttpRequestMethodNotSupportedException e) {

        return ApiResponse.error(405, "请求方法不允许");
    }

    // 最终兜底
    @ExceptionHandler(Exception.class)
    public ApiResponse<?> handleException(Exception e) {
        return ApiResponse.error(500, "服务器内部错误");
    }
}