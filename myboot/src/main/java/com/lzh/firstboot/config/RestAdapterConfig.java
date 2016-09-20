package com.lzh.firstboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit.RestAdapter;

/**
 * 作者： Jonathan
 * 创建时间： 2016/9/20 ${Time}.
 * RestAdapterConfig的描述：${DESCRIPTION}
 */
@Configuration
public class RestAdapterConfig {

    /**
     * 获取RestAdapter单例Bean
     * @return
     */
    @Bean
    public RestAdapter getRestAdapter(){
        /**
         * setEndpoint("http://localhost:8081"):指定基本的URL，
         * API接口中的URL是相对于该URL的路径的，
         * 不能少了协议名，例如写成：localhost:8081就不行
         */
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("http://localhost:8080")
                .build();
        return adapter;
    }

}
