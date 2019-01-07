package com.jyj.tt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyj.tt.dao.TimerDao;
import com.jyj.tt.dao.UserDao;
import com.jyj.tt.model.TimerBean;
import com.jyj.tt.model.UserBean;
import com.jyj.tt.service.TimerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "timerService")
public class TimerServiceImpl implements TimerService {

    @Autowired
    TimerDao timerDao;


    @Override
    public PageInfo<TimerBean> findAllTimer(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TimerBean> allTimer = timerDao.findAllTimer();
        PageInfo<TimerBean> pageInfo = new PageInfo<>(allTimer);
        return pageInfo;
    }

    @Override
    public void addTimer(TimerBean userBean) {
        timerDao.addTimer(userBean);
    }
}
