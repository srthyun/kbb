package com.dhyoon.kbb.apps.engine.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EngineServiceImpl implements EngineService {

    private final List<SearchEngine> searchEngine;

    public void setEngineHealth() {
        searchEngine.forEach(SearchEngine::setHealth);
    }

}
