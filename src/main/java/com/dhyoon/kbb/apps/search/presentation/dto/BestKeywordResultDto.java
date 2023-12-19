package com.dhyoon.kbb.apps.search.presentation.dto;

import com.dhyoon.kbb.apps.search.domain.dto.BestKeywordResult;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BestKeywordResultDto {

    @Schema(description = "검색키워드")
    private String keyword;
    @Schema(description = "검색 수")
    private long hitCount;

    public static BestKeywordResultDto of(BestKeywordResult bestKeywordResult) {
        return BestKeywordResultDto.builder()
                .keyword(bestKeywordResult.getKeyword())
                .hitCount(bestKeywordResult.getHitCount())
                .build();
    }
}
