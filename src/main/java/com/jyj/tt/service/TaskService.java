package com.jyj.tt.service;

import com.github.pagehelper.PageInfo;
import com.jyj.tt.model.TaskBean;

public interface TaskService {
    PageInfo<TaskBean> findAllTask(int pageNum, int pageSize);
    void addTask(TaskBean taskBean);
}
