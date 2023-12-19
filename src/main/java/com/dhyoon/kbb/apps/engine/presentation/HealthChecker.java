package com.dhyoon.kbb.apps.engine.presentation;

import com.dhyoon.kbb.apps.engine.application.EngineFacade;
import com.dhyoon.kbb.apps.engine.domain.SearchEngine;
import com.dhyoon.kbb.apps.search.application.dto.SearchCriteria;
import com.dhyoon.kbb.core.enumerate.SortTypeEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class HealthChecker {

    private final EngineFacade engineFacade;

    @Scheduled(fixedRateString = "${engine.health-check-time}")
    public void healthCheck() {
        log.info("scheduled start");
        engineFacade.setEngineHealth();
        log.info("scheduled end");
    }
}
