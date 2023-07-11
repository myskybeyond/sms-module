package com.syzn.sms.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * job会由于异常发生导出数据库中的触发状态为error,error后任务将不会再继续触发（造成这个原因说是由于集群的关系-待考证）
 * 人工处理下-程序启动后重置下job的触发状态
 *
 * @author Jiantao Li
 * @date 2019/4/29 9:57
 */
@Component
@Order(1)
@Slf4j
public class JobTrigger implements ApplicationRunner {

//    @Autowired
//    private QuartzManager quartzManager;
//
    @Override
    public void run(ApplicationArguments args) throws Exception {
//        log.debug("程序启动后重置下job的触发状态");
//        List<Map<String, Object>> jobs = quartzManager.queryAllJob();
//        for (Map<String, Object> job : jobs) {
//            String jobStat = (String) job.get("jobStatus");
//            if ("ERROR".equals(jobStat)) {
//                log.debug("执行resume任务-任务名称:{},任务组名称:{}", (String) job.get("jobName"), (String) job.get("jobGroupName"));
//                quartzManager.resumeJob((String) job.get("jobName"), (String) job.get("jobGroupName"));
//            }
//        }
    }
}
