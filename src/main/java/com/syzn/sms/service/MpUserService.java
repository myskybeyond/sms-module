package com.syzn.sms.service;

import me.chanjar.weixin.mp.bean.result.WxMpUser;

/**
 * @description:
 * @author: JianTao Li
 * @time: 2023/6/19 16:43
 * @email: myskybeyond@gmail.com
 */
public interface MpUserService {

    /**
     * 关注公众号绑定关系
     * @param wxMpUser
     */
    void saveUser(WxMpUser wxMpUser);

    /**
     * 取消关注
     * @param openId
     */
    void cancelSubscribe(String openId);
}
