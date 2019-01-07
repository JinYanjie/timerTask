package com.jyj.tt.util;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

public class SchedulerUtil {

    public static Scheduler handleSimpleTrigger(String jobName, //任务名称
                                                String jobGroupName,//任务组名
                                                String triggerName, //触发名字
                                                String triggerGroupName,//触发组名
                                                long startTime,//开始时间
                                                long endTime,//结束时间
                                                Class jobClass,//启动哪个任务
                                                int intervalTime, //间隔时间
                                                int repeatCount) {

        SchedulerFactory schedulerfactory = new StdSchedulerFactory();
        Scheduler scheduler = null;
        try {
            scheduler = schedulerfactory.getScheduler();
            JobDetail job = JobBuilder.newJob(jobClass)
                    .withIdentity(jobName).build();
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity(triggerName)
                    .withSchedule(
                            SimpleScheduleBuilder.repeatSecondlyForever(intervalTime)
                                    .withRepeatCount(repeatCount))
                    .startAt(new Date(startTime))
                    .endAt(new Date(endTime))
                    .startNow()
                    .build();
            scheduler.scheduleJob(job, trigger);
            scheduler.start();


        } catch (Exception e) {
            System.out.println("执行" + jobName + "组" + jobName + "任务出现异常E:[" + e.getMessage() + "]");
        }
        return scheduler;
    }

    //取消定时任务
    public static Scheduler cancelJob(String jobName,
                                      String triggerName,//任务名称
                                      int userId) {
        SchedulerFactory schedulerfactory = new StdSchedulerFactory();
        Scheduler scheduler = null;
        try {
            scheduler = schedulerfactory.getScheduler();
            scheduler.pauseTrigger(new TriggerKey(triggerName + userId));
            scheduler.unscheduleJob(new TriggerKey(triggerName + userId));
            scheduler.deleteJob(new JobKey(jobName + userId));
            scheduler.shutdown();

        } catch (Exception e) {
            System.out.println("执行" + jobName + "组" + jobName + "任务出现异常E:[" + e.getMessage() + "]");
        }
        return scheduler;
    }

    //修改定时任务
    public static void modifyJobTime(String jobName,
                                     String triggerName,//任务名称
                                     int userId,
                                     long startTime,//开始时间
                                     long endTime,//结束时间
                                     int intervalTime, //间隔时间
                                     int repeatCount) {
        SchedulerFactory schedulerfactory = new StdSchedulerFactory();
        Scheduler scheduler = null;
        try {
            scheduler = schedulerfactory.getScheduler();
            Trigger trigger = scheduler.getTrigger(new TriggerKey(triggerName + userId));
            if (trigger == null) {
                return;
            }

            TriggerBuilder<SimpleTrigger> triggerBuilder = (TriggerBuilder<SimpleTrigger>) trigger.getTriggerBuilder();
            SimpleTrigger build = triggerBuilder
                    .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(intervalTime).withRepeatCount(repeatCount))
                    .startAt(new Date(startTime))
                    .endAt(new Date(endTime))
                    .build();

            scheduler.resumeTrigger(build.getKey());

        } catch (Exception e) {
            System.out.println("执行" + jobName + "组" + jobName + "任务出现异常E:[" + e.getMessage() + "]");
        }
    }

    public static void hadleCronTrigger(String jobName, String jobGroupName,
                                        String triggerName, String triggerGroupName, Class jobClass, String cron) {
        SchedulerFactory schedulerfactory = new StdSchedulerFactory();
        Scheduler scheduler = null;
        try {
            scheduler = schedulerfactory.getScheduler();
            JobDetail job = JobBuilder.newJob(jobClass)
                    .withIdentity(jobName, jobGroupName).build();
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerName, triggerGroupName)
                    .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                    .startNow().build();
            scheduler.scheduleJob(job, trigger);
            scheduler.start();
        } catch (Exception e) {
        }
    }

}
