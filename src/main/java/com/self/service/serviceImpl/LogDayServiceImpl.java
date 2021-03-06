package com.self.service.serviceImpl;

import com.self.mapper.LogDayMapper;
import com.self.po.LogDay;
import com.self.po.User;
import com.self.service.LogDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kcz on 2016/6/4.
 */
@Service
@Transactional
public class LogDayServiceImpl implements LogDayService {

    @Autowired
    private LogDayMapper logDayMapper;
   
    public List<LogDay> queryLogDay(User user) throws Exception {
        return logDayMapper.queryLogDay(user);
    }

    @Override
    public void addLogDay(LogDay logDay) throws Exception {
        logDayMapper.addLogDay(logDay);
    }
}
