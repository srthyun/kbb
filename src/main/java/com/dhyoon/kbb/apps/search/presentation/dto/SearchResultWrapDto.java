package com.dhyoon.kbb.apps.search.presentation.dto;

import com.dhyoon.kbb.apps.engine.infrastructure.dto.SearchResultWrap;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class SearchResultWrapDto {

    private List<SearchResultDto> documents;
    private int totalCount;
    private boolean hasNext;


    public static SearchResultWrapDto of(SearchResultWrap searchResult) {
        return SearchResultWrapDto.builder()
                .documents(searchResult.getDocuments().stream().map(SearchResultDto::of).toList())
                .totalCount(searchResult.getTotalCount())
                .hasNext(searchResult.isHasNext()).build();
    }

}
