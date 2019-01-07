package com.jyj.tt.dao;

import com.jyj.tt.model.TaskBean;
import com.jyj.tt.model.UserBean;

import java.util.List;

public interface UserDao {
    List<UserBean> findAllUser();
    void addUser(UserBean userBean);
}
