package com.bv;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ProjectName: mall
 * @Package: com.bv.member
 * @ClassName: AppMember
 * @Author: blovus
 * @Description: 会员服务的实现
 * @Date: 2019/4/29 0:14
 * @Version: 1.0
 */
@SpringCloudApplication
@EnableFeignClients
@EnableSwagger2Doc
@EnableApolloConfig
@MapperScan("com.bv.member.mapper")
public class AppMember {
    public static void main(String[] args) {
        SpringApplication.run(AppMember.class, args);
    }
}
