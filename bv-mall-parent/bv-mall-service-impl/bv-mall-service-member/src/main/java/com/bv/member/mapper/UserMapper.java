package com.bv.member.mapper;

import com.bv.member.mapper.entity.UserDO;
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

    int insert(UserDO userDO);

    UserDO getById(@Param("id") Long id, @Param("valid") Integer valid);

    UserDO getByMobile(@Param("mobile") String mobile, @Param("valid") Integer valid);

    UserDO getByMobileAndPassword(@Param("mobile") String mobile, @Param("password") String password, @Param("valid") String valid);


}
