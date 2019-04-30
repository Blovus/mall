package com.bv.member;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ProjectName: mall
 * @Package: com.bv.member
 * @ClassName: AppMember
 * @Author: blovus
 * @Description: 会员服务的实现
 * @Date: 2019/4/29 0:14
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableSwagger2Doc
public class AppMember {
    public static void main(String[] args) {
        SpringApplication.run(AppMember.class, args);
    }
}
