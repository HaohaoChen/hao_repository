package com.yupont;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Administrator on 2017/12/21 0021.
 */

// Spring Boot 应用的标识
@SpringBootApplication
// mapper 接口类扫描包配置多种方式  a.@MapperScan("com.yupont.*.dao")  b.@MapperScan({"com.yupont.mybatis.dao","com.yupont.redis_mybatis.dao"})
@MapperScan("com.yupont.*.dao")
public class Application {
    public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        SpringApplication.run(Application.class,args);
    }
}
