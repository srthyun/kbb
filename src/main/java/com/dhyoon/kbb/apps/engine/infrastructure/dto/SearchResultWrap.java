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
public class SearchResultWrap {

    private List<SearchResult> documents;
    private int totalCount;
    private boolean hasNext;


    public static SearchResultWrap of(KakaoSearchResult kakaoSearchResult) {
        final KakaoMeta meta = kakaoSearchResult.getMeta();
        final List<KakaoDocument> documents = kakaoSearchResult.getDocuments();
        return SearchResultWrap.builder()
                .documents(documents.stream().map(SearchResult::of).toList())
                .totalCount(meta.getTotalCount())
                .hasNext(!meta.isEnd()).build();
    }

    public static SearchResultWrap of(NaverSearchResult naverSearchResult) {
        final List<NaverItem> items = naverSearchResult.getItems();
        final boolean hasNext =
                naverSearchResult.getTotal() > (naverSearchResult.getStart() * naverSearchResult.getDisplay());
        return SearchResultWrap.builder()
                .documents(items.stream().map(SearchResult::of).toList())
                .totalCount(naverSearchResult.getTotal())
                .hasNext(hasNext)
                .build();
    }

}
