package com.lzh.firstboot.dao;

import com.lzh.firstboot.common.datasource.DatabaseContextHolder;
import com.lzh.firstboot.common.datasource.DatabaseType;
import com.lzh.firstboot.mapper.ShopMapper;
import com.lzh.firstboot.domain.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 作者： Jonathan
 * 创建时间： 2016/9/21 ${Time}.
* ShopDao的描述：${DESCRIPTION}
 */
@Repository
public class ShopDao {

    @Autowired
    private ShopMapper mapper;

    public Shop getShop(int id){
        DatabaseContextHolder.setDatabaseType(DatabaseType.myboot1);
        return mapper.getShop(id);
    }
}
