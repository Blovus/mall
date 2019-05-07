package com.bv.core.utils;

import org.springframework.beans.BeanUtils;

/**
 * @ProjectName: mall
 * @Package: com.bv.core.utils
 * @ClassName: ExtBeanUtils
 * @Author: blovus
 * @Description: 自定义对象转换工具类
 * @Date: 2019/5/7 23:05
 * @Version: 1.0
 */
public class ExtBeanUtils {

    /**
     * @Method dtoToDo
     * @Author blovus
     * @Version 1.0
     * @Description dot 转换为Do 工具类
     * @Param dtoEntity
     * @Param doClass
     * @Return Do
     * @Exception
     * @Date 2019/5/7 23:05
     */
    public static <Do> Do dtoToDo(Object dtoEntity, Class<Do> doClass) {
        // 判断dto是否为空!
        if (dtoEntity == null) {
            return null;
        }
        // 判断DoClass 是否为空
        if (doClass == null) {
            return null;
        }
        try {
            Do newInstance = doClass.newInstance();
            BeanUtils.copyProperties(dtoEntity, newInstance);
            // Dto转换Do
            return newInstance;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @Method doToDto
     * @Author blovus
     * @Version 1.0
     * @Description do 转换为Dto 工具类
     * @Param doEntity
     * @Param dtoClass
     * @Return Dto
     * @Exception
     * @Date 2019/5/7 23:07
     */
    public static <Dto> Dto doToDto(Object doEntity, Class<Dto> dtoClass) {
        // 判断dto是否为空!
        if (doEntity == null) {
            return null;
        }
        // 判断DoClass 是否为空
        if (dtoClass == null) {
            return null;
        }
        try {
            Dto newInstance = dtoClass.newInstance();
            BeanUtils.copyProperties(doEntity, newInstance);
            // Dto转换Do
            return newInstance;
        } catch (Exception e) {
            return null;
        }
    }

}
