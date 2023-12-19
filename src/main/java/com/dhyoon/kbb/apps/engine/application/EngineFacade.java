package com.dhyoon.kbb.apps.engine.application;

import com.dhyoon.kbb.apps.engine.domain.EngineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EngineFacade {

    private final EngineService engineService;

    public void setEngineHealth() {
        engineService.setEngineHealth();
    }
}
