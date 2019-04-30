package com.bv.wechat;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ProjectName: mall
 * @Package: com.bv.wechat
 * @ClassName: AppWechat
 * @Author: blovus
 * @Description: 微信服务
 * @Date: 2019/4/28 0:32
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2Doc
public class AppWechat {
    public static void main(String[] args) {
        SpringApplication.run(AppWechat.class, args);
    }
}
