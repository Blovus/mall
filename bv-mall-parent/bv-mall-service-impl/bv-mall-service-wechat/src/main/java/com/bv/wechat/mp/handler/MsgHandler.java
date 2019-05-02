package com.bv.wechat.mp.handler;

import com.bv.core.constants.ExtConstants;
import com.bv.core.templates.ExtRedisTemplate;
import com.bv.core.utils.ExtRegexUtils;
import com.bv.wechat.mp.builder.TextBuilder;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

import static me.chanjar.weixin.common.api.WxConsts.XmlMsgType;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@Component
@SuppressWarnings("static-access")
public class MsgHandler extends AbstractHandler {


    /**
     * 发送验证码消息
     */
    @Value("${mall.wechat.registration.code.message}")
    private String registrationCodeMessage;
    /**
     * 默认回复消息
     */
    @Value("${mall.wechat.default.registration.code.message}")
    private String defaultRegistrationCodeMessage;


    @Resource(name = "ExtRedisTemplate")
    private ExtRedisTemplate extRedisTemplate;


    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) {

        if (!wxMessage.getMsgType().equals(XmlMsgType.EVENT)) {
            //TODO 可以选择将消息保存到本地
        }

        //当用户输入关键词如“你好”，“客服”等，并且有客服在线时，把消息转发给在线客服
        try {
            if (StringUtils.startsWithAny(wxMessage.getContent(), "你好", "客服")
                    && weixinService.getKefuService().kfOnlineList()
                    .getKfOnlineList().size() > 0) {
                return WxMpXmlOutMessage.TRANSFER_CUSTOMER_SERVICE()
                        .fromUser(wxMessage.getToUser())
                        .toUser(wxMessage.getFromUser()).build();
            }
        } catch (WxErrorException e) {
            e.printStackTrace();
        }

        //组装回复消息
        //获取微信客户端发送的消息
        String wxMessageContent = wxMessage.getContent();
        //判断是否为手机号码，如果是的话做则随机生成4位数字注册码
        if (ExtRegexUtils.checkMobile(wxMessageContent)) {
            int registCode = registCode();
            String content = String.format(registrationCodeMessage, registCode);
            String.format(registrationCodeMessage, registCode);
            extRedisTemplate.setString(ExtConstants.WECHATCODE_KEY + wxMessageContent, registCode + "", ExtConstants.WECHATCODE_TIMEOUT);
            return new TextBuilder().build(content, wxMessage, weixinService);

        }


        //String content = "收到信息内容：" + JsonUtils.toJson(wxMessage);

        return new TextBuilder().build(defaultRegistrationCodeMessage, wxMessage, weixinService);
    }

    // 获取注册码
    private int registCode() {
        int registCode = (int) (Math.random() * 9000 + 1000);
        return registCode;
    }


}
