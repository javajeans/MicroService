package com.lzh.secondboot.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 作者： Jonathan
 * 创建时间： 2016/9/20 ${Time}.
 * Hotel的描述：${DESCRIPTION}
 */
@Getter @Setter
public class Hotel {

    private int id;

    private String hotelname;

    public Hotel(int id, String hotelname) {
        this.id = id;
        this.hotelname = hotelname;
    }
}
