package com.lzh.firstboot.dao;

import com.lzh.firstboot.exception.UserException;
import com.lzh.firstboot.mapper.UserMapper;
import com.lzh.firstboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 作者： Jonathan
 * 创建时间： 2016/9/14 ${Time}.
 * UserDao的描述：${DESCRIPTION}
 */
@Repository
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    public int insertUser(String username, String password){
        return userMapper.insertUser(username, password);
    }

    public int insertUserWithBackId(User user){
        return userMapper.insertUserWithBackId(user);
    }

    public void testTransactional(String username){
                throw new UserException("测试事务");
            }
}