package com.microservice.framework.consul;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 作者：Jonathan
 * 日期时间：2016/9/8 17:12
 **/
@Component
@Getter @Setter
public class ConsulProperties {

    @Value("${service.name}")//服务名称
    private String serviceName;
    @Value("${service.port:8080}")//检查端口
    private int servicePort;
    @Value("${service.tag:dev}")
    private String serviceTag;
    @Value("${health.url}")
    private String healthUrl;//检查url
    @Value("${health.interval:10}")
    private int healthInterval;//时间间隔
}
