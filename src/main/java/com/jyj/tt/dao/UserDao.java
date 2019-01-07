package com.jyj.tt.dao;

import com.jyj.tt.model.TaskBean;
import com.jyj.tt.model.TimerBean;
import com.jyj.tt.model.UserBean;

import java.util.List;

public interface UserDao {
    List<UserBean> findAllUser();
    List<TimerBean> findMyTimer(int userId);
    void addUser(UserBean userBean);
}
