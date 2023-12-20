package com.dhyoon.kbb.apps.search.application;

import com.dhyoon.kbb.apps.engine.infrastructure.dto.SearchResultWrap;
import com.dhyoon.kbb.apps.search.application.dto.SearchCriteria;
import com.dhyoon.kbb.apps.search.domain.SearchService;
import com.dhyoon.kbb.apps.search.presentation.dto.BestKeywordResultDto;
import com.dhyoon.kbb.apps.search.presentation.dto.SearchResultWrapDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SearchFacade {

    private final SearchService searchService;

    public SearchResultWrapDto searchBlog(SearchCriteria criteria) {
        searchService.increaseHit(criteria.getKeyword());
        SearchResultWrap result = searchService.searchBlog(criteria);
        return SearchResultWrapDto.of(result);
    }

    public List<BestKeywordResultDto> getBestKeywordList() {
        return searchService.getBestKeywordList().stream().map(BestKeywordResultDto::of).toList();
    }
}
