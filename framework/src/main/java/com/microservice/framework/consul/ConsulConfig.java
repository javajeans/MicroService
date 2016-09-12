package com.microservice.framework.consul;

import com.orbitz.consul.Consul;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 作者：Jonathan
 * 日期时间：2016/9/8 17:45
 **/
@Configuration
public class ConsulConfig {
    @Bean
    public Consul consul() {
        return Consul.builder().build();
    }
}
