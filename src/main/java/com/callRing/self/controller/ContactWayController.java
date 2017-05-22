package com.callRing.self.controller;

import com.callRing.self.po.ContactWay;
import com.callRing.self.service.ContactWayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by kcz on 2016/5/30.
 */
@Controller
@RequestMapping("/contactWay")
public class ContactWayController {

    @Autowired
    private ContactWayService contactWayService;

    @RequestMapping("/insertContactWay")
    @ResponseBody
    public void insertContactWay(HttpSession session,ContactWay contactWay) throws Exception {
        contactWay.setUserName((String)session.getAttribute("userName"));
        contactWayService.insertContactWay(contactWay);

    }
}
