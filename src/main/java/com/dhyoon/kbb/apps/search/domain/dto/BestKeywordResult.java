package com.dhyoon.kbb.apps.search.domain.dto;

import com.dhyoon.kbb.apps.search.domain.entity.KeywordHitEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BestKeywordResult {

    private String keyword;
    private long hitCount;

    public static BestKeywordResult of(KeywordHitEntity searchKeyword) {
        return BestKeywordResult.builder()
                .keyword(searchKeyword.getKeyword())
                .hitCount(searchKeyword.getHitCount())
                .build();
    }
}
