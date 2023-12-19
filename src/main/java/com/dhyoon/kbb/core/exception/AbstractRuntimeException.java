package com.dhyoon.kbb.core.exception;

import com.dhyoon.kbb.core.enumerate.ExceptionCodeEnum;
import lombok.Getter;

@Getter
public class AbstractRuntimeException extends RuntimeException {

    protected String message;
    protected String code;

    public void init(ExceptionCodeEnum responseEnum) {
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
    }

    public void init(ExceptionCodeEnum responseEnum, String message) {
        this.code = responseEnum.getCode();
        this.message = message;
    }

}
