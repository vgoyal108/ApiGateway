package com.example.ApiGateWay.feignCalls;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;


import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "token" ,url="http://localhost:8083",fallbackFactory = fallBack.class)
public interface FeignImpl {
    @RequestMapping(method = RequestMethod.GET,value = "/user-service/user/token")
    boolean isTokenValid(@RequestHeader("authorization") String authorizationHeader);
}
