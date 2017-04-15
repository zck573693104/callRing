package com.callRing.self.controller;


import com.callRing.self.po.GraphTheory;
import com.callRing.self.po.User;
import com.callRing.self.service.UserService;
import com.callRing.self.service.serviceImpl.GraphTheoryServiceImpl;
import com.callRing.util.UploadFileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by kcz on 2016/11/14.
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	 private GraphTheoryServiceImpl graphTheoryService;

	@Autowired
	private UserService userService;

	@RequestMapping("/register")
	public ModelAndView checkRegister(User user)throws Exception{
		userService.checkRegister(user);
		ModelAndView model=new ModelAndView();
		model.setViewName("login");
		model.addObject("user", user);
		return model;
	}

	/**
	 * 检查登录时候把user的userName userIntroduce userHeadPortraitPath也一起查出来
	 * @param httpSession
	 * @param user
	 * @return
	 * @throws Exception
     */
	@RequestMapping("/checkLogin")
	public String checkLogin(HttpSession httpSession, User user) throws Exception{
		user=userService.checkLogin(user);
		httpSession.setAttribute("userIntroduce",user.getUserIntroduce());
		httpSession.setAttribute("userHeadPortraitPath", user.getUserHeadPortraitPath());
		String userName=user.getUserName();
		httpSession.setAttribute("userName", user.getUserName());
		//return "main";
		return "redirect:/graphTheory/queryGraphs.action?userName="+java.net.URLEncoder.encode(userName,"UTF-8");
	}

	@RequestMapping("/updatePicPath")
	public ModelAndView updatePicPath(HttpSession httpSession,HttpServletRequest request,User user,MultipartFile userHeadPortrait)throws Exception{
		 ModelAndView model=new ModelAndView();
		 user.setUserName((String)httpSession.getAttribute("userName"));
		 String newFileName= UploadFileUtils.uploadFile(userHeadPortrait, request);
		 user.setUserHeadPortraitPath(newFileName);
		 userService.updatePicPath(user);
		 user=userService.queryPicPath(user);
		 httpSession.removeAttribute("userHeadPortraitPath");
		 String userHeadPortraitPath=user.getUserHeadPortraitPath();
		 httpSession.setAttribute("userHeadPortraitPath", userHeadPortraitPath);
		 GraphTheory graphTheory=new GraphTheory();
		 graphTheory.setUserName((String) httpSession.getAttribute("userName"));
	     List<GraphTheory> graphTheoryList=graphTheoryService.queryGraphs(graphTheory);
	     model.addObject(graphTheoryList);
	     model.setViewName("main");
		 return model;
	}

	@RequestMapping("/queryUserInfo")
	@ResponseBody
	public User queryIntroduce(HttpSession httpSession, HttpServletRequest request, HttpServletResponse response)throws Exception{
		String username=(String)httpSession.getAttribute("userName");
		User user =new User();
		user.setUserName(username);
		httpSession.setAttribute("user", user=userService.queryUserInfo(user));
		return user;
	}


	/**
	 * 自我介绍只允许一条 判断introduce表是否有用户名 如果没有则insert否则update
	 */
	@RequestMapping("/updateUserInfo")
	public String updateUserInfo(String userIntroduce,HttpSession session, MultipartFile userHeadPortrait, HttpServletRequest request)throws Exception{
		String newFileNames= UploadFileUtils.uploadFile(userHeadPortrait, request);
		User user=new User();
		user.setUserIntroduce(userIntroduce);
		user.setUserName((String) session.getAttribute("userName"));
		user.setUserHeadPortraitPath(newFileNames);
		userService.updateUserInfo(user);
		user=userService.queryPicPath(user);
		session.removeAttribute("userHeadPortraitPath");
		if (!StringUtils.isBlank(user.getUserHeadPortraitPath())){
			session.setAttribute("userHeadPortraitPath", user.getUserHeadPortraitPath());
		}
		return "success";
	}
}
