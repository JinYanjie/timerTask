package com.jyj.tt.dao;

import com.jyj.tt.model.TimerBean;
import com.jyj.tt.model.UserBean;

import java.util.List;

public interface TimerDao {
    List<TimerBean> findAllTimer();
    void addTimer(TimerBean timerBean);
}
