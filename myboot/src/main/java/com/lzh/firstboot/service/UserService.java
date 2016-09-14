package com.lzh.firstboot.service;

import com.lzh.firstboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 作者： Jonathan
 * 创建时间： 2016/9/12 ${Time}.
 * UserService的描述：${DESCRIPTION}
 */
@Service
public class UserService {

        @Autowired
    private User user;

    public User getUser(){
        return user;
    }
}
