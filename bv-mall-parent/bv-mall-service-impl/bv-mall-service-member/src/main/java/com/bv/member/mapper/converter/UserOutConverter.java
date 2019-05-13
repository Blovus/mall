package com.bv.member.mapper.converter;

import com.bv.core.converter.Converter;
import com.bv.core.utils.ExtBeanUtils;
import com.bv.member.dto.output.UserOutDTO;
import com.bv.member.mapper.entity.UserDO;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: mall
 * @Package: com.bv.member.mapper.converter
 * @ClassName: UserOutConverter
 * @Author: blovus
 * @Description: UserOutConverter
 * @Date: 2019/5/7 22:55
 * @Version: 1.0
 */
@Service("UserOutConverter")
public class UserOutConverter extends Converter<UserDO, UserOutDTO> {


    @Override
    protected UserOutDTO defaultInvert(UserDO userDO)  {

        return ExtBeanUtils.doToDto(userDO, UserOutDTO.class);
    }

    @Override
    protected UserDO defaultConvert(UserOutDTO userOutDTO) {
        return ExtBeanUtils.dtoToDo(userOutDTO, UserDO.class);
    }
}
