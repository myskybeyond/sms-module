package com.syzn.sms.mapper;

import com.syzn.sms.job.task.bean.mp.DutyNoticeTemplateBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: JianTao Li
 * @time: 2023/6/19 14:07
 * @email: myskybeyond@gmail.com
 */
@Mapper
public interface DutyPlanMapper {

    List<DutyNoticeTemplateBean> queryDutyPlans(@Param("startDt") String startDt,@Param("endDt") String endDt);
}
