package com.dhyoon.kbb.apps.search.domain;

import com.dhyoon.kbb.apps.search.domain.entity.KeywordHitEntity;

import java.util.List;

public interface SearchReader {

    List<KeywordHitEntity> getBestKeywordList();
}
