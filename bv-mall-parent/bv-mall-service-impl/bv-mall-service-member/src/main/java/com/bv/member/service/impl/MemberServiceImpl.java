package com.bv.member.service.impl;

import com.bv.core.base.BaseApiService;
import com.bv.core.base.BaseResponse;
import com.bv.core.constants.ExtConstants;
import com.bv.member.entity.UserEntity;
import com.bv.member.feign.WechatServiceFeign;
import com.bv.member.mapper.UserMapper;
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
@RestController
public class MemberServiceImpl extends BaseApiService implements MemberService {


    @Autowired
    private WechatServiceFeign wechatServiceFeign;

    @Autowired
    private UserMapper userMapper;


    @Override
    public BaseResponse<UserEntity> existMobile(String mobile) {
        // 验证参数
        if (StringUtils.isEmpty(mobile)) {
            return setResultError("手机号码不能为空!");
        }
        //根据手机号码查询
        UserEntity userEntity = userMapper.getByMobile(mobile);
        if (userEntity == null) {
            return setResultError(ExtConstants.HTTP_RES_CODE_EXIST_202, "用户不存在");
        }
        // 注意需要将敏感数据进行脱敏  todo 下次转dto
        userEntity.setPassword(null);

        return setResultSuccess(userEntity);
    }


}
