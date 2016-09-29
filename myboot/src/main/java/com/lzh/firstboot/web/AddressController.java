package com.lzh.firstboot.web;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import io.swagger.annotations.Api;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * 作者： Jonathan
 * 创建时间： 2016/9/29 ${Time}.
 * AddressController的描述：${DESCRIPTION}
 */
@RestController
@RequestMapping("/address")
@Api("地址测试接口")
public class AddressController {

@Autowired
private OkHttpClient okHttpClient;

    @RequestMapping(value = "/testokhttp",method = RequestMethod.GET)
    public String testOkHttp(@RequestParam("id") int id,@RequestParam("name") String name){
        String url = String.format("http://localhost:8081/hotel/getHotelInfo?id=%d&name=%s",id,name);
        Response response = null;
        Request request =null;
        try{
            request = new Request.Builder().url(url).build();
            response = okHttpClient.newCall(request).execute();

        }catch (IOException e){
            System.out.println("tesokhttp失败！");
            e.printStackTrace();
        }finally{
            if(response.body()!=null){
                try{
                    response.body().close();//一定要关闭，不然会泄露资源
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        return "";
    }
}
