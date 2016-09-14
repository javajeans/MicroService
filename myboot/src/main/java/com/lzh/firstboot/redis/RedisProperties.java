package com.lzh.firstboot.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 作者： Jonathan
 * 创建时间： 2016/9/13 ${Time}.
 * RedisProperties的描述：${DESCRIPTION}
 */
@Component
@ConfigurationProperties(prefix = "redis.cache")
public class RedisProperties {

    private int expireSeconds;

    private String clusterNodes;

    private int commandTimeout;

    public int getExpireSeconds() {
        return expireSeconds;
    }

    public void setExpireSeconds(int expireSeconds) {
        this.expireSeconds = expireSeconds;
    }

    public String getClusterNodes() {
        return clusterNodes;
    }

    public void setClusterNodes(String clusterNodes) {
        this.clusterNodes = clusterNodes;
    }

    public int getCommandTimeout() {
        return commandTimeout;
    }

    public void setCommandTimeout(int commandTimeout) {
        this.commandTimeout = commandTimeout;
    }
}
