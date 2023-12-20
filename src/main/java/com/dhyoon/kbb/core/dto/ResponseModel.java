package com.dhyoon.kbb.core.dto;

import com.dhyoon.kbb.core.exception.AbstractRuntimeException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ResponseModel<T> {

    private String code;
    private String message;
    private T data;
    private PageInfo page;

    public ResponseModel(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> ResponseModel<T> ok(T data) {
        return new ResponseModel<>("", "", data, null);
    }

    public static <T> ResponseModel<T> ok(T data, PageInfo page) {
        return new ResponseModel<>("", "", data, page);
    }

    public static <T> ResponseModel<T> error(AbstractRuntimeException exception) {
        return new ResponseModel<>(exception.getCode(), exception.getMessage());
    }
}
