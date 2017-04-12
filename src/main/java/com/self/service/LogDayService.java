package com.self.service;

import com.self.po.LogDay;
import com.self.po.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kcz on 2016/6/4.
 */

public interface LogDayService {

    List<LogDay> queryLogDay(User user)throws Exception;

    void addLogDay(LogDay logDay)throws Exception;
}
