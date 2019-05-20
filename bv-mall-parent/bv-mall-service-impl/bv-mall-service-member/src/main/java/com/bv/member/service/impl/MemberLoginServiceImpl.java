package com.bv.member.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bv.core.base.BaseApiService;
import com.bv.core.base.BaseResponse;
import com.bv.core.constants.ExtMemberConstants;
import com.bv.core.token.ExtGenerateToken;
import com.bv.core.transaction.RedisDataSoureceTransaction;
import com.bv.core.utils.MD5Utils;
import com.bv.core.utils.SnowflakeIdUtils;
import com.bv.core.utils.TypeCastUtils;
import com.bv.member.dto.input.UserLoginInpDTO;
import com.bv.member.mapper.UserMapper;
import com.bv.member.mapper.UserTokenMapper;
import com.bv.member.mapper.entity.UserDO;
import com.bv.member.mapper.entity.UserTokenDO;
import com.bv.member.service.MemberLoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
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
    private RedisDataSoureceTransaction redisDataSoureceTransaction;

    @Autowired
    private ExtGenerateToken generateToken;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserTokenMapper userTokenMapper;


    @Override
    public BaseResponse<JSONObject> login(@RequestBody UserLoginInpDTO userLoginInpDTO) {

        // 验证参数
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

        String deviceInfo = userLoginInpDTO.getDeviceInfo();
        if (StringUtils.isEmpty(deviceInfo)) {
            return setResultError("设备信息不能为空!");
        }

        if (!(loginType.equals(ExtMemberConstants.MEMBER_LOGIN_TYPE_ANDROID) || loginType.equals(ExtMemberConstants.MEMBER_LOGIN_TYPE_IOS)
                || loginType.equals(ExtMemberConstants.MEMBER_LOGIN_TYPE_PC) || loginType.equals(ExtMemberConstants.MEMBER_LOGIN_TYPE_WECHAT))) {
            return setResultError("登陆类型出现错误!");
        }

        // 对密码加密
        String md5Password = MD5Utils.MD5(password);

        // 使用手机和密码查询数据库，判断用户是否存在
        UserDO userDO = userMapper.getByMobileAndPassword(mobile, md5Password, "0");

        if (null == userDO) {
            return setResultError("用户名或密码错误");
        }

        // 获取userId
        // 根据userId + loginType查询当前登录账号是否有登陆过
        Long userId = userDO.getIdMallUser();
        UserTokenDO userTokenDo = userTokenMapper.getByUserIdAndLoginType(userId, loginType);


        //开启事务
        TransactionStatus transactionStatus = null;

        try {
            transactionStatus = redisDataSoureceTransaction.begin();


            // 如过登陆过 清除之前的redis token 删除表里的记录
            if (null != userTokenDo) {
                generateToken.removeToken(userTokenDo.getUserToken());
                int deleteResult = userTokenMapper.deleteByUserIdAndloginType(userId, loginType);
                if (!toDaoResult(deleteResult)) {
                    redisDataSoureceTransaction.rollback(transactionStatus);
                    return setResultError("系统错误");
                }
            }


            //表中插入新的token
            UserTokenDO newUserTokenDO = new UserTokenDO();

            long tokenId = SnowflakeIdUtils.getId();
            newUserTokenDO.setIdMallUserToken(tokenId);
            newUserTokenDO.setIdMallUser(userId);
            newUserTokenDO.setLoginType(loginType);

            // 设置token存放在redis中
            String rKey = ExtMemberConstants.MEMBER_TOKEN_KEY_PREFIX + loginType;
            String token = generateToken.createToken(rKey, TypeCastUtils.toString(userId), ExtMemberConstants.MEMBRE_LOGIN_TOKEN_TIME);

            newUserTokenDO.setUserToken(token);
            newUserTokenDO.setDeviceInfo(deviceInfo);
            newUserTokenDO.setCreateBy(userId);
            newUserTokenDO.setUpdateBy(userId);

            int insertResult = userTokenMapper.insert(newUserTokenDO);
            //判断insert结果，如果小于等于0，则更新失败需要回滚
            if (!toDaoResult(insertResult)) {
                redisDataSoureceTransaction.rollback(transactionStatus);
                return setResultError("系统错误");
            }
            redisDataSoureceTransaction.commit(transactionStatus);
            //创建data返回
            JSONObject data = new JSONObject();
            data.put("token", token);
            return setResultSuccess(data);

        } catch (Exception e) {
            try {
                redisDataSoureceTransaction.rollback(transactionStatus);
                return setResultError("系统错误");
            } catch (Exception e2) {
                return null;
            }
        }
    }

}
