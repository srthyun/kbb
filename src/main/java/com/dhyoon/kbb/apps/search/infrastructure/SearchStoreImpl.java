package com.dhyoon.kbb.apps.search.infrastructure;

import com.dhyoon.kbb.apps.search.domain.SearchStore;
import com.dhyoon.kbb.apps.search.domain.entity.KeywordHitEntity;
import com.dhyoon.kbb.apps.search.domain.entity.SearchHistoryEntity;
import com.dhyoon.kbb.apps.search.infrastructure.repository.KeywordHitRepository;
import com.dhyoon.kbb.apps.search.infrastructure.repository.SearchHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SearchStoreImpl implements SearchStore {

    private final KeywordHitRepository keywordHitRepository;
    private final SearchHistoryRepository searchHistoryRepository;

    @Override
    public void store(SearchHistoryEntity searchHistoryEntity) {
        searchHistoryRepository.save(searchHistoryEntity);
    }

    public void store(KeywordHitEntity keywordHitEntity) {
        keywordHitRepository.save(keywordHitEntity);
    }

    public void increaseHit(String keyword) {
        Optional<KeywordHitEntity> opt = keywordHitRepository.findByKeyword(keyword);
        if (opt.isPresent()) {
            opt.get().increaseHit();
        } else {
            store(KeywordHitEntity.of(keyword));
        }
    }
}
