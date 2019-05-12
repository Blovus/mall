package com.bv.member.service;

import com.alibaba.fastjson.JSONObject;
import com.bv.core.base.BaseResponse;
import com.bv.member.dto.input.UserInDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ProjectName: mall
 * @Package: com.bv.member.service
 * @ClassName: MemberRegisterService
 * @Author: blovus
 * @Description: 会员注册接口
 * @Date: 2019/5/3 15:20
 * @Version: 1.0
 */
@Api(tags = "会员注册接口")
public interface MemberRegisterService {

    /**
     * @Method register
     * @Author blovus
     * @Version 1.0
     * @Description 会员用户注册信息接口
     * @Param userEntity
     * @Param registCode
     * @Return com.bv.core.base.BaseResponse<com.alibaba.fastjson.JSONObject>
     * @Exception
     * @Date 2019/5/4 18:54
     */
    @PostMapping("/register")
    @ApiOperation(value = "会员用户注册信息接口")
    BaseResponse<JSONObject> register(@RequestBody UserInDTO userInDTO,
                                      @RequestParam("registCode") String registCode) throws Exception;


}
