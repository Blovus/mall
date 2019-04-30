package com.bv.member.feign;

import com.bv.wechat.service.WechatService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @ProjectName: mall
 * @Package: com.bv.member.feign
 * @ClassName: WechatAppServiceFegin
 * @Author: blovus
 * @Description: 微信接口调用
 * @Date: 2019/4/29 0:04
 * @Version: 1.0
 */
@FeignClient("app-bv-wechat")
public interface WechatServiceFegin extends WechatService {

}
