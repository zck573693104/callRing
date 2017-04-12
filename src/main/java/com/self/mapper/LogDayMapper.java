package com.self.mapper;

import com.self.po.LogDay;
import com.self.po.User;

import java.util.List;

/**
 * Created by kcz on 2016/6/4.
 */
public interface LogDayMapper {

    List<LogDay> queryLogDay(User user)throws Exception;

    void addLogDay(LogDay logDay)throws Exception;
}
