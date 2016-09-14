package com.lzh.firstboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * 作者： Jonathan
 * 创建时间： 2016/9/13 ${Time}.
 * JedisClusterConfig的描述：${DESCRIPTION}
 * 说明：

 该类注入了RedisProperties类，可以直接读取其属性
 这里没有对jedis链接池提供更多的配置（jedis-2.5.x好像不支持，jedis-2.6.x支持），具体的配置属性可以查看文章开头第一篇博客
 注意：

 该类使用了Java注解，@Configuration与@Bean，
 在方法上使用@Bean注解可以让方法的返回值为单例，
 该方法的返回值可以直接注入到其他类中去使用
 @Bean注解是方法级别的
 如果使用的是常用的spring注解@Component，
 在方法上没有注解的话，方法的返回值就会是一个多例，
 该方法的返回值不可以直接注入到其他类去使用
 该方式的注解是类级别的

 */
@Configuration
public class JedisClusterConfig {

    @Autowired
    private RedisProperties redisProperties;

    /**
     * 这里返回的JedisCluster是单例的，并且可以直接注入到其他类中去使用
     * @return
     */
    @Bean
    public JedisCluster getJedisCluster(){
        String[] serverArray = redisProperties.getClusterNodes().split(",");//获取服务器数组（这里要相信自己的输入，所以没有考虑空指针问题）

        Set<HostAndPort> nodes= new HashSet<HostAndPort>();

        for(String ipPort:serverArray){

            String[] isPortPair = ipPort.split(":");
            nodes.add(new HostAndPort(isPortPair[0].trim(),Integer.valueOf(isPortPair[1])));
        }
        return new JedisCluster(nodes,redisProperties.getCommandTimeout());
    }
}
