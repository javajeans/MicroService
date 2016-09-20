package com.lzh.firstboot.retrofit.api;

import com.lzh.firstboot.domain.Hotel;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

import java.util.List;

/**
 * 作者： Jonathan
 * 创建时间： 2016/9/20 ${Time}.
 * HotelAPI的描述：${DESCRIPTION}
 */

public interface HotelAPI {

    /**
     * GET请求带查询参数
     * @param hotelname
     * @return
     */
    @GET("/hotel/getHotelWithQueryParameter")
    public Hotel getHotelWithQueryParameter(@Query("hotelname") String hotelname);

    /**
     * Post请求
     * @return
     */
    @POST("/hotel/getHotelList")
    public List<Hotel> getHotelList();

    /**
     * POST请求，带参数JavaBean
     * @param hotel
     * @return
     */
    @POST("/hotel/getHotelListWithBody")
    public List<Hotel> getHotelListWithBody(@Body Hotel hotel);
}
