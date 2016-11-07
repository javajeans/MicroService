package com.lzh.secondboot.web;

import com.lzh.secondboot.exception.MyExceptionResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * 作者： Jonathan
 * 创建时间： 2016/11/7 ${Time}.
 * GlobalExceptionHandler的描述：同一个异常被局部范围异常处理器和全局范围异常处理器同时覆盖，会选择小范围的局部范围处理器
 同一个异常被小范围的异常类和大范围的异常处理器同时覆盖，会选择小范围的异常处理器
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    //    @ExceptionHandler(value={RuntimeException.class,MyRuntimeException.class})
    //    @ExceptionHandler//处理所有异常
    @ResponseBody //在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
    public MyExceptionResponse exceptionHandler(RuntimeException e, HttpServletResponse response) {
        MyExceptionResponse resp = new MyExceptionResponse();
        resp.setCode(300);
        resp.setMsg("exception-Handler");
        //        response.setStatus(600);
        return resp;
    }
}
