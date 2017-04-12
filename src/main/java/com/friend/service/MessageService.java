package com.friend.service;

import com.friend.po.Message;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MessageService {

	void insertMessage(List<Message> messageList)throws Exception;

	List<Message> selectOfflineMessage(Message message)throws Exception;

	void deleteOfflineMessage(Message message)throws Exception;

	List<Message> countMessageList(Message message)throws Exception;

	void updateMessageBoolean(Message message)throws Exception;
}
