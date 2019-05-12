package com.bv.member.service.impl;

import com.bv.core.base.BaseApiService;
import com.bv.core.base.BaseResponse;
import com.bv.core.constants.ExtConstants;
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
public class MemberServiceImpl extends BaseApiService implements MemberService {


    @Autowired
    private WechatServiceFeign wechatServiceFeign;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserOutConverter userOutConverter;

    @Override
    public BaseResponse<UserOutDTO> existMobile(String mobile) throws Exception {
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


}
