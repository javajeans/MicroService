package com.microservicerr.myserviceA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 *
 */
@EnableSwagger2
@SpringBootApplication
public class MyServiceAApplication implements EmbeddedServletContainerCustomizer {

    public static void main(String[] args){
        SpringApplication.run(MyServiceAApplication.class,args);
    }
    public void customize(ConfigurableEmbeddedServletContainer container){
        container.setPort(8082);
    }


}