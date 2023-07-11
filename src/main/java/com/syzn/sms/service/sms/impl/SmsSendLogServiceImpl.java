package com.syzn.sms.service.sms.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.syzn.sms.domain.SmsSendEntity;
import com.syzn.sms.mapper.SmsSendMapper;
import com.syzn.sms.service.sms.SmsSendLogService;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: JianTao Li
 * @time: 2023/6/20 8:41
 * @email: myskybeyond@gmail.com
 */
@Service
public class SmsSendLogServiceImpl extends ServiceImpl<SmsSendMapper, SmsSendEntity> implements SmsSendLogService {
}
