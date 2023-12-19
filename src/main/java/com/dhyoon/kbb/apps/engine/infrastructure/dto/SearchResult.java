package com.dhyoon.kbb.apps.engine.infrastructure.dto;

import com.dhyoon.kbb.core.utils.LocalDateUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class SearchResult {

    private String title;
    private String contents;
    private String url;
    private String blogName;
    private String thumbnail;
    private LocalDate postedAt;

    private String bloggerName;
    private String bloggerLink;


    public static SearchResult of(KakaoDocument kakaoDocument) {
        return SearchResult.builder()
                .title(kakaoDocument.getTitle())
                .contents(kakaoDocument.getContents())
                .url(kakaoDocument.getUrl())
                .blogName(kakaoDocument.getBlogname())
                .thumbnail(kakaoDocument.getThumbnail())
                .postedAt(LocalDateUtil.offsetToLocalDate(kakaoDocument.getDatetime()))
                .build();
    }

    public static SearchResult of(NaverItem naverItem) {
        return SearchResult.builder()
                .title(naverItem.getTitle())
                .contents(naverItem.getDescription())
                .url(naverItem.getLink())
                .postedAt(LocalDateUtil.toLocalDate(naverItem.getPostdate()))
                .bloggerName(naverItem.getBloggername())
                .bloggerLink(naverItem.getBloggerlink())
                .build();
    }

}
