package com.callRing.friend.mapper;

import com.callRing.friend.po.Message;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by kcz on 2016/11/8.
 */
public interface MessageMapper {

	void insertMessage(@Param("messageList") List<Message> messageList);

	List<Message> selectOfflineMessage(Message message);

	void deleteOfflineMessage(Message message);

	List<Message> countMessageList(Message message);

	void updateMessageBoolean(Message message);

	List<Message> getMessage(@Param("beginDate")Date beginDate, @Param("endDate")Date endDate);
}
