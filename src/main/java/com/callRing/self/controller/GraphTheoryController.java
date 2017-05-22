package com.callRing.self.controller;

import com.callRing.self.po.GraphTheory;
import com.callRing.self.po.LogDay;
import com.callRing.self.service.GraphTheoryService;
import com.callRing.self.service.LogDayService;
import com.callRing.util.UploadFileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kcz on 2016/5/22.
 */
@RestController
@RequestMapping("/graphTheory")
public class GraphTheoryController {

	@Autowired
	private LogDayService logDayService;

	@Autowired
	private GraphTheoryService graphTheoryService;

	@RequestMapping("/insertPicPath")
	@ResponseBody
	public void insertPicPath(HttpSession session, @RequestParam MultipartFile[] graphTheories,
			String graphTheoryContent, HttpServletRequest request) throws Exception {
		List<String> newFileNames = UploadFileUtils.uploadFileList(graphTheories, request);
		if (!CollectionUtils.isEmpty(newFileNames)) {
			List<GraphTheory> graphTheoryList = new ArrayList<>();
			for (String newFileName : newFileNames) {
				GraphTheory graphTheory = new GraphTheory();
				graphTheory.setGraphTheoryContent(graphTheoryContent);
				graphTheory.setGraphTheoryImagePicPath(newFileName);
				graphTheory.setUserName((String) session.getAttribute("userName"));
				graphTheoryList.add(graphTheory);
			}
			graphTheoryService.insertPicPath(graphTheoryList);
		} else {

			LogDay logDay = new LogDay();
			logDay.setUserName((String) session.getAttribute("userName"));
			logDay.setLogDayContext(graphTheoryContent);
			logDayService.addLogDay(logDay);
		}

	}

	@RequestMapping("/queryGraphs")
	@ResponseBody
	public ModelAndView queryGraphs(HttpSession session, GraphTheory graphTheory) throws Exception {
		ModelAndView model = new ModelAndView();
		graphTheory.setUserName((String) session.getAttribute("userName"));
		List<GraphTheory> graphTheoryList = graphTheoryService.queryGraphs(graphTheory);
		List<GraphTheory> graphTheoryTempList = new ArrayList<>();
		for (GraphTheory graphTheoryTemp:graphTheoryList){
		    if (StringUtils.isBlank(graphTheoryTemp.getGraphTheoryImagePicPath())){
		        graphTheoryTempList.add(graphTheoryTemp);
            }
        }
        graphTheoryList.removeAll(graphTheoryTempList);
		model.setViewName("main");
		model.addObject(graphTheoryList);
		return model;
	}
}
