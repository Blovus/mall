package com.bv.wechat.entity;

import lombok.Data;

/**
 * @ProjectName: mall
 * @Package: com.bv.wechat.entity
 * @ClassName: AppEntity
 * @Author: blovus
 * @Description: App实体类层
 * @Date: 2019/4/28 0:02
 * @Version: 1.0
 */
@Data
public class AppEntity {
    /**
     * id
     */
    private String appId;
    /**
     * 应用名称
     */
    private String appName;

    public AppEntity() {

    }

    public AppEntity(String appId, String appName) {
        super();
        this.appId = appId;
        this.appName = appName;
    }
}
