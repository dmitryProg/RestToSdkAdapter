package com.sber.restsdkadapter.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerResolver extends ResponseEntityExceptionHandler {

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ExceptionData unknownExceptionHandler(Exception exception) {
        log.error(exception.getMessage(), exception.getCause());
        return new ExceptionData("Exception", "Unknown error");
    }

    @Data
    @AllArgsConstructor
    private class ExceptionData {
        String exceptionType;
        String exceptionMessage;
    }

}