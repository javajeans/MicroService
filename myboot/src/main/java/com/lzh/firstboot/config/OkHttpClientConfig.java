package com.lzh.firstboot.config;

import com.squareup.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 作者： Jonathan
 * 创建时间： 2016/9/29 ${Time}.
 * OkHttpClientConfig的描述：${DESCRIPTION}
 */
@Configuration
public class OkHttpClientConfig {

    @Bean
    public OkHttpClient okHttpClient(){
        return new OkHttpClient();
    }
}
