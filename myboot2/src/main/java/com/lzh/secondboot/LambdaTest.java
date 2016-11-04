package com.lzh.secondboot;

import java.util.Arrays;
import java.util.List;

/**
 * 作者： Jonathan
 * 创建时间： 2016/10/31 ${Time}.
 * LambdaTest的描述：${DESCRIPTION}
 */

public class LambdaTest {

    public static void main(String args[]){
        List features = Arrays.asList("Lambdas","Default Method", "Stream API");
        features.forEach(n -> System.out.println(n));
    }

}
