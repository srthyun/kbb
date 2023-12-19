package com.dhyoon.kbb.core.exception;

import com.dhyoon.kbb.core.enumerate.ExceptionCodeEnum;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UnUsableEngineException extends AbstractRuntimeException {

    public UnUsableEngineException() {
        this.init(ExceptionCodeEnum.UNUSABLE_ENGINE);
    }

    public UnUsableEngineException(String message) {
        this.init(ExceptionCodeEnum.UNUSABLE_ENGINE, message);
    }
}
