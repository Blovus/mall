DROP TABLE IF EXISTS `mall_user`;
CREATE TABLE `mall_user`
(
    `ID_MALL_USER` int(18)     NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `MOBILE`       varchar(11) NOT NULL COMMENT '手机号',
    `EMAIL`        varchar(50) NOT NULL COMMENT '邮箱号',
    `PASSWORD`     varchar(64) NOT NULL COMMENT '密码',
    `USER_NAME`    varchar(50)          DEFAULT NULL COMMENT '用户名',
    `SEX`          tinyint(1)           DEFAULT '0' COMMENT '性别  1男  2女',
    `AGE`          tinyint(3)           DEFAULT '0' COMMENT '年龄',
    `PIC_IMG`      varchar(255)         DEFAULT NULL COMMENT '用户头像',
    `QQ_OPENID`    varchar(50)          DEFAULT NULL COMMENT 'QQ联合登陆id',
    `WX_OPENID`    varchar(50)          DEFAULT NULL COMMENT '微信公众号关注id',
    `IS_VALID`     tinyint(1)           DEFAULT '1' COMMENT '是否可用 1正常  2冻结',
    `CREATE_BY`    int(18)              DEFAULT NULL COMMENT '创建用户',
    `CREATE_TIME`  timestamp   NOT NULL DEFAULT NOW() COMMENT '创建时间',
    `UPDATE_BY`    int(18)              DEFAULT NULL COMMENT '更新用户',
    `UPDATE_TIME`  timestamp   NOT NULL DEFAULT NOW() COMMENT '更新时间',
    PRIMARY KEY (`ID_MALL_USER`),
    UNIQUE KEY `MOBILE_UNIQUE` (`MOBILE`),
    UNIQUE KEY `USER_NAME_UNIQUE` (`USER_NAME`),
    UNIQUE KEY `EMAIL_UNIQUE` (`EMAIL`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 25
  DEFAULT CHARSET = utf8 COMMENT ='用户会员表';
