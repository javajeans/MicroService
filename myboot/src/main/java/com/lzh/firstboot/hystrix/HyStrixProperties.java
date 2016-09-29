package com.lzh.firstboot.hystrix;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 作者： Jonathan
 * 创建时间： 2016/9/27 ${Time}.
 * HyStrixProperties的描述：${DESCRIPTION}
 */
@Getter @Setter
@Component
@ConfigurationProperties(prefix = "hystrix")
public class HyStrixProperties {
    private int timeoutInMillions;
}
