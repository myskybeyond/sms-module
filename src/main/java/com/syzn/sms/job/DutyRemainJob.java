package com.syzn.sms.job;

import cn.hutool.json.JSONUtil;
import com.syzn.sms.config.SMSConfig;
import com.syzn.sms.config.WxMpConfig;
import com.syzn.sms.job.task.bean.TaskParamBean;
import com.syzn.sms.job.task.impl.NoticePush.DutyNoticeTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @description: 值日提醒任务
 * @author: JianTao Li
 * @time: 2023/6/19 12:09
 * @email: myskybeyond@gmail.com
 */
@Component
@Slf4j
public class DutyRemainJob {

    private final static String TASK_NAME = "值日排班提醒";

    private final DutyNoticeTask dutyNoticeTask;
    private final SMSConfig smsConfig;

    private final WxMpConfig wxMpConfig;

    @Value("${mail.enable}")
    private Boolean mailEnabled;

    public DutyRemainJob(DutyNoticeTask dutyNoticeTask,
                         SMSConfig smsConfig,
                         WxMpConfig wxMpConfig
                         ){
        this.dutyNoticeTask = dutyNoticeTask;
        this.smsConfig = smsConfig;
        this.wxMpConfig = wxMpConfig;
    }

    String initParam(){
        TaskParamBean param = new TaskParamBean();
        param.setAllowSms(smsConfig.getEnable());
        param.setAllowWpTemplateMsg(wxMpConfig.getEnable());
        param.setAllowMail(mailEnabled);
        log.warn("自动作业：{}参数初始化、短消息开关:{}-微信公众号模版消息开关:{}-163邮箱消息开关:{}",TASK_NAME,smsConfig.getEnable(),wxMpConfig.getEnable(),mailEnabled);
        return JSONUtil.toJsonStr(param);
    }

    @Scheduled(cron = "0/5 * * * * ?")
//    @Scheduled(cron = "0 0 8 * * ?")
    public void run(){
        log.info("自动作业：{}开始执行....",TASK_NAME);
        String paramStr = initParam();
//        dutyNoticeTask.run(paramStr);
        log.info("自动作业：{}执行结束...",TASK_NAME);
    }
}
