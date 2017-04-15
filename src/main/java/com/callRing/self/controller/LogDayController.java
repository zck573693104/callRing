package com.callRing.self.controller;

import com.callRing.self.po.LogDay;
import com.callRing.self.po.User;
import com.callRing.self.service.serviceImpl.LogDayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by kcz on 2016/6/4.
 */
@Controller
@RequestMapping("/logday")
public class LogDayController {

    @Autowired
    private LogDayServiceImpl logDayService;

    @RequestMapping("/queryLogDay")
    @ResponseBody
    public List<LogDay>queryLogDay(HttpSession session)throws Exception{
        User user =new User();
        user.setUserName((String)session.getAttribute("userName"));
        List<LogDay>logDayList=logDayService.queryLogDay(user);
        return logDayList;
    }
}
