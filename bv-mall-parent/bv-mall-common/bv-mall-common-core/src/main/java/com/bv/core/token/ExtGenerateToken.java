package com.bv.core.token;

import com.bv.core.templates.ExtRedisTemplate;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @ProjectName: mall
 * @Package: com.bv.core.token
 * @ClassName: ExtGenerateToken
 * @Author: blovus
 * @Description: 自定义常规token生成工具
 * @Date: 2019/5/13 22:36
 * @Version: 1.0
 */
@Component
public class ExtGenerateToken {

    @Autowired
    private ExtRedisTemplate extRedisTemplate;

    /**
     * @Method createToken
     * @Author blovus
     * @Version 1.0
     * @Description 生成令牌
     * @Param keyPrefix  令牌key前缀
     * @Param redisValue  redis存放的值
     * @Return java.lang.String
     * @Exception
     * @Date 2019/5/13 22:41
     */
    public String createToken(String keyPrefix, String redisValue) {
        return createToken(keyPrefix, redisValue, null);
    }

    /**
     * @Method createToken
     * @Author blovus
     * @Version 1.0
     * @Description 生成令牌
     * @Param keyPrefix  令牌key前缀
     * @Param redisValue redis存放的值
     * @Param time  有效期
     * @Return java.lang.String
     * @Exception
     * @Date 2019/5/13 22:40
     */
    public String createToken(String keyPrefix, String redisValue, Long time) {
        if (StringUtils.isEmpty(redisValue)) {
            new Exception("redisValue Not nul");
        }
        String token = keyPrefix + UUID.randomUUID().toString().replace("-", "");
        extRedisTemplate.setString(token, redisValue, time);
        return token;
    }

    /**
     * @Method getToken
     * @Author blovus
     * @Version 1.0
     * @Description 根据token获取redis中的value值
     * @Param token
     * @Return java.lang.String
     * @Exception
     * @Date 2019/5/13 22:40
     */
    public String getToken(String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        String value = extRedisTemplate.getString(token);
        return value;
    }

    /**
     * @Method removeToken
     * @Author blovus
     * @Version 1.0
     * @Description 移除token
     * @Param token
     * @Return java.lang.Boolean
     * @Exception
     * @Date 2019/5/13 22:40
     */
    public Boolean removeToken(String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }

        return extRedisTemplate.delKey(token);

    }


}
