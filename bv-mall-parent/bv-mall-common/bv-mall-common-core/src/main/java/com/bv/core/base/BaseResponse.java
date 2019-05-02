package com.bv.core.base;

import lombok.Data;

/**
 * @ProjectName: mall
 * @Package: com.bv.core.base
 * @ClassName: BaseResponse
 * @Author: blovus
 * @Description: 返回对象抽取
 * @Date: 2019/5/2 23:31
 * @Version: 1.0
 */
@Data
public class BaseResponse<T> {

    private Integer rtnCode;
    private String msg;
    private T data;

    public BaseResponse() {

    }

    public BaseResponse(Integer rtnCode, String msg, T data) {
        super();
        this.rtnCode = rtnCode;
        this.msg = msg;
        this.data = data;
    }

}
