package com.bv.member.mapper.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @ProjectName: mall
 * @Package: com.bv.member.mapper.entity
 * @ClassName: UserTokenDo
 * @Author: blovus
 * @Description: 用户登陆票据表
 * @Date: 2019/5/12 21:55
 * @Version: 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserTokenDO implements Serializable {
    /**
     * 主键id
     */
    private Long idMallUserToken;

    /**
     * 用户会员表id
     */
    private Long idMallUser;

    /**
     * 用户票据
     */
    private String userToken;

    /**
     * 登录端类型 0-测试使用 1-pc 2-安卓 3-ios 4-微信 99-未知
     */
    private String loginType;

    /**
     * 登陆设备
     */
    private String deviceInfo;

    /**
     * 是否可用 0正常  1冻结
     */
    private Integer isValid;

    /**
     * 创建用户
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新用户
     */
    private Long updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}