package com.bv.wechat.service;

import com.alibaba.fastjson.JSONObject;
import com.bv.core.base.BaseResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ProjectName: mall
 * @Package: com.bv.wechat.service
 * @ClassName: VerificaCodeService
 * @Author: blovus
 * @Description: 微信验证码接口
 * @Date: 2019/5/3 0:03
 * @Version: 1.0
 */
public interface VerificaCodeService {

    @ApiOperation(value = "根据手机号码验证码token是否正确")
    @GetMapping("/verificaWeixinCode")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "phone", dataType = "String", required = true, value = "用户手机号码"),
            @ApiImplicitParam(paramType = "query", name = "wechatCode", dataType = "String", required = true, value = "微信注册码") })
    BaseResponse<JSONObject> verificaWeixinCode(String phone, String wechatCode);

}
