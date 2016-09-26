package com.lzh.firstboot.service;

import com.lzh.firstboot.dao.UserDao;
import com.lzh.firstboot.domain.Hotel;
import com.lzh.firstboot.domain.User;
import com.lzh.firstboot.retrofit.api.HotelAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 作者： Jonathan
 * 创建时间： 2016/9/12 ${Time}.
 * UserService的描述：${DESCRIPTION}
 */
@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);


    @Autowired
    private UserDao userDao;


    @Autowired
    private HotelAPI hotelApi;
    private Hotel hotel;

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

    public Hotel getHotelFromMybootWithQueryParameter(String hotelname){
        return hotelApi.getHotelWithQueryParameter(hotelname);
    }

    public List<Hotel> getHotelFromMootList(){
        return hotelApi.getHotelList();//测试post请求
    }

    public List<Hotel> getHotelFromMybootListWithBody(Hotel hotel){
        return hotelApi.getHotelListWithBody(hotel);//测试post请求
    }


    public User getUserByIdAndUsernameOrPassword(Integer id, String username, String password){
        User user = userDao.getUserByIdAndUsernameOrPassword(id, username, password);
        LOGGER.info("getUserByIdAndUsernameOrPassword success! user:'{}'", user);
        return user;
    }


    @Transactional
    public void testTransaction(String username,String password){
        System.out.println(userDao.insertUser(username,password));
        userDao.testTransactional(username);
    }
}
