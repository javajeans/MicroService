package com.microservice.archaius;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Optional;
import com.netflix.config.PollResult;
import com.netflix.config.PolledConfigurationSource;
import com.orbitz.consul.Consul;
import com.orbitz.consul.KeyValueClient;

/**
 * 指定archaius读取配置的源头
 */
public class ConsulConfigurationSource implements PolledConfigurationSource {

    private String keyName;

    public ConsulConfigurationSource(String keyName) {
        this.keyName = keyName;
    }

    /**
     * 默认情况下，每隔60s，该方法会执行一次
     */
    @Override
    public PollResult poll(boolean initial, Object checkPoint) throws Exception {
        Consul consul = Consul.builder().build();
        KeyValueClient kvClient = consul.keyValueClient();
        Optional<String> kvOpt = kvClient.getValueAsString(keyName);
        String kvStr = StringUtils.EMPTY;
        if (kvOpt.isPresent()) {
            kvStr = kvOpt.get();
        }

        Properties props = new Properties();
        props.load(new StringReader(kvStr));//String->Properties

        Map<String, Object> propMap = new HashMap<String,Object>();
        for (Object key : props.keySet()) {
            propMap.put((String) key, props.get(key));
        }
        return PollResult.createFull(propMap);
    }

}