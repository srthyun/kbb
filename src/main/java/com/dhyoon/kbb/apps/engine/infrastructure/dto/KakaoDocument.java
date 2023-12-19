package com.dhyoon.kbb.apps.engine.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class KakaoDocument {

    private String title;
    private String contents;
    private String url;
    private String blogname;
    private String thumbnail;
    private String datetime;

}
