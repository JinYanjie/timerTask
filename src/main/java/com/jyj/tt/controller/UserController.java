package com.jyj.tt.controller;

import com.github.pagehelper.PageInfo;
import com.jyj.tt.model.TimerBean;
import com.jyj.tt.model.UserBean;
import com.jyj.tt.service.UserService;
import com.jyj.tt.util.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping(path = "/add")
    public @ResponseBody
    Object addNewUser(@RequestParam String name, @RequestParam String email) {
        UserBean userBean = new UserBean(name, email);
        userService.addUser(userBean);
        return ReturnUtil.onSuccess("保存成功");
    }


    @ResponseBody
    @GetMapping("/allUser")
    public Object getUsersPager(
            @RequestParam(name = "page", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "rows", required = false, defaultValue = "10")
                    int pageSize) {
        PageInfo<UserBean> allUser = userService.findAllUser(pageNum, pageSize);
        return ReturnUtil.getObject(allUser);
    }

    @ResponseBody
    @GetMapping("/myTimer")
    public Object getMyTimer(
            @RequestParam(name = "page", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "rows", required = false, defaultValue = "10")
                    int pageSize,
            @RequestParam int userId
            ) {
        PageInfo<TimerBean> myTimer = userService.findMyTimer(pageNum, pageSize,userId);
        return ReturnUtil.getObject(myTimer);
    }

}
