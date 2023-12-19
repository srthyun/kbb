package com.dhyoon.kbb.apps.search.application.dto;

import com.dhyoon.kbb.apps.search.presentation.dto.SearchCriteriaDto;
import com.dhyoon.kbb.core.enumerate.SortTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchCriteria {

    private int page;
    private int size;
    private SortTypeEnum sort;
    private String keyword;

    public static SearchCriteria of(SearchCriteriaDto criteria) {
        return SearchCriteria.builder()
                .page(criteria.getPage())
                .size(criteria.getSize())
                .sort(criteria.getSort())
                .keyword(criteria.getKeyword())
                .build();
    }
}
