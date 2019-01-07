package com.jyj.tt.service;

import com.github.pagehelper.PageInfo;
import com.jyj.tt.model.TimerBean;
import com.jyj.tt.model.UserBean;

public interface TimerService {
    PageInfo<TimerBean> findAllTimer(int pageNum, int pageSize);
    void addTimer(TimerBean timerBean);
}
