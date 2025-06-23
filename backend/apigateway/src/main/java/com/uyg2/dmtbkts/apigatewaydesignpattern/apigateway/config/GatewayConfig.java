package com.uyg2.dmtbkt.apigatewaydesignpattern.apigateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
public class GatewayConfig {

    // IP adresine göre rate limiting uygular
    @Bean
    public KeyResolver userKeyResolver() {
        return exchange -> Mono.just(
            exchange.getRequest().getRemoteAddress().getAddress().getHostAddress()
        );
    }

    @Bean
    public RedisRateLimiter redisRateLimiter() {
        // replenishRate: saniyede yenilenen token sayısı
        // burstCapacity: en fazla token kapasitesi (patlama için)
        return new RedisRateLimiter(5, 10);
    }
}
