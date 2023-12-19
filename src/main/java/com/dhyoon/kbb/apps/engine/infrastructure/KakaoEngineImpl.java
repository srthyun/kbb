package com.dhyoon.kbb.apps.engine.infrastructure;

import com.dhyoon.kbb.apps.engine.domain.SearchEngine;
import com.dhyoon.kbb.apps.engine.infrastructure.dto.KakaoSearchCriteria;
import com.dhyoon.kbb.apps.engine.infrastructure.dto.KakaoSearchResult;
import com.dhyoon.kbb.apps.engine.infrastructure.dto.SearchResultWrap;
import com.dhyoon.kbb.apps.engine.infrastructure.feign.KakaoSearchFeignClient;
import com.dhyoon.kbb.apps.search.application.dto.SearchCriteria;
import com.dhyoon.kbb.core.enumerate.SortTypeEnum;
import com.dhyoon.kbb.core.exception.UnUsableEngineException;
import com.dhyoon.kbb.core.utils.HttpUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class KakaoEngineImpl extends AbstractEngine implements SearchEngine {

    @Value("${engine.kakao.access-key}")
    private String accessKey;

    private final KakaoSearchFeignClient kakaoSearchFeignClient;


//    @Override
//    public void setHealth() {
//        try {
//            super.setHealth();
//        } catch (FeignException feign) {
//            if (feign.status() == HttpStatus.BAD_REQUEST.value()) {
//                healthy();
//            } else {
//                unHealthy(feign.getMessage());
//            }
//        }
//
//    }


    @Override
    public SearchResultWrap searchBlog(SearchCriteria criteria) {
        final String key = "KakaoAK " + accessKey;
        KakaoSearchResult result = kakaoSearchFeignClient.searchBlog(key, KakaoSearchCriteria.of(criteria));
        return SearchResultWrap.of(result);
    }
}
