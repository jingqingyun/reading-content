package com.jingqingyun.reading.web.servlet;

import com.jingqingyun.common.exception.BusinessException;
import com.jingqingyun.common.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ValidationException;
import java.util.Optional;

@SuppressWarnings({"rawtypes"})
@Slf4j
@RestControllerAdvice
public class ControllerExceptionAdvicer {

    @ExceptionHandler
    public Response catchMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        log.warn("Catch MissingServletRequestParameterException: {}", e.toString());
        return Response.error("参数错误，请检查");
    }

    @ExceptionHandler
    public Response catchMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        log.warn("Catch MethodArgumentTypeMismatchException: {}", e.toString());
        return Response.error("参数错误，请检查");
    }

    @ExceptionHandler
    public Response catchValidationException(ValidationException e) {
        log.warn("Catch ValidationException: {}", e.toString());
        return Response.error(e.getMessage());
    }

    @ExceptionHandler
    public Response catchBindException(BindException e) {
        log.warn("Catch BindException: {}", e.toString());
        String message = Optional.ofNullable(e.getBindingResult().getFieldError())
                .map(error -> error.getField() + error.getDefaultMessage())
                .orElse("参数错误，请检查");
        return Response.error(message);
    }

    @ExceptionHandler
    public Response catchMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.warn("Catch MethodArgumentNotValidException: {}", e.toString());
        String message = Optional.ofNullable(e.getBindingResult().getFieldError())
                .map(error -> error.getField() + error.getDefaultMessage())
                .orElse("参数错误，请检查");
        return Response.error(message);
    }

    @ExceptionHandler
    public Response catchHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.warn("Catch HttpRequestMethodNotSupportedException: {}", e.toString());
        return Response.error(e.getMethod() + "请求方式错误");
    }

    @ExceptionHandler
    public Response cacheDuplicateKeyException(DuplicateKeyException e) {
        log.error("Catch DuplicateKeyException: {}", e.toString(), e);
        return Response.error("请勿保存重复数据，请检查");
    }

    @ExceptionHandler
    public Response catchBusinessException(BusinessException e) {
        log.error("Catch BusinessException: {}", e.toString(), e);
        return Response.error(e.getMessage());
    }

    @ExceptionHandler
    public Response catchException(Exception e) {
        log.error("Catch exception: {}", e.toString(), e);
        return Response.error(e.getMessage());
    }

}
