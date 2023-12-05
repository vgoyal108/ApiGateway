package com.example.ApiGateWay.feignCalls;

import com.example.ApiGateWay.feignCalls.FeignImpl;
import feign.hystrix.FallbackFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class fallBack implements FallbackFactory<FeignImpl> {

    @Override
    public FeignImpl create(Throwable cause) {
        return new FeignImpl() {
            @Override
            public boolean isTokenValid(String authorizationHeader) {
                return false;
            }
        };
    }
}
