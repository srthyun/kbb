package com.dhyoon.kbb.core.enumerate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SortTypeEnum {

    ACCURACY("accuracy", "sim"),
    RECENCY("recency", "date");

    private final String kakao;
    private final String naver;

}
