package com.bv.member.service;

import com.bv.wechat.entity.AppEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ProjectName: mall
 * @Package: com.bv.member.service
 * @ClassName: MemberService
 * @Author: blovus
 * @Description: 会员服务接口
 * @Date: 2019/4/28 22:54
 * @Version: 1.0
 */
@Api(tags = "会员服务接口")
public interface MemberService {

    /**
     * @Method memberInvokeWechat
     * @Author blovus
     * @Version 1.0
     * @Description 会员服务接口调用微信接口
     * @Return com.bv.wechat.entity.AppEntity
     * @Exception
     * @Date 2019/4/28 23:44
     */
    @ApiOperation(value = "会员服务调用微信服务")
    @GetMapping("/memberInvokeWechat")
    AppEntity memberInvokeWechat();

}
