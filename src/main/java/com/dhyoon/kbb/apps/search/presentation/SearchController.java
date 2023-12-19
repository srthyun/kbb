package com.dhyoon.kbb.apps.search.presentation;

import com.dhyoon.kbb.apps.search.application.SearchFacade;
import com.dhyoon.kbb.apps.search.application.dto.SearchCriteria;
import com.dhyoon.kbb.apps.search.presentation.dto.BestKeywordResultDto;
import com.dhyoon.kbb.apps.search.presentation.dto.SearchCriteriaDto;
import com.dhyoon.kbb.apps.search.presentation.dto.SearchResultDto;
import com.dhyoon.kbb.apps.search.presentation.dto.SearchResultWrapDto;
import com.dhyoon.kbb.core.dto.PageInfo;
import com.dhyoon.kbb.core.dto.ResponseModel;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {

    private final SearchFacade searchFacade;


    @Operation(summary = "베스트 키워드 목록")
    @GetMapping("/best-keyword")
    public ResponseModel<List<BestKeywordResultDto>> getBestKeyword() {
        List<BestKeywordResultDto> list = searchFacade.getBestKeywordList();
        return ResponseModel.ok(list);
    }

    @Operation(summary = "블로그 검색")
    @GetMapping("/blog")
    public ResponseModel<List<SearchResultDto>> getBlogList(@ParameterObject SearchCriteriaDto criteria) {
        SearchResultWrapDto result = searchFacade.searchBlog(SearchCriteria.of(criteria));
        return ResponseModel.ok(result.getDocuments()
                , PageInfo.builder()
                        .page(criteria.getPage())
                        .size(criteria.getSize())
                        .totalCount(result.getTotalCount())
                        .hasNext(result.isHasNext()).build());
    }
}
