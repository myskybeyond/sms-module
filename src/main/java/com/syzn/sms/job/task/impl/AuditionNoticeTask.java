//package com.syzn.sms.job.task.impl;
//
//import cn.hutool.core.date.DateUtil;
//import com.qinzs.service.quartzJob.task.ITask;
//import com.qinzs.service.sch.SchAuditonRegisterService;
//import com.qinzs.service.sms.SmsSendService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
///**
// * @author Jiantao Li
// * @date 2019/9/6 17:54
// */
//@Slf4j
//@Component("auditionNoticeTask")
//public class AuditionNoticeTask implements ITask {
//    @Autowired
//    private SmsSendService smsSendService;
//
//    @Autowired
//    private SchAuditonRegisterService auditonRegisterService;
//    @Override
//    public void run(String params) {
//        log.debug("学员试听提醒作业任务执行-时间:{}", DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
//        /**
//         * 查询目标用户-执行发短信动作
//         */
//        List<Map<String, Object>> list = auditonRegisterService.queryAuditonStudent();
//        log.debug("学员试听提醒-我给你发短信了啊！");
////            smsSendService.sendSms(SmsUsage.RMD,"18603273132",null);
//    }
//}
