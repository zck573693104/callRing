package com.callRing.friend.controller;

import com.callRing.friend.po.Friend;
import com.callRing.friend.service.serviceImpl.FriendServiceImpl;
import com.callRing.friend.vo.SpanVo;
import com.callRing.self.po.User;
import com.callRing.self.po.UserPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@RequestMapping("/friend")
@Controller
public class FriendController {

	@Autowired
	private FriendServiceImpl friendService;

	@RequestMapping("/queryOftenChatFriend")
	@ResponseBody
	public List<Friend> queryOftenChatFriend(HttpSession session, HttpServletRequest request)throws Exception{
	User user =new User();
	user.setUserName((String) session.getAttribute("userName"));
	List<Friend>friends=friendService.queryOftenChatFriend(user);

		return friends;
	}
	/**
	 * 分页计算 limit (页数-1)*每页条数,每页条数
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addFriend")
	@ResponseBody
	public List<User> addFriend(HttpSession session)throws Exception{
	    User user=new User();
		UserPo userPo=new UserPo();
		userPo.setUser(user);
		userPo.setPageNo(0);
		userPo.setPageSize(1);
		userPo.getUser().setUserName((String) session.getAttribute("userName"));
		return friendService.addFriend(userPo);
	}

	@RequestMapping("/becomeFriend")
	@ResponseBody
	public void becomeFriend(HttpServletRequest request,HttpSession session)throws Exception{
		String friendName=request.getParameter("userName");
		String friendgraphTheoryImagePicPath=request.getParameter("userHeadPortraitPath");
		Friend friend=new Friend();
		friend.setUserName((String) session.getAttribute("userName"));
		friend.setFriendgraphTheoryImagePicPath(friendgraphTheoryImagePicPath);
		friend.setFriendName(friendName);
		friendService.becomeFriend(friend);
	}

	@RequestMapping("/selectFriendLogDay")
	@ResponseBody
	public List<SpanVo> selectFriendLogDay(HttpSession session)throws Exception{
		String userName= (String) session.getAttribute("userName");
		List<SpanVo>spanList=friendService.selectFriendLogDay(userName);
		DateFormat sdf = new SimpleDateFormat("HH:mm:ss");//返回字符串时间给前台
		for (SpanVo spanVo:spanList){
			spanVo.setLogDateString(sdf.format(spanVo.getLogDate()));
		}
		return spanList;
	}
}
