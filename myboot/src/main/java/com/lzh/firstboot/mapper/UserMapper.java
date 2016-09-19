package com.lzh.firstboot.mapper;

import com.lzh.firstboot.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * 作者： Jonathan
 * 创建时间： 2016/9/14 ${Time}.
 * UserMapper的描述：${DESCRIPTION}
 */
@Repository
public interface UserMapper {

    @Insert("INSERT INTO tb_user(username,password) VALUE(#{username},#{password}")
    public int insertUser(@Param("username") String username,@Param("password") String password);

    /**
     * 插入用户，并将主键设置到user中
     * 注意：返回的是数据库影响条数，即1
     * @param user
     * @return
     */
    public int insertUserWithBackId(User user);
}
