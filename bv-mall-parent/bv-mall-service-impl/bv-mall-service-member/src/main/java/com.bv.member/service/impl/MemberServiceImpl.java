package com.bv.member.service.impl;

import com.bv.core.base.BaseApiService;
import com.bv.member.feign.WechatServiceFegin;
import com.bv.member.service.MemberService;
import com.bv.wechat.entity.AppEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: mall
 * @Package: com.bv.member.service.impl
 * @ClassName: MemberServiceImpl
 * @Author: blovus
 * @Description: 会员服务接口实现
 * @Date: 2019/4/28 23:55
 * @Version: 1.0
 */
@RestController
public class MemberServiceImpl extends BaseApiService implements MemberService {


    @Autowired
    private WechatServiceFegin wechatServiceFegin;

    @Override
    public AppEntity memberInvokeWechat() {
        return wechatServiceFegin.getApp();
    }

}
