package com.bv;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ProjectName: mall
 * @Package: com.bv.wechat
 * @ClassName: AppWechat
 * @Author: blovus
 * @Description: 微信服务
 * @Date: 2019/4/28 0:32
 * @Version: 1.0
 */
@SpringCloudApplication
@EnableApolloConfig
@EnableSwagger2Doc
@EnableFeignClients
public class AppWechat {
    public static void main(String[] args) {
        SpringApplication.run(AppWechat.class, args);
    }
}
