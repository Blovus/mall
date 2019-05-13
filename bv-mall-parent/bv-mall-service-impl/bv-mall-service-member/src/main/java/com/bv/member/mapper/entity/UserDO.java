package com.bv.member.mapper.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Mybatis com.bv.mbg.Generator on 2019/05/04
 * 用户会员表
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDO implements Serializable {
    /**
     * 主键id
     */
    private Long idMallUser;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱号
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 性别  1男  2女
     */
    private Integer sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 用户头像
     */
    private String picImg;

    /**
     * QQ联合登陆id
     */
    private String qqOpenid;

    /**
     * 微信公众号关注id
     */
    private String wxOpenid;

    /**
     * 是否可用 0正常  1冻结
     */
    private Integer isValid;

    /**
     * 创建用户
     */
    private Integer createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新用户
     */
    private Integer updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}