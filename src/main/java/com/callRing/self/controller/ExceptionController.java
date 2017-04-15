package com.callRing.self.controller;

import com.callRing.exception.CustomException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by kcz on 2016/1/28.
 */
public class ExceptionController implements HandlerExceptionResolver {
   
    public ModelAndView resolveException
            (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
             Object handler, Exception ex) {
        //handler就是处理器适配器要执行的对象
        //解析异常类型
        //如果该异常是系统自定义的异常，直接取出异常信息在页面显示
//        String message=null;
//        if(ex instanceof CustomException){
//            message=((CustomException)ex).getMessage();
//        }
//        else {
//            //如果该 异常类型不是系统 自定义的异常，构造一个自定义的异常类型（信息为“未知错误”）
//            message="未知错误";
//        }
        //上述代码变为
        CustomException customException=null;
        if(ex instanceof CustomException){
            customException=(CustomException)ex;

        }
        else {
            customException=new CustomException("未知错误");
        }
        String message=customException.getMessage();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("message",message);
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
