package com.dhyoon.kbb.core.exception;

import com.dhyoon.kbb.core.enumerate.ExceptionCodeEnum;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InvalidParameterException extends AbstractRuntimeException {

    public InvalidParameterException() {
        this.init(ExceptionCodeEnum.INVALID_PARAMETER);
    }

    public InvalidParameterException(String message) {
        this.init(ExceptionCodeEnum.INVALID_PARAMETER, message);
    }
}
