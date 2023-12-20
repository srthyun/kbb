package com.dhyoon.kbb.apps.search.domain;

import com.dhyoon.kbb.apps.engine.domain.SearchEngine;
import com.dhyoon.kbb.apps.engine.infrastructure.dto.SearchResultWrap;
import com.dhyoon.kbb.apps.search.application.dto.SearchCriteria;
import com.dhyoon.kbb.apps.search.domain.dto.BestKeywordResult;
import com.dhyoon.kbb.apps.search.domain.entity.KeywordHitEntity;
import com.dhyoon.kbb.apps.search.domain.entity.SearchHistoryEntity;
import com.dhyoon.kbb.core.exception.EmptyUsableEngineException;
import com.dhyoon.kbb.core.exception.InvalidParameterException;
import com.dhyoon.kbb.core.exception.UnUsableEngineException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SearchServiceImpl implements SearchService {

    private final List<SearchEngine> searchEngineList;
    private final SearchReader searchReader;
    private final SearchStore searchStore;

    @Override
    @Transactional
    public SearchResultWrap searchBlog(SearchCriteria criteria) {
        searchStore.store(SearchHistoryEntity.builder()
                .keyword(criteria.getKeyword())
                .build());
        final List<SearchEngine> healtyEngineList = searchEngineList.stream()
                .filter(SearchEngine::isHealthy).toList();
        if (healtyEngineList.isEmpty()) {
            throw new EmptyUsableEngineException();
        }
        return searchBlog(healtyEngineList, 0, criteria);
    }

    private SearchResultWrap searchBlog(List<SearchEngine> engineList, int index, SearchCriteria criteria) {
        final SearchEngine engine = engineList.get(index);
        try {
            return engine.searchBlog(criteria);
        } catch (UnUsableEngineException e) {
            if (engineList.size() == index) {
                throw new EmptyUsableEngineException();
            }
            return searchBlog(engineList, index + 1, criteria);
        } catch (FeignException feignException) {
            if (feignException.status() == HttpStatus.BAD_REQUEST.value()) {
                throw new InvalidParameterException();
            } else {
                throw feignException;
            }
        }
    }

    @Override
    public List<BestKeywordResult> getBestKeywordList() {
        final List<KeywordHitEntity> list = searchReader.getBestKeywordList();
        return list.stream().map(BestKeywordResult::of).toList();
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Async
    public void increaseHit(String keyword) {
        searchStore.increaseHit(keyword);
    }
}
