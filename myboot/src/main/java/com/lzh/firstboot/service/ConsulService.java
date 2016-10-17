package com.lzh.firstboot.service;

import com.orbitz.consul.*;
import com.orbitz.consul.model.health.ServiceHealth;
import org.springframework.stereotype.Service;


import java.net.URI;
import java.util.List;

/**
 * 作者： Jonathan
 * 创建时间： 2016/10/17 ${Time}.
 * ConsulService的描述：${DESCRIPTION}
 */

@Service
public class ConsulService {
    /**
     * 注册服务
     * 并对服务进行健康检查
     * servicename唯一
     * serviceId没发现有什么作用
     */
    public void registerService(String serviceName, String serviceId) {
        Consul consul = Consul.builder().build();//建立consul实例
        AgentClient agentClient = consul.agentClient();//建立AgentClient
        try {
            /**
             * 注意该注册接口
             * 需要提供一个健康检查的服务URL，以及每隔多长时间访问一下该服务
             */
            agentClient.register(8080, URI.create("http://127.0.0.1:8080/health").toURL(), 3, serviceName, serviceId, "dev");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
           * 发现可用的服务
           */
         public List<ServiceHealth> findHealthyService(String servicename){
                 Consul consul = Consul.builder().build();
                 HealthClient healthClient = consul.healthClient();//获取所有健康的服务
                 return healthClient.getHealthyServiceInstances(servicename).getResponse();//寻找passing状态的节点
             }

    /**
     * 发现服务
     */
    public void storeKV(String key, String value) {
        Consul consul = Consul.builder().build();
        KeyValueClient keyValueClient = consul.keyValueClient();

        keyValueClient.putValue(key, value);//存储KV
    }

    /**
     * 根据key获取Value
     */
    public String getKV(String key) {
        Consul consul = Consul.builder().build();
        KeyValueClient keyValueClient = consul.keyValueClient();
        return keyValueClient.getValueAsString(key).get();
    }

    /**
     * 找出一致性的节点（应该是同一个DC中的所有server节点）
     */
    public List<String> findRaftPeers() {
        StatusClient statusClient = Consul.builder().build().statusClient();
        return statusClient.getPeers();
    }

    /**
     * 获取leader
     */
    public String findRaftLeader() {
        StatusClient statusClient = Consul.builder().build().statusClient();
        return statusClient.getLeader();
    }
}
