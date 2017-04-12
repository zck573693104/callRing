package com.self.controller;

import com.self.po.ContactWay;
import com.self.service.ContactWayService;
import com.self.service.serviceImpl.ContactWayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by kcz on 2016/5/30.
 */
@Controller
@RequestMapping("/contactWay")
public class ContactWayController {

    @Autowired
    private ContactWayServiceImpl contactWayService;

    @RequestMapping("/insertContactWay")
    public String insertContactWay(HttpSession session,ContactWay contactWay) throws Exception {
        contactWay.setUserName((String)session.getAttribute("userName"));
        contactWayService.insertContactWay(contactWay);
        return "success";
    }
}
