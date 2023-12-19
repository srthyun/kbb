package com.dhyoon.kbb.apps.engine.domain;

import com.dhyoon.kbb.apps.engine.infrastructure.dto.KakaoSearchResult;
import com.dhyoon.kbb.apps.engine.infrastructure.dto.SearchResult;
import com.dhyoon.kbb.apps.engine.infrastructure.dto.SearchResultWrap;
import com.dhyoon.kbb.apps.search.application.dto.SearchCriteria;
import com.dhyoon.kbb.core.enumerate.SortTypeEnum;
import com.dhyoon.kbb.core.exception.UnUsableEngineException;
import com.dhyoon.kbb.core.utils.HttpUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import feign.FeignException;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

public interface SearchEngine {

    boolean isHealthy();

    default void setHealth() {
        try {
            this.searchBlog(SearchCriteria.builder()
                    .page(1)
                    .size(1)
                    .sort(SortTypeEnum.ACCURACY)
                    .keyword("카카오뱅크").build());
            healthy();
        } catch (UnUsableEngineException unusable) {
            unHealthy(unusable.getMessage());
        }

    }

    void healthy();

    void unHealthy(String reason);

    SearchResultWrap searchBlog(SearchCriteria criteria);


}
