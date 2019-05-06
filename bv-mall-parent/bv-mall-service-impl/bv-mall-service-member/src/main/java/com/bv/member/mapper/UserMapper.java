package com.bv.member.mapper;

import com.bv.member.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ProjectName: mall
 * @Package: com.bv.member.mapper
 * @ClassName: UserMapper
 * @Author: blovus
 * @Description: 用户会员表mapper层
 * @Date: 2019/5/4 19:19
 * @Version: 1.0
 */
public interface UserMapper {

    Integer insert(UserEntity userEntity);

    UserEntity getById(@Param("id") String id);

    UserEntity getByMobile(@Param("mobile") String mobile);

}
