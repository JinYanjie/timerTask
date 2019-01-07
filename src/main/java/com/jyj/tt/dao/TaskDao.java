package com.jyj.tt.dao;

import com.jyj.tt.model.TaskBean;

import java.util.List;

public interface TaskDao {
    List<TaskBean> findAllTask();
    void addTask(TaskBean taskBean);
}
