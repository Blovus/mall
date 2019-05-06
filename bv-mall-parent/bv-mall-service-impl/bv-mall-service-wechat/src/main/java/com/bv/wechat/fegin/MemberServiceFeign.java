package com.bv.wechat.fegin;

import com.bv.member.service.MemberService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @ProjectName: mall
 * @Package: com.bv.wechat.fegin
 * @ClassName: MemberServiceFegin
 * @Author: blovus
 * @Description: member接口调用
 * @Date: 2019/5/4 20:18
 * @Version: 1.0
 */
@FeignClient("app-bv-member")
public interface MemberServiceFeign extends MemberService {

}
