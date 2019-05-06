package com.bv.member.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Created by Mybatis com.bv.mbg.Generator on 2019/05/04
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "用户会员表")
public class UserEntity implements Serializable {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Integer idMallUser;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String mobile;

    /**
     * 邮箱号
     */
    @ApiModelProperty(value = "邮箱号")
    private String email;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String userName;

    /**
     * 性别  1男  2女
     */
    @ApiModelProperty(value = "性别  1男  2女")
    private Boolean sex;

    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄")
    private Byte age;

    /**
     * 用户头像
     */
    @ApiModelProperty(value = "用户头像")
    private String picImg;

    /**
     * QQ联合登陆id
     */
    @ApiModelProperty(value = "QQ联合登陆id")
    private String qqOpenid;

    /**
     * 微信公众号关注id
     */
    @ApiModelProperty(value = "微信公众号关注id")
    private String wxOpenid;

    /**
     * 是否可用 1正常  2冻结
     */
    @ApiModelProperty(value = "是否可用 1正常  2冻结")
    private Boolean isValid;

    /**
     * 创建用户
     */
    @ApiModelProperty(value = "创建用户")
    private Integer createBy;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新用户
     */
    @ApiModelProperty(value = "更新用户")
    private Integer updateBy;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}