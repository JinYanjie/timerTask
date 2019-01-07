package com.jyj.tt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyj.tt.dao.TaskDao;
import com.jyj.tt.model.TaskBean;
import com.jyj.tt.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "taskService")
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskDao taskDao;

    @Override
    public PageInfo<TaskBean> findAllTask(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TaskBean> allTask = taskDao.findAllTask();
        PageInfo<TaskBean> pageInfo = new PageInfo<>(allTask);
        return pageInfo;
    }

    @Override
    public void addTask(TaskBean taskBean) {
        taskDao.addTask(taskBean);
    }
}
