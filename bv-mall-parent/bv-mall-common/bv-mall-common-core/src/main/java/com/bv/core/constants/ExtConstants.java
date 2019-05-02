package com.bv.core.constants;

/**
 * @ProjectName: mall
 * @Package: com.bv.core.utils
 * @ClassName: Constants
 * @Author: blovus
 * @Description: 常用常量
 * @Date: 2019/5/2 21:28
 * @Version: 1.0
 */
public interface ExtConstants {
    // 响应请求成功
    String HTTP_RES_CODE_200_VALUE = "success";
    // 系统错误
    String HTTP_RES_CODE_500_VALUE = "fail";
    // 响应请求成功code
    Integer HTTP_RES_CODE_200 = 200;
    // 系统错误
    Integer HTTP_RES_CODE_500 = 500;
    // 未关联QQ账号
    Integer HTTP_RES_CODE_201 = 201;
    // 发送邮件
    String MSG_EMAIL = "email";
    // 会员token
    String TOKEN_MEMBER = "TOKEN_MEMBER";
    // 用户有效期 90天
    Long TOKEN_MEMBER_TIME = (long) (60 * 60 * 24 * 90);
    int COOKIE_TOKEN_MEMBER_TIME = (60 * 60 * 24 * 90);
    // cookie 会员 totoken 名称
    String COOKIE_MEMBER_TOKEN = "cookie_member_token";
    // 微信code
    String WECHATCODE_KEY = "wechat.code";
    // 微信注册码有效期30分钟
    Long WECHATCODE_TIMEOUT = 1800l;
}
