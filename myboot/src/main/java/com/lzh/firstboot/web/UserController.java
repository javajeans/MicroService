package com.lzh.firstboot.web;


import com.lzh.firstboot.redis.MyRedisTemplate;
import com.lzh.firstboot.service.UserService;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lzh.firstboot.domain.User;

/**
 * 作者： Jonathan
 * 创建时间： 2016/9/12 ${Time}.
 * UserController的描述：${DESCRIPTION}
 */
@Api("userController相关API")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MyRedisTemplate myRedisTemplate;

    @ApiOperation("添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "username", dataType = "String", required = true, value = "用户的姓名", defaultValue = "zhiheng.li"),
            @ApiImplicitParam(paramType = "query", name = "password", dataType = "String", required = true, value = "用户的密码", defaultValue = "123456")
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public boolean addUser(@RequestParam("username") String username,
                           @RequestParam("password") String password) {
        return userService.addUser(username, password);
    }


    @ApiOperation("添加用户且返回已经设置了主键的user实例")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "username", dataType = "String", required = true, value = "用户的姓名", defaultValue = "zhiheng.li"),
            @ApiImplicitParam(paramType = "query", name = "password", dataType = "String", required = true, value = "用户的密码", defaultValue = "123456")
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value = "/addUserWithBackId", method = RequestMethod.POST)
    public User addUserWithBackId(@RequestParam("username") String username,
                                  @RequestParam("password") String password) {
        return userService.addUserWithBackId(username, password);
    }

    @ApiOperation("测试事务")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "username", dataType = "String", required = true, value = "用户的姓名", defaultValue = "zhiheng.li"),
            @ApiImplicitParam(paramType = "query", name = "password", dataType = "String", required = true, value = "用户的密码", defaultValue = "123456")

    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value = "/testTransaction", method = RequestMethod.POST)
    public void testTransaction(@RequestParam("username") String username,
                                @RequestParam("password") String password) {
        userService.testTransaction(username, password);
    }
//    @ApiOperation("获取用户信息")
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType = "header", name = "username", dataType = "String", required = true, value = "用户的姓名", defaultValue = "zhiheng.li"),
//            @ApiImplicitParam(paramType = "query", name = "password", dataType = "String", required = true, value = "用户的密码", defaultValue = "123456")
//
//    })
//    @ApiResponses({
//            @ApiResponse(code = 400, message = "请求参数没填好"),
//            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
//    })
//    @RequestMapping("/getUser")
//    public User getUser() {
//        return userService.getUser();
//    }

//    @RequestMapping("testJedisCluster")
//    public User testJedisCluster(@RequestParam("username") String username) {
//        String value = myRedisTemplate.get(MyConstants.USER_FORWARD_CACHE_PREFIX, username);
//        if (StringUtils.isBlank(value)) {
//            myRedisTemplate.set(MyConstants.USER_FORWARD_CACHE_PREFIX, username, JSON.toJSONString(getUser()));
//            return null;
//        }
//        return JSON.parseObject(value, User.class);
//    }
}
