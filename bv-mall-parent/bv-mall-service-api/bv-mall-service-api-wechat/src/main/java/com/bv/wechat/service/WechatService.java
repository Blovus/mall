package com.bv.wechat.service;

import com.bv.core.base.BaseResponse;
import com.bv.wechat.entity.AppEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ProjectName: mall
 * @Package: com.bv.wechat.service
 * @ClassName: WechatService
 * @Author: blovus
 * @Description: 微信服务接口
 * @Date: 2019/4/28 0:09
 * @Version: 1.0
 */
@Api(tags = "微信服务接口")
public interface WechatService {
    /**
     * @Method getApp
     * @Author blovus
     * @Version 1.0
     * @Description 应用服务接口
     * @Return com.blovus.wechat.entity.AppEntity
     * @Exception
     * @Date 2019/4/28 0:20
     */
    @ApiOperation(value = "微信应用服务接口")
    @GetMapping("/getApp")
    BaseResponse<AppEntity> getApp();
}
