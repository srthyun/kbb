package com.dhyoon.kbb.core.exception;

import com.dhyoon.kbb.core.enumerate.ExceptionCodeEnum;

public class EmptyUsableEngineException extends AbstractRuntimeException {

    public EmptyUsableEngineException() {
        this.init(ExceptionCodeEnum.EMPTY_USABLE_ENGINE);
    }

    public EmptyUsableEngineException(String message) {
        this.init(ExceptionCodeEnum.EMPTY_USABLE_ENGINE, message);
    }
}
