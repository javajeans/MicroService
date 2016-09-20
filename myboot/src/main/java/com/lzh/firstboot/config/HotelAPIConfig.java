package com.lzh.firstboot.config;

import com.lzh.firstboot.retrofit.api.HotelAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit.RestAdapter;

/**
 * 作者： Jonathan
 * 创建时间： 2016/9/20 ${Time}.
 * HotelAPIConfig的描述：${DESCRIPTION}
 */


@Configuration
public class HotelAPIConfig {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private RestAdapter adapter;

    @Bean
    public HotelAPI getHotelAPI(){
        return adapter.create(HotelAPI.class);
    }
}
