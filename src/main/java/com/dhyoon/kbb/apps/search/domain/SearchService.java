package com.dhyoon.kbb.apps.search.domain;

import com.dhyoon.kbb.apps.engine.infrastructure.dto.SearchResultWrap;
import com.dhyoon.kbb.apps.search.application.dto.SearchCriteria;
import com.dhyoon.kbb.apps.search.domain.dto.BestKeywordResult;

import java.util.List;

public interface SearchService {

    SearchResultWrap searchBlog(SearchCriteria criteria);

    List<BestKeywordResult> getBestKeywordList();

    void increaseHit(String keyword);
}
