package com.jyj.tt.controller;

import com.github.pagehelper.PageInfo;
import com.jyj.tt.job.JobA;
import com.jyj.tt.model.TimerBean;
import com.jyj.tt.model.UserBean;
import com.jyj.tt.service.TimerService;
import com.jyj.tt.service.UserService;
import com.jyj.tt.util.DateUtil;
import com.jyj.tt.util.ReturnUtil;
import com.jyj.tt.util.SchedulerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/timer")
public class TimerController {


    @Autowired
    private TimerService timerService;

    @PostMapping(path = "/add")
    public @ResponseBody
    Object addNewTimer(@RequestParam String jobName,
                       @RequestParam(name = "jobGroupName", required = false, defaultValue = "jobGroupName") String jobGroupName,
                       @RequestParam(name = "triggerName", required = false, defaultValue = "triggerName") String triggerName,
                       @RequestParam(name = "triggerGroupName", required = false, defaultValue = "triggerGroupName") String triggerGroupName,
                       @RequestParam String startTime,
                       @RequestParam String endTime,
                       @RequestParam int intervalTime,
                       @RequestParam int repeatCount,
                       @RequestParam int userId
    ) {
        TimerBean timerBean = new TimerBean(jobName, jobGroupName, triggerName, triggerGroupName,
                startTime, endTime, intervalTime, repeatCount, userId);
        timerService.addTimer(timerBean);

        SchedulerUtil.handleSimpleTrigger(jobName + userId, jobGroupName + userId, triggerName, triggerGroupName,
                DateUtil.dateParse(startTime, DateUtil.DATE_TIME_PATTERN),
                DateUtil.dateParse(endTime, DateUtil.DATE_TIME_PATTERN),
                JobA.class,
                intervalTime, repeatCount
        );
        return ReturnUtil.onSuccess("保存成功");
    }


    @ResponseBody
    @GetMapping("/allTimer")
    public Object getUsersPager(
            @RequestParam(name = "page", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "rows", required = false, defaultValue = "10")
                    int pageSize) {
        PageInfo<TimerBean> allTimer = timerService.findAllTimer(pageNum, pageSize);
        return ReturnUtil.getObject(allTimer);
    }

    @ResponseBody
    @GetMapping("/cancelTimer")
    public Object cancelTimer(
            @RequestParam String jobName,
            @RequestParam String triggerName,
            @RequestParam int userId) {
        SchedulerUtil.cancelJob(jobName, triggerName, userId);
        return ReturnUtil.onSuccess("取消成功");
    }

    @ResponseBody
    @GetMapping("/modifyTimer")
    public Object modifyTimer(
            @RequestParam String jobName,
            @RequestParam String triggerName,
            @RequestParam int userId,
            @RequestParam String startTime,
            @RequestParam String endTime,
            @RequestParam int intervalTime,
            @RequestParam int repeatCount) {
        SchedulerUtil.modifyJobTime(jobName, triggerName, userId,
                DateUtil.dateParse(startTime, DateUtil.DATE_TIME_PATTERN),
                DateUtil.dateParse(endTime, DateUtil.DATE_TIME_PATTERN),
                intervalTime,
                repeatCount);
        return ReturnUtil.onSuccess("修改成功");
    }

}
