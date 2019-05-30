package com.bv.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ProjectName: mall
 * @Package: com.bv.mall
 * @ClassName: AppEurekadescription '基础服务'
 * @Author: blovus
 * @Description: Eureka启动程序
 * @Date: 2019/4/27 23:51
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class AppEureka {
    public static void main(String[] args) {
        SpringApplication.run(AppEureka.class, args);
    }
}
