package com.jyj.tt.controller;

import com.github.pagehelper.PageInfo;
import com.jyj.tt.model.TaskBean;
import com.jyj.tt.service.TaskService;
import com.jyj.tt.util.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping(path = "/add")
    public @ResponseBody
    Object addTask(@RequestParam String name, @RequestParam String time) {
        TaskBean taskBean = new TaskBean(name, time);
        taskService.addTask(taskBean);
        return ReturnUtil.saveSuccess();
    }

    @ResponseBody
    @GetMapping("/allTask")
    public Object findAllUser(
            @RequestParam(name = "page", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "rows", required = false, defaultValue = "10")
                    int pageSize) {
        PageInfo<TaskBean> allTask = taskService.findAllTask(pageNum, pageSize);
        return ReturnUtil.getObject(allTask);
    }
}
