package com.dhyoon.kbb.apps.engine.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class KakaoSearchResult {

    private KakaoMeta meta;
    private List<KakaoDocument> documents;

    private Integer code;
    private String msg;

}
