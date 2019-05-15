package com.bv.member.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bv.core.base.BaseApiService;
import com.bv.core.base.BaseResponse;
import com.bv.core.constants.ExtConstants;
import com.bv.core.utils.MD5Utils;
import com.bv.core.utils.SnowflakeIdUtils;
import com.bv.member.dto.input.UserInDTO;
import com.bv.member.feign.VerificaCodeServiceFeign;
import com.bv.member.mapper.UserMapper;
import com.bv.member.mapper.converter.UserInConverter;
import com.bv.member.mapper.entity.UserDO;
import com.bv.member.service.MemberRegisterService;
import com.ctrip.framework.apollo.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: mall
 * @Package: com.bv.member.service.impl
 * @ClassName: MemberRegisterServiceImpl
 * @Author: blovus
 * @Description: 会员注册接口实现
 * @Date: 2019/5/4 18:55
 * @Version: 1.0
 */
@RestController("MemberRegisterService")
public class MemberRegisterServiceImpl extends BaseApiService implements MemberRegisterService {

    @Autowired
    private VerificaCodeServiceFeign verificaCodeServiceFeign;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserInConverter userInConverter;


    @Override
    @Transactional
    public BaseResponse<JSONObject> register(@RequestBody UserInDTO userInDTO, String registCode) throws Exception {

        System.out.println("xxxx");
        // 验证参数
        String userName = userInDTO.getUserName();
        if (StringUtils.isEmpty(userName)) {
            return setResultError("用户名称不能为空!");
        }
        String mobile = userInDTO.getMobile();
        if (StringUtils.isEmpty(mobile)) {
            return setResultError("手机号码不能为空!");
        }
        String password = userInDTO.getPassword();
        if (StringUtils.isEmpty(password)) {
            return setResultError("密码不能为空!");
        }
        String newPassWord = MD5Utils.MD5(password);
        // 将密码采用MD5加密
        userInDTO.setPassword(newPassWord);
        // 调用微信接口,验证注册码是否正确
        BaseResponse<JSONObject> resultVerificaWeixinCode = verificaCodeServiceFeign.verificaWeixinCode(mobile,
                registCode);
        if (!resultVerificaWeixinCode.getRtnCode().equals(ExtConstants.HTTP_RES_CODE_200)) {
            return setResultError(resultVerificaWeixinCode.getMsg());
        }
        //转换为DO
        UserDO userEntity = userInConverter.convert(userInDTO);

        userEntity.setIdMallUser(SnowflakeIdUtils.getId());

        int registerResult = userMapper.insert(userEntity);

        return registerResult > 0 ? setResultSuccess("注册成功") : setResultSuccess("注册失败");
    }
}
