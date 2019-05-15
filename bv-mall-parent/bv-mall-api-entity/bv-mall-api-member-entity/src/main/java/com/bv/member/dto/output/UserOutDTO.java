package com.bv.member.dto.output;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Mybatis com.bv.mbg.Generator on 2019/05/04
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "用户响应参数")
public class UserOutDTO implements Serializable {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Long idMallUser;

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
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String userName;

    /**
     * 性别  1男  2女
     */
    @ApiModelProperty(value = "性别  1男  2女")
    private Integer sex;

    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄")
    private Integer age;

    /**
     * 用户头像
     */
    @ApiModelProperty(value = "用户头像")
    private String picImg;

    /**
     * QQ联合登陆id
     */
    @ApiModelProperty(value = "QQ联合登陆id")
    private String qqOpenId;

    /**
     * 微信公众号关注id
     */
    @ApiModelProperty(value = "微信公众号关注id")
    private String wxOpenId;


    private static final long serialVersionUID = 1L;
}