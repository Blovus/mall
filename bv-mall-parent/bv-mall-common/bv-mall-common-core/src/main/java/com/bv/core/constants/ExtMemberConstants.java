package com.bv.core.constants;

/**
 * @ProjectName: mall
 * @Package: com.bv.core.constants
 * @ClassName: ExtLoginConstants
 * @Author: blovus
 * @Description: 会员服务常量
 * @Date: 2019/5/13 22:48
 * @Version: 1.0
 */
public interface ExtMemberConstants {
    // token
    String MEMBER_TOKEN_KEY_PREFIX = "bv.mb.login";

    // PC的登陆类型
    String MEMBER_LOGIN_TYPE_PC = "1";

    // 安卓的登陆类型
    String MEMBER_LOGIN_TYPE_ANDROID = "2";

    // IOS的登陆类型
    String MEMBER_LOGIN_TYPE_IOS = "3";

    // 微信的登陆类型
    String MEMBER_LOGIN_TYPE_WECHAT = "4";

    // 登陆超时时间 有效期 90天
    Long MEMBRE_LOGIN_TOKEN_TIME = 77776000L;


}
