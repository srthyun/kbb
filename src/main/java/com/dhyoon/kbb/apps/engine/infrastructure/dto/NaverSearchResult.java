package com.dhyoon.kbb.apps.engine.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class NaverSearchResult {

    private String lastBuildDate;
    private int total;
    private int start;
    private int display;
    private List<NaverItem> items;

}
