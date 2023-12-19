package com.dhyoon.kbb.apps.search.infrastructure;

import com.dhyoon.kbb.apps.search.domain.SearchReader;
import com.dhyoon.kbb.apps.search.domain.entity.KeywordHitEntity;
import com.dhyoon.kbb.apps.search.infrastructure.repository.KeywordHitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SearchReaderImpl implements SearchReader {

    private final KeywordHitRepository keywordHitRepository;

    @Override
    public List<KeywordHitEntity> getBestKeywordList() {
        return keywordHitRepository.findTop10ByOrderByHitCountDesc();
    }
}
