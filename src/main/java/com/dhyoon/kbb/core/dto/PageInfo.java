package com.dhyoon.kbb.core.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class PageInfo {

    @Schema(description = "조회 페이지")
    private int page;
    @Schema(description = "페이지당 아이템 수")
    private int size;
    @Schema(description = "총 아이템 수")
    private int totalCount;
    @Schema(description = "다음페이지 존재여부")
    private boolean hasNext;

}
