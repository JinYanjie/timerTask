package com.jyj.tt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyj.tt.dao.TaskDao;
import com.jyj.tt.dao.UserDao;
import com.jyj.tt.model.TaskBean;
import com.jyj.tt.model.TimerBean;
import com.jyj.tt.model.UserBean;
import com.jyj.tt.service.TaskService;
import com.jyj.tt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;


    @Override
    public PageInfo<UserBean> findAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserBean> allUser = userDao.findAllUser();
        PageInfo<UserBean> pageInfo = new PageInfo<>(allUser);
        return pageInfo;
    }

    @Override
    public PageInfo<TimerBean> findMyTimer(int pageNum, int pageSize,int userId) {
        PageHelper.startPage(pageNum, pageSize);
        List<TimerBean> myTimer = userDao.findMyTimer(userId);
        PageInfo<TimerBean> pageInfo = new PageInfo<>(myTimer);
        return pageInfo;
    }

    @Override
    public void addUser(UserBean userBean) {
        userDao.addUser(userBean);
    }
}
