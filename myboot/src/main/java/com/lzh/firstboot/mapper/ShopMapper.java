package com.lzh.firstboot.mapper;

import com.lzh.firstboot.domain.Shop;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * 作者： Jonathan
 * 创建时间： 2016/9/21 ${Time}.
 * SopMapper的描述：${DESCRIPTION}
 */

public interface ShopMapper {
    @Select("SELECT * FROM tb_shop WHERE id = #{id}")
    @Results(value = {@Result(id = true, column = "id", property = "id"),@Result(column = "shop_name", property = "shopName")})
    public Shop getShop(@Param("id") int id);

}
