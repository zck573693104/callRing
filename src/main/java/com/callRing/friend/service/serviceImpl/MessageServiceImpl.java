package com.callRing.friend.service.serviceImpl;

import com.callRing.friend.mapper.MessageMapper;
import com.callRing.friend.po.Message;
import com.callRing.friend.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class MessageServiceImpl implements MessageService {

	@Autowired
    private MessageMapper messageMapper;

	@Override
	public void insertMessage(List<Message> messageList) throws Exception {
		messageMapper.insertMessage(messageList);
		
	}

	@Override
	public List<Message> selectOfflineMessage(Message message) throws Exception {
		return messageMapper.selectOfflineMessage(message);
	}

	@Override
	public void deleteOfflineMessage(Message message) throws Exception {
		messageMapper.deleteOfflineMessage(message);
	}

	@Override
	public List<Message> countMessageList(Message message) throws Exception {
		return messageMapper.countMessageList(message);
	}

	@Override
	public void updateMessageBoolean(Message message) throws Exception {
		messageMapper.updateMessageBoolean(message);
	}

}
