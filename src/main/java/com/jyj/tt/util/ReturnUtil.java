package com.jyj.tt.util;

import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.Map;

public class ReturnUtil {

    public static Object getObject(PageInfo result) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("success", true);
        resultMap.put("code", 1000);
        Map<String, Object> taskMap = new HashMap<String, Object>();
        taskMap.put("task", result.getList());
        taskMap.put("count", result.getTotal());
        resultMap.put("data", taskMap);
        return resultMap;
    }

    public static Object onSuccess(String msg) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("success", true);
        resultMap.put("code", 1000);
        resultMap.put("message", msg);
        Map<String, Object> taskMap = new HashMap<String, Object>();
        resultMap.put("data", taskMap);
        return resultMap;
    }

}
