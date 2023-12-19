package com.dhyoon.kbb.apps.engine.infrastructure;

import com.dhyoon.kbb.apps.engine.infrastructure.dto.SearchResultWrap;
import com.dhyoon.kbb.apps.search.application.dto.SearchCriteria;
import com.dhyoon.kbb.core.enumerate.SortTypeEnum;
import com.dhyoon.kbb.core.exception.UnUsableEngineException;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
public abstract class AbstractEngine {

    private boolean health = false;

    public boolean isHealthy() {
        return health;
    }

    public void setHealth() {
        try {
            this.searchBlog(SearchCriteria.builder()
                    .page(1)
                    .size(1)
                    .sort(SortTypeEnum.ACCURACY)
                    .keyword("카카오뱅크").build());
            healthy();
        } catch (UnUsableEngineException unusable) {
            unHealthy(unusable.getMessage());
        } catch (FeignException feign) {
            if (feign.status() == HttpStatus.BAD_REQUEST.value()) {
                healthy();
            } else {
                unHealthy(feign.getMessage());
            }
        }
    }

    public void healthy() {
        health = true;
        log.info("[{}] HEALTHY", this.getClass().getSimpleName());
    }

    public void unHealthy(String reason) {
        health = false;
        log.warn("[{}] UNHEALTHY ===> {}", this.getClass().getSimpleName(), reason);
    }

    abstract SearchResultWrap searchBlog(SearchCriteria criteria);

}
