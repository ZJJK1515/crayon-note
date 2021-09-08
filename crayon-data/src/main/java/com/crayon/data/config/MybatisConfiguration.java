package com.crayon.data.config;

import com.crayon.data.interceptor.CrayonSQLInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class MybatisConfiguration {

    /**
     * 注册拦截器
     */
    @Bean
    public CrayonSQLInterceptor mybatisInterceptor() {
        CrayonSQLInterceptor interceptor = new CrayonSQLInterceptor();
        Properties properties = new Properties();
        // 可以调用properties.setProperty方法来给拦截器设置一些自定义参数
        interceptor.setProperties(properties);
        return interceptor;
    }

}
