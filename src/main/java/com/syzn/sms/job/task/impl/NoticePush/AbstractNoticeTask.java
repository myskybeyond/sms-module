package com.syzn.sms.job.task.impl.NoticePush;

import com.syzn.sms.exception.SmszsBaseException;
import com.syzn.sms.job.task.bean.TaskParamBean;
import com.syzn.sms.service.MaiSendService;
import com.syzn.sms.service.SmsSendService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 消息推送抽象类
 *
 * @author Jiantao Li
 * @date 2019/10/12 11:42
 */
@Slf4j
public abstract class AbstractNoticeTask<T> {

    @Autowired
    public WxMpService wxService;
    @Autowired
    public SmsSendService smsSendService;
    @Autowired
    public MaiSendService maiSendService;

    /**
     * 任务发送内容抽象方法
     * @return
     */
    public abstract List<T> prepareTaskContent();

    /**
     * 发送微信模版消息提醒
     *
     * @return
     */
    public abstract boolean sendTemplateMsg(T content) throws WxErrorException;

    /**
     * 发送短消息提醒
     *
     * @return
     */
    public abstract boolean sendSms(T content) throws SmszsBaseException;

    public abstract boolean sendMail(T content);

    /**
     * 执行任务
     *
     * @param param       任务参数
     */
    public void executeTask(TaskParamBean param) {
        List<T> taskContent = prepareTaskContent();
       taskContent.forEach(content -> {
           log.info("消息推送、msg：{}",content);
           boolean sendStat = false;
           try {
               if(param.isAllowSms()){
                   sendStat = sendSms(content);
               }
               if(param.isAllowWpTemplateMsg()){
                   sendStat = sendTemplateMsg(content);
               }
               if(param.isAllowMail()){
                   sendStat = sendMail(content);
               }
               if(!sendStat){
                   log.error("消息推送失败...");
               }
           } catch (SmszsBaseException | WxErrorException  e) {
               e.printStackTrace();
           }
       });
    }
}
