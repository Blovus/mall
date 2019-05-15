package com.bv.member.mapper;

import com.bv.member.mapper.entity.UserTokenDO;
import org.apache.ibatis.annotations.Param;

/**
 * @ProjectName: mall
 * @Package: com.bv.member.mapper.xml
 * @ClassName: UserTokenMapper
 * @Author: blovus
 * @Description: 用户token表mapper层
 * @Date: 2019/5/14 21:50
 * @Version: 1.0
 */
public interface UserTokenMapper {

    /**
     * @Method getByUserIdAndLoginType
     * @Author blovus
     * @Version 1.0
     * @Description 根据用户和登陆状态查询数据
     * @Param userId
     * @Param loginType
     * @Return com.bv.member.mapper.entity.UserTokenDo
     * @Exception
     * @Date 2019/5/14 22:04
     */
    UserTokenDO getByUserIdAndLoginType(@Param("userId") Long userId, @Param("loginType") String loginType);

    /**
     * @Method updateTokenValid
     * @Author blovus
     * @Version 1.0
     * @Description 根据userId和loginType将数据更新为不可以
     * @Param userId
     * @Param loginType
     * @Return int
     * @Exception
     * @Date 2019/5/14 22:04
     */
    int deleteByUserIdAndloginType(@Param("userId") Long userId, @Param("loginType") String loginType);

    /**
     * @Method insertUserToken
     * @Author blovus
     * @Version 1.0
     * @Description 新增数据
     * @Param userTokenDo
     * @Return int
     * @Exception
     * @Date 2019/5/14 22:04
     */
    int insert(UserTokenDO userTokenDo);


}
