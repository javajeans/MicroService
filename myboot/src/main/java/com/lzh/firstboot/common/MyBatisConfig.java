package com.lzh.firstboot.common;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.lzh.firstboot.common.datasource.DatabaseType;
import com.lzh.firstboot.common.datasource.DynamicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * springboot集成mybatis的基本入口
 * 创建数据源
 * 创建SqlSessionFactory
 * 作者： Jonathan
 * 创建时间： 2016/9/14 ${Time}.
 * MyBatisConfig的描述：${DESCRIPTION}
 */
@Configuration
@MapperScan(basePackages = "com.lzh.firstboot.mapper")
public class MyBatisConfig {

    @Autowired
    private Environment env;

    /**
     * 创建数据源
     *
     * @return
     * @throws Exception
     * @Primary 该注解表示在同一个接口有多个实现类可以注入的时候，默认选择哪一个，而不是让@Autowire注解报错（一般用于多数据源的情况下）
     */

    @Bean
    //@Primary
    public DataSource getDataSource() throws Exception {
        Properties props = new Properties();
        props.put("driverClassName", env.getProperty("jdbc.driverClassName"));
        props.put("url", env.getProperty("jdbc.url"));
        props.put("username", env.getProperty("jdbc.username"));
        props.put("password", env.getProperty("jdbc.password"));
        return DruidDataSourceFactory.createDataSource(props);
    }

    @Bean
    //@Primary
    public DataSource getDataSource1() throws Exception {
        Properties props = new Properties();
        props.put("driverClassName", env.getProperty("jdbc1.driverClassName"));
        props.put("url", env.getProperty("jdbc1.url"));
        props.put("username", env.getProperty("jdbc1.username"));
        props.put("password", env.getProperty("jdbc1.password"));
        return DruidDataSourceFactory.createDataSource(props);
    }

    /**
     * @param getDataSource
     * @param getDataSource1
     * @return
     * @Primary 该注释表示在同一个接口有多个实现类可以注入的时候，默认选择哪一个；
     * @Qualifier 根据名称进行注入，通常是具有多个类型的相同实例注入
     */
    @Bean
    @Primary
    public DynamicDataSource dataSource(@Qualifier("getDataSource") DataSource getDataSource, @Qualifier("getDataSource1") DataSource getDataSource1) {
            Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
        targetDataSources.put(DatabaseType.myboot, getDataSource);
        targetDataSources.put(DatabaseType.myboot1, getDataSource1);
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSources);
        dataSource.setDefaultTargetDataSource(getDataSource);
        return dataSource;
    }

    /**
     * 根据数据源创建SqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DynamicDataSource ds) throws Exception {
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setDataSource(ds);// 指定数据源(这个必须有，否则报错)
        // 下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
        fb.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));// 指定基包
        fb.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapperLocations")));//

        return fb.getObject();
    }

    /* 配置事务管理器
    */
    @Bean
    public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }
}
