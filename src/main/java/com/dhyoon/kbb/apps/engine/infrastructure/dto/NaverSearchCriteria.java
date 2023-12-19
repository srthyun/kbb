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
public class NaverSearchCriteria {

    private String query;
    private String sort;
    private int start;
    private int display;

    public static NaverSearchCriteria of(SearchCriteria criteria) {
        return NaverSearchCriteria.builder()
                .query(criteria.getKeyword())
                .sort(criteria.getSort().getNaver())
                .start(criteria.getPage())
                .display(criteria.getSize())
                .build();
    }
}
