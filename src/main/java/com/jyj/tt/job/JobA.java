package com.jyj.tt.job;

import com.jyj.tt.util.DateUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class JobA implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Date fireTime = jobExecutionContext.getFireTime();
        Date nextfireTime = jobExecutionContext.getNextFireTime();
        String name = jobExecutionContext.getJobDetail().getKey().getName();
        String jobName = jobExecutionContext.getJobDetail().getJobDataMap().getString("name");
        String group = jobExecutionContext.getJobDetail().getKey().getGroup();

        jobExecutionContext.getScheduler();
        System.out.println(jobName+"   "+group+"  "+ name+"  "+ DateUtil.dateFormat(fireTime,DateUtil.HOUR_PATTERN) +"任务运行了。。。。"
                +"下次运行时间：   "+DateUtil.dateFormat(nextfireTime,DateUtil.HOUR_PATTERN));
    }
}
