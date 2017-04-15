package com.callRing.self.service;

import com.callRing.self.po.LogDay;
import com.callRing.self.po.User;

import java.util.List;

/**
 * Created by kcz on 2016/6/4.
 */

public interface LogDayService {

    List<LogDay> queryLogDay(User user)throws Exception;

    void addLogDay(LogDay logDay)throws Exception;
}
