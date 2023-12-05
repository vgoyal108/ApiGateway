package com.example.ApiGateWay.Config;
import com.example.ApiGateWay.filter.QueryParamFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ZuulConfig {
    @Bean
    public QueryParamFilter queryParamFilter() {
        return new QueryParamFilter();
    }
}
