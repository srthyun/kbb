package com.dhyoon.kbb.apps.engine.domain;

import com.dhyoon.kbb.apps.engine.infrastructure.dto.SearchResultWrap;
import com.dhyoon.kbb.apps.search.application.dto.SearchCriteria;

public interface SearchEngine {

    boolean isHealthy();

    void setHealth();

    SearchResultWrap searchBlog(SearchCriteria criteria);


}
