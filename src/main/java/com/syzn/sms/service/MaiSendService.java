package com.syzn.sms.service;

/**
 * @description:
 * @author: JianTao Li
 * @time: 2023/6/21 9:38
 * @email: myskybeyond@gmail.com
 */
public interface MaiSendService {

    void send(String to,String subject,String content);


}
