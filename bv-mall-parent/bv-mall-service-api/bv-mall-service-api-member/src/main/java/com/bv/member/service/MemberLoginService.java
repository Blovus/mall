package com.bv.member.service;

import com.alibaba.fastjson.JSONObject;
import com.bv.core.base.BaseResponse;
import com.bv.member.dto.input.UserLoginInpDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @ProjectName: mall
 * @Package: com.bv.member.service
 * @ClassName: MenberLoginService
 * @Author: blovus
 * @Description: 用户登录服务接口
 * @Date: 2019/5/12 21:51
 * @Version: 1.0
 */
@Api(tags = "会员登录接口")
public interface MemberLoginService {



    @PostMapping("/login")
    @ApiOperation(value = "会员用户登陆信息接口")
    BaseResponse<JSONObject> login(@RequestBody UserLoginInpDTO userLoginInpDTO);


}
