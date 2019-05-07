package com.bv.core.error;

import com.alibaba.fastjson.JSONObject;
import com.bv.core.base.BaseApiService;
import com.bv.core.base.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ProjectName: mall
 * @Package: com.bv.core.error
 * @ClassName: GlobalExceptionHandler
 * @Author: blovus
 * @Description: 全局捕获异常
 * @Date: 2019/5/7 23:45
 * @Version: 1.0
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends BaseApiService<JSONObject> {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public BaseResponse<JSONObject> exceptionHandler(Exception e) {
        log.info("###全局捕获异常###,error:{}", e);
        return setResultError("系统错误!");
    }

}
