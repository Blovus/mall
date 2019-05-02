package com.bv.wechat.service.impl;

import com.bv.core.base.BaseApiService;
import com.bv.core.base.BaseResponse;
import com.bv.wechat.entity.AppEntity;
import com.bv.wechat.service.WechatService;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: mall
 * @Package: com.bv.wechat.service.impl
 * @ClassName: WechatAppserviceImpl
 * @Author: blovus
 * @Description: 微信接口实现
 * @Date: 2019/4/28 0:27
 * @Version: 1.0
 */
@RestController
public class WechatServiceImpl extends BaseApiService<AppEntity> implements WechatService {

    @Override
    public BaseResponse<AppEntity> getApp() {
        return setResultSuccess(new AppEntity("1", "嗷嗷"));
    }


}
