package com.bv.member.feign;

import com.bv.wechat.service.WechatService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @ProjectName: mall
 * @Package: com.bv.member.feign
 * @ClassName: WechatAppServiceFegin
 * @Author: blovus
 * @Description: wechat接口调用
 * @Date: 2019/4/29 0:04
 * @Version: 1.0
 */
@FeignClient("app-bv-wechat")
public interface WechatServiceFeign extends WechatService {

}
