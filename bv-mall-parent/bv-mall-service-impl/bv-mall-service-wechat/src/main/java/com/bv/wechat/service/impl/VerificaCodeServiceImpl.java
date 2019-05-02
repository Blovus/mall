package com.bv.wechat.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bv.core.base.BaseApiService;
import com.bv.core.base.BaseResponse;
import com.bv.core.constants.ExtConstants;
import com.bv.core.templates.ExtRedisTemplate;
import com.bv.wechat.service.VerificaCodeService;
import com.ctrip.framework.apollo.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: mall
 * @Package: com.bv.wechat.service.impl
 * @ClassName: VerificaCodeServiceImpl
 * @Author: blovus
 * @Description: 微信验证码接口实现
 * @Date: 2019/5/3 0:01
 * @Version: 1.0
 */
@RestController
public class VerificaCodeServiceImpl extends BaseApiService<JSONObject> implements VerificaCodeService {
    @Autowired
    private ExtRedisTemplate extRedisTemplate;

    @Override
    public BaseResponse<JSONObject> verificaWeixinCode(String phone, String wechatCode) {
        //校验参数
        if (StringUtils.isEmpty(phone)) {
            return setResultError("手机号码不能为空!");
        }
        if (StringUtils.isEmpty(wechatCode)) {
            return setResultError("注册码不能为空!");
        }
        //从redis中获取注册码
        String redisKey = ExtConstants.WECHATCODE_KEY + phone;
        String code = extRedisTemplate.getString(redisKey);

        //注册码校验
        if (StringUtils.isEmpty(code)) {
            return setResultError("注册码已经过期,请重新发送验证码");
        }
        if (!code.equals(wechatCode)) {
            return setResultError("注册码不正确");
        }
        //校验结果为正确后删除key
        extRedisTemplate.delKey(redisKey);
        return setResultSuccess("注册码验证码正确");
    }

}
