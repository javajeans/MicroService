package com.lzh.firstboot.service;

import com.lzh.firstboot.dao.ShopDao;
import com.lzh.firstboot.domain.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 作者： Jonathan
 * 创建时间： 2016/9/21 ${Time}.
 * ShopService的描述：${DESCRIPTION}
 */
@Service
public class ShopService {

    @Autowired
    private ShopDao shopDao;

    public Shop getShop(int id){
        return shopDao.getShop(id);
    }
}
