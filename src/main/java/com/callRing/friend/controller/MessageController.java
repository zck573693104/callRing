package com.callRing.friend.controller;


import com.callRing.friend.po.Message;
import com.callRing.friend.service.MessageService;
import com.callRing.friend.service.serviceImpl.MessageServiceImpl;
import com.callRing.friend.websocket.MyWebSocketHandler;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private MyWebSocketHandler handler;

	@Autowired
	private MessageService messageService;

	/**
	 * 读取离线消息并进行删除消息记录 将记录设置为已读false
	 * @param message
	 * @return
	 * @throws Exception
     */
	@RequestMapping("/selectOfflineMessage")
	@ResponseBody
	public List<Message> selectOfflineMessage(Message message,HttpSession session) throws Exception {
		message.setUserName((String) session.getAttribute("userName"));
		DateFormat sdf = new SimpleDateFormat("HH:mm:ss");//返回字符串时间给前台
		List<Message>messageList=messageService.selectOfflineMessage(message);
		for (Message messages:messageList) {
			messages.setSendDaetString(sdf.format(messages.getSendDate()));
		}
//		if (messageList.size()!=0){
//			messageService.deleteOfflineMessage(message);//删除消息记录
//		}
		//更新消息状态为被读
		message.setRead(false);
		messageService.updateMessageBoolean(message);
      return  messageList;
	}

	// 跳转到发布广播页面
	@RequestMapping(value = "broadcast", method = RequestMethod.GET)
	public ModelAndView broadcast() {

		return new ModelAndView("broadcast");
	}

	// 发布系统广播（群发）
	@ResponseBody
	@RequestMapping(value = "broadcast", method = RequestMethod.POST)
	public void broadcast(String text) throws IOException {
		DateFormat sdf = new SimpleDateFormat("HH:mm:ss");//返回字符串时间给前台
		Message message = new Message();
		message.setSendDate(new Timestamp(new Date().getTime()));
		message.setUserName("系统广播");
		message.setText(text);
		message.setSendDate(new Timestamp(new Date().getTime()));
		message.setSendDaetString(sdf.format(message.getSendDate()));
		handler.broadcast(new TextMessage(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(message)));
	}

	@RequestMapping("/countMessageList")
	@ResponseBody
	public List<Message>countMessageList(Message message,HttpSession session)throws Exception{
		DateFormat sdf = new SimpleDateFormat("HH:mm:ss");//返回字符串时间给前台
		message.setUserName((String) session.getAttribute("userName"));
	List<Message>countMessageList=	messageService.countMessageList(message);
	for (Message message1:countMessageList){
		message1.setSendDaetString(sdf.format(message1.getSendDate()));
	}
		return countMessageList;
	}
}