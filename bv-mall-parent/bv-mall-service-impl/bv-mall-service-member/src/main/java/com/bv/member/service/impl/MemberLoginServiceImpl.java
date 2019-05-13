package com.bv.member.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bv.core.base.BaseApiService;
import com.bv.core.base.BaseResponse;
import com.bv.core.constants.ExtMemberConstants;
import com.bv.core.token.ExtGenerateToken;
import com.bv.core.utils.MD5Utils;
import com.bv.core.utils.TypeCastUtils;
import com.bv.member.dto.input.UserLoginInpDTO;
import com.bv.member.mapper.UserMapper;
import com.bv.member.mapper.entity.UserDO;
import com.bv.member.service.MemberLoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: mall
 * @Package: com.bv.member.service.impl
 * @ClassName: MemberLoginServiceImpl
 * @Author: blovus
 * @Description: 11
 * @Date: 2019/5/13 22:17
 * @Version: 1.0
 */
@RestController("MemberLoginService")
public class MemberLoginServiceImpl extends BaseApiService<JSONObject> implements MemberLoginService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ExtGenerateToken generateToken;


    @Override
    public BaseResponse<JSONObject> login(@RequestBody UserLoginInpDTO userLoginInpDTO) {

        //验证参数
        String mobile = userLoginInpDTO.getMobile();
        if (StringUtils.isEmpty(mobile)) {
            return setResultError("手机号码不能为空");
        }
        String password = userLoginInpDTO.getPassword();

        if (StringUtils.isEmpty(password)) {
            return setResultError("密码不能为空");
        }

        String loginType = userLoginInpDTO.getLoginType();
        if (StringUtils.isEmpty(loginType)) {
            return setResultError("登陆类型不能为空!");
        }
        if (!(loginType.equals(ExtMemberConstants.MEMBER_LOGIN_TYPE_ANDROID) || loginType.equals(ExtMemberConstants.MEMBER_LOGIN_TYPE_IOS)
                || loginType.equals(ExtMemberConstants.MEMBER_LOGIN_TYPE_PC) || loginType.equals(ExtMemberConstants.MEMBER_LOGIN_TYPE_WECHAT))) {
            return setResultError("登陆类型出现错误!");
        }


        //对密码加密
        String md5Password = MD5Utils.MD5(password);

        //使用手机和密码查询数据库，判断用户是否存在
        UserDO userDO = userMapper.getByMobileAndPassword(mobile, md5Password, 0);

        if (null == userDO) {
            return setResultError("用户名或密码错误");
        }

        //获取userId  设置token
        Long userId = userDO.getIdMallUser();
        String rKey = ExtMemberConstants.MEMBER_TOKEN_KEY_PREFIX + loginType;
        String userToken = generateToken.createToken(rKey, TypeCastUtils.toString(userId), ExtMemberConstants.MEMBRE_LOGIN_TOKEN_TIME);

        //创建data返回
        JSONObject data = new JSONObject();
        data.put("token", userToken);
        return setResultSuccess(data);
    }

}
