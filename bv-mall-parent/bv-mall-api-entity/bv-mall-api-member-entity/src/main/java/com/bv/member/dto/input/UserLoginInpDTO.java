package com.bv.member.dto.input;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ProjectName: mall
 * @Package: com.bv.member.dto.input
 * @ClassName: UserLoginInpDTO
 * @Author: blovus
 * @Description: 用户登陆参数
 * @Date: 2019/5/13 22:08
 * @Version: 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "用户登陆参数")
public class UserLoginInpDTO implements Serializable {
    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码")
    private String mobile;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 登陆类型  1-pc 2-安卓 3-ios 4-微信 99-未知
     */
    @ApiModelProperty(value = "登陆类型")
    private String loginType;
    /**
     * 设备信息
     */
    @ApiModelProperty(value = "设备信息")
    private String deviceInfo;




}
