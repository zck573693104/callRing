package com.self.controller;

import com.self.po.GraphTheory;
import com.self.po.LogDay;
import com.self.service.GraphTheoryService;
import com.self.service.LogDayService;
import com.self.service.serviceImpl.GraphTheoryServiceImpl;
import com.self.service.serviceImpl.LogDayServiceImpl;
import com.util.UploadFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kcz on 2016/5/22.
 */
@Controller
@RequestMapping("/graphTheory")
public class GraphTheoryController {

    @Autowired
    private LogDayServiceImpl logDayService;

    @Autowired
    private GraphTheoryServiceImpl graphTheoryService;

    @RequestMapping("/insertPicPath")
    public String insertPicPath(HttpSession session,@RequestParam MultipartFile[] graphTheories,String graphTheoryContent, HttpServletRequest request) throws Exception {
            List<String>newFileNames= UploadFileUtils.uploadFileList(graphTheories, request);
            if (newFileNames.size()!=0){
                List<GraphTheory>graphTheoryList=new ArrayList<>();
                for (String newFileName:newFileNames){
                    GraphTheory graphTheory=new GraphTheory();
                    graphTheory.setGraphTheoryContent(graphTheoryContent);
                    graphTheory.setGraphTheoryImagePicPath(newFileName);
                    graphTheory.setUserName((String)session.getAttribute("userName"));
                    graphTheoryList.add(graphTheory);
                }
                graphTheoryService.insertPicPath(graphTheoryList);
            }
            else {
            LogDay logDay=new LogDay();
            logDay.setUserName((String)session.getAttribute("userName"));
            logDay.setLogDayContext(graphTheoryContent);
            logDayService.addLogDay(logDay);
        }
        return "success";
    }

    @RequestMapping("/queryGraphs")
    @ResponseBody
     public ModelAndView  queryGraphs(HttpSession session,GraphTheory graphTheory) throws Exception {
        ModelAndView model=new ModelAndView();
        graphTheory.setUserName((String) session.getAttribute("userName"));
        List<GraphTheory> graphTheoryList=graphTheoryService.queryGraphs(graphTheory);
        model.setViewName("main");
        model.addObject(graphTheoryList);
        return  model;
    }
}
