package com.dhyoon.kbb.apps.engine.infrastructure;

import com.dhyoon.kbb.apps.engine.domain.SearchEngine;
import com.dhyoon.kbb.apps.engine.infrastructure.dto.NaverSearchCriteria;
import com.dhyoon.kbb.apps.engine.infrastructure.dto.NaverSearchResult;
import com.dhyoon.kbb.apps.engine.infrastructure.dto.SearchResultWrap;
import com.dhyoon.kbb.apps.engine.infrastructure.feign.NaverSearchFeignClient;
import com.dhyoon.kbb.apps.search.application.dto.SearchCriteria;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
@Order(1)
public class NaverEngineImpl extends AbstractEngine implements SearchEngine {

    @Value("${engine.naver.client-id}")
    private String clientId;
    @Value("${engine.naver.client-secret}")
    private String clientSecret;

    private final NaverSearchFeignClient naverSearchFeignClient;

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
//    }

    @Override
    public SearchResultWrap searchBlog(SearchCriteria criteria) {
        NaverSearchResult result = naverSearchFeignClient.searchBlog(clientId, clientSecret,
                NaverSearchCriteria.of(criteria));
        return SearchResultWrap.of(result);
    }
}
