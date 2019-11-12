package com.wddlhyss.community;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties
@MapperScan(basePackages = "com.wddlhyss.community.mapper")
@ComponentScan(basePackages = {"com.wddlhyss.community.service",
                               "com.wddlhyss.community.controller",
                               "com.wddlhyss.community.provider"})
public class CommunityApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommunityApplication.class, args);
    }

}
