package com.bv.member.mapper.converter;

import com.bv.core.converter.Converter;
import com.bv.core.utils.ExtBeanUtils;
import com.bv.member.dto.input.UserInDTO;
import com.bv.member.mapper.entity.UserDO;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: mall
 * @Package: com.bv.member.mapper.converter
 * @ClassName: UserInfoConverter
 * @Author: blovus
 * @Description: UserInConverter
 * @Date: 2019/5/7 22:55
 * @Version: 1.0
 */
@Service("UserInConverter")
public class UserInConverter  extends Converter<UserDO, UserInDTO> {


    @Override
    protected UserInDTO defaultInvert(UserDO userDO) throws Exception {

        return ExtBeanUtils.doToDto(userDO,UserInDTO.class);
    }

    @Override
    protected UserDO defaultConvert(UserInDTO userInDTO) throws Exception {
        return ExtBeanUtils.dtoToDo(userInDTO,UserDO.class);
    }
}
