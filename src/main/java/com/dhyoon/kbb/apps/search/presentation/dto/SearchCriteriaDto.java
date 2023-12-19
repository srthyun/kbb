package com.dhyoon.kbb.apps.search.presentation.dto;

import com.dhyoon.kbb.core.enumerate.SortTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
public class SearchCriteriaDto {

    @Schema(description = "검색키워드", requiredMode = Schema.RequiredMode.REQUIRED)
    private String keyword;
    @Schema(description = "조회 페이지", requiredMode = Schema.RequiredMode.REQUIRED, defaultValue = "1")
    private int page;
    @Schema(description = "페이지 아이템 수", requiredMode = Schema.RequiredMode.REQUIRED, defaultValue = "30")
    private int size;
    @Schema(description = "정렬 조건(정확도, 최신순)"
            , requiredMode = Schema.RequiredMode.REQUIRED
            , defaultValue = "ACCURACY"
            , allowableValues = {"ACCURACY", "RECENCY"})
    private SortTypeEnum sort;
}
