package com.bv.member.feign;

import com.bv.wechat.service.VerificaCodeService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @ProjectName: mall
 * @Package: com.bv.member.feign
 * @ClassName: VerificaCodeServiceFeign
 * @Author: blovus
 * @Description: 微信验证码接口调用
 * @Date: 2019/5/4 20:52
 * @Version: 1.0
 */
@FeignClient("app-bv-wechat")
public interface VerificaCodeServiceFeign extends VerificaCodeService {
}
