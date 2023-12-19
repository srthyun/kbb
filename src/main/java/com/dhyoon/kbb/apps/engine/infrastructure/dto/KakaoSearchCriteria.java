package com.dhyoon.kbb.apps.engine.infrastructure.dto;

import com.dhyoon.kbb.apps.search.application.dto.SearchCriteria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class KakaoSearchCriteria {

    private String query;
    private String sort;
    private int page;
    private int size;

    public static KakaoSearchCriteria of(SearchCriteria criteria) {
        return KakaoSearchCriteria.builder()
                .query(criteria.getKeyword())
                .sort(criteria.getSort().getKakao())
                .page(criteria.getPage())
                .size(criteria.getSize())
                .build();
    }
}
