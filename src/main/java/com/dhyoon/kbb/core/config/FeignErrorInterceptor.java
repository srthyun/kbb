package com.dhyoon.kbb.core.config;

import com.dhyoon.kbb.core.exception.UnUsableEngineException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class FeignErrorInterceptor implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        log.warn("feign exception :: {}", response.status());
        if (response.status() / 100 == 5) {
            throw new UnUsableEngineException(response.status() + " : " + response.reason());
        }
        if (response.status() == 401) {
            throw new UnUsableEngineException(response.status() + " : " + response.reason());
        }
        if (response.status() == 403) {
            throw new UnUsableEngineException(response.status() + " : " + response.reason());
        }
        if (response.status() == 429) {
            throw new UnUsableEngineException(response.status() + " : " + response.reason());
        }
        return new Default().decode(methodKey, response);
    }

}
