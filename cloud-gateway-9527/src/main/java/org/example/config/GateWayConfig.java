package org.example.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangrq
 * @version V1.0
 * @Title: GateWayConfig
 * @Package org.example.config
 * @Description:
 * @date 2020-03-24 10:16
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("Path route example",r -> r.path("/guonei").uri("http://news.baidu.com")).build();
        return routes.build();
    }
}
