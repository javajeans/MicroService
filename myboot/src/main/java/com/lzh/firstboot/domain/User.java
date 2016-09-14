package com.lzh.firstboot.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 作者： Jonathan
 * 创建时间： 2016/9/12 ${Time}.
 * User的描述：@ConfigurationProperties(prefix="user")
 * 自动读取application.properties(是spring-boot默认查找的文件）文件中的user.*的属性
 * 在没有使用@ConfigurationProperties的情况下，可以使用@Value，需要将bean添加@Component，
 * 具体使用查看“UserService”
 */

@Component
@ConfigurationProperties(prefix="user")
public class User {

    //@Value("$user.id}")
    private int id;

    private String username;

    private String password;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
