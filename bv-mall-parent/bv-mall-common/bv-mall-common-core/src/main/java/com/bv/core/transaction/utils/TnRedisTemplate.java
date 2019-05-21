package com.bv.core.transaction.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: mall
 * @Package: com.bv.core.transaction.utils
 * @ClassName: TnRedisTemplate
 * @Author: blovus
 * @Description: 事务下使用的redisTemplate
 * @Date: 2019/5/20 23:00
 * @Version: 1.0
 */
@Scope(ConfigurableListableBeanFactory.SCOPE_PROTOTYPE)
@Component("TnRedisTemplate")
public class TnRedisTemplate {

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 开启Redis 事务
     */
    public void begin() {
        // 开启Redis 事务权限
        redisTemplate.setEnableTransactionSupport(true);
        // 开启事务
        redisTemplate.multi();

    }

    /**
     * 提交事务
     */
    public void exec() {
        // 成功提交事务
        redisTemplate.exec();
    }

    /**
     * 回滚Redis 事务
     */
    public void discard() {
        redisTemplate.discard();
    }


}
