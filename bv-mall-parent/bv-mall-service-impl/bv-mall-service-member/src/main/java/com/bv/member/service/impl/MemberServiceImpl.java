package com.bv.member.service.impl;

import com.bv.core.base.BaseApiService;
import com.bv.core.base.BaseResponse;
import com.bv.core.constants.ExtConstants;
import com.bv.core.token.ExtGenerateToken;
import com.bv.core.utils.TypeCastUtils;
import com.bv.member.dto.output.UserOutDTO;
import com.bv.member.feign.WechatServiceFeign;
import com.bv.member.mapper.UserMapper;
import com.bv.member.mapper.converter.UserOutConverter;
import com.bv.member.mapper.entity.UserDO;
import com.bv.member.service.MemberService;
import com.ctrip.framework.apollo.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: mall
 * @Package: com.bv.member.service.impl
 * @ClassName: MemberServiceImpl
 * @Author: blovus
 * @Description: 会员服务接口实现
 * @Date: 2019/4/28 23:55
 * @Version: 1.0
 */
@RestController("MemberService")
public class MemberServiceImpl extends BaseApiService<UserOutDTO> implements MemberService {


    @Autowired
    private WechatServiceFeign wechatServiceFeign;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserOutConverter userOutConverter;

    @Autowired
    private ExtGenerateToken generateToken;

    @Override
    public BaseResponse<UserOutDTO> existMobile(String mobile) {
        // 验证参数
        if (StringUtils.isEmpty(mobile)) {
            return setResultError("手机号码不能为空!");
        }
        //根据手机号码查询
        UserDO userDO = userMapper.getByMobile(mobile, 0);
        if (userDO == null) {
            return setResultError(ExtConstants.HTTP_RES_CODE_EXIST_202, "用户不存在");
        }
        //转换为DTO
        UserOutDTO userOutDTO = userOutConverter.invert(userDO);
        return setResultSuccess(userOutDTO);
    }

    @Override
    public BaseResponse<UserOutDTO> getUserInfo(String token) {

        // 参数验证
        if (StringUtils.isEmpty(token)) {
            return setResultError("token不能为空!");
        }
        // 使用token向redis中查询userId
        String redisValue = generateToken.getToken(token);
        if (StringUtils.isEmpty(redisValue)) {
            return setResultError("token已经失效或者不正确");
        }
        Long userId = TypeCastUtils.toLong(redisValue);
        // 根据userId查询用户信息
        UserDO userDo = userMapper.getById(userId, 0);
        if (userDo == null) {
            return setResultError("用户信息不存在!");
        }
        // 将Do转换为Dto
        UserOutDTO userOutDTO = userOutConverter.invert(userDo);
        return setResultSuccess(userOutDTO);

    }


}
