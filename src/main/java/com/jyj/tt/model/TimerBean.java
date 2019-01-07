package com.jyj.tt.model;

import org.apache.htrace.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 定时信息
 * 由客户端提交
 * 用户  设置  定时执行   任务A
 */
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
@Entity
public class TimerBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//定时id

    private String jobName; //任务名称
    private String jobGroupName;//任务组名
    private String triggerName; //触发名字
    private String triggerGroupName;//触发组名

    private String startTime;//开始时间
    private String endTime;//结束时间
    private int intervalTime; //间隔时间
    private int repeatCount;//重复次数
    private int userId;//用户id

    public TimerBean() {
    }

    public TimerBean(String jobName, String jobGroupName, String triggerName, String triggerGroupName, String startTime, String endTime, int intervalTime, int repeatCount, int userId) {
        this.jobName = jobName;
        this.jobGroupName = jobGroupName;
        this.triggerName = triggerName;
        this.triggerGroupName = triggerGroupName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.intervalTime = intervalTime;
        this.repeatCount = repeatCount;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroupName() {
        return jobGroupName;
    }

    public void setJobGroupName(String jobGroupName) {
        this.jobGroupName = jobGroupName;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTriggerGroupName() {
        return triggerGroupName;
    }

    public void setTriggerGroupName(String triggerGroupName) {
        this.triggerGroupName = triggerGroupName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getIntervalTime() {
        return intervalTime;
    }

    public void setIntervalTime(int intervalTime) {
        this.intervalTime = intervalTime;
    }

    public int getCount() {
        return repeatCount;
    }

    public void setCount(int repeatCount) {
        this.repeatCount = repeatCount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
