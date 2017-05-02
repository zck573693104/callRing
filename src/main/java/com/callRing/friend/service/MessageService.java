package com.callRing.friend.service;

import com.callRing.friend.po.Message;

import java.util.Date;
import java.util.List;

public interface MessageService {

	void insertMessage(List<Message> messageList)throws Exception;

	List<Message> selectOfflineMessage(Message message)throws Exception;

	void deleteOfflineMessage(Message message)throws Exception;

	List<Message> countMessageList(Message message)throws Exception;

	void updateMessageBoolean(Message message)throws Exception;

	List<Message> getMessage(Date beginDate, Date endDate)throws Exception;
}
