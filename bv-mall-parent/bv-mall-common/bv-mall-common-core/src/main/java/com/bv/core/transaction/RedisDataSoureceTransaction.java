package com.bv.core.transaction;

import com.bv.core.transaction.utils.TnRedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

/**
 * @ProjectName: mall
 * @Package: com.bv.core.transaction
 * @ClassName: RedisDataSoureceTransaction
 * @Author: blovus
 * @Description: redis整合数据库事务 （以后写框架 ，目前暂且这样弄）
 * @Date: 2019/5/20 22:42
 * @Version: 1.0
 */
@Component("RedisDataSoureceTransaction")
@Scope(ConfigurableListableBeanFactory.SCOPE_PROTOTYPE)
public class RedisDataSoureceTransaction {

    @Autowired
    private TnRedisTemplate redisTemplate;
    /**
     * 数据源事务管理器
     */
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    /**
     * 开始事务 采用默认传播行为
     *
     * @return
     */
    public TransactionStatus begin() {
        // 手动begin数据库事务
        // 1.开启数据库的事务 事务传播行为
        TransactionStatus transaction = dataSourceTransactionManager.getTransaction(new DefaultTransactionAttribute());
        // 2.开启redis事务
        redisTemplate.begin();
        return transaction;
    }

    /**
     * 提交事务
     *
     * @param transactionStatus 事务传播行为
     * @throws Exception
     */
    public void commit(TransactionStatus transactionStatus) throws Exception {
        if (transactionStatus == null) {
            throw new Exception("transactionStatus is null");
        }
        // 支持Redis与数据库事务同时提交
        dataSourceTransactionManager.commit(transactionStatus);
    }

    /**
     * 回滚事务
     *
     * @param transactionStatus
     * @throws Exception
     */
    public void rollback(TransactionStatus transactionStatus) throws Exception {
        if (transactionStatus == null) {
            throw new Exception("transactionStatus is null");
        }
        // 1.回滚数据库事务 redis事务和数据库的事务同时回滚
        dataSourceTransactionManager.rollback(transactionStatus);
        // // 2.回滚redis事务
        // redisUtil.discard();
    }
    // 如果redis的值与数据库的值保持不一致话


}
