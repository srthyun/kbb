package com.dhyoon.kbb.apps.engine.infrastructure.feign;

import com.dhyoon.kbb.apps.engine.infrastructure.dto.KakaoSearchCriteria;
import com.dhyoon.kbb.apps.engine.infrastructure.dto.KakaoSearchResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "KakaoSearchFeign", url = "${engine.kakao.url}", path = "/v2/search")
public interface KakaoSearchFeignClient {

    @GetMapping("/blog")
    KakaoSearchResult searchBlog(@RequestHeader("Authorization") String authorization
            , @SpringQueryMap KakaoSearchCriteria criteria);
}
