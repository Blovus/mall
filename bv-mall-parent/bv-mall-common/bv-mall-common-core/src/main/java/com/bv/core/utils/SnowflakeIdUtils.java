package com.bv.core.utils;

/**
 * @ProjectName: mall
 * @Package: com.bv.core.utils
 * @ClassName: SnowflakeIdUtils
 * @Author: blovus
 * @Description: 基于雪花算法实现的id生成器
 * @Date: 2019/5/14 22:21
 * @Version: 1.0
 */
public class SnowflakeIdUtils {
    private static SnowflakeIdWorker idWorker;

    static {
        // 使用静态代码块初始化 SnowflakeIdWorker
        idWorker = new SnowflakeIdWorker(1, 1);
    }

    public static String getId() {
        return idWorker.nextId() + "";
    }

}
