-- 用户会员表
DROP TABLE IF EXISTS `mall_user`;
CREATE TABLE `mall_user`
(
    `id_mall_user` int(18)     NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `mobile`       varchar(11) NOT NULL COMMENT '手机号',
    `email`        varchar(50) NOT NULL COMMENT '邮箱号',
    `password`     varchar(64) NOT NULL COMMENT '密码',
    `user_name`    varchar(50)          DEFAULT NULL COMMENT '用户名',
    `sex`          tinyint(1)           DEFAULT '0' COMMENT '性别  1男  2女',
    `age`          tinyint(3)           DEFAULT '0' COMMENT '年龄',
    `pic_img`      varchar(255)         DEFAULT NULL COMMENT '用户头像',
    `qq_openid`    varchar(50)          DEFAULT NULL COMMENT 'QQ联合登陆id',
    `wx_openid`    varchar(50)          DEFAULT NULL COMMENT '微信公众号关注id',
    `is_valid`     tinyint(1)           DEFAULT '0' COMMENT '是否可用 0正常  1冻结',
    `create_by`    int(18)              DEFAULT NULL COMMENT '创建用户',
    `create_time`  timestamp   NOT NULL DEFAULT NOW() COMMENT '创建时间',
    `update_by`    int(18)              DEFAULT NULL COMMENT '更新用户',
    `update_time`  timestamp   NOT NULL DEFAULT NOW() COMMENT '更新时间',
    PRIMARY KEY (`ID_MALL_USER`),
    UNIQUE KEY `MOBILE_UNIQUE` (`MOBILE`),
    UNIQUE KEY `USER_NAME_UNIQUE` (`USER_NAME`),
    UNIQUE KEY `EMAIL_UNIQUE` (`EMAIL`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='用户会员表';


-- 用户登陆票据表
DROP TABLE IF EXISTS `mall_user_token`;

CREATE TABLE `mall_user_token`
(
    `id_mall_user_token` int(18)      NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `id_mall_user`       int(18)               DEFAULT '1' COMMENT '用户会员表id',
    `user_token`         varchar(255) NOT NULL COMMENT '用户票据',
    `login_type`         int(3)       NOT NULL DEFAULT '1' COMMENT '登录端类型 0-测试使用 1-pc 2-安卓 3-ios 4-微信 99-未知 ',
    `device_info`        varchar(255)          DEFAULT NULL comment '登陆设备',
    `is_valid`           tinyint(1)   NOT NULL DEFAULT '0' COMMENT '是否可用 0正常  1冻结',
    `create_by`          int(18)      NOT NULL COMMENT '创建用户',
    `create_time`        timestamp    NOT NULL DEFAULT NOW() COMMENT '创建时间',
    `update_by`          int(18)      NOT NULL COMMENT '更新用户',
    `update_time`        timestamp    NOT NULL DEFAULT NOW() COMMENT '更新时间',
    PRIMARY KEY (`id_mall_user_token`)
) ENGINE = InnoDB
