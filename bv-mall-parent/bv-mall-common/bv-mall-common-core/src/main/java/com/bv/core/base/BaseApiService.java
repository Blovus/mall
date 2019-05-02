package com.bv.core.base;

import com.bv.core.constants.ExtConstants;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: mall
 * @Package: com.bv.core.base
 * @ClassName: BaseApiService
 * @Author: blovus
 * @Description: service抽取
 * @Date: 2019/5/2 23:27
 * @Version: 1.0
 */
@Data
@Component
public class BaseApiService<T> {
    public BaseResponse<T> setResultError(Integer code, String msg) {
        return setResult(code, msg, null);
    }

    // 返回错误，可以传msg
    public BaseResponse<T> setResultError(String msg) {
        return setResult(ExtConstants.HTTP_RES_CODE_500, msg, null);
    }

    // 返回成功，可以传data值
    public BaseResponse<T> setResultSuccess(T data) {
        return setResult(ExtConstants.HTTP_RES_CODE_200, ExtConstants.HTTP_RES_CODE_200_VALUE, data);
    }

    // 返回成功，沒有data值
    public BaseResponse<T> setResultSuccess() {
        return setResult(ExtConstants.HTTP_RES_CODE_200, ExtConstants.HTTP_RES_CODE_200_VALUE, null);
    }

    // 返回成功，沒有data值
    public BaseResponse<T> setResultSuccess(String msg) {
        return setResult(ExtConstants.HTTP_RES_CODE_200, msg, null);
    }

    // 通用封装
    public BaseResponse<T> setResult(Integer code, String msg, T data) {
        return new BaseResponse<T>(code, msg, (T) data);
    }

}
