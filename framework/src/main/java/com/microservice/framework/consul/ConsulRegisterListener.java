package com.microservice.framework.consul;

import com.orbitz.consul.AgentClient;
import com.orbitz.consul.Consul;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.net.MalformedURLException;
import java.net.URI;

/**
 * 作者：Jonathan
 * 日期时间：2016/9/8 17:09
 **/
public class ConsulRegisterListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Consul consul = event.getApplicationContext().getBean(Consul.class);
        ConsulProperties prop = event.getApplicationContext().getBean(ConsulProperties.class);
        AgentClient agentClient = consul.agentClient();
        try {
            agentClient.register(prop.getServicePort(),
                    URI.create(prop.getHealthUrl()).toURL(),
                    prop.getHealthInterval(),
                    prop.getServiceName(),
                    prop.getServiceTag());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
