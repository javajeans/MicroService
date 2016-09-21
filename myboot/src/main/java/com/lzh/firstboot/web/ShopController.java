package com.lzh.firstboot.web;

import com.lzh.firstboot.domain.Shop;
import com.lzh.firstboot.service.ShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作者： Jonathan
 * 创建时间： 2016/9/21 ${Time}.
 * ShopController的描述：${DESCRIPTION}
 */
@Api("shopController相关Api")
@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @ApiOperation("获取shop信息，测试数据库")
    @RequestMapping(value = "/getShop",method = RequestMethod.GET)
    public Shop getShop(@RequestParam("id") int id){
        return shopService.getShop(id);
    }

}
