package com.jyj.tt.service;

import com.github.pagehelper.PageInfo;
import com.jyj.tt.model.TaskBean;
import com.jyj.tt.model.TimerBean;
import com.jyj.tt.model.UserBean;

public interface UserService {
    PageInfo<UserBean> findAllUser(int pageNum, int pageSize);
    PageInfo<TimerBean> findMyTimer(int pageNum, int pageSize,int userId);
    void addUser(UserBean userBean);

}
