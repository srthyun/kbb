package com.dhyoon.kbb.core.exception;

import com.dhyoon.kbb.core.dto.ResponseModel;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class})
    public ResponseModel exceptionHandler(Exception exception, HttpServletRequest request) {
        this.print(exception, request);

        return new ResponseModel("-9999", exception.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({EmptyUsableEngineException.class})
    public ResponseModel engineExceptionHandler(EmptyUsableEngineException exception
            , HttpServletRequest request) {
        this.print(exception, request);

        return ResponseModel.error(exception);
    }

    public void print(Exception exception, HttpServletRequest request) {
        String exceptionName = exception.getClass().getSimpleName();
        String stackTrace = Arrays.stream(exception.getStackTrace())
                .limit(10L)
                .map(StackTraceElement::toString)
                .collect(Collectors.joining("\n"));
        log.error("[{}] =====> url : {}", exceptionName, request.getRequestURL());
        log.error("[{}] =====> message : {}", exceptionName, exception.getMessage());
        log.error("[{}] =====> trace : \n{}", exceptionName, stackTrace);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({InvalidParameterException.class})
    public ResponseModel invalidParameterException(InvalidParameterException exception
            , HttpServletRequest request) {
        this.print(exception, request);

        return ResponseModel.error(exception);
    }
}
