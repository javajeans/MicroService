package com.lzh.firstboot.common.datasource;

import com.lzh.firstboot.dao.ShopDao;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 作者： Jonathan
 * 创建时间： 2016/9/26
 * DataSourceAspect的描述：列出了两种切面方法，在这里推荐使用前者，原因：
 *
 * @Around：需要写执行目标方法的那一行代码，而这一行代码可能会抛异常，还需要抛出或捕获
 */
@Component
@Aspect
public class DataSourceAspect {

//    @Before("execution(* com.lzh.firstboot.dao.*.*(..))")
//    public void setDataSourceKey(JoinPoint point){
//        //连接点所属的类实例是ShopDao
//        if(point.getTarget() instanceof ShopDao){
//            DatabaseContextHolder.setDatabaseType(DatabaseType.myboot1);
//        }else{//连接点所属的类实例是UserDao（当然，这一步也可以不写，因为defaultTargertDataSource就是该类所用的myboot）
//            DatabaseContextHolder.setDatabaseType(DatabaseType.myboot);
//        }
//    }

    //    @Around("execution(* com.xxx.firstboot.dao.*.*(..))")
//    public Object setDataSourceKeyByAround(ProceedingJoinPoint point) throws Throwable{
//        if(point.getTarget() instanceof ShopDao){
//            DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
//        }else{//连接点所属的类实例是UserDao（当然，这一步也可以不写，因为defaultTargertDataSource就是该类所用的mytestdb）
//            DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
//        }
//        return point.proceed();//执行目标方法
//    }


    /**
     * 使用空方法定义切点表达式
     */
    @Pointcut("execution(* com.lzh.firstboot.dao.*.*(..))")
    public void declareJointPointExpression() {
    }

    /**
     * 使用定义切点表达式的方法进行切点表达式的引入
     */
    @Before("declareJointPointExpression()")
    public void setDataSourceKey(JoinPoint point) {
        // 连接点所属的类实例是ShopDao
        if (point.getTarget() instanceof ShopDao) {
            DatabaseContextHolder.setDatabaseType(DatabaseType.myboot1);
        } else {// 连接点所属的类实例是UserDao（当然，这一步也可以不写，因为defaultTargertDataSource就是该类所用的myboot）
            DatabaseContextHolder.setDatabaseType(DatabaseType.myboot);
        }
    }
}
