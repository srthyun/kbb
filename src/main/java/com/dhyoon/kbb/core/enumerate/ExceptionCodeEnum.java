package com.dhyoon.kbb.core.enumerate;

import lombok.Getter;

@Getter
public enum ExceptionCodeEnum {

    UNUSABLE_ENGINE("-1000", "엔진사용이 불가능합니다."),
    EMPTY_USABLE_ENGINE("-1001", "사용가능한 엔진이 없습니다."),
    INVALID_PARAMETER("-1002", "요청 파라미터를 확인해주세요.");

    private final String code;
    private final String message;

    ExceptionCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
