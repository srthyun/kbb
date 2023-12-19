package com.dhyoon.kbb.apps.search.presentation.dto;

import com.dhyoon.kbb.apps.engine.infrastructure.dto.SearchResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class SearchResultDto {

    private String title;
    private String contents;
    private String url;
    private String blogName;
    private String thumbnail;
    private LocalDate postedAt;

    private String bloggerName;
    private String bloggerLink;


    public static SearchResultDto of(SearchResult searchResult) {
        return SearchResultDto.builder()
                .title(searchResult.getTitle())
                .contents(searchResult.getContents())
                .url(searchResult.getUrl())
                .blogName(searchResult.getBlogName())
                .thumbnail(searchResult.getThumbnail())
                .postedAt(searchResult.getPostedAt())
                .bloggerName(searchResult.getBloggerName())
                .bloggerLink(searchResult.getBloggerLink())
                .build();
    }

}
