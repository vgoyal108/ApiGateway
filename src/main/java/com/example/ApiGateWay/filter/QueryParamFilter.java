package com.example.ApiGateWay.filter;

import com.example.ApiGateWay.feignCalls.FeignImpl;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class QueryParamFilter extends ZuulFilter {

    @Autowired
    FeignImpl feign;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context=RequestContext.getCurrentContext();
        String authorizedQueryParam=context.getRequest().getParameter("authorized");
        if (authorizedQueryParam == null || authorizedQueryParam.equals("false")) {
            context.setSendZuulResponse(true);
        } else if (authorizedQueryParam.equals("true")){
            String authorizationHeader = context.getRequest().getHeader("authorization");
            boolean isValidToken=feign.isTokenValid(authorizationHeader);
            System.out.println("Theeeeeeee      " +isValidToken);
            if (isValidToken) {
                context.setSendZuulResponse(true);
            }
            else {


                context.setSendZuulResponse(false);
                context.setResponseStatusCode(401);
                context.setResponseBody("token Expired Login in again");
            }

        }

        return null;

    }
    }


// context.setSendZuulResponse(false);
//         context.setResponseStatusCode(401);
//         context.setResponseBody("Unauthorized: 'authorized' query parameter is missing or not set to 'true'");