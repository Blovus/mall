package com.bv;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @ProjectName: mall
 * @Package: com.bv
 * @ClassName: AppGateWay
 * @Author: blovus
 * @Description: 网关入口
 * @Date: 2019/4/29 21:38
 * @Version: 1.0
 */
@SpringCloudApplication
@EnableApolloConfig
public class AppGateWay {
    public static void main(String[] args) {
        SpringApplication.run(AppGateWay.class, args);
    }
}
