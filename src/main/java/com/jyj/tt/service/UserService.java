package com.jyj.tt.service;

import com.github.pagehelper.PageInfo;
import com.jyj.tt.model.TaskBean;
import com.jyj.tt.model.UserBean;

public interface UserService {
    PageInfo<UserBean> findAllUser(int pageNum, int pageSize);
    void addUser(UserBean userBean);
}
