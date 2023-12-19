package com.dhyoon.kbb.apps.search.domain;

import com.dhyoon.kbb.apps.search.domain.entity.KeywordHitEntity;
import com.dhyoon.kbb.apps.search.domain.entity.SearchHistoryEntity;

public interface SearchStore {

    void store(SearchHistoryEntity searchHistoryEntity);

    void store(KeywordHitEntity keywordHitEntity);

    void increaseHit(String keyword);
}
