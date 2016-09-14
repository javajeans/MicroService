package com.lzh.firstboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 作者： Jonathan
 * 创建时间： 2016/9/12 ${Time}.
 * Application的描述：${DESCRIPTION}
 * 主类要位于根包路径下，方便之后的扫描
 * @EnableAutoConfiguration:spring boot的注解，一般只用于主类，
 * @ComponentScan 进行包的扫描，扫描路径由@EnableAutoConfiguration指定了
 */
@EnableSwagger2
@SpringBootApplication
public class Application {

     public static void main(String[] args){
         SpringApplication.run(Application.class,args);
     }
}
