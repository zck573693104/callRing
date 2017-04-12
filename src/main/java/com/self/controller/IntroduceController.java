package com.self.controller;

import com.self.service.IntroduceService;
import com.self.service.serviceImpl.IntroduceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kcz on 2016/5/21.
 */
@Controller
@RequestMapping("/introduce")
public class IntroduceController {

    @Autowired
    private IntroduceServiceImpl introduceService;

    @RequestMapping("/get")
    public void get(){}
}
