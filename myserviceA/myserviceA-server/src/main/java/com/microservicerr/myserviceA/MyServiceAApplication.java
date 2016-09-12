package com.microservicerr.myserviceA;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.microservice.framework.MySpringApplication;



/**
 *
 */
@SpringBootApplication
public class MyServiceAApplication {

    public static void main(String[] args){
      MySpringApplication mySpringApplication = new MySpringApplication();

      mySpringApplication.run(args);
    }



}