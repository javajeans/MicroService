package com.lzh.firstboot.web;


import com.lzh.firstboot.domain.Hotel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 作者： Jonathan
 * 创建时间： 2016/9/20 ${Time}.
 * HotelController的描述：${DESCRIPTION}
 */
@RestController
@RequestMapping("/hotel")
@Api("HotelController相关API")
public class HotelController {

    @ApiOperation("获取酒店Hotel信息：getHotelWithQueryParameter")
    @RequestMapping(value="/getHotelWithQueryParameter",method = RequestMethod.GET)
    public Hotel getHotelWithQueryParameter(@RequestParam("hotelname") String hotelname){
        if(hotelname.equals("nana")){
            return new Hotel(777,"假日酒店");
        }
        return new Hotel(1314,"玫瑰酒店 ");
    }

    @ApiOperation("获取酒店Hotel信息：getHotelList")
    @RequestMapping(value="/getHotelList",method=RequestMethod.POST)
    public List<Hotel> getHotelList() {
        List<Hotel> hotelList = new ArrayList<Hotel>();
        hotelList.add(new Hotel(1314, "玫瑰酒店"));
        hotelList.add(new Hotel(2046, "2046酒店"));
        return hotelList;
    }

    @ApiOperation("获取酒店Hotel信息：getHotelListWithBody")
    @RequestMapping(value="/getHotelListWithBody",method=RequestMethod.POST)
    public List<Hotel> getHotelListWithBody(@RequestBody Hotel hotel) {
        List<Hotel> hotelList = new ArrayList<Hotel>();
        if(hotel.getHotelname().equals("武林酒店")){
            hotelList.add(new Hotel(13141, "玫瑰酒店1"));
            hotelList.add(new Hotel(20461, "2046酒店1"));
            return hotelList;
        }
        hotelList.add(new Hotel(1314, "玫瑰酒店"));
        hotelList.add(new Hotel(2046, "2046酒店"));
        return hotelList;
    }

    @ApiOperation("获取酒店Hotel信息：getHotelInfo")
    @RequestMapping(value="/getHotelInfo",method=RequestMethod.GET)
    public Hotel getHotelInfo(@RequestParam("id") int id, @RequestParam("name") String name) {
//        try {
//            TimeUnit.MILLISECONDS.sleep(2000);//用于测试超时
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return new Hotel(id, name);
    }
}
