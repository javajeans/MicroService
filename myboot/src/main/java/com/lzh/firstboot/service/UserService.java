package com.lzh.firstboot.service;

import com.lzh.firstboot.dao.UserDao;
import com.lzh.firstboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 作者： Jonathan
 * 创建时间： 2016/9/12 ${Time}.
 * UserService的描述：${DESCRIPTION}
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public boolean addUser(String username, String password){
        return userDao.insertUser(username, password)==1?true:false;
    }

    public User addUserWithBackId(String username, String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userDao.insertUserWithBackId(user);//该方法后，主键已经设置到user中了
        return user;
    }
    @Transactional
    public void testTransaction(String username,String password){
        System.out.println(userDao.insertUser(username,password));
        userDao.testTransactional(username);
    }
}
