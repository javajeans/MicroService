package web;

import domain.Hotel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

/**
 * 作者： Jonathan
 * 创建时间： 2016/9/20 ${Time}.
 * HotelController的描述：${DESCRIPTION}
 */
@Api("hotelController相关API")
@RestController
@RequestMapping("/hotel")
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
        List<Hotel> hotelList = new ArrayList<>();
        hotelList.add(new Hotel(1314, "玫瑰酒店"));
        hotelList.add(new Hotel(2046, "2046酒店"));
        return hotelList;
    }

    @ApiOperation("获取酒店Hotel信息：getHotelListWithBody")
    @RequestMapping(value="/getHotelListWithBody",method=RequestMethod.POST)
    public List<Hotel> getHotelListWithBody(@RequestBody Hotel hotel) {
        List<Hotel> hotelList = new ArrayList<>();
        if(hotel.getHotelname().equals("武林酒店")){
            hotelList.add(new Hotel(13141, "玫瑰酒店1"));
            hotelList.add(new Hotel(20461, "2046酒店1"));
            return hotelList;
        }
        hotelList.add(new Hotel(1314, "玫瑰酒店"));
        hotelList.add(new Hotel(2046, "2046酒店"));
        return hotelList;
    }

}
