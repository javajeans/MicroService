package com.lzh.secondboot.web;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作者： Jonathan
 * 创建时间： 2016/11/7 ${Time}.
 * AdviceController的描述：${DESCRIPTION}
 */

@Api("测试controllerAdvice和全局异常处理")
@RestController
@RequestMapping
public class AdviceController {

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String test1() {
        throw new RuntimeException("advice1 - exception1");
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public String test2() {
        throw new RuntimeException("advice1 - exception2");
    }

    //    @ExceptionHandler(RuntimeException.class)
    //    public MyExceptionResponse exceptionHandler() {
    //        MyExceptionResponse resp = new MyExceptionResponse();
    //        resp.setCode(300);
    //        resp.setMsg("exception-Handler");
    //        return resp;
    //    }


}
