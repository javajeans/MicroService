package com.microservice.framework;

import com.microservice.framework.consul.ConsulRegisterListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 作者：Jonathan
 * 日期时间：2016/9/8 15:24
 **/
@SpringBootApplication
public class MySpringApplication {

     public void run(String[] args){
         SpringApplication sa = new SpringApplication(MySpringApplication.class);

         sa.addListeners(new ConsulRegisterListener());

         sa.run(args);
     }

    public static void main(String[] args){

    }
}
