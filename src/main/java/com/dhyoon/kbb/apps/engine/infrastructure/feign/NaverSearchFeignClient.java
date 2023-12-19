package com.dhyoon.kbb.apps.engine.infrastructure.feign;

import com.dhyoon.kbb.apps.engine.infrastructure.dto.NaverSearchCriteria;
import com.dhyoon.kbb.apps.engine.infrastructure.dto.NaverSearchResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "NaverSearchFeign", url = "${engine.naver.url}", path = "/v1/search")
public interface NaverSearchFeignClient {

    @GetMapping("/blog.json")
    NaverSearchResult searchBlog(@RequestHeader("X-Naver-Client-Id") String clientId
            , @RequestHeader("X-Naver-Client-Secret") String clientSecret
            , @SpringQueryMap NaverSearchCriteria criteria);
}
