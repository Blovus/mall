package com.bv.member.service;

import com.bv.core.base.BaseResponse;
import com.bv.member.dto.output.UserOutDTO;
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
     * @Version 1.0
     * @Description todo
     * @Param mobile
     * @Return com.bv.core.base.BaseResponse<com.bv.member.mapper.entity.UserEntity>
     * @Exception
     * @Date 2019/5/4 20:05
     */
    @ApiOperation(value = "根据手机号码查询是否已经存在,如果存在返回当前用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "mobile", dataType = "String", required = true, value = "用户手机号码"),})
    @GetMapping("/existMobile")
    BaseResponse<UserOutDTO> existMobile(@RequestParam("mobile") String mobile) ;

    /**
     * @Method getUserInfo
     * @Author blovus
     * @Version 1.0
     * @Description 根据token查询用户信息
     * @Param token
     * @Return com.bv.core.base.BaseResponse<com.bv.member.dto.output.UserOutDTO>
     * @Exception
     * @Date 2019/5/13 23:26
     */
    @GetMapping("/userInfo")
    @ApiOperation(value = "/userInfo")
    BaseResponse<UserOutDTO> getUserInfo(@RequestParam("token") String token);


}
