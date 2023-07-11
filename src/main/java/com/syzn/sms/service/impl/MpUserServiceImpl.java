package com.syzn.sms.service.impl;

import com.syzn.sms.service.MpUserService;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: JianTao Li
 * @time: 2023/6/19 16:44
 * @email: myskybeyond@gmail.com
 */
@Service
public class MpUserServiceImpl implements MpUserService {
    @Override
    public void saveUser(WxMpUser wxMpUser) {
        // TODO: 2023/6/19 待根据表结构编写代码
    }

    @Override
    public void cancelSubscribe(String openId) {
// TODO: 2023/6/19 待根据表结构编写代码
    }
}
