package com.lzh.firstboot.exception;

import org.springframework.dao.DataAccessException;

/**
 * 作者： Jonathan
 * 创建时间： 2016/9/19 ${Time}.
 * UserException的描述：自定义异常
 */

public class UserException extends DataAccessException {



    private static final long serialVersionUID = 8901479830692029025L;


    public UserException(String msg) {
        super(msg);
    }


}
