package com.syzn.sms.job.task.impl.NoticePush;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.syzn.sms.exception.SmszsBaseException;
import com.syzn.sms.job.task.ITask;
import com.syzn.sms.job.task.bean.TaskParamBean;
import com.syzn.sms.job.task.bean.mp.DutyNoticeTemplateBean;
import com.syzn.sms.mapper.DutyPlanMapper;
import com.syzn.sms.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.MessageFormat;
import java.util.*;

import static com.syzn.sms.constants.Const.REGEX_MOBILE;
import static com.syzn.sms.constants.SmsUsage.DUTY_NOTICE;

/**
 * 值日排班提醒任务类
 *
 * @author Jiantao Li
 * @date 2019/9/6 17:39
 */
@Slf4j
@Component("DutyNoticeTask")
public class DutyNoticeTask extends AbstractNoticeTask<DutyNoticeTemplateBean> implements ITask {

    private final static String MAIL_TEMPLATE = "系统自动提醒:【{0}】您好，【{1}】({2})需要你打扫【{3}】区域，值日工作在8:30前完成，请提前安排时间！与你同天值日的还有【{4}】";
    private final static String MAIL_SUBJECT = "上元智能值日提醒";

    @Resource
    private DutyPlanMapper dutyPlanMapper;

    @Value("${duty.remain.before.days}")
    private Integer remainBeforeDays;

    List<DutyNoticeTemplateBean> pushData = new ArrayList<>();

    @Override
    public void run(String params) {
        log.debug("值日提醒作业任务执行-时间:{}", DateUtil.now());
        TaskParamBean param = JSONUtil.toBean(params, TaskParamBean.class);
        this.executeTask(param);
    }

    @Override
    public List<DutyNoticeTemplateBean> prepareTaskContent() {
        log.info("值日提前{}天提醒", remainBeforeDays);
        String[] dateArray = DateUtils.getOffsetDays(remainBeforeDays);
        if (dateArray.length < 1) {
            log.error("未获取到排班日期,不执行推送消息服务...");
        }
        pushData = dutyPlanMapper.queryDutyPlans(dateArray[0], dateArray[dateArray.length - 1]);
        if (Objects.isNull(pushData) || pushData.size() == 0) {
            log.warn("{}-{}无值日排班...", dateArray[0], dateArray[dateArray.length - 1]);
        }
        return pushData;
    }

    /**
     * 发送上课提醒微信模版消息
     */
    @Override
    public boolean sendTemplateMsg(DutyNoticeTemplateBean notice) throws WxErrorException {
        if (StrUtil.isNotBlank(notice.getAppId())) {
            WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder().toUser(notice.getAppId()).templateId(notice.getTemplateId()).build();
            templateMessage.addData(new WxMpTemplateData("first", MessageFormat.format("{0}您好", notice.getDutyEmployeeName())));
            templateMessage.addData(new WxMpTemplateData("keyword1", notice.getDutyAreaName()));
            templateMessage.addData(new WxMpTemplateData("keyword2", notice.getDutyDate().toString()));
            templateMessage.addData(new WxMpTemplateData("remark", "区域，请关注！【" + notice.getOrgName() + "】"));
            wxService.getTemplateMsgService().sendTemplateMsg(templateMessage);
            return true;
        } else {
            log.info("学员:【{}】未关注上元智能公众号，无法推送值日排班提醒模版消息。", notice.getDutyEmployeeName());
            return false;
        }
    }

    /**
     * 发送上课提醒短信息
     */
    @Override
    public boolean sendSms(DutyNoticeTemplateBean stud) throws SmszsBaseException {
        if (StrUtil.isNotBlank(stud.getMobile()) && stud.getMobile().matches(REGEX_MOBILE)) {
            Map<String, String> smsVariableMap = new HashMap<>();
            smsVariableMap.put("name", stud.getDutyEmployeeName());
            smsVariableMap.put("dutyDt", DateUtil.format(stud.getDutyDate(), DatePattern.NORM_DATE_FORMAT));
            smsVariableMap.put("dutyArea", stud.getDutyAreaName());
            smsSendService.sendSms(stud.getOrgId(), DUTY_NOTICE, stud.getMobile(), smsVariableMap);
            return true;
        } else {
            log.info("推送值日提醒失败，员工:【{}】没有预留有效的手机号。手机号：{}", stud.getDutyEmployeeName(), stud.getMobile());
            return false;
        }

    }

    @Override
    public boolean sendMail(DutyNoticeTemplateBean content) {
        String to = content.getEmail();
        if (StrUtil.isNotBlank(to)) {
            Date dutyDate = content.getDutyDate();
            String sameDayDutyEmployees = getSameDayDutyEmployee(dutyDate, content.getDutyEmployeeName());
            String dayOfWeek = DateUtils.getDayOfWeek(dutyDate);
            String message = MessageFormat.format(MAIL_TEMPLATE, content.getDutyEmployeeName(), DateUtil.format(dutyDate, DatePattern.NORM_DATE_FORMAT), dayOfWeek,content.getDutyAreaName(), sameDayDutyEmployees);
            maiSendService.send(to, MAIL_SUBJECT, message);
            return true;
        } else {
            log.info("推送值日提醒失败，员工:【{}】没有预留有效的163邮箱。邮箱：{}", content.getDutyEmployeeName(), to);
            return false;
        }
    }

    /**
     * 获取同天值日的员工姓名
     *
     * @param dutyDt          值日日期
     * @param excludeEmployee 需去除的员工
     * @return 多个员工以逗号分隔
     */
    private String getSameDayDutyEmployee(Date dutyDt, String excludeEmployee) {
        /**
         * 员工去重
         */
        Set<String> set = new HashSet<>();
        pushData.forEach(d -> {
            if (dutyDt.equals(d.getDutyDate()) && !excludeEmployee.equals(d.getDutyEmployeeName())) {
                set.add(d.getDutyEmployeeName());
            }
        });
        StringBuilder sb = new StringBuilder();
        set.forEach(s -> {
            sb.append(s);
            sb.append(" ");
        });
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
