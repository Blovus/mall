package com.bv.member.service;

import com.bv.core.base.BaseResponse;
import com.bv.member.entity.UserEntity;
import com.bv.wechat.entity.AppEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
     * @Method existMobile
     * @Author blovus
     * @Version  1.0
     * @Description  todo 
     * @Param mobile    
     * @Return com.bv.core.base.BaseResponse<com.bv.member.entity.UserEntity>
     * @Exception 
     * @Date 2019/5/4 20:05
     */
    @ApiOperation(value = "根据手机号码查询是否已经存在,如果存在返回当前用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "mobile", dataType = "String", required = true, value = "用户手机号码"), })
    @PostMapping("/existMobile")
    BaseResponse<UserEntity> existMobile(@RequestParam("mobile") String mobile);




}
